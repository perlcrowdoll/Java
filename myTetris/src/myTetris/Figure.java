package myTetris;

public class Figure {

	private int curentfigure;

	protected byte[][] figureshape;
	protected static byte[][] figureshape1 = { { 2, 2, 0 }, { 0, 2, 2 }, { 0, 0, 0 } };
	protected static byte[][] figureshape2 = { { 0, 0, 2 }, { 0, 2, 2 }, { 0, 2, 0 } };

	protected static byte[][] figureshape3 = { { 2, 2, 0 }, { 2, 2, 0 }, { 0, 0, 0 } };

	protected static byte[][] figureshape4 = { { 0, 2, 0 }, { 0, 2, 0 }, { 0, 2, 0 } };
	protected static byte[][] figureshape5 = { { 0, 0, 0 }, { 2, 2, 2 }, { 0, 0, 0 } };

	protected static byte[][] figureshape6 = { { 0, 2, 0 }, { 2, 2, 2 }, { 0, 0, 0 } };
	protected static byte[][] figureshape7 = { { 0, 2, 0 }, { 0, 2, 2 }, { 0, 2, 0 } };
	protected static byte[][] figureshape8 = { { 0, 0, 0 }, { 2, 2, 2 }, { 0, 2, 0 } };
	protected static byte[][] figureshape9 = { { 0, 2, 0 }, { 2, 2, 0 }, { 0, 2, 0 } };

	protected static byte[][] figureshape10 = { { 0, 2, 2 }, { 2, 2, 0 }, { 0, 0, 0 } };
	protected static byte[][] figureshape11 = { { 2, 0, 0 }, { 2, 2, 0 }, { 0, 2, 0 } };

	protected Figure(int figurenumber) {
		if (figurenumber == 1) {
			this.figureshape = figureshape1;
			this.curentfigure = 1;
		}
		if (figurenumber == 2) {
			this.figureshape = figureshape2;
			this.curentfigure = 2;
		}
		if (figurenumber == 3) {
			this.figureshape = figureshape3;
			this.curentfigure = 3;
		}
		if (figurenumber == 4) {
			this.figureshape = figureshape4;
			this.curentfigure = 4;
		}
		if (figurenumber == 5) {
			this.figureshape = figureshape5;
			this.curentfigure = 5;
		}
		if (figurenumber == 6) {
			this.figureshape = figureshape6;
			this.curentfigure = 6;
		}
		if (figurenumber == 7) {
			this.figureshape = figureshape7;
			this.curentfigure = 7;
		}
		if (figurenumber == 8) {
			this.figureshape = figureshape8;
			curentfigure = 8;
		}
		if (figurenumber == 9) {
			this.figureshape = figureshape9;
			this.curentfigure = 9;
		}
		if (figurenumber == 10) {
			this.figureshape = figureshape10;
			this.curentfigure = 10;
		}
		if (figurenumber == 11) {
			this.figureshape = figureshape11;
			this.curentfigure = 11;
		}
	}

	protected int getCurentfigure() {
		return curentfigure;
	}

	protected void setCurentfigure(int curentfigure) {
		curentfigure = curentfigure;
	}

}
