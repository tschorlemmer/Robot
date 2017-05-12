package gameListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameObjects.ObjectManager;

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
