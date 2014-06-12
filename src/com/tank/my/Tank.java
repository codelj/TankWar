package com.tank.my;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	private static final int XSPEED = 5;
	private static final int YSPEED = 5;
	
	int x, y;
	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;
	
	enum Direction {L, LU, U, RU, R, RD, D, LD,STOP};
	private Direction dir = Direction.STOP;
	

	public Tank(int x, int y) {
//		super();
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.red);
//		g.fillRoundRect(x, y, 30, 30, 10, 10);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_RIGHT:
//			x += 5;
			bR = true;
			break;
		case KeyEvent.VK_LEFT:
//			x -= 5;
			bL = true;
			break;
		case KeyEvent.VK_UP:
//			y -= 5;
			bU = true;
			break;
		case KeyEvent.VK_DOWN:
//			y += 5;
			bD = true;
			break;
		}
		
		move();
	}
	
	void move(){
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
		case STOP:
			break;
		}
		
		locateDirection();
	}
	
	void locateDirection(){
		if(bL && !bU && !bR && !bD) 
			dir = Direction.L;
		else if(bL && bU && !bR && !bD) 
			dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) 
			dir = Direction.U;
		else if(!bL && bU && bR && !bD) 
			dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) 
			dir = Direction.R;
		else if(!bL && !bU && bR && bD) 
			dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) 
			dir = Direction.D;
		else if(bL && !bU && !bR && bD) 
			dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) 
			dir = Direction.STOP;
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_RIGHT:
//			x += 5;
			bR = false;
			break;
		case KeyEvent.VK_LEFT:
//			x -= 5;
			bL = false;
			break;
		case KeyEvent.VK_UP:
//			y -= 5;
			bU = false;
			break;
		case KeyEvent.VK_DOWN:
//			y += 5;
			bD = false;
			break;
		}
	}
	
	
	
	
	

}
