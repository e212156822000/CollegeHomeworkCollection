import java.util.Random;
public class Tetrahedron extends Triangle{
	private double height;
	Random rand = new Random();
	
	public Tetrahedron(int x1, int y1, int x2, int y2, int x3, int y3){
		super(x1, y1, x2, y2, x3, y3);
	}
	
	public void setHeight(int n){
		height = (double) n;
	}

	public double getHeight(){
		return height;
	}
	
	public double getVolume(){
		return (double) 1/3*getArea()*getHeight();
	}
	
	//override method speak
	public void speak(){
		////super should be used here...
		super.speak();
		System.out.println("This is message from Tetrahedron:");
		System.out.println("Height is " +getHeight()+",and the volume is "+ getVolume());
		
	}
}
