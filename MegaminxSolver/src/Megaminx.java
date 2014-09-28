import java.io.*;
import java.util.*;

public class Megaminx {
	int firstStarCounter = 0;
	EdgePiece[] e = new EdgePiece[30];
	CornerPiece[] c = new CornerPiece[20];

	public CornerPiece getCorner(int f1, int f2, int f3) {
		return c[getCornerNumber(f1, f2, f3)];
	}
	
	public void initialize() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("minx.txt"));
		StringTokenizer st;
		int[][] a = new int[12][10];
		for(int i = 0; i < a.length; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < a[0].length; j++){
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		e[getEdgeNumber(0,1)] = new EdgePiece(0,1,a[0][1],a[1][5]);
		e[getEdgeNumber(0,2)] = new EdgePiece(0,2,a[0][3],a[2][5]);
		e[getEdgeNumber(0,3)] = new EdgePiece(0,3,a[0][5],a[3][5]);
		e[getEdgeNumber(0,4)] = new EdgePiece(0,4,a[0][7],a[4][5]);
		e[getEdgeNumber(0,5)] = new EdgePiece(0,5,a[0][9],a[5][5]);
		e[getEdgeNumber(1,2)] = new EdgePiece(1,2,a[1][3],a[2][7]);
		e[getEdgeNumber(1,6)] = new EdgePiece(1,6,a[1][1],a[6][1]);
		e[getEdgeNumber(1,10)] = new EdgePiece(1,10,a[1][9],a[10][9]);
		e[getEdgeNumber(1,5)] = new EdgePiece(1,5,a[1][7],a[5][3]);
		e[getEdgeNumber(2,7)] = new EdgePiece(2,7,a[2][1],a[7][1]);
		e[getEdgeNumber(2,3)] = new EdgePiece(2,3,a[2][3],a[3][7]);
		e[getEdgeNumber(2,6)] = new EdgePiece(2,6,a[2][9],a[6][9]);
		e[getEdgeNumber(3,8)] = new EdgePiece(3,8,a[3][1],a[8][1]);
		e[getEdgeNumber(3,4)] = new EdgePiece(3,4,a[3][3],a[4][7]);
		e[getEdgeNumber(3,7)] = new EdgePiece(3,7,a[3][9],a[7][9]);
		e[getEdgeNumber(4,9)] = new EdgePiece(4,9,a[4][1],a[9][1]);
		e[getEdgeNumber(4,5)] = new EdgePiece(4,5,a[4][3],a[5][7]);
		e[getEdgeNumber(4,8)] = new EdgePiece(4,8,a[4][9],a[8][9]);
		e[getEdgeNumber(5,10)] = new EdgePiece(5,10,a[5][1],a[10][1]);
		e[getEdgeNumber(5,9)] = new EdgePiece(5,9,a[5][9],a[9][9]);
		e[getEdgeNumber(6,10)] = new EdgePiece(6,10,a[6][3],a[10][7]);
		e[getEdgeNumber(6,7)] = new EdgePiece(6,7,a[6][7],a[7][3]);
		e[getEdgeNumber(7,8)] = new EdgePiece(7,8,a[7][7],a[8][3]);
		e[getEdgeNumber(8,9)] = new EdgePiece(8,9,a[8][7],a[9][3]);
		e[getEdgeNumber(9,10)] = new EdgePiece(9,10,a[9][7],a[10][3]);
		e[getEdgeNumber(10,11)] = new EdgePiece(10,11,a[10][5],a[11][1]);
		e[getEdgeNumber(9,11)] = new EdgePiece(9,11,a[9][5],a[11][3]);
		e[getEdgeNumber(8,11)] = new EdgePiece(8,11,a[8][5],a[11][5]);
		e[getEdgeNumber(7,11)] = new EdgePiece(7,11,a[7][5],a[11][7]);
		e[getEdgeNumber(6,11)] = new EdgePiece(6,11,a[6][5],a[11][9]);
		
		c[getCornerNumber(0,1,2)] = new CornerPiece(0,1,2,a[0][0],a[1][4],a[2][6]);
		c[getCornerNumber(0,2,3)] = new CornerPiece(0,2,3,a[0][2],a[2][4],a[3][6]);
		c[getCornerNumber(0,3,4)] = new CornerPiece(0,3,4,a[0][4],a[3][4],a[4][6]);
		c[getCornerNumber(0,4,5)] = new CornerPiece(0,4,5,a[0][6],a[4][4],a[5][6]);
		c[getCornerNumber(0,1,5)] = new CornerPiece(0,1,5,a[0][8],a[1][6],a[5][4]);
		c[getCornerNumber(1,5,10)] = new CornerPiece(1,5,10,a[1][8],a[5][2],a[10][0]);
		c[getCornerNumber(1,6,10)] = new CornerPiece(1,6,10,a[1][0],a[6][2],a[10][8]);
		c[getCornerNumber(1,2,6)] = new CornerPiece(1,2,6,a[1][2],a[2][8],a[6][0]);
		c[getCornerNumber(2,3,7)] = new CornerPiece(2,3,7,a[2][2],a[3][8],a[7][0]);
		c[getCornerNumber(2,6,7)] = new CornerPiece(2,6,7,a[2][0],a[6][8],a[7][2]);
		c[getCornerNumber(3,4,8)] = new CornerPiece(3,4,8,a[3][2],a[4][8],a[8][0]);
		c[getCornerNumber(3,7,8)] = new CornerPiece(3,7,8,a[3][0],a[7][8],a[8][2]);
		c[getCornerNumber(4,5,9)] = new CornerPiece(4,5,9,a[4][2],a[5][8],a[9][0]);
		c[getCornerNumber(4,8,9)] = new CornerPiece(4,8,9,a[4][0],a[8][8],a[9][2]);
		c[getCornerNumber(5,9,10)] = new CornerPiece(5,9,10,a[5][0],a[9][8],a[10][2]);
		c[getCornerNumber(6,7,11)] = new CornerPiece(6,7,11,a[6][6],a[7][4],a[11][8]);
		c[getCornerNumber(7,8,11)] = new CornerPiece(7,8,11,a[7][6],a[8][4],a[11][6]);
		c[getCornerNumber(8,9,11)] = new CornerPiece(8,9,11,a[8][6],a[9][4],a[11][4]);
		c[getCornerNumber(9,10,11)] = new CornerPiece(9,10,11,a[9][6],a[10][4],a[11][2]);
		c[getCornerNumber(6,10,11)] = new CornerPiece(6,10,11,a[6][4],a[10][6],a[11][0]);
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		Megaminx m = new Megaminx();
		m.initialize();
		m.makeFirstStar();
		//System.out.println("FIRST STAGE");
		m.correctFirstStar();
		//System.out.println("SECOND STAGE");
		m.completeFirstLayer();	
		//System.out.println("THIRD STAGE");
		//m.makeLayerTwo();
		//System.out.println("FOURTH STAGE");
	}
	
	public boolean check(){

		for(int i = 0; i < e.length; i++){
			if (e[i].getColor1() != e[i].getFace1() || e[i].getColor2() != e[i].getFace2())
				return false;
		}


		
		for(int i = 0; i < c.length; i++){
			if (c[i].getColor1() != c[i].getFace1() || c[i].getColor2() != c[i].getFace2() || c[i].getColor3() != c[i].getFace3()){
				//System.out.println(c[i].getColor3());
				return false;
			}
		}
		return true;
		
		
		
		
	}

	public EdgePiece getEdge(int f1, int f2) {
		return e[getEdgeNumber(f1, f2)];
	}

	public int searchEdge1(int c) {
		for (int i = 0; i < e.length; i++) {
			if (!((e[i].getFace1() == c && e[i].getColor1() == c) 
					|| (e[i].getFace2() == c && e[i].getColor2() == c)) 
					&& e[i].getColor1() == c || e[i].getColor2() == c) {
				//System.out.println(e[i].getFace1()+" "+e[i].getFace2());
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
	public void positionEdgeFirstStar(EdgePiece a) {
		int c1 = a.getColor1();
		int c2 = a.getColor2();
		EdgePiece a1 = e[searchEdge(c1,c2)];
		//System.out.println(e[searchEdge(c1,c2)].getFace1()+" "+e[searchEdge(c1,c2)].getFace2());
		if (firstStarCounter == 0) {
			
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
					a1 = e[searchEdge(c1,c2)];
				}
				
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 8 || a1.getFace2() == 8)) {
					turn(9);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 1 || a1.getFace2() == 1)) {
					turn(6);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(4);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 3 || a1.getFace2() == 3) {
				while (!(a1.getFace1() == 2 || a1.getFace2() == 2)) {
					turn(3);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 2 || a1.getFace2() == 2) {
				while (!(a1.getFace1() == 1 || a1.getFace2() == 1)) {
					turn(2);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 1 || a1.getFace2() == 1) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(1);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			//System.out.println("hi");
			if (a1.getColor1() != 0) {
				//System.out.println("correction");
				int t = a1.getFace2();
				turnR(a1.getFace2());
				turn(0);
				a1 = e[searchEdge(c1,c2)];
				if(a1.getFace2() == t)
					turnR(a1.getFace1());
				else
					turnR(a1.getFace2());
				turnR(0);
				//System.out.println("gecorrection");
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 1) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 8 || a1.getFace2() == 8)) {
					turn(9);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 2 || a1.getFace2() == 2)) {
					turn(6);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(4);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 3 || a1.getFace2() == 3) {
				while (!(a1.getFace1() == 2 || a1.getFace2() == 2)) {
					turn(3);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 2 || a1.getFace2() == 2) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(2);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			//System.out.println("hi");
			if (a1.getColor1() != 0) {
				//System.out.println("correction");
				int t = a1.getFace2();
				turnR(a1.getFace2());
				turn(0);
				a1 = e[searchEdge(c1,c2)];
				if(a1.getFace2() == t)
					turnR(a1.getFace1());
				else
					turnR(a1.getFace2());
				turnR(0);
				//System.out.println("gecorrection");
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 2) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(10);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 8 || a1.getFace2() == 8)) {
					turn(9);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 10 || a1.getFace2() == 10)) {
					turn(6);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 3 || a1.getFace2() == 3)) {
					turn(4);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 3 || a1.getFace2() == 3) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(3);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			//System.out.println("hi");
			if (a1.getColor1() != 0) {
				//System.out.println("correction");
				int t = a1.getFace2();
				turnR(a1.getFace2());
				turn(0);
				a1 = e[searchEdge(c1,c2)];
				if(a1.getFace2() == t)
					turnR(a1.getFace1());
				else
					turnR(a1.getFace2());
				turnR(0);
				//System.out.println("gecorrection");
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 3) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(9);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 10 || a1.getFace2() == 10)) {
					turn(6);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 4 || a1.getFace2() == 4)) {
					turn(5);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 4 || a1.getFace2() == 4) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(4);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			//System.out.println("hi");
			if (a1.getColor1() != 0) {
				//System.out.println("correction");
				int t = a1.getFace2();
				turnR(a1.getFace2());
				turn(0);
				a1 = e[searchEdge(c1,c2)];
				if(a1.getFace2() == t)
					turnR(a1.getFace1());
				else
					turnR(a1.getFace2());
				turnR(0);
				//System.out.println("gecorrection");
			}
			firstStarCounter++;
			return;
		}

		if (firstStarCounter == 4) {
			if (a1.getFace1() == 10 || a1.getFace2() == 10) {
				while (!(a1.getFace1() == 9 || a1.getFace2() == 9)) {
					turn(10);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 9 || a1.getFace2() == 9) {
				while (!(a1.getFace1() == 5 || a1.getFace2() == 5)) {
					turn(9);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 8 || a1.getFace2() == 8) {
				while (!(a1.getFace1() == 7 || a1.getFace2() == 7)) {
					turn(8);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 7 || a1.getFace2() == 7) {
				while (!(a1.getFace1() == 6 || a1.getFace2() == 6)) {
					turn(7);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 6 || a1.getFace2() == 6) {
				while (!(a1.getFace1() == 10 || a1.getFace2() == 10)) {
					turn(6);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			if (a1.getFace1() == 5 || a1.getFace2() == 5) {
				while (!(a1.getFace1() == 0 || a1.getFace2() == 0)) {
					turn(5);
					a1 = e[searchEdge(c1,c2)];
				}
			}
			//System.out.println("hi");
			if (a1.getColor1() != 0) {
				//System.out.println("correction");
				int t = a1.getFace2();
				turnR(a1.getFace2());
				turn(0);
				a1 = e[searchEdge(c1,c2)];
				if(a1.getFace2() == t)
					turnR(a1.getFace1());
				else
					turnR(a1.getFace2());
				turnR(0);
				//System.out.println("gecorrection");
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
					//System.out.println("hello");
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
			a1 = e[searchEdge(1,2)];
			int c = a1.getFace2();
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
				a1 = getEdge(1, 2);
			}
		}
		if (a1.getFace1() == 9 || a1.getFace2() == 9) {
			while (!(a1.getFace1() == 8
					|| a1.getFace2() == 8)) {
				turn(9);
				a1 = getEdge(1, 2);
			}
		}
		if (a1.getFace1() == 8 || a1.getFace2() ==  8) {
			while (!(a1.getFace1() == 7
					|| a1.getFace2() == 7)) {
				turn(8);
				a1 = getEdge(1, 2);
			}
		}
		if (a1.getFace1() == 7 || a1.getFace2() == 7) {
			while (!(a1.getFace1() == 6
					|| a1.getFace2() == 6)) {
				turn(7);
				a1 = getEdge(1, 2);
			}
		}
		if (a1.getFace1() == 6 || a1.getFace2() == 6) {
			while (!(a1.getFace1()!= 1)) {
				turn(6);
				a1 = getEdge(1, 2);
			}
		}
		if(a1.getColor1() == a1.getFace1()){
			turn(6);
			turn(2);
			turnR(6);
			turnR(2);
			turnR(6);
			turnR(1);
			turn(6);
			turn(1);
		}else{
			turnR(6);
			turnR(1);
			turn(6);
			turn(1);
			turn(6);
			turn(2);
			turnR(6);
			turnR(2);
		}
		
		EdgePiece a2 = getEdge(2, 3);
		if (a2.getFace1() < 6
				&& a2.getFace2() < 6
				&& ((Math.abs(a2.getFace2() - a2.getFace1()) == 1) || ((a2
						.getFace1() == 5 && a2.getFace2() == 1) || (a2
						.getFace1() == 1 && a2.getFace2() == 5)))) {
			//insert edge algorithm
			int a = a2.getFace2();
			int b = a2.getFace1();
			turn(a);
			a1 = e[searchEdge(2,3)];
			int c = a2.getFace2();
			turnR(c);
			turnR(a);
			turnR(c);
			turnR(b);
			turn(c);
			turn(b);
		}
		if (a2.getFace1() == 10 || a2.getFace2() == 10) {
			while (!(a2.getFace1() == 9
					|| a2.getFace2() == 9)) {
				turn(10);
				a2 = getEdge(2,3);
			}
		}
		if (a2.getFace1() == 9 || a2.getFace2() == 9) {
			while (!(a2.getFace1() == 8
					|| a2.getFace2() == 8)) {
				turn(9);
				a2 = getEdge(2,3);
			}
		}
		if (a2.getFace1() == 8 || a2.getFace2() ==  8) {
			while (!(a2.getFace1() == 7
					|| a2.getFace2() == 7)) {
				turn(8);
				a2 = getEdge(2,3);
			}
		}
		if (a2.getFace1() == 6 || a2.getFace2() == 6) {
			while (!(a2.getFace1() == 10
					|| a2.getFace2() == 10)) {
				turn(6);
				a2 = getEdge(2,3);
			}
		}
		if (a2.getFace1() == 7 || a2.getFace2() == 7) {
			while (!(a2.getFace1()!= 2)) {
				turn(6);
				a2 = getEdge(2,3);
			}
		}
		if(a2.getColor1() == a2.getFace1()){
			turn(7);
			turn(3);
			turnR(7);
			turnR(3);
			turnR(7);
			turnR(2);
			turn(7);
			turn(2);
		}else{
			turnR(7);
			turnR(2);
			turn(7);
			turn(2);
			turn(7);
			turn(3);
			turnR(7);
			turnR(3);
		}
		
		EdgePiece a3 = getEdge(3,4);
		if (a3.getFace1() < 6
				&& a3.getFace2() < 6
				&& ((Math.abs(a3.getFace2() - a3.getFace1()) == 1) || ((a3
						.getFace1() == 5 && a3.getFace2() == 1) || (a3
						.getFace1() == 1 && a3.getFace2() == 5)))) {
			//insert edge algorithm
			int a = a3.getFace2();
			int b = a3.getFace1();
			turn(a);
			a3 = e[searchEdge(2,3)];
			int c = a3.getFace2();
			turnR(c);
			turnR(a);
			turnR(c);
			turnR(b);
			turn(c);
			turn(b);
		}
		if (a3.getFace1() == 10 || a3.getFace2() == 10) {
			while (!(a3.getFace1() == 9
					|| a3.getFace2() == 9)) {
				turn(10);
				a3 = getEdge(3,4);
			}
		}
		if (a3.getFace1() == 9 || a3.getFace2() == 9) {
			while (!(a3.getFace1() == 8
					|| a3.getFace2() == 8)) {
				turn(9);
				a3 = getEdge(3,4);
			}
		}
		if (a3.getFace1() == 7 || a3.getFace2() ==  7) {
			while (!(a3.getFace1() == 6
					|| a3.getFace2() == 6)) {
				turn(7);
				a3 = getEdge(3,4);
			}
		}
		if (a3.getFace1() == 6 || a3.getFace2() == 6) {
			while (!(a3.getFace1() == 10
					|| a3.getFace2() == 10)) {
				turn(6);
				a3 = getEdge(3,4);
			}
		}
		if (a3.getFace1() == 8 || a3.getFace2() == 8) {
			while (!(a3.getFace1()!= 3)) {
				turn(8);
				a3 = getEdge(3,4);
			}
		}
		if(a3.getColor1() == a3.getFace1()){
			turn(8);
			turn(4);
			turnR(8);
			turnR(4);
			turnR(8);
			turnR(3);
			turn(8);
			turn(3);
		}else{
			turnR(8);
			turnR(3);
			turn(8);
			turn(3);
			turn(8);
			turn(4);
			turnR(8);
			turnR(4);
		}
		
		EdgePiece a4 = getEdge(4,5);
		if (a4.getFace1() < 6
				&& a4.getFace2() < 6
				&& ((Math.abs(a3.getFace2() - a4.getFace1()) == 1) || ((a4
						.getFace1() == 5 && a4.getFace2() == 1) || (a4
						.getFace1() == 1 && a4.getFace2() == 5)))) {
			//insert edge algorithm
			int a = a4.getFace2();
			int b = a4.getFace1();
			turn(a);
			a3 = e[searchEdge(2,3)];
			int c = a4.getFace2();
			turnR(c);
			turnR(a);
			turnR(c);
			turnR(b);
			turn(c);
			turn(b);
		}
		if (a4.getFace1() == 10 || a4.getFace2() == 10) {
			while (!(a4.getFace1() == 9
					|| a4.getFace2() == 9)) {
				turn(10);
				a4 = getEdge(4,5);
			}
		}
		if (a4.getFace1() == 8 || a4.getFace2() == 8) {
			while (!(a4.getFace1() == 7
					|| a4.getFace2() == 7)) {
				turn(8);
				a4 = getEdge(4,5);
			}
		}
		if (a4.getFace1() == 7 || a4.getFace2() ==  7) {
			while (!(a4.getFace1() == 6
					|| a4.getFace2() == 6)) {
				turn(7);
				a4 = getEdge(4,5);
			}
		}
		if (a4.getFace1() == 6 || a4.getFace2() == 6) {
			while (!(a4.getFace1() == 10
					|| a4.getFace2() == 10)) {
				turn(6);
				a4 = getEdge(4,5);
			}
		}
		if (a4.getFace1() == 9 || a4.getFace2() == 9) {
			while (!(a4.getFace1()!= 4)) {
				turn(9);
				a4 = getEdge(4,5);
			}
		}
		if(a4.getColor1() == a4.getFace1()){
			turn(9);
			turn(5);
			turnR(9);
			turnR(5);
			turnR(9);
			turnR(4);
			turn(9);
			turn(4);
		}else{
			turnR(9);
			turnR(4);
			turn(9);
			turn(4);
			turn(9);
			turn(5);
			turnR(9);
			turnR(5);
		}
		
		EdgePiece a5 = getEdge(1,5);
		if (a5.getFace1() < 6
				&& a5.getFace2() < 6
				&& ((Math.abs(a3.getFace2() - a5.getFace1()) == 1) || ((a5
						.getFace1() == 5 && a5.getFace2() == 1) || (a5
						.getFace1() == 1 && a5.getFace2() == 5)))) {
			//insert edge algorithm
			int a = a5.getFace2();
			int b = a5.getFace1();
			turn(a);
			a3 = e[searchEdge(2,3)];
			int c = a5.getFace2();
			turnR(c);
			turnR(a);
			turnR(c);
			turnR(b);
			turn(c);
			turn(b);
		}
		if (a5.getFace1() == 10 || a5.getFace2() == 10) {
			while (!(a5.getFace1() == 9
					|| a5.getFace2() == 9)) {
				turn(10);
				a5 = getEdge(1,5);
			}
		}
		if (a5.getFace1() == 8 || a5.getFace2() == 8) {
			while (!(a5.getFace1() == 7
					|| a5.getFace2() == 7)) {
				turn(8);
				a5 = getEdge(1,5);
			}
		}
		if (a5.getFace1() == 7 || a5.getFace2() ==  7) {
			while (!(a5.getFace1() == 6
					|| a5.getFace2() == 6)) {
				turn(7);
				a5 = getEdge(1,5);
			}
		}
		if (a5.getFace1() == 6 || a5.getFace2() == 6) {
			while (!(a5.getFace1() == 10
					|| a5.getFace2() == 10)) {
				turn(6);
				a5 = getEdge(1,5);
			}
		}
		if (a5.getFace1() == 10 || a5.getFace2() == 10) {
			while (!(a5.getFace1()!= 5)) {
				turn(9);
				a5 = getEdge(1,5);
			}
		}
		if(a4.getColor1() == a4.getFace1()){
			turn(10);
			turn(1);
			turnR(10);
			turnR(1);
			turnR(10);
			turnR(5);
			turn(10);
			turn(5);
		}else{
			turnR(10);
			turnR(5);
			turn(10);
			turn(5);
			turn(10);
			turn(1);
			turnR(10);
			turnR(1);
		}
	}

	//make beige 3rd layer
//	public void makeBeige(){
//		CornerPiece b1 = getCorner(1,2,6);
//		if (b1.getFace1() == 10 || b1.getFace2() == 10) {
//			while (!(b1.getFace1() == 9
//					|| b1.getFace2() == 9)) {
//				turn(10);
//				b1 = getEdge(1, 2);
//			}
//		}
//		if (b1.getFace1() == 9 || b1.getFace2() == 9) {
//			while (!(b1.getFace1() == 8
//					|| b1.getFace2() == 8)) {
//				turn(9);
//				b1 = getEdge(1, 2);
//			}
//		}
//		if (a1.getFace1() == 8 || b1.getFace2() ==  8) {
//			while (!(b1.getFace1() == 7
//					|| b1.getFace2() == 7)) {
//				turn(8);
//				b1 = getEdge(1, 2);
//			}
//		}
//		if (b1.getFace1() == 7 || b1.getFace2() == 7) {
//			while (!(b1.getFace1() == 6
//					|| b1.getFace2() == 6)) {
//				turn(7);
//				b1 = getEdge(1, 2);
//			}
//		}
//		if (b1.getFace1() == 6 || b1.getFace2() == 6) {
//			while (!(b1.getFace1()!= 1)) {
//				turn(6);
//				b1 = getCorner(1, 2);
//			}
//		}
	//}
	
	public void turn(int f) {
		System.out.println(f);
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
		System.out.println(f+"R");
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
		System.out.println("2 "+f);
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
		System.out.println("2 "+f+"R");
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
		getCorner(0, 1, 2).setColor3(c0);
		getCorner(0, 1, 2).setColor1(c1);
		getCorner(0, 1, 2).setColor2(c2);

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
		getCorner(0, 2, 3).setColor3(c0);
		getCorner(0, 2, 3).setColor1(c1);
		getCorner(0, 2, 3).setColor2(c2);

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
		getCorner(0, 2, 3).setColor2(getCorner(0, 3, 4).getColor3());
		getCorner(0, 2, 3).setColor3(getCorner(0, 3, 4).getColor1());
		getCorner(0, 2, 3).setColor1(getCorner(0, 3, 4).getColor2());
		getCorner(0, 3, 4).setColor3(c0);
		getCorner(0, 3, 4).setColor1(c1);
		getCorner(0, 3, 4).setColor2(c2);

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
		getCorner(0, 4, 5).setColor3(c0);
		getCorner(0, 4, 5).setColor1(c1);
		getCorner(0, 4, 5).setColor2(c2);

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
		getCorner(1, 5, 10).setColor3(c0);
		getCorner(1, 5, 10).setColor1(c1);
		getCorner(1, 5, 10).setColor2(c2);

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

		int c0 = getCorner(5, 9, 10).getColor2();
		c1 = getCorner(5, 9, 10).getColor3();
		c2 = getCorner(5, 9, 10).getColor1();
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
		case 3: //0,1,2
			return 0;
		case 6: //1,2,3
			return 1;
		case 5: //0,2,3
			return 2;
		case 7: //0,3,4
			return 3;
		case 9: 
			if (f1 == 0 || f2 == 0 || f3 == 0)
				return 4; //0,4,5,
			return 5; //1,2,6
		case 16: //1,5,10
			return 6;
		case 17: 
			return 7;
		case 12: //1,2,3
			return 8;
		case 15:
			if (f1 == 2 || f2 == 2 || f3 == 2)
				return 9; //1,2,3
			return 10; //1,2,3
		case 18: //7,8,3
			if (f1 == 3 || f2 == 3 || f3 == 3)
				return 11;
			return 12;
		case 21: //1,2,3
			return 13;
		case 24:
			if (f1 == 5 || f2 == 5 || f3 == 5)
				return 14; //1,2,3
			return 15; //1,2,3
		case 27: //1,2,3
			return 16;
		case 26: //1,2,3
			return 17;
		case 28: //1,2,3
			return 18;
		case 30: //1,2,3
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
		case 16:
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
