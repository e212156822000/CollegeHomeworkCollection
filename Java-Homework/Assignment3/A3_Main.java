/*****************************************
�o�ӵ{���|��random ���ͥX�T�ӳ��I�A�åB�Ц�b�@��6*11���a�ϤW�C
���۵{���|�p��T���I�s���������n�G
1)�Y�i���T���ΡA�N�|��ܥX�T���έ��n�A
2)�Y���ন�T���ΡA�N�|��ܥX�D�T���Ϊ��r�ˡC
******************************************/
import java.util.Random;

public class A3_Main {
	public static void main(String[] args) {

		Random ran = new Random();

		/*-- Create a 6x11 map--*/
		int map[][] = new int[6][11];
		/*-- Create a Triangle class object name with default value --*/
		A3_Triangle t1 = new A3_Triangle();
		/*-- Generate points by random--*/
		int px1,py1,px2,py2,px3,py3;
		
		px1 = ran.nextInt(6);
		px2 = ran.nextInt(6);
		px3 = ran.nextInt(6);
		py1 = ran.nextInt(11);
		py2 = ran.nextInt(11);
		py3 = ran.nextInt(11);
		
		for(int i = 0; i < 6 ;i++){
			for(int k = 0;k < 11;k++){
				if(i == px1 && k == py1) map[i][k] = 1;
				else if(i == px2 && k == py2) map[i][k] = 2;
				else if(i == px3 && k == py3) map[i][k] = 3;
				else map[i][k] = 0;
			}
		}
		/*-- Transfer points to triangle object--*/
		t1.getPoint(px1,py1,px2,py2,px3,py3);
		/*-- Show map--*/
		for(int i = 0; i < 6 ;i++){
			for(int k = 0;k < 11;k++){
				System.out.print(map[i][k]);
			}
			System.out.println();
		}
		
		/*-- Show points coordinate--*/
		System.out.println("Point 1 is at (" + px1 + "," + py1 +").");
		System.out.println("Point 2 is at (" + px2 + "," + py2 +").");
		System.out.println("Point 3 is at (" + px3 + "," + py3 +").");
		/*-- Show area--*/
		if( t1.getArea() == 0 ) System.out.println("It's not a triangle.");
		else System.out.println("The area is " + t1.getArea() );
	}

}
