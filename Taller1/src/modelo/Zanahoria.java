package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Zanahoria {

	float x, y;
	PImage zanahoria;
	PApplet p;
	
	public Zanahoria(float x, float y, PApplet p) {
		this.x= x;
		this.y= y;
		zanahoria= p.loadImage("imagenes/zanahoria.png");
	}
	
	public void pintarZa(PApplet p) {
		p.image(zanahoria,x,y, 30,60);
	}
	public void moverZa(PApplet p) {
		y+=20;
	}
}
