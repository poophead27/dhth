
public class CornerPiece{
	int f1, f2, f3, c1, c2, c3;
	
	public CornerPiece(int face1, int face2, int face3, int color1, int color2, int color3){
		f1 = face1;
		f2 = face2;
		f3 = face3;
		c1 = color1;
		c2 = color2;
		c3 = color3;
	}
	
	public int getColor1(){
		return c1;
	}
	
	public int getColor2(){
		return c2;
	}
	
	public int getColor3(){
		return c3;
	}
	
	public int getFace1(){
		return f1;
	}
	
	public int getFace2(){
		return f2;
	}
	
	public int getFace3(){
		return f3;
	}
	
	public void setColor1(int c){
		c1 = c;
	}
	
	public void setColor2(int c){
		c2 = c;
	}
	
	public void setColor3(int c){
		c3 = c;
	}
}
