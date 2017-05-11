package gameListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameObjects.ObjectManager;
import graphics.GameWindow;

public class GameKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code){
		case KeyEvent.VK_W:
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
		case KeyEvent.VK_UP:
			GameWindow.y--;
			break;
		case KeyEvent.VK_DOWN:
			GameWindow.y++;
			break;
		case KeyEvent.VK_LEFT:
			GameWindow.x--;
			break;
		case KeyEvent.VK_RIGHT:
			GameWindow.x++;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code){
		case KeyEvent.VK_W:
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
