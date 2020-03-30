package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Conejo {

	float X,Y;
	PImage conejo,estamina, nivel1, nivel2,nivel3,nivel4,nivel5;
	int velocidad;
	PApplet p;
	int contador;
	boolean uno,dos,tres,cuatro,cinco;
	
	public Conejo(float X, float Y,PApplet p) {
		this.X=X;
		this.Y=Y;
		conejo=p.loadImage("imagenes/conejo.png");
		estamina=p.loadImage("imagenes/estaminaC.png");
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

		p.image(conejo, X, Y,69,82);
		p.image(estamina, 900, 0,270,40);
		
		if(p.frameCount %5 ==0) {
			contador++;
		}
		
		if(uno== true) {
			p.image(nivel1, 965, 5,203,32);
		}
		if(dos== true) {
			p.image(nivel2, 965, 5,203,32);
		}
		if(tres== true) {
			p.image(nivel3, 965, 5,203,32);
		}
		if(cuatro== true) {
			p.image(nivel4, 965, 5,203,32);
		}
		if(cinco== true) {
			p.image(nivel5, 965, 5,203,32);
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
	
	public void mover(PApplet p) {
		if(contador<30) {
		if (p.keyPressed) {
		    if (p.key == 's' || p.key == 'S') {
		    	this.Y+=5;
		    }
			if (p.key == 'w' || p.key == 'W') {
			    this.Y-=5;
			 }
			if (p.key == 'd' || p.key == 'D') {
			    this.X+=5;
		     }
		 	 if (p.key == 'a' || p.key == 'A') {
			   this.X-=5;
	}
		}
		
	}
	
}

	public void recargarEstamina(PApplet p) {
		

		if (p.keyPressed) {
			if (p.key == 'h' || p.key == 'H') {
				
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
		    	}
		}
		}
	}
	

