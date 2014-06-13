package com.tank.my;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	
	int x, y;
	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;
	
	TankClientMy tc = null;
//	Missile m = null;
	
	
	enum Direction {L, LU, U, RU, R, RD, D, LD,STOP};
	private Direction dir = Direction.STOP;
	

	public Tank(int x, int y, TankClientMy tc ) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	
	public 
	void 
	draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.red);
//		g.fillRoundRect(x, y, 30, 30, 10, 10);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
	}
	
	public 
	void 
	keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_SPACE:
			tc.m = fire();
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		}
		
		move();
	}
	
	private 
	void 
	move(){
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
	
	private
	void 
	locateDirection(){
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
	
	public 
	void 
	keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		}
	}
	
	Missile	m;
	
	private 
	Missile 
	fire(){
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		if(dir.equals(Direction.STOP))
			m = null;
		else 
			m = new Missile(x, y, dir);
		return m;
	}
	
	
	

}
