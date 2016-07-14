import java.lang.Math;
public class A3_Triangle {

	int x1,y1,x2,y2,x3,y3;
	double area;
	
	/*-- Create Constructor to set default value --*/
	public A3_Triangle() {
		area = 0;
	}

	/*-- Get point's coordinate --*/
	public void getPoint(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	/*--Calculate area  --*/
	public double getArea() {
		double a = 0 , b = 0, c = 0;
		a = Math.sqrt( Math.pow((x1-x2),2) + Math.pow((y1-y2),2) );
		b = Math.sqrt( Math.pow((x1-x3),2) + Math.pow((y1-y3),2) );
		c = Math.sqrt( Math.pow((x3-x2),2) + Math.pow((y3-y2),2) );
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

}