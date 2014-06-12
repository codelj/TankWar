package com.tank.my;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;

public class TankClientMy extends Frame{
	
	


	private static final long serialVersionUID = 1L;
	private static final int Frame_Width = 800;
	private static final int Frame_length = 600;
	
	Image offScreenImage = null;
	
	
	int x = 100, y = 100;
	
	public void paint(Graphics g){
//		Color c = g.getColor();
		g.setColor(Color.red);
//		g.fillRoundRect(x, y, 30, 30, 10, 10);
		g.fillOval(x, y, 30, 30);
//		g.setColor(c);
		
//		y += 5;
//		x += 5;
	}

	@Override
	public void update(Graphics g) {
		if(offScreenImage == null)
			offScreenImage = this.createImage(Frame_Width, Frame_length);
		
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.lightGray);
		gOffScreen.fillRect(0, 0, Frame_Width, Frame_length);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	public void lauchFrame(){
		this.setLocation(200,100);
		this.setSize(Frame_Width,Frame_length);
		this.setResizable(false);
		this.setTitle("TankWar_MyFrame");
//		setName("myFrame");
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setBackground(Color.LIGHT_GRAY);		
		
		
		this.addKeyListener(new KeyMonitor());
		
		
		setVisible(true);
		new Thread(new PaintThread()).start();
	}
	
	public static void main(String[] args) {
		new TankClientMy().lauchFrame();
	}
	
	
	private class PaintThread implements Runnable{
		
		public void run(){
			while(true){
				repaint(); // will call super.paint()/overrided paint()
				try{
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	private class KeyMonitor extends KeyAdapter{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyTyped(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
//			super.keyPressed(e);
			
			int key = e.getKeyCode();
			
			switch (key) {
			case KeyEvent.VK_RIGHT:
				x += 5;
				break;
			case KeyEvent.VK_LEFT:
				x -= 5;
				break;
			case KeyEvent.VK_UP:
				y -= 5;
				break;
			case KeyEvent.VK_DOWN:
				y += 5;
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
		}
	}
	
	
	
}
