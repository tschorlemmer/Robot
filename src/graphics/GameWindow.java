package graphics;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

import gameListeners.GameKeyListener;
import gameObjects.Entity;
import gameObjects.ObjectManager;
import utility.Util; 

/*
 * The point of this class is to display graphics and be the base for handling the display of things to the window
 * 
 * IT DOES NOT CALCULATE THE GRAPHICS, BUT DISPLAYS THEM IN APPROPRIATE LOCATIONS
 */

public class GameWindow extends JFrame {
	
	Image myScreen;

	public static int x = 0, y = 0;
	private static final long serialVersionUID = 1L;

	public GameWindow(){
		setup();
		System.out.println(Util.getFileURL(""));
	}
	
	private void setup(){
		
		this.setSize(Util.getScreenWidth(),Util.getScreenHeight());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.addKeyListener(new GameKeyListener());
	}
	
	@Override
	public void paint(Graphics g)
	{    
		myScreen =createImage(getSize().width,getSize().height);
		Graphics o = myScreen.getGraphics();
		doubleBuffer(o);
		g.drawImage(myScreen,0,0,null);
	}   
	public void doubleBuffer(Graphics g){
		Entity[] e = {ObjectManager.player};
		Camera c = new Camera(ObjectManager.map.getChunks(),e,x,y);
	
		g.drawImage(c.getView(), 0, 0, null);
	}
}
