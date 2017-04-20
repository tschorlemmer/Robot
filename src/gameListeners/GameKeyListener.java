package gameListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
		
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}

}
