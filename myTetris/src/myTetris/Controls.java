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
			System.out.println("pause");
			if (pause == false)
			{
				System.out.println(Thread.currentThread());
				System.out.println("pause - 1");
				pause=true;

						try {
							Main.game.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


			}
			if (pause == true)
			{
				System.out.println("pause - 2");
				pause=false;
				try {
					Main.game.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
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
