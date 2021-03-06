package com.tank.my;

import java.awt.Color;
import java.awt.Graphics;

import com.tank.my.Tank.Direction;

public class Missile {
	
	public static final int XSPEED = 15;
	public static final int YSPEED = 15;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	int x,y;
	private Tank.Direction dir;
	
	
	
	public Missile(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public 
	void 
	draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
	}

	private 
	void 
	move() {
		switch(dir){
		case L:
			x -= XSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case U:
			y -= YSPEED;
			break;
		case RU:
			x += XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RD:
			x += XSPEED;
			y += YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case LD:
			x -= XSPEED;
			y += YSPEED;
			break;
		}
	}
	
	
	
}
