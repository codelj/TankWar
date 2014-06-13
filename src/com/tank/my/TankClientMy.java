package com.tank.my;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankClientMy extends Frame{
	
/*	

*/
	public static final long serialVersionUID = 1L;
	public static final int Frame_Width = 800;
	public static final int Frame_length = 600;
	
	private Image offScreenImage = null;
	private Tank myTank = new Tank(50, 50, this);
	Missile m = null;
	
	
	public 
	void 
	paint(Graphics g){
		if(m != null)
			m.draw(g);
		myTank.draw(g);
	}

	@Override
	public 
	void 
	update(Graphics g) {
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
	
	public 
	void 
	lauchFrame(){
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
	
	public 
	static 
	void 
	main(String[] args) {
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
//		@Override
//		public void keyTyped(KeyEvent e) {
//			// TODO Auto-generated method stub
//			super.keyTyped(e);
//		}

		@Override
		public 
		void 
		keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}

		@Override
		public 
		void 
		keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
	}
	
	
	
}
