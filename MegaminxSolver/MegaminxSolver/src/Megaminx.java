public class Megaminx {
	int firstStarCounter = 0;
	EdgePiece[] e = new EdgePiece[30];
	CornerPiece[] c = new CornerPiece[20];

	public CornerPiece getCorner(int f1, int f2, int f3) {
		return c[getCornerNumber(f1, f2, f3)];
	}

	public EdgePiece getEdge(int f1, int f2) {
		return e[getEdgeNumber(f1, f2)];
	}

	public int searchEdge1(int c) {
		for (int i = 0; i < e.length; i++) {
			if (!((e[i].getFace1() == c && e[i].getColor1() == c) || (e[i]
					.getFace2() == c && e[i].getColor2() == c))) {
				return i;

			}

		}
		return -1;

	}
	
	public int searchEdge(int c1, int c2){
		for (int i = 0; i < e.length; i++) {
			if(e[i].getColor1() == c1 && e[i].getColor2() == c2 
					|| e[i].getColor1() == c2 && e[i].getColor2() == c1)
				return i;
		}
		return -1;
	}

	// making white star at the bottom
	public void makeFirstStar() {
		int a1 = searchEdge1(0);
		if (a1 != -1) {
			positionEdgeFirstStar(e[a1]);
		}
		int a2 = searchEdge1(0);
		if (a2 != -1) {
			positionEdgeFirstStar(e[a2]);
		}
		int a3 = searchEdge1(0);
		if (a3 != -1) {
			positionEdgeFirstStar(e[a3]);
		}
		int a4 = searchEdge1(0);
		if (a4 != -1) {
			positionEdgeFirstStar(e[a4]);
		}
		int a5 = searchEdge1(0);
		if (a5 != -1) {
			positionEdgeFirstStar(e[a5]);
		}
	}

	// positioning the edge pieces for the white side
	public void positionEdgeFirstStar(EdgePiece a1) {
		int c1 = a1.getColor1();
		int c2 = a1.getColor2();
		if (firstStarCounter == 0) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 8 || a1.getFace2() == 8)) {
					turn(9);
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 1 || a1.getFace2() == 1)) {
					turn(6);
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(4);
				}
			}
			if (a1.getFace1() == 3 || a1.getFace2() == 3) {
				while (!(a1.getFace1() == 2 || a1.getFace2() == 2)) {
					turn(3);
				}
			}
			if (a1.getFace1() == 2 || a1.getFace2() == 2) {
				while (!(a1.getFace1() == 1 || a1.getFace2() == 1)) {
					turn(2);
				}
			}
			if (a1.getFace1() == 1 || a1.getFace2() == 1) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(1);
				}
			}

			if (a1.getColor1() != 0) {
				turnR(a1.getFace1());
				turn(a1.getFace2());
				turnR(a1.getFace2());
				turnR(a1.getFace1());
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 1) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 8 || a1.getFace2() == 8)) {
					turn(9);
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 2 || a1.getFace2() == 2)) {
					turn(6);
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(4);
				}
			}
			if (a1.getFace1() == 3 || a1.getFace2() == 3) {
				while (!(a1.getFace1() == 2 || a1.getFace2() == 2)) {
					turn(3);
				}
			}
			if (a1.getFace1() == 2 || a1.getFace2() == 2) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(2);
				}
			}
			if (a1.getColor1() != 0) {
				turnR(a1.getFace1());
				turn(a1.getFace2());
				turnR(a1.getFace2());
				turnR(a1.getFace1());
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 2) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(10);
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 8 || a1.getFace2() == 8)) {
					turn(9);
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 10 || a1.getFace2() == 10)) {
					turn(6);
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(4);
				}
			}
			if (a1.getFace1() == 3 || a1.getFace2() == 3) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(3);
				}
			}
			if (a1.getColor1() != 0) {
				turnR(a1.getFace1());
				turn(a1.getFace2());
				turnR(a1.getFace2());
				turnR(a1.getFace1());
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 3) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(9);
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 10 || a1.getFace2() == 10)) {
					turn(6);
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(4);
				}
			}

			if (a1.getColor1() != 0) {
				turnR(a1.getFace1());
				turn(a1.getFace2());
				turnR(a1.getFace2());
				turnR(a1.getFace1());
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 4) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 5 || a1.getFace2() == 5)) {
					turn(9);
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 10 || a1.getFace2() == 10)) {
					turn(6);
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(5);
				}
			}

			if (a1.getColor1() != 0) {
				turnR(a1.getFace1());
				turn(a1.getFace2());
				turnR(a1.getFace2());
				turnR(a1.getFace1());
			}
			firstStarCounter++;
			return;
		}
	}

	// finishes the star and correctly orients the edge pieces
	public void correctFirstStar() {
		int completed = 0;
		while (completed < 4) {
			for (int i = 0; i < 5; i++) {
				if (getEdge(0, i + 1).getColor2() == getEdge(0, i + 1)
						.getFace2()) {
					turn2(getEdge(0, i + 1).getColor2());
					completed++;
				}
			}
			turn(0);
		}
		for (int j = 0; j < 5; j++) {
			turn2R(j + 1);
		}
	}

	// completes the first layer by adding the corner pieces to the white side
	public void completeFirstLayer() {
		// get it ut of any traps
		if (getCorner(0, 1, 2).getFace1() == 0
				|| getCorner(0, 1, 2).getFace2() == 0
				|| getCorner(0, 1, 2).getFace3() == 0) {
			int a = getCorner(0, 1, 2).getFace2();
			int b = getCorner(0, 1, 2).getFace3();
			turnR(a);
			turnR(b);
			turn(a);
			turn(b);
		}
		if (getCorner(0, 1, 2).getFace1() == 10
				|| getCorner(0, 1, 2).getFace2() == 10
				|| getCorner(0, 1, 2).getFace3() == 10) {
			while (!(getCorner(0, 1, 2).getFace1() == 9
					|| getCorner(0, 1, 2).getFace2() == 9 || getCorner(0, 1, 2)
					.getFace3() == 9)) {
				turn(10);
			}
		}
		if (getCorner(0, 1, 2).getFace1() == 9
				|| getCorner(0, 1, 2).getFace2() == 9
				|| getCorner(0, 1, 2).getFace3() == 9) {
			while (!(getCorner(0, 1, 2).getFace1() == 8
					|| getCorner(0, 1, 2).getFace2() == 8 || getCorner(0, 1, 2)
					.getFace3() == 8)) {
				turn(9);
			}
		}
		if (getCorner(0, 1, 2).getFace1() == 8
				|| getCorner(0, 1, 2).getFace2() == 8
				|| getCorner(0, 1, 2).getFace3() == 8) {
			while (!(getCorner(0, 1, 2).getFace1() == 7
					|| getCorner(0, 1, 2).getFace2() == 7 || getCorner(0, 1, 2)
					.getFace3() == 7)) {
				turn(8);
			}
		}
		if (getCorner(0, 1, 2).getFace1() == 6
				|| getCorner(0, 1, 2).getFace2() == 6
				|| getCorner(0, 1, 2).getFace3() == 6) {
			while (!((getCorner(0, 1, 2).getFace1() == 6
					|| getCorner(0, 1, 2).getFace2() == 6 || getCorner(0, 1, 2)
					.getFace3() == 6)
					&& (getCorner(0, 1, 2).getFace1() == 1
							|| getCorner(0, 1, 2).getFace2() == 1 || getCorner(
							0, 1, 2).getFace3() == 1) && (getCorner(0, 1, 2)
					.getFace1() == 2 || getCorner(0, 1, 2).getFace2() == 2 || getCorner(
						0, 1, 2).getFace3() == 2))) {
				turn(6);
			}
			while (getCorner(0, 1, 2).getFace1() != 0) {
				turnR(1);
				turnR(6);
				turn(1);
				turn(6);
			}
		}
		if (getCorner(0, 1, 2).getFace1() == 7
				|| getCorner(0, 1, 2).getFace2() == 7
				|| getCorner(0, 1, 2).getFace3() == 7) {
			while (!(getCorner(0, 1, 2).getFace1() == 6
					|| getCorner(0, 1, 2).getFace2() == 6 || getCorner(0, 1, 2)
					.getFace2() == 6)) {
				turn(7);
			}
		}

		if (getCorner(0, 2, 3).getFace1() == 0
				|| getCorner(0, 2, 3).getFace2() == 0
				|| getCorner(0, 2, 3).getFace3() == 0) {
			int a = getCorner(0, 2, 3).getFace2();
			int b = getCorner(0, 2, 3).getFace3();
			turnR(a);
			turnR(b);
			turn(a);
			turn(b);
		}
		if (getCorner(0, 2, 3).getFace1() == 10
				|| getCorner(0, 2, 3).getFace2() == 10
				|| getCorner(0, 2, 3).getFace3() == 10) {
			while (!(getCorner(0, 2, 3).getFace1() == 9
					|| getCorner(0, 2, 3).getFace2() == 9 || getCorner(0, 2, 3)
					.getFace3() == 9)) {
				turn(10);
			}
		}
		if (getCorner(0, 2, 3).getFace1() == 9
				|| getCorner(0, 2, 3).getFace2() == 9
				|| getCorner(0, 2, 3).getFace3() == 9) {
			while (!(getCorner(0, 2, 3).getFace1() == 8
					|| getCorner(0, 2, 3).getFace2() == 8 || getCorner(0, 2, 3)
					.getFace3() == 8)) {
				turn(9);
			}
		}
		if (getCorner(0, 2, 3).getFace1() == 8
				|| getCorner(0, 2, 3).getFace2() == 8
				|| getCorner(0, 2, 3).getFace3() == 8) {
			while (!(getCorner(0, 2, 3).getFace1() == 7
					|| getCorner(0, 2, 3).getFace2() == 7 || getCorner(0, 2, 3)
					.getFace3() == 7)) {
				turn(8);
			}
		}
		if (getCorner(0, 2, 3).getFace1() == 7
				|| getCorner(0, 2, 3).getFace2() == 7
				|| getCorner(0, 2, 3).getFace3() == 7) {
			while (!((getCorner(0, 2, 3).getFace1() == 7
					|| getCorner(0, 2, 3).getFace2() == 7 || getCorner(0, 2, 3)
					.getFace3() == 7)
					&& (getCorner(0, 2, 3).getFace1() == 2
							|| getCorner(0, 2, 3).getFace2() == 2 || getCorner(
							0, 2, 3).getFace3() == 2) && (getCorner(0, 2, 3)
					.getFace1() == 3 || getCorner(0, 2, 3).getFace2() == 3 || getCorner(
						0, 2, 3).getFace3() == 3))) {
				turn(7);
			}
			while (getCorner(0, 2, 3).getFace1() != 0) {
				turnR(2);
				turnR(7);
				turn(2);
				turn(7);
			}
		}
		if (getCorner(0, 2, 3).getFace1() == 6
				|| getCorner(0, 2, 3).getFace2() == 6
				|| getCorner(0, 2, 3).getFace3() == 6) {
			while (!(getCorner(0, 2, 3).getFace1() == 10
					|| getCorner(0, 2, 3).getFace2() == 10 || getCorner(0, 2, 3)
					.getFace3() == 10)) {
				turn(6);
			}
		}

		if (getCorner(0, 3, 4).getFace1() == 0
				|| getCorner(0, 3, 4).getFace2() == 0
				|| getCorner(0, 3, 4).getFace3() == 0) {
			int a = getCorner(0, 3, 4).getFace2();
			int b = getCorner(0, 3, 4).getFace3();
			turnR(a);
			turnR(b);
			turn(a);
			turn(b);
		}
		if (getCorner(0, 3, 4).getFace1() == 10
				|| getCorner(0, 3, 4).getFace2() == 10
				|| getCorner(0, 3, 4).getFace3() == 10) {
			while (!(getCorner(0, 3, 4).getFace1() == 9
					|| getCorner(0, 3, 4).getFace2() == 9 || getCorner(0, 3, 4)
					.getFace3() == 9)) {
				turn(10);
			}
		}
		if (getCorner(0, 3, 4).getFace1() == 9
				|| getCorner(0, 3, 4).getFace2() == 9
				|| getCorner(0, 3, 4).getFace3() == 9) {
			while (!(getCorner(0, 3, 4).getFace1() == 8
					|| getCorner(0, 3, 4).getFace2() == 8 || getCorner(0, 3, 4)
					.getFace3() == 8)) {
				turn(9);
			}
		}
		if (getCorner(0, 3, 4).getFace1() == 7
				|| getCorner(0, 3, 4).getFace2() == 7
				|| getCorner(0, 3, 4).getFace3() == 7) {
			while (!(getCorner(0, 3, 4).getFace1() == 6
					|| getCorner(0, 3, 4).getFace2() == 6 || getCorner(0, 3, 4)
					.getFace3() == 6)) {
				turn(7);
			}
		}
		if (getCorner(0, 3, 4).getFace1() == 8
				|| getCorner(0, 3, 4).getFace2() == 8
				|| getCorner(0, 3, 4).getFace3() == 8) {
			while (!((getCorner(0, 3, 4).getFace1() == 8
					|| getCorner(0, 3, 4).getFace2() == 8 || getCorner(0, 3, 4)
					.getFace3() == 8)
					&& (getCorner(0, 3, 4).getFace1() == 3
							|| getCorner(0, 3, 4).getFace2() == 3 || getCorner(
							0, 3, 4).getFace3() == 3) && (getCorner(0, 3, 4)
					.getFace1() == 4 || getCorner(0, 3, 4).getFace2() == 4 || getCorner(
						0, 3, 4).getFace3() == 3))) {
				turn(8);
			}
			while (getCorner(0, 3, 4).getFace1() != 0) {
				turnR(3);
				turnR(8);
				turn(3);
				turn(8);
			}
		}
		if (getCorner(0, 3, 4).getFace1() == 6
				|| getCorner(0, 3, 4).getFace2() == 6
				|| getCorner(0, 3, 4).getFace3() == 6) {
			while (!(getCorner(0, 3, 4).getFace1() == 10
					|| getCorner(0, 3, 4).getFace2() == 10 || getCorner(0, 3, 4)
					.getFace3() == 10)) {
				turn(6);
			}
		}

		if (getCorner(0, 4, 5).getFace1() == 0
				|| getCorner(0, 4, 5).getFace2() == 0
				|| getCorner(0, 4, 5).getFace3() == 0) {
			int a = getCorner(0, 4, 5).getFace2();
			int b = getCorner(0, 4, 5).getFace3();
			turnR(a);
			turnR(b);
			turn(a);
			turn(b);
		}
		if (getCorner(0, 4, 5).getFace1() == 8
				|| getCorner(0, 4, 5).getFace2() == 8
				|| getCorner(0, 4, 5).getFace3() == 8) {
			while (!(getCorner(0, 4, 5).getFace1() == 7
					|| getCorner(0, 4, 5).getFace2() == 7 || getCorner(0, 4, 5)
					.getFace3() == 7)) {
				turn(8);
			}
		}
		if (getCorner(0, 4, 5).getFace1() == 9
				|| getCorner(0, 4, 5).getFace2() == 9
				|| getCorner(0, 4, 5).getFace3() == 9) {
			while (!(getCorner(0, 4, 5).getFace1() == 8
					|| getCorner(0, 4, 5).getFace2() == 8 || getCorner(0, 4, 5)
					.getFace3() == 8)) {
				turn(9);
			}
		}
		if (getCorner(0, 4, 5).getFace1() == 7
				|| getCorner(0, 4, 5).getFace2() == 7
				|| getCorner(0, 4, 5).getFace3() == 7) {
			while (!(getCorner(0, 4, 5).getFace1() == 6
					|| getCorner(0, 4, 5).getFace2() == 6 || getCorner(0, 4, 5)
					.getFace3() == 6)) {
				turn(7);
			}
		}
		if (getCorner(0, 4, 5).getFace1() == 10
				|| getCorner(0, 4, 5).getFace2() == 10
				|| getCorner(0, 4, 5).getFace3() == 10) {
			while (!((getCorner(0, 4, 5).getFace1() == 10
					|| getCorner(0, 4, 5).getFace2() == 10 || getCorner(0, 4, 5)
					.getFace3() == 8)
					&& (getCorner(0, 4, 5).getFace1() == 5
							|| getCorner(0, 4, 5).getFace2() == 5 || getCorner(
							0, 4, 5).getFace3() == 5) && (getCorner(0, 4, 5)
					.getFace1() == 1 || getCorner(0, 4, 5).getFace2() == 1 || getCorner(
						0, 4, 5).getFace3() == 1))) {
				turn(10);
			}
			while (getCorner(0, 4, 5).getFace1() != 0) {
				turnR(4);
				turnR(10);
				turn(4);
				turn(10);
			}
		}
		if (getCorner(0, 4, 5).getFace1() == 6
				|| getCorner(0, 4, 5).getFace2() == 6
				|| getCorner(0, 4, 5).getFace3() == 6) {
			while (!(getCorner(0, 4, 5).getFace1() == 10
					|| getCorner(0, 4, 5).getFace2() == 10 || getCorner(0, 4, 5)
					.getFace3() == 10)) {
				turn(6);
			}
		}
	}

	// finishes making the second layer of the MegaMinx
	public void makeLayerTwo() {
		EdgePiece a1 = getEdge(1, 2);
		if (a1.getFace1() < 6
				&& a1.getFace2() < 6
				&& ((Math.abs(a1.getFace2() - a1.getFace1()) == 1) || ((a1
						.getFace1() == 5 && a1.getFace2() == 1) || (a1
						.getFace1() == 1 && a1.getFace2() == 5)))) {
			//insert edge algorithm
			int a = a1.getFace2();
			int b = a1.getFace1();
			turn(a);
			int c = a1.getFace1();
			turnR(c);
			turnR(a);
			turnR(c);
			turnR(b);
			turn(c);
			turn(b);
		}
		if (a1.getFace1() == 10 || a1.getFace2() == 10) {
			while (!(a1.getFace1() == 9
					|| a1.getFace2() == 9)) {
				turn(10);
			}
		}
		if (a1.getFace1() == 9 || a1.getFace2() == 9) {
			while (!(a1.getFace1() == 8
					|| a1.getFace2() == 8)) {
				turn(9);
			}
		}
		if (a1.getFace1() == 8 || a1.getFace2() ==  8) {
			while (!(a1.getFace1() == 7
					|| a1.getFace2() == 7)) {
				turn(8);
			}
		}
		if (a1.getFace1() == 8 || a1.getFace2() == 8) {
			while (!(a1.getFace1() == 9
					|| a1.getFace2() == 9)) {
				turn(10);
			}
		}
	}
	

	public void turn(int f) {
		switch (f) {
		case 0:
			turn0();
			break;
		case 1:
			turn1();
			break;
		case 2:
			turn2();
			break;
		case 3:
			turn3();
			break;
		case 4:
			turn4();
			break;
		case 5:
			turn5();
			break;
		case 6:
			turn6();
			break;
		case 7:
			turn7();
			break;
		case 8:
			turn8();
			break;
		case 9:
			turn9();
			break;
		case 10:
			turn10();
			break;
		case 11:
			turn11();
			break;

		}

	}

	public void turnR(int f) {
		switch (f) {
		case 0:
			turn0();
			turn0();
			turn0();
			turn0();
			break;
		case 1:
			turn1();
			turn1();
			turn1();
			turn1();
			break;
		case 2:
			turn2();
			turn2();
			turn2();
			turn2();
			break;
		case 3:
			turn3();
			turn3();
			turn3();
			turn3();
			break;
		case 4:
			turn4();
			turn4();
			turn4();
			turn4();
			break;
		case 5:
			turn5();
			turn5();
			turn5();
			turn5();
			break;
		case 6:
			turn6();
			turn6();
			turn6();
			turn6();
			break;
		case 7:
			turn7();
			turn7();
			turn7();
			turn7();
			break;
		case 8:
			turn8();
			turn8();
			turn8();
			turn8();
			break;
		case 9:
			turn9();
			turn9();
			turn9();
			turn9();
			break;
		case 10:
			turn10();
			turn10();
			turn10();
			turn10();
			break;
		case 11:
			turn11();
			turn11();
			turn11();
			turn11();
			break;

		}
	}

	public void turn2(int f) {
		switch (f) {
		case 0:
			turn0();
			turn0();
			break;
		case 1:
			turn1();
			turn1();
			break;
		case 2:
			turn2();
			turn2();
			break;
		case 3:
			turn3();
			turn3();
			break;
		case 4:
			turn4();
			turn4();
			break;
		case 5:
			turn5();
			turn5();
			break;
		case 6:
			turn6();
			turn6();
			break;
		case 7:
			turn7();
			turn7();
			break;
		case 8:
			turn8();
			turn8();
			break;
		case 9:
			turn9();
			turn9();
			break;
		case 10:
			turn10();
			turn10();
			break;
		case 11:
			turn11();
			turn11();
			break;

		}
	}

	public void turn2R(int f) {
		switch (f) {
		case 0:
			turn0();
			turn0();
			turn0();
			break;
		case 1:
			turn1();
			turn1();
			turn1();
			break;
		case 2:
			turn2();
			turn2();
			turn2();
			break;
		case 3:
			turn3();
			turn3();
			turn3();
			break;
		case 4:
			turn4();
			turn4();
			turn4();
			break;
		case 5:
			turn5();
			turn5();
			turn5();
			break;
		case 6:
			turn6();
			turn6();
			turn6();
			break;
		case 7:
			turn7();
			turn7();
			turn7();
			break;
		case 8:
			turn8();
			turn8();
			turn8();
			break;
		case 9:
			turn9();
			turn9();
			turn9();
			break;
		case 10:
			turn10();
			turn10();
			turn10();
			break;
		case 11:
			turn11();
			turn11();
			turn11();
			break;

		}
	}

	public void turn0() {
		int c1 = getEdge(0, 5).getColor1();
		int c2 = getEdge(0, 5).getColor2();
		getEdge(0, 5).setColor1(getEdge(0, 4).getColor1());
		getEdge(0, 5).setColor2(getEdge(0, 4).getColor2());
		getEdge(0, 4).setColor1(getEdge(0, 3).getColor1());
		getEdge(0, 4).setColor2(getEdge(0, 3).getColor2());
		getEdge(0, 3).setColor1(getEdge(0, 2).getColor1());
		getEdge(0, 3).setColor2(getEdge(0, 2).getColor2());
		getEdge(0, 2).setColor1(getEdge(0, 1).getColor1());
		getEdge(0, 2).setColor2(getEdge(0, 1).getColor2());
		getEdge(0, 1).setColor1(c1);
		getEdge(0, 1).setColor2(c2);

		int c0 = getCorner(0, 1, 5).getColor1();
		c1 = getCorner(0, 1, 5).getColor2();
		c2 = getCorner(0, 1, 5).getColor3();
		getCorner(0, 1, 5).setColor1(getCorner(0, 4, 5).getColor1());
		getCorner(0, 1, 5).setColor2(getCorner(0, 4, 5).getColor2());
		getCorner(0, 1, 5).setColor3(getCorner(0, 4, 5).getColor3());
		getCorner(0, 4, 5).setColor1(getCorner(0, 3, 4).getColor1());
		getCorner(0, 4, 5).setColor2(getCorner(0, 3, 4).getColor2());
		getCorner(0, 4, 5).setColor3(getCorner(0, 3, 4).getColor3());
		getCorner(0, 3, 4).setColor1(getCorner(0, 2, 3).getColor1());
		getCorner(0, 3, 4).setColor2(getCorner(0, 2, 3).getColor2());
		getCorner(0, 3, 4).setColor3(getCorner(0, 2, 3).getColor3());
		getCorner(0, 2, 3).setColor1(getCorner(0, 1, 2).getColor1());
		getCorner(0, 2, 3).setColor2(getCorner(0, 1, 2).getColor2());
		getCorner(0, 2, 3).setColor3(getCorner(0, 1, 2).getColor3());
		getCorner(0, 1, 2).setColor1(c0);
		getCorner(0, 1, 2).setColor2(c1);
		getCorner(0, 1, 2).setColor3(c2);

	}

	public void turn1() {
		int c1 = getEdge(1, 2).getColor1();
		int c2 = getEdge(1, 2).getColor2();
		getEdge(1, 2).setColor1(getEdge(1, 6).getColor1());
		getEdge(1, 2).setColor2(getEdge(1, 6).getColor2());
		getEdge(1, 6).setColor1(getEdge(1, 10).getColor1());
		getEdge(1, 6).setColor2(getEdge(1, 10).getColor2());
		getEdge(1, 10).setColor1(getEdge(1, 5).getColor1());
		getEdge(1, 10).setColor2(getEdge(1, 5).getColor2());
		getEdge(1, 5).setColor1(getEdge(0, 1).getColor2());
		getEdge(1, 5).setColor2(getEdge(0, 1).getColor1());
		getEdge(0, 1).setColor2(c1);
		getEdge(0, 1).setColor1(c2);

		int c0 = getCorner(1, 2, 6).getColor1();
		c1 = getCorner(1, 2, 6).getColor2();
		c2 = getCorner(1, 2, 6).getColor3();
		getCorner(1, 2, 6).setColor1(getCorner(1, 6, 10).getColor1());
		getCorner(1, 2, 6).setColor2(getCorner(1, 6, 10).getColor2());
		getCorner(1, 2, 6).setColor3(getCorner(1, 6, 10).getColor3());
		getCorner(1, 6, 10).setColor1(getCorner(1, 5, 10).getColor1());
		getCorner(1, 6, 10).setColor2(getCorner(1, 5, 10).getColor2());
		getCorner(1, 6, 10).setColor3(getCorner(1, 5, 10).getColor3());
		getCorner(1, 5, 10).setColor1(getCorner(0, 1, 5).getColor2());
		getCorner(1, 5, 10).setColor2(getCorner(0, 1, 5).getColor3());
		getCorner(1, 5, 10).setColor3(getCorner(0, 1, 5).getColor1());
		getCorner(0, 1, 5).setColor2(getCorner(0, 1, 2).getColor3());
		getCorner(0, 1, 5).setColor3(getCorner(0, 1, 2).getColor1());
		getCorner(0, 1, 5).setColor1(getCorner(0, 1, 2).getColor2());
		getCorner(0, 1, 2).setColor1(c0);
		getCorner(0, 1, 2).setColor2(c1);
		getCorner(0, 1, 2).setColor3(c2);

	}

	public void turn2() {
		int c1 = getEdge(2, 3).getColor1();
		int c2 = getEdge(2, 3).getColor2();
		getEdge(2, 3).setColor1(getEdge(2, 7).getColor1());
		getEdge(2, 3).setColor2(getEdge(2, 7).getColor2());
		getEdge(2, 7).setColor1(getEdge(2, 6).getColor1());
		getEdge(2, 7).setColor2(getEdge(2, 6).getColor2());
		getEdge(2, 6).setColor1(getEdge(1, 2).getColor2());
		getEdge(2, 6).setColor2(getEdge(1, 2).getColor1());
		getEdge(1, 2).setColor2(getEdge(0, 2).getColor2());
		getEdge(1, 2).setColor1(getEdge(0, 2).getColor1());
		getEdge(0, 2).setColor2(c1);
		getEdge(0, 2).setColor1(c2);

		int c0 = getCorner(2, 3, 7).getColor1();
		c1 = getCorner(2, 3, 7).getColor2();
		c2 = getCorner(2, 3, 7).getColor3();
		getCorner(2, 3, 7).setColor1(getCorner(2, 6, 7).getColor1());
		getCorner(2, 3, 7).setColor2(getCorner(2, 6, 7).getColor2());
		getCorner(2, 3, 7).setColor3(getCorner(2, 6, 7).getColor3());
		getCorner(2, 6, 7).setColor1(getCorner(1, 2, 6).getColor2());
		getCorner(2, 6, 7).setColor2(getCorner(1, 2, 6).getColor3());
		getCorner(2, 6, 7).setColor3(getCorner(1, 2, 6).getColor1());
		getCorner(1, 2, 6).setColor2(getCorner(0, 1, 2).getColor2());
		getCorner(1, 2, 6).setColor3(getCorner(0, 1, 2).getColor3());
		getCorner(1, 2, 6).setColor1(getCorner(0, 1, 2).getColor1());
		getCorner(0, 1, 2).setColor2(getCorner(0, 2, 3).getColor3());
		getCorner(0, 1, 2).setColor3(getCorner(0, 2, 3).getColor1());
		getCorner(0, 1, 2).setColor1(getCorner(0, 2, 3).getColor2());
		getCorner(0, 2, 3).setColor1(c0);
		getCorner(0, 2, 3).setColor2(c1);
		getCorner(0, 2, 3).setColor3(c2);

	}

	public void turn3() {
		int c1 = getEdge(3, 4).getColor1();
		int c2 = getEdge(3, 4).getColor2();
		getEdge(3, 4).setColor1(getEdge(3, 8).getColor1());
		getEdge(3, 4).setColor2(getEdge(3, 8).getColor2());
		getEdge(3, 8).setColor1(getEdge(3, 7).getColor1());
		getEdge(3, 8).setColor2(getEdge(3, 7).getColor2());
		getEdge(3, 7).setColor1(getEdge(2, 3).getColor2());
		getEdge(3, 7).setColor2(getEdge(2, 3).getColor1());
		getEdge(2, 3).setColor2(getEdge(0, 3).getColor2());
		getEdge(2, 3).setColor1(getEdge(0, 3).getColor1());
		getEdge(0, 3).setColor2(c1);
		getEdge(0, 3).setColor1(c2);

		int c0 = getCorner(3, 4, 8).getColor1();
		c1 = getCorner(3, 4, 8).getColor2();
		c2 = getCorner(3, 4, 8).getColor3();
		getCorner(3, 4, 8).setColor1(getCorner(3, 7, 8).getColor1());
		getCorner(3, 4, 8).setColor2(getCorner(3, 7, 8).getColor2());
		getCorner(3, 4, 8).setColor3(getCorner(3, 7, 8).getColor3());
		getCorner(3, 7, 8).setColor1(getCorner(2, 3, 7).getColor2());
		getCorner(3, 7, 8).setColor2(getCorner(2, 3, 7).getColor3());
		getCorner(3, 7, 8).setColor3(getCorner(2, 3, 7).getColor1());
		getCorner(2, 3, 7).setColor2(getCorner(0, 2, 3).getColor2());
		getCorner(2, 3, 7).setColor3(getCorner(0, 2, 3).getColor3());
		getCorner(2, 3, 7).setColor1(getCorner(0, 2, 3).getColor1());
		getCorner(0, 2, 3).setColor2(getCorner(3, 4, 8).getColor3());
		getCorner(0, 2, 3).setColor3(getCorner(3, 4, 8).getColor1());
		getCorner(0, 2, 3).setColor1(getCorner(3, 4, 8).getColor2());
		getCorner(3, 4, 8).setColor1(c0);
		getCorner(3, 4, 8).setColor2(c1);
		getCorner(3, 4, 8).setColor3(c2);

	}

	public void turn4() {
		int c1 = getEdge(4, 5).getColor1();
		int c2 = getEdge(4, 5).getColor2();
		getEdge(4, 5).setColor1(getEdge(4, 9).getColor1());
		getEdge(4, 5).setColor2(getEdge(4, 9).getColor2());
		getEdge(4, 9).setColor1(getEdge(4, 8).getColor1());
		getEdge(4, 9).setColor2(getEdge(4, 8).getColor2());
		getEdge(4, 8).setColor1(getEdge(3, 4).getColor2());
		getEdge(4, 8).setColor2(getEdge(3, 4).getColor1());
		getEdge(3, 4).setColor2(getEdge(0, 4).getColor2());
		getEdge(3, 4).setColor1(getEdge(0, 4).getColor1());
		getEdge(0, 4).setColor2(c1);
		getEdge(0, 4).setColor1(c2);

		int c0 = getCorner(4, 5, 9).getColor1();
		c1 = getCorner(4, 5, 9).getColor2();
		c2 = getCorner(4, 5, 9).getColor3();
		getCorner(4, 5, 9).setColor1(getCorner(4, 8, 9).getColor1());
		getCorner(4, 5, 9).setColor2(getCorner(4, 8, 9).getColor2());
		getCorner(4, 5, 9).setColor3(getCorner(4, 8, 9).getColor3());
		getCorner(4, 8, 9).setColor1(getCorner(3, 4, 8).getColor2());
		getCorner(4, 8, 9).setColor2(getCorner(3, 4, 8).getColor3());
		getCorner(4, 8, 9).setColor3(getCorner(3, 4, 8).getColor1());
		getCorner(3, 4, 8).setColor2(getCorner(0, 3, 4).getColor2());
		getCorner(3, 4, 8).setColor3(getCorner(0, 3, 4).getColor3());
		getCorner(3, 4, 8).setColor1(getCorner(0, 3, 4).getColor1());
		getCorner(0, 3, 4).setColor2(getCorner(0, 4, 5).getColor3());
		getCorner(0, 3, 4).setColor3(getCorner(0, 4, 5).getColor1());
		getCorner(0, 3, 4).setColor1(getCorner(0, 4, 5).getColor2());
		getCorner(0, 4, 5).setColor1(c0);
		getCorner(0, 4, 5).setColor2(c1);
		getCorner(0, 4, 5).setColor3(c2);

	}

	public void turn5() {
		int c1 = getEdge(5, 10).getColor1();
		int c2 = getEdge(5, 10).getColor2();
		getEdge(5, 10).setColor1(getEdge(5, 9).getColor1());
		getEdge(5, 10).setColor2(getEdge(5, 9).getColor2());
		getEdge(5, 9).setColor2(getEdge(4, 5).getColor1());
		getEdge(5, 9).setColor1(getEdge(4, 5).getColor2());
		getEdge(4, 5).setColor2(getEdge(0, 5).getColor2());
		getEdge(4, 5).setColor1(getEdge(0, 5).getColor1());
		getEdge(0, 5).setColor2(getEdge(1, 5).getColor2());
		getEdge(0, 5).setColor1(getEdge(1, 5).getColor1());
		getEdge(1, 5).setColor2(c1);
		getEdge(1, 5).setColor1(c2);

		int c0 = getCorner(5, 9, 10).getColor1();
		c1 = getCorner(5, 9, 10).getColor2();
		c2 = getCorner(5, 9, 10).getColor3();
		getCorner(5, 9, 10).setColor1(getCorner(4, 5, 9).getColor2());
		getCorner(5, 9, 10).setColor2(getCorner(4, 5, 9).getColor3());
		getCorner(5, 9, 10).setColor3(getCorner(4, 5, 9).getColor1());
		getCorner(4, 5, 9).setColor2(getCorner(0, 4, 5).getColor2());
		getCorner(4, 5, 9).setColor3(getCorner(0, 4, 5).getColor3());
		getCorner(4, 5, 9).setColor1(getCorner(0, 4, 5).getColor1());
		getCorner(0, 4, 5).setColor2(getCorner(0, 1, 5).getColor3());
		getCorner(0, 4, 5).setColor3(getCorner(0, 1, 5).getColor1());
		getCorner(0, 4, 5).setColor1(getCorner(0, 1, 5).getColor2());
		getCorner(0, 1, 5).setColor3(getCorner(1, 5, 10).getColor3());
		getCorner(0, 1, 5).setColor1(getCorner(1, 5, 10).getColor1());
		getCorner(0, 1, 5).setColor2(getCorner(1, 5, 10).getColor2());
		getCorner(0, 4, 5).setColor3(c0);
		getCorner(0, 4, 5).setColor1(c1);
		getCorner(0, 4, 5).setColor2(c2);

	}

	public void turn6() {
		int c1 = getEdge(1, 6).getColor2();
		int c2 = getEdge(1, 6).getColor1();
		getEdge(1, 6).setColor2(getEdge(2, 6).getColor2());
		getEdge(1, 6).setColor1(getEdge(2, 6).getColor1());
		getEdge(2, 6).setColor2(getEdge(6, 7).getColor1());
		getEdge(2, 6).setColor1(getEdge(6, 7).getColor2());
		getEdge(6, 7).setColor1(getEdge(6, 11).getColor1());
		getEdge(6, 7).setColor2(getEdge(6, 11).getColor2());
		getEdge(6, 11).setColor1(getEdge(6, 10).getColor1());
		getEdge(6, 11).setColor2(getEdge(6, 10).getColor2());
		getEdge(6, 10).setColor1(c1);
		getEdge(6, 10).setColor2(c2);

		int c0 = getCorner(6, 7, 11).getColor1();
		c1 = getCorner(6, 7, 11).getColor2();
		c2 = getCorner(6, 7, 11).getColor3();
		getCorner(6, 7, 11).setColor1(getCorner(6, 11, 10).getColor1());
		getCorner(6, 7, 11).setColor2(getCorner(6, 11, 10).getColor2());
		getCorner(6, 7, 11).setColor3(getCorner(6, 11, 10).getColor3());
		getCorner(6, 11, 10).setColor1(getCorner(1, 6, 10).getColor2());
		getCorner(6, 11, 10).setColor2(getCorner(1, 6, 10).getColor3());
		getCorner(6, 11, 10).setColor3(getCorner(1, 6, 10).getColor1());
		getCorner(1, 6, 10).setColor2(getCorner(1, 2, 6).getColor3());
		getCorner(1, 6, 10).setColor3(getCorner(1, 2, 6).getColor1());
		getCorner(1, 6, 10).setColor1(getCorner(1, 2, 6).getColor2());
		getCorner(1, 2, 6).setColor3(getCorner(2, 6, 7).getColor3());
		getCorner(1, 2, 6).setColor1(getCorner(2, 6, 7).getColor1());
		getCorner(1, 2, 6).setColor2(getCorner(2, 6, 7).getColor2());
		getCorner(2, 6, 7).setColor3(c0);
		getCorner(2, 6, 7).setColor1(c1);
		getCorner(2, 6, 7).setColor2(c2);

	}

	public void turn7() {
		int c1 = getEdge(2, 7).getColor2();
		int c2 = getEdge(2, 7).getColor1();
		getEdge(2, 7).setColor2(getEdge(3, 7).getColor2());
		getEdge(2, 7).setColor1(getEdge(3, 7).getColor1());
		getEdge(3, 7).setColor2(getEdge(7, 8).getColor1());
		getEdge(3, 7).setColor1(getEdge(7, 8).getColor2());
		getEdge(7, 8).setColor1(getEdge(7, 11).getColor1());
		getEdge(7, 8).setColor2(getEdge(7, 11).getColor2());
		getEdge(7, 11).setColor1(getEdge(6, 7).getColor2());
		getEdge(7, 11).setColor2(getEdge(6, 7).getColor1());
		getEdge(6, 7).setColor2(c1);
		getEdge(6, 7).setColor1(c2);

		int c0 = getCorner(5, 9, 10).getColor1();
		c1 = getCorner(5, 9, 10).getColor2();
		c2 = getCorner(5, 9, 10).getColor3();
		getCorner(5, 9, 10).setColor2(getCorner(6, 7, 11).getColor2());
		getCorner(5, 9, 10).setColor3(getCorner(6, 7, 11).getColor3());
		getCorner(5, 9, 10).setColor1(getCorner(6, 7, 11).getColor1());
		getCorner(6, 7, 11).setColor2(getCorner(2, 6, 7).getColor2());
		getCorner(6, 7, 11).setColor3(getCorner(2, 6, 7).getColor3());
		getCorner(6, 7, 11).setColor1(getCorner(2, 6, 7).getColor1());
		getCorner(2, 6, 7).setColor2(getCorner(2, 3, 7).getColor3());
		getCorner(2, 6, 7).setColor3(getCorner(2, 3, 7).getColor1());
		getCorner(2, 6, 7).setColor1(getCorner(2, 3, 7).getColor2());
		getCorner(2, 3, 7).setColor3(getCorner(3, 7, 8).getColor3());
		getCorner(2, 3, 7).setColor1(getCorner(3, 7, 8).getColor1());
		getCorner(2, 3, 7).setColor2(getCorner(3, 7, 8).getColor2());
		getCorner(3, 7, 8).setColor3(c0);
		getCorner(3, 7, 8).setColor1(c1);
		getCorner(3, 7, 8).setColor2(c2);

	}

	public void turn8() {
		int c1 = getEdge(3, 8).getColor2();
		int c2 = getEdge(3, 8).getColor1();
		getEdge(3, 8).setColor2(getEdge(4, 8).getColor2());
		getEdge(3, 8).setColor1(getEdge(4, 8).getColor1());
		getEdge(4, 8).setColor2(getEdge(8, 9).getColor1());
		getEdge(4, 8).setColor1(getEdge(8, 9).getColor2());
		getEdge(8, 9).setColor1(getEdge(8, 11).getColor1());
		getEdge(8, 9).setColor2(getEdge(8, 11).getColor2());
		getEdge(8, 11).setColor1(getEdge(7, 8).getColor2());
		getEdge(8, 11).setColor2(getEdge(7, 8).getColor1());
		getEdge(7, 8).setColor2(c1);
		getEdge(7, 8).setColor1(c2);

		int c0 = getCorner(8, 9, 11).getColor1();
		c1 = getCorner(8, 9, 11).getColor2();
		c2 = getCorner(8, 9, 11).getColor3();
		getCorner(8, 9, 11).setColor1(getCorner(7, 8, 11).getColor2());
		getCorner(8, 9, 11).setColor2(getCorner(7, 8, 11).getColor3());
		getCorner(8, 9, 11).setColor3(getCorner(7, 8, 11).getColor1());
		getCorner(7, 8, 11).setColor2(getCorner(3, 7, 8).getColor2());
		getCorner(7, 8, 11).setColor3(getCorner(3, 7, 8).getColor3());
		getCorner(7, 8, 11).setColor1(getCorner(3, 7, 8).getColor1());
		getCorner(3, 7, 8).setColor2(getCorner(3, 4, 8).getColor3());
		getCorner(3, 7, 8).setColor3(getCorner(3, 4, 8).getColor1());
		getCorner(3, 7, 8).setColor1(getCorner(3, 4, 8).getColor2());
		getCorner(3, 4, 8).setColor3(getCorner(4, 8, 9).getColor3());
		getCorner(3, 4, 8).setColor1(getCorner(4, 8, 9).getColor1());
		getCorner(3, 4, 8).setColor2(getCorner(4, 8, 9).getColor2());
		getCorner(4, 8, 9).setColor3(c0);
		getCorner(4, 8, 9).setColor1(c1);
		getCorner(4, 8, 9).setColor2(c2);

	}

	public void turn9() {
		int c1 = getEdge(4, 9).getColor2();
		int c2 = getEdge(4, 9).getColor1();
		getEdge(4, 9).setColor2(getEdge(5, 9).getColor2());
		getEdge(4, 9).setColor1(getEdge(5, 9).getColor1());
		getEdge(5, 9).setColor2(getEdge(9, 10).getColor1());
		getEdge(5, 9).setColor1(getEdge(9, 10).getColor2());
		getEdge(9, 10).setColor1(getEdge(9, 11).getColor1());
		getEdge(9, 10).setColor2(getEdge(9, 11).getColor2());
		getEdge(9, 11).setColor1(getEdge(8, 9).getColor2());
		getEdge(9, 11).setColor2(getEdge(8, 9).getColor1());
		getEdge(8, 9).setColor2(c1);
		getEdge(8, 9).setColor1(c2);

		int c0 = getCorner(9, 10, 11).getColor1();
		c1 = getCorner(9, 10, 11).getColor2();
		c2 = getCorner(9, 10, 11).getColor3();
		getCorner(9, 10, 11).setColor1(getCorner(8, 9, 11).getColor2());
		getCorner(9, 10, 11).setColor2(getCorner(8, 9, 11).getColor3());
		getCorner(9, 10, 11).setColor3(getCorner(8, 9, 11).getColor1());
		getCorner(8, 9, 11).setColor2(getCorner(4, 8, 9).getColor2());
		getCorner(8, 9, 11).setColor3(getCorner(4, 8, 9).getColor3());
		getCorner(8, 9, 11).setColor1(getCorner(4, 8, 9).getColor1());
		getCorner(4, 8, 9).setColor2(getCorner(4, 5, 9).getColor3());
		getCorner(4, 8, 9).setColor3(getCorner(4, 5, 9).getColor1());
		getCorner(4, 8, 9).setColor1(getCorner(4, 5, 9).getColor2());
		getCorner(4, 5, 9).setColor3(getCorner(5, 9, 10).getColor3());
		getCorner(4, 5, 9).setColor1(getCorner(5, 9, 10).getColor1());
		getCorner(4, 5, 9).setColor2(getCorner(5, 9, 10).getColor2());
		getCorner(5, 9, 10).setColor3(c0);
		getCorner(5, 9, 10).setColor1(c1);
		getCorner(5, 9, 10).setColor2(c2);

	}

	public void turn10() {
		int c1 = getEdge(1, 10).getColor2();
		int c2 = getEdge(1, 10).getColor1();
		getEdge(1, 10).setColor2(getEdge(6, 10).getColor2());
		getEdge(1, 10).setColor1(getEdge(6, 10).getColor1());
		getEdge(6, 10).setColor2(getEdge(10, 11).getColor1());
		getEdge(6, 10).setColor1(getEdge(10, 11).getColor2());
		getEdge(10, 11).setColor1(getEdge(9, 10).getColor2());
		getEdge(10, 11).setColor2(getEdge(9, 10).getColor1());
		getEdge(9, 10).setColor2(getEdge(5, 10).getColor2());
		getEdge(9, 10).setColor1(getEdge(5, 10).getColor1());
		getEdge(5, 10).setColor2(c1);
		getEdge(5, 10).setColor1(c2);

		int c0 = getCorner(9, 10, 11).getColor2();
		c1 = getCorner(9, 10, 11).getColor3();
		c2 = getCorner(9, 10, 11).getColor1();
		getCorner(9, 10, 11).setColor2(getCorner(5, 9, 10).getColor2());
		getCorner(9, 10, 11).setColor3(getCorner(5, 9, 10).getColor3());
		getCorner(9, 10, 11).setColor1(getCorner(5, 9, 10).getColor1());
		getCorner(5, 9, 10).setColor2(getCorner(1, 5, 10).getColor2());
		getCorner(5, 9, 10).setColor3(getCorner(1, 5, 10).getColor3());
		getCorner(5, 9, 10).setColor1(getCorner(1, 5, 10).getColor1());
		getCorner(1, 5, 10).setColor2(getCorner(1, 6, 10).getColor3());
		getCorner(1, 5, 10).setColor3(getCorner(1, 6, 10).getColor1());
		getCorner(1, 5, 10).setColor1(getCorner(1, 6, 10).getColor2());
		getCorner(1, 6, 10).setColor3(getCorner(6, 10, 11).getColor3());
		getCorner(1, 6, 10).setColor1(getCorner(6, 10, 11).getColor1());
		getCorner(1, 6, 10).setColor2(getCorner(6, 10, 11).getColor2());
		getCorner(6, 10, 11).setColor3(c0);
		getCorner(6, 10, 11).setColor1(c1);
		getCorner(6, 10, 11).setColor2(c2);

	}

	public void turn11() {
		int c1 = getEdge(6, 11).getColor2();
		int c2 = getEdge(6, 11).getColor1();
		getEdge(6, 11).setColor2(getEdge(7, 11).getColor2());
		getEdge(6, 11).setColor1(getEdge(7, 11).getColor1());
		getEdge(7, 11).setColor2(getEdge(8, 11).getColor2());
		getEdge(7, 11).setColor1(getEdge(8, 11).getColor1());
		getEdge(8, 11).setColor2(getEdge(9, 11).getColor2());
		getEdge(8, 11).setColor1(getEdge(9, 11).getColor1());
		getEdge(9, 11).setColor2(getEdge(10, 11).getColor2());
		getEdge(9, 11).setColor1(getEdge(10, 11).getColor1());
		getEdge(10, 11).setColor2(c1);
		getEdge(10, 11).setColor1(c2);

		int c0 = getCorner(6, 10, 11).getColor2();
		c1 = getCorner(6, 10, 11).getColor3();
		c2 = getCorner(6, 10, 11).getColor1();
		getCorner(6, 10, 11).setColor2(getCorner(6, 7, 11).getColor3());
		getCorner(6, 10, 11).setColor3(getCorner(6, 7, 11).getColor1());
		getCorner(6, 10, 11).setColor1(getCorner(6, 7, 11).getColor2());
		getCorner(6, 7, 11).setColor3(getCorner(7, 8, 11).getColor3());
		getCorner(6, 7, 11).setColor1(getCorner(7, 8, 11).getColor1());
		getCorner(6, 7, 11).setColor2(getCorner(7, 8, 11).getColor2());
		getCorner(7, 8, 11).setColor3(getCorner(8, 9, 11).getColor3());
		getCorner(7, 8, 11).setColor1(getCorner(8, 9, 11).getColor1());
		getCorner(7, 8, 11).setColor2(getCorner(8, 9, 11).getColor2());
		getCorner(8, 9, 11).setColor3(getCorner(9, 10, 11).getColor3());
		getCorner(8, 9, 11).setColor1(getCorner(9, 10, 11).getColor1());
		getCorner(8, 9, 11).setColor2(getCorner(9, 10, 11).getColor2());
		getCorner(9, 10, 11).setColor3(c0);
		getCorner(9, 10, 11).setColor1(c1);
		getCorner(9, 10, 11).setColor2(c2);

	}

	public int getCornerNumber(int f1, int f2, int f3) {

		switch (f1 + f2 + f3) {
		case 3:
			return 0;
		case 6:
			return 1;
		case 5:
			return 2;
		case 7:
			return 3;
		case 9:
			if (f1 == 0 || f2 == 0 || f3 == 0)
				return 4;
			return 5;
		case 16:
			return 6;
		case 17:
			if (f1 == 1 || f2 == 1 || f3 == 1)
				return 7;
			return 8;
		case 12:
			return 9;
		case 15:
			if (f1 == 2 || f2 == 2 || f3 == 2)
				return 10;
			return 11;
		case 18:
			return 12;
		case 21:
			return 13;
		case 24:
			if (f1 == 5 || f2 == 5 || f3 == 5)
				return 14;
			return 15;
		case 27:
			return 16;
		case 26:
			return 17;
		case 28:
			return 18;
		case 30:
			return 19;

		}
		return -1;
	}

	public int getEdgeNumber(int f1, int f2) {
		if (f1 > f2) {
			int t = f1;
			f1 = f2;
			f2 = t;
		}

		int n = f1 * 10 + f2;

		switch (n) {
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;
		case 4:
			return 3;
		case 5:
			return 4;
		case 12:
			return 5;
		case 15:
			return 6;
		case 19:
			return 7;
		case 20:
			return 8;
		case 23:
			return 9;
		case 26:
			return 10;
		case 27:
			return 11;
		case 34:
			return 12;
		case 37:
			return 13;
		case 38:
			return 14;
		case 45:
			return 15;
		case 48:
			return 16;
		case 49:
			return 17;
		case 59:
			return 18;
		case 60:
			return 19;
		case 67:
			return 20;
		case 70:
			return 21;
		case 71:
			return 22;
		case 78:
			return 23;
		case 81:
			return 24;
		case 89:
			return 25;
		case 91:
			return 26;
		case 100:
			return 27;
		case 101:
			return 28;
		case 111:
			return 29;

		}
		return -1;
	}

}
