package myTetris;

public class Game extends Thread {
	
	
	public void run()
	{
		while (!Main.isGameOver) {
				Actions.setSpeed();
				Actions.insertFigureToField();
				Actions.printField();
				while (Main.triger) {
					Actions.step();
					try {
						Thread.sleep(Main.timer);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Actions.printField();
				}
				Actions.figure = Actions.newfigure;
				Main.triger = true;	
			}

		
	}
}
