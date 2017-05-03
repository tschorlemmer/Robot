package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.JFrame;

import gameFileIO.ImageReader;
import gameListeners.GameKeyListener;
import gameObjects.Entity;
import utility.Util; 

/*
 * The point of this class is to display graphics and be the base for handling the display of things to the window
 * 
 * IT DOES NOT CALCULATE THE GRAPHICS, BUT DISPLAYS THEM IN APPROPRIATE LOCATIONS
 */

public class GameWindow extends JFrame {
	
	Image myScreen;
	Entity test = new Entity(ImageReader.getImageFromURL(Util.getFileURL("rsc\\testblock.png")));
	
	private static final long serialVersionUID = 1L;

	public GameWindow(){
		setup();
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
		g.drawImage(test.getImage(),0,0,null);
	}
}
