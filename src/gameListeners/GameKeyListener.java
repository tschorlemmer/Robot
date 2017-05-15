package gameListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameFileIO.MapReader;
import gameObjects.Item;
import gameObjects.ObjectManager;
import graphics.GameWindow;

public class GameKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();//gets the code from the keyevent for use in the listener
		switch(code){
		case KeyEvent.VK_W://sets the directions of player movement while the key is pressed down
			ObjectManager.player.setMoveUp(true);
			break;
		case KeyEvent.VK_S:
			ObjectManager.player.setMoveDown(true);
			break;
		case KeyEvent.VK_A:
			ObjectManager.player.setMoveLeft(true);
			break;
		case KeyEvent.VK_D:
			ObjectManager.player.setMoveRight(true);
			break;
		case KeyEvent.VK_EQUALS:
			GameWindow.getCamera().addScale(.1);
			break;
		case KeyEvent.VK_MINUS:
			GameWindow.getCamera().addScale(-.1);
			break;
		case KeyEvent.VK_UP:
			GameWindow.getCamera().addY(-10);
			break;
		case KeyEvent.VK_DOWN:
			GameWindow.getCamera().addY(10);
			break;
		case KeyEvent.VK_LEFT:
			GameWindow.getCamera().addX(-10);
			break;
		case KeyEvent.VK_RIGHT:
			GameWindow.getCamera().addX(10);
			break;
		case KeyEvent.VK_1:
			ObjectManager.addItem(new Item(ObjectManager.player.getX(),ObjectManager.player.getY(),0));
			break;
		case KeyEvent.VK_2:
			ObjectManager.addItem(new Item(ObjectManager.player.getX(),ObjectManager.player.getY(),1));
			break;
		case KeyEvent.VK_3:
			ObjectManager.addItem(new Item(ObjectManager.player.getX(),ObjectManager.player.getY(),2));
			break;
		case KeyEvent.VK_HOME:
			MapReader.readMapFromPicture("1.png");
			break;
		case KeyEvent.VK_END:
			MapReader.readMapFromPicture("2.png");
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code){
		case KeyEvent.VK_W://stops the character movement in the various directions when the key is released
			ObjectManager.player.setMoveUp(false);
			break;
		case KeyEvent.VK_S:
			ObjectManager.player.setMoveDown(false);
			break;
		case KeyEvent.VK_A:
			ObjectManager.player.setMoveLeft(false);
			break;
		case KeyEvent.VK_D:
			ObjectManager.player.setMoveRight(false);
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		}
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}

}
