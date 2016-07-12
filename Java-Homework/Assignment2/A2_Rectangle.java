

/* Rectangle.java */
public class A2_Rectangle {
	// retangle's height and width
	private double height, width;
	/*-- Create 1st Constructor to set default value of height and width --*/
	public A2_Rectangle(){
		height = 1.0;
		width = 1.0;
	}
	/*-- Create 2nd Constructor with given height and width 
	      from user input in main function --*/
	public A2_Rectangle(double height,double width){
		this.height = height;
		this.width = width;
	}
	/*-- Create a public method named getArea() for computing area of rectangle and returning to caller --*/
	public double getArea(){
		return height * width;
	}
	
}
