import java.lang.Math;

/* Triangle.java */
public class A2_Triangle {
	// a,b,c denote the three side length of triangle 
	private double a, b, c;
	
	/*-- Create 1st Constructor to set default value of three side length --*/
	public A2_Triangle(){
		a = 1.0;
		b = 1.0;
		c = 1.0;
		getArea();
	}
	/*-- Create 2nd Constructor with given three side length 
	      from user input in main function --*/
	public A2_Triangle(double a,double b,double c){
		this.a = a;
		this.b = b;
		this.c = c;
		getArea();
	}
	/*-- Create a public method named getArea() for computing area of triangle and returning to caller. 
	     hint: implement mathematical method that only use three side length of triangle to get area  --*/
	protected double getArea(){
		//®üÀs¤½¦¡¡C
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
}
