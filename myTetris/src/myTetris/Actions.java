package myTetris;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Actions {

	protected static Figure figure;
	protected static Figure newfigure;

	public static Byte[][] makeGameFieldCopy() {

		Byte two = 2;
		Byte[][] gamefieldTemp = new Byte[30][9];

		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {
				if (!Field.gamefield[i][ii].equals(two))
					gamefieldTemp[i][ii] = Field.gamefield[i][ii];
				else
					gamefieldTemp[i][ii] = 0;
			}

		}

		return gamefieldTemp;
	}

	public static void moveRight() {
		if (isPossibleToMove("right", findFigureRight())) {
			Byte zero = 0;
			Byte one = 1;
			Byte two = 2;
			boolean step = false;
			Byte[][] gamefieldTemp = makeGameFieldCopy();

			for (int i = 0; i < 30; i++) {
				for (int ii = 0; ii < 9; ii++) {

					// if (Field.gamefield[i][ii].equals(two) && gamefieldTemp[i][ii +
					// 1].equals(zero)) {
					if (Field.gamefield[i][ii].equals(two)) {
						step = true;
						gamefieldTemp[i][ii + 1] = 2;
						continue;
					}

				}

			}
			if (step)
				Field.gamefield = gamefieldTemp;
		}
	}

	protected static void moveLeft() {

		if (isPossibleToMove("left", findFigureLeft())) {
			Byte zero = 0;
			Byte one = 1;
			Byte two = 2;
			boolean step = false;
			Byte[][] gamefieldTemp = makeGameFieldCopy();

			for (int i = 0; i < 30; i++) {
				for (int ii = 0; ii < 9; ii++) {

					// if (Field.gamefield[i][ii].equals(two) && gamefieldTemp[i][ii -
					// 1].equals(zero)) {
					if (Field.gamefield[i][ii].equals(two)) {
						step = true;
						gamefieldTemp[i][ii - 1] = 2;
						// gamefieldTemp[i][ii]=0;
						continue;
					}
				}

			}
			if (step)
				Field.gamefield = gamefieldTemp;
		}
	}

	protected static void rotate() {
		switch (figure.getCurentfigure()) {
		case 1: {
			replaceFigure(2);
			break;
		}

		case 2: {
			replaceFigure(1);
			break;
		}

		case 4: {
			replaceFigure(5);
			break;
		}

		case 5: {
			replaceFigure(4);
			break;
		}

		case 6: {
			replaceFigure(7);
			break;
		}

		case 7: {
			replaceFigure(8);
			break;
		}

		case 8: {
			replaceFigure(9);
			break;
		}

		case 9: {
			replaceFigure(6);
			break;
		}

		case 10: {
			replaceFigure(11);
			break;
		}

		case 11: {
			replaceFigure(10);
			break;
		}
		}

	}

	protected static void replaceFigure(int tofigure) {
		Byte two = 2;
		int firstline = 0;
		int lastline = 0;
		int right = 0;
		int left = 0;
		int counter = 0;

		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {

				if (Field.gamefield[i][ii].equals(two)) {
					if (counter == 0) {
						left = ii;
						right = ii;
						counter++;
						firstline = i;

					} else {
						lastline = i;
						if (left > ii)
							left = ii;
						if (right < ii)
							right = ii;

					}
				}

			}
		}

		insertFigureToField(left, firstline, tofigure);
	}

	protected static void printField() {
		String value = "";
		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {

				Main.field.table.setValueAt(Field.gamefield[i][ii], i, ii);
			}
		}
	}

	protected static Figure generateFigure() {
		int random = (int) (Math.random() * 11 + 1);
		return new Figure(random);

	}

	protected static void step() {

		Byte zero = 0;
		Byte one = 1;
		Byte two = 2;
		Byte[][] gamefieldTemp;

		if (isPossibleForStep(findFigureBottom() + 1) == true) {

			gamefieldTemp = makeGameFieldCopy();

			for (int i = 0; i < 30; i++) {
				for (int ii = 0; ii < 9; ii++) {

					if (Field.gamefield[i][ii].equals(two) && gamefieldTemp[i][ii].equals(zero)) {
						gamefieldTemp[i + 1][ii] = 2;
						// gamefieldTemp[i][ii]=0;
						continue;
					}

					if (Field.gamefield[i][ii].equals(two) && gamefieldTemp[i][ii].equals(two)) {
						gamefieldTemp[i + 1][ii] = 2;
						continue;
					}
				}
			}
			Field.gamefield = gamefieldTemp;

			if (isitFinal()) {
				Field.gamefield = mountFigure(gamefieldTemp);
				removeFullLines();
				Main.triger = false;
			}

		}

		else {
			Field.gamefield = mountFigure(Field.gamefield);
			removeFullLines();
			Main.triger = false;
		}

	}

	protected static boolean isItPossibleToInsertFigureToField(Figure figure) {
		Byte one = 1;
		int fieldY = 0;
		for (int i = 0; i < 3; i++) {
			int fieldX = 3;
			for (int ii = 0; ii < 3; ii++) {
				if (Field.gamefield[fieldY][fieldX].equals(one))
					return false;
				fieldX++;
			}
			fieldY++;
		}
		return true;
	}

	protected static void insertNewFigureToNextFigureWindow() {
		int fieldY = 0;
		for (int i = 0; i < 3; i++) {
			int fieldX = 0;
			for (int ii = 0; ii < 3; ii++) {

				Field.figure[fieldY][fieldX] = newfigure.figureshape[i][ii];
				fieldX++;
			}
			fieldY++;
		}
		String value = "";
		for (int i = 0; i < 3; i++) {
			for (int ii = 0; ii < 3; ii++) {

				Main.field.table_1.setValueAt(Field.figure[i][ii], i, ii);
			}
		}
	}

	protected static void insertFigureToField() {
		if (figure == null)
			figure = generateFigure();

		if (isItPossibleToInsertFigureToField(figure)) {
			newfigure = generateFigure();
			insertNewFigureToNextFigureWindow();

			int fieldY = 0;
			for (int i = 0; i < 3; i++) {
				int fieldX = 3;
				for (int ii = 0; ii < 3; ii++) {

					Field.gamefield[fieldY][fieldX] = figure.figureshape[i][ii];
					fieldX++;
				}
				fieldY++;
			}
		} else {
			Main.isGameOver = true;
			new JOptionPane().showMessageDialog(null, "GAME OVER.", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	protected static void insertFigureToField(int x, int y, int figurenumber) {
		figure = new Figure(figurenumber);

		Byte zero = 0;
		Byte one = 1;
		Byte two = 2;
		Byte[][] gamefieldTemp = makeGameFieldCopy();

		int fieldY = y;
		for (int i = 0; i < 3; i++) {
			int fieldX = x;
			for (int ii = 0; ii < 3; ii++) {

				gamefieldTemp[fieldY][fieldX] = figure.figureshape[i][ii];
				fieldX++;
			}
			fieldY++;
		}
		Field.gamefield = gamefieldTemp;
	}

	protected static Byte[][] mountFigure(Byte[][] arr) {
		Byte two = 2;
		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {
				if (arr[i][ii].equals(two))
					arr[i][ii] = 1;
			}
		}
		return arr;
	}

	protected static boolean isitFinal() {
		Byte two = 2;
		for (int i = 0; i < 9; i++) {
			if (Field.gamefield[29][i].equals(two))
				return true;
		}
		return false;
	}

	protected static int findFigureBottom() {
		Byte two = 2;
		int index = 0;
		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {
				if (Field.gamefield[i][ii].equals(two))
					index = i;
			}
		}
		return index;
	}

	protected static String findFigureRight() {
		int rightcolumn = 0;
		int rightrow = 0;
		Byte two = 2;
		String index;
		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {
				if (Field.gamefield[i][ii].equals(two)) {
					if (rightcolumn <= ii) {
						rightcolumn = ii;
						rightrow = i;
					}

				}
			}
		}
		return rightrow + " " + rightcolumn;
	}

	protected static String findFigureLeft() {
		int leftcolumn = 9;
		int leftrow = 0;
		Byte two = 2;
		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {
				if (Field.gamefield[i][ii].equals(two)) {
					if (leftcolumn >= ii) {
						leftcolumn = ii;
						leftrow = i;
					}
				}
			}
		}
		return leftrow + " " + leftcolumn;
	}

	protected static boolean isPossibleForStep(int linenumber) {
		Byte zero = 1;
		Byte one = 1;
		Byte two = 2;
		boolean isPossible = true;
		int x = 1;
		int rowleft = Integer.parseInt(findFigureLeft().split(" ")[0]);
		int columnleft = Integer.parseInt(findFigureLeft().split(" ")[1]);

		int rowright = Integer.parseInt(findFigureRight().split(" ")[0]);
		int columnright = Integer.parseInt(findFigureRight().split(" ")[1]);

		for (int i = 0; i < 9; i++) {
			if (linenumber < 30) {

				if (Field.gamefield[linenumber - 1][i].equals(two) && Field.gamefield[linenumber][i].equals(one)) {
					isPossible = false;
				}
			}
		}

		if (Field.gamefield[rowleft + 1][columnleft].equals(one))
			isPossible = false;

		if (Field.gamefield[rowright + 1][columnright].equals(one))
			isPossible = false;

		return isPossible;
	}

	protected static boolean isPossibleToMove(String direction, String coordinates) {
		Byte one = 1;
		Byte two = 2;
		int row = Integer.parseInt(coordinates.split(" ")[0]);
		int column = Integer.parseInt(coordinates.split(" ")[1]);

		switch (direction) {
		case "right": {

			if (column == 8)
				return false;

			if (column < 8) {
				if (Field.gamefield[row][column].equals(two) && Field.gamefield[row][column + 1].equals(one)) {
					return false;
				}
			}
			break;
		}
		case "left": {

			if (column == 0)
				return false;

			if (column > 0) {
				if (Field.gamefield[row][column].equals(two) && Field.gamefield[row][column - 1].equals(one)) {
					return false;
				}
			}

			break;
		}

		}

		return true;
	}

	protected static void removeFullLines() {

		Byte[][] gamefieldTemp = makeGameFieldCopy();
		Byte one = 0;
		boolean ifHad = false;
		int full = 0;
		for (int i = 0; i < 30; i++) {
			for (int i2 = 0; i2 < 9; i2++) {
				if (gamefieldTemp[i][i2] == 1)
					full = 1;
				else {
					full = 0;
					break;
				}
			}
			if (full == 1) {
				ifHad = true;
				for (int i2 = i; i2 > 0; i2--) {

					gamefieldTemp[i2] = gamefieldTemp[i2 - 1];
				}
				gamefieldTemp[0] = null;
				gamefieldTemp[0] = new Byte[9];

				for (int i3 = 0; i3 < 9; i3++) {
					gamefieldTemp[0][i3] = one;
				}
				Field.score += 100;
				Main.field.label.setText(String.valueOf(Field.score));

			}
			full = 0;

		}
		if (ifHad == true)
			Field.gamefield = gamefieldTemp;

	}

	protected static void forceMount() {
		while (Main.triger) {
			Actions.step();
			Actions.printField();
		}
	}

	protected static void setSpeed() {
		if (Field.score < 1000) {
			Main.timer = 330;
			Main.field.label_1.setText("10");
		}
		if (Field.score >= 1000 && Field.score < 2000) {
			Main.timer = 300;
			Main.field.label_1.setText("9");
		}
		if (Field.score >= 2000 && Field.score < 3000) {
			Main.timer = 270;
			Main.field.label_1.setText("8");
		}
		if (Field.score >= 3000 && Field.score < 4000) {
			Main.timer = 240;
			Main.field.label_1.setText("7");
		}
		if (Field.score >= 4000 && Field.score < 5000) {
			Main.timer = 210;
			Main.field.label_1.setText("6");
		}
		if (Field.score >= 5000 && Field.score < 6000) {
			Main.timer = 180;
			Main.field.label_1.setText("5");
		}
		if (Field.score >= 6000 && Field.score < 7000) {
			Main.timer = 150;
			Main.field.label_1.setText("4");
		}
		if (Field.score >= 7000 && Field.score < 8000) {
			Main.timer = 120;
			Main.field.label_1.setText("3");
		}
		if (Field.score >= 8000 && Field.score < 9000) {
			Main.timer = 90;
			Main.field.label_1.setText("2");
		}
		if (Field.score >= 9000) {
			Main.timer = 60;
			Main.field.label_1.setText("1");
		}
	}

}
