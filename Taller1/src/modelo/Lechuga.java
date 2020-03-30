package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Lechuga {
	float x, y;
	PImage zanahoria;
	PApplet p;
	
	public Lechuga(float x, float y, PApplet p) {
		this.x= x;
		this.y= y;
		zanahoria= p.loadImage("imagenes/lechuga.png");
	}
	
	public void pintarLe(PApplet p) {
		p.image(zanahoria,x,y,70,60);
	}
	
	public void moverLe(PApplet p) {
		y+=20;
	}
}
