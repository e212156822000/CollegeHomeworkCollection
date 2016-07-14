import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] pointx = new int[3];
		int[] pointy = new int[3];
		Random ran = new Random();

		/*-- Create a 6x11 map--*/
		int[][] map = new int[6][11];

		/*-- Generate points by random--*/
		for (int i = 0; i < 3; i++) {
			pointx[i] = ran.nextInt(6);
			pointy[i] = ran.nextInt(11);
		}
		
		/*-- Create a Tetrahedron class object name with default value --*/
		Tetrahedron t1 = new Tetrahedron(pointx[0],pointy[0],pointx[1],pointy[1],pointx[2],pointy[2]);
		t1.setHeight(ran.nextInt(10));
		/*--Fill in the map.--*/
		for (int i = 0; i < 3; i++) {
			map[pointx[i]][pointy[i]] = i + 1;
		}

		/*-- Show map--*/
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 11; j++) {
				if (map[i][j] != 0) {
					System.out.print("*");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		/*--Tetrahedron speak info--*/
		t1.speak();
	}
}
