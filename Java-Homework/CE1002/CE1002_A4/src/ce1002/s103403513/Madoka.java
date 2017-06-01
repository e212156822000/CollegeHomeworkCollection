package ce1002.s103403513;

public class Madoka extends GameCharacter{

	public Madoka() {
		super(50000,155,45,"Madoka");
		// TODO Auto-generated constructor stub
	}
	@Override
	public double normalPunch() {
		// TODO Auto-generated method stub
		return basicPower*weight;
	}

	@Override
	public double CA() {
		// TODO Auto-generated method stub
		return basicPower*weight*4+height;
	}

}
