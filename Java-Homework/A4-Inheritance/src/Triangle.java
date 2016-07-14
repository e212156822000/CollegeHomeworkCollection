public class Triangle {
	double[] pointx = new double[3];
	double[] pointy = new double[3];
	double sideA, sideB, sideC;
	
	public Triangle(){
		
	}
	/*-- Triangle Constructor --*/
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		pointx[0] = (double) x1;
		pointy[0] = (double) y1;
		pointx[1] = (double) x2;
		pointy[1] = (double) y2;
		pointx[2] = (double) x3;
		pointy[2] = (double) y3;
		sideA = Math.sqrt(Math.pow((pointx[0] - pointx[1]), 2) + Math.pow((pointy[0] - pointy[1]), 2));
		sideB = Math.sqrt(Math.pow((pointx[0] - pointx[2]), 2) + Math.pow((pointy[0] - pointy[2]), 2));
		sideC = Math.sqrt(Math.pow((pointx[2] - pointx[1]), 2) + Math.pow((pointy[2] - pointy[1]), 2));
	}

	public void setTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		pointx[0] = (double) x1;
		pointy[0] = (double) y1;
		pointx[1] = (double) x2;
		pointy[1] = (double) y2;
		pointx[2] = (double) x3;
		pointy[2] = (double) y3;
		sideA = Math.sqrt(Math.pow((pointx[0] - pointx[1]), 2) + Math.pow((pointy[0] - pointy[1]), 2));
		sideB = Math.sqrt(Math.pow((pointx[0] - pointx[2]), 2) + Math.pow((pointy[0] - pointy[2]), 2));
		sideC = Math.sqrt(Math.pow((pointx[2] - pointx[1]), 2) + Math.pow((pointy[2] - pointy[1]), 2));
	}

	/*--Calculate area  --*/
	public double getArea() {
		double s = (sideA + sideB + sideC) / 2.0;
		return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
	}

	public void speak() {
		/*-- Show points coordinate--*/
		for (int i = 0; i < 3; i++) {
			System.out.println("Point " + (i + 1) + " is at (" + pointx[i] + "," + pointy[i] + ").");
		}
		/*-- Show area--*/
		System.out.println("The area is " + getArea());
	}
}
