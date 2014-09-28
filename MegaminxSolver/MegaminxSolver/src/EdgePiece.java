import java.util.ArrayList;


public class EdgePiece{
	int f1, f2, c1, c2;
	
	public EdgePiece(int face1, int face2, int color1, int color2){
		f1 = face1;
		f2 = face2;
		c1 = color1;
		c2 = color2;
	}

	public int getColor1(){
		return c1;
	}
	
	public int getColor2(){
		return c2;
	}
	
	public int getFace1(){
		return f1;
	}
	
	public int getFace2(){
		return f2;
	}
	
	public void setColor1(int c){
		c1 = c;
	}
	
	public void setColor2(int c){
		c2 = c;
	}
}
