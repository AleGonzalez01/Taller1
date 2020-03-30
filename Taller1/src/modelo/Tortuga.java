package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Tortuga {
	Comunicación com;
	float X,Y;
	PImage tortuga, estamina, nivel1, nivel2,nivel3,nivel4,nivel5;
	int velocidad;
	PApplet p;
	int contador;
	boolean uno,dos,tres,cuatro,cinco;
	public Tortuga(float X, float Y, PApplet p) {
		this.X=X;
		this.Y=Y;
		tortuga= p.loadImage("imagenes/tortuga.png");
		estamina= p.loadImage("imagenes/estaminaT.png");
		nivel1=p.loadImage("imagenes/nivel1.png");
		nivel2=p.loadImage("imagenes/nivel2.png");
		nivel3=p.loadImage("imagenes/nivel3.png");
		nivel4=p.loadImage("imagenes/nivel4.png");
		nivel5=p.loadImage("imagenes/nivel5.png");
		this.contador= 0;
		this.uno = false;
		this.dos = false;
		this.tres = false;
		this.cuatro = false;
		this.cinco = false;
		
	}
	
	public void pintar(PApplet p) {
		p.image(tortuga, X, Y,103,40);
		p.image(estamina, 900, 40,270,40);
		
		
		
		if(p.frameCount %5 ==0) {
			contador++;
		}

		
		if(uno== true) {
			p.image(nivel1, 965, 40,203,38);
		}
		if(dos== true) {
			p.image(nivel2, 965, 40,203,38);
		}
		if(tres== true) {
			p.image(nivel3, 965, 40,203,38);
		}
		if(cuatro== true) {
			p.image(nivel4, 965, 40,203,38);
		}
		if(cinco== true) {
			p.image(nivel5, 965, 40,203,38);
		}
		
		switch(contador) {
		case 5:
			uno=true;
			break;
		case 10:
			uno =false;
			dos= true;
			break;
		case 15:
			
			dos= false;
			uno=false;
			tres=true;
			break;
		case 20:
		
			tres=false;
			dos= false;
			uno=false;
			cuatro=true;
			break;
		case 25:
			
			cuatro=false;
			tres=false;
			dos= false;
			uno=false;
			cinco=true;
			break;
		case 30:
			cuatro=false;
			tres=false;
			dos= false;
			uno=false;
			cinco=false;
			break;
		}
	}
	
	public void mover(String accion) {
		 
		switch(accion) {
		case "RIGHT":
			X+=5;
			break;
		case "UP":
			Y+=5;
			break;
		case "LEFT":
			X-=5;
			break;
		case "DOWN":
			Y-=5;
			break;
			
		}
		 
		 
		 
	
	
	}
	
	public void recargarEstamina(String recar) {
	
		switch(recar) {
		case "recarga":
			if(contador>=0 && contador<=5) {
	    		contador= 0;
	    		uno= true;
	    	}
			
			if(contador>=5 && contador<=10) {
	    		contador= 5;
	    		dos=false;
	    		uno= true;
	    	}
	    	if(contador>=10 && contador<=15) {
	    		contador= 10;
	    		tres= false;
	    		dos=true;
	    		uno= false;
	    	}
	    	if(contador>=15 && contador<=20) {
	    		contador= 15;
	    		cuatro= false;
	    		tres= true;
	    		dos=false;
	    		uno= false;
	    	}
	    	if(contador>=20 && contador<=25) {
	    		contador= 20;
	    		cinco=false;
	    		cuatro= true;
	    		tres= false;
	    		dos=false;
	    		uno= false;
	    	}
	    	if(contador>30) {
	    		contador=25;
	    	}
			
			break;
		}
	}
	

	public float getX() {
		return X;
	}

	public void setX(float x) {
		X = x;
	}

	public float getY() {
		return Y;
	}

	public void setY(float y) {
		Y = y;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public PApplet getP() {
		return p;
	}

	public void setP(PApplet p) {
		this.p = p;
	}
	
	
}

