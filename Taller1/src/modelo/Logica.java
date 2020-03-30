package modelo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica implements Comunicación.OnMessageListener{
	Comunicación com;
	Conejo conejo;
	Tortuga tortuga;
	PApplet p;
	PImage fondo, ganoC, ganoT, perdioC, perdioT, zanahoria, lechuga;
	float x, y, xc,yc,xt;
	int contador, contadorZ, contadorL;
	
	ArrayList<Zanahoria> zanahorias;
	ArrayList<Lechuga> lechugas;

	public Logica(PApplet p) {
		this.conejo = new Conejo(30, 500, p);
		this.tortuga = new Tortuga(30, 600, p);
		fondo = p.loadImage("imagenes/fondo.png");
		ganoC = p.loadImage("imagenes/ganoC.png");
		ganoT = p.loadImage("imagenes/ganoT.png");
		perdioC = p.loadImage("imagenes/perdioC.png");
		perdioT = p.loadImage("imagenes/perdioT.png");
		zanahoria = p.loadImage("imagenes/zanahoria.png");
		lechuga = p.loadImage("imagenes/lechuga.png");
		this.x = 0;
		this.y = 0;
		this.contador = 0;
		this.contadorZ = 0;
		this.contadorL= 0;
	
		this.yc= 20;
		
		zanahorias= new ArrayList ();
		lechugas= new ArrayList();
		
	}

	public void comunicacion() {
		com = new Comunicación(this);
		com.setObserver(this);
		com.esperarConexion();

	}

	public void pintar(PApplet p) {
	
		
		p.image(fondo, x, y, 4599, 700);
		p.textSize(30);
		p.text(contadorZ,60,45);
		p.text(contadorL,60,90);
		p.image(zanahoria, 20, 10, 20, 40);
		p.image(lechuga, 10, 60, 40, 40);

		if (p.frameCount % 10 == 0) {
			contador++;
		
			}

		if(p.frameCount % 10 == 0 && contador<22) {
			lechugas.add(new Lechuga(p.random(10, 1100),yc,p));
	
		
		}
		if(p.frameCount % 13 == 0 && contador<22) {
	
			zanahorias.add(new Zanahoria(p.random(10, 1100),yc,p));
		
		}
		
			for (int i = 0; i < zanahorias.size(); i++) {

				zanahorias.get(i).pintarZa(p);
				zanahorias.get(i).moverZa(p);
				
				if(zanahorias.get(i).y==700 ) {
					zanahorias.remove(i);
				}
				
	
				if(p.dist(conejo.X, conejo.Y, zanahorias.get(i).x, zanahorias.get(i).y) <50) {
				
					zanahorias.remove(i);
					contadorZ++;
					
				}
			}
			
			
			for (int i = 0; i < lechugas.size(); i++) {
				;
				lechugas.get(i).pintarLe(p);
				lechugas.get(i).moverLe(p);
				if(lechugas.get(i).y==700 ) {
					lechugas.remove(i);
				}
				
				if(p.dist(tortuga.X, tortuga.Y, lechugas.get(i).x, lechugas.get(i).y) <50) {
					
					lechugas.remove(i);
					contadorL++;
				
				}
			
		}
		
		
		
		if (contador >= 1 && contador <= 23) {
			this.x -= 15;
		}
		if (contador == 23) {
			this.x = -3400;
			
		}
		tortuga.pintar(p);
		conejo.pintar(p);

		if (conejo.X >= 1200) {

			p.image(ganoC, 100, 0,1000,700);
		}

		if (conejo.X <= 0) {

			p.image(perdioC, 100, 0, 1000,700);
		}
		if (tortuga.X >= 1200) {

			p.image(ganoT, 100, 0, 1000,700);
		}
		if ( tortuga.X <=0) {

			p.image(perdioT, 100, 0, 1000,700);
		}

	}
	

	public void estamina(PApplet p) {

		conejo.recargarEstamina(p);

	}

	public void mover(PApplet p) {
		conejo.mover(p);
		
	}
	
	
	

	@Override
	public void onMessage(String mensaje) {
		// TODO Auto-generated method stub
		if(mensaje.startsWith("POS")) {
			String[] direccion = mensaje.split("::");
			p.printArray(direccion);
			tortuga.mover(direccion[1]);
		}
		if(mensaje.startsWith("POS")) {
			String[] recarga = mensaje.split("::");
			p.printArray(recarga);
			tortuga.recargarEstamina(recarga[1]);
		}
	}
	
	
	
	
}