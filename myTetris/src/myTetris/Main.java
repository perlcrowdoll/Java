package myTetris;

public class Main {
	protected static boolean triger = true;
	protected static long timer = 330;
	protected static boolean isGameOver = false;
	protected static Game game;

	protected static Field field;

	public static synchronized void main(String[] arr) throws InterruptedException {
		field = new Field();
		game = new Game();
		game.start();		
		System.out.println(Thread.currentThread());

	}

}
