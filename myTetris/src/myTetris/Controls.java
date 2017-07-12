package myTetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {

	protected static boolean pause = false;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Actions.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Actions.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
			System.out.println("up");
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Actions.rotate();
		}
		if (e.getKeyCode() == KeyEvent.VK_P) {
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			Actions.forceMount();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
