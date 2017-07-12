package myTetris;

public class Main {
	protected static boolean triger = true;
	protected static long timer = 330;
	protected static boolean isGameOver = false;

	protected static Field field;

	public static void main(String[] arr) throws InterruptedException {
		field = new Field();
		while (!isGameOver) {
			Actions.setSpeed();
			Actions.insertFigureToField();
			Actions.printField();
			while (triger) {
				Actions.step();
				Thread.sleep(timer);
				Actions.printField();
			}
			Actions.figure = Actions.newfigure;
			triger = true;
		}

	}

}
