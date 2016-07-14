/*************************************************
這個程式一開始會先設定正方形的邊長為1.0，三角形的三個邊長也為1.0，
然後分別算出正方形、三角形的面積。接著
1)會讓使用者輸入方形的長寬，程式會計算出面積。
2)會讓使用者輸入三角形的三邊常，程式會計算出面積。
**************************************************/

import java.util.Scanner;

/* You can choose any IO method in JAVA to get the input */
public class A2_TestArea {
	/* main function better to be only one in all java files,
	   so most(? maybe..I think) developer will put main function in Test class. */
	
	 public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 
		 /*-- Create a Rectangle class object name r1 with default value --*/
		 A2_Rectangle r1 = new A2_Rectangle();
		 System.out.println("Rectangle r1 has area of "+r1.getArea());
		 /*-- Create a Triangle class object name t1 with default value --*/
		 A2_Triangle t1 = new A2_Triangle();
		 System.out.println("Traiangle t1 has area of "+t1.getArea());
		 /*-- Let user input defined value to Rectangle class object name r2 --*/
		 System.out.print("Enter height : ");
		 double height = input.nextDouble();
		 System.out.print("Enter width : ");
		 double width = input.nextDouble();
		 A2_Rectangle r2 = new A2_Rectangle(height,width);
		 System.out.println("Rectangle r2 has area of "+r2.getArea());
		 /*-- Let user input defined value to Triangle class object name t2 --*/
		 System.out.print("Enter length of sideA : ");
		 double a = input.nextDouble();
		 System.out.print("Enter length of sideB : ");
		 double b = input.nextDouble();
		 System.out.print("Enter length of sideC : ");
		 double c = input.nextDouble();
		 A2_Triangle t2 = new A2_Triangle(a,b,c);
		 System.out.println("Traiangle t2 has area of "+t2.getArea());
	 }
}
