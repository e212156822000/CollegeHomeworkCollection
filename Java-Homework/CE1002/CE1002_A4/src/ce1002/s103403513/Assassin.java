package ce1002.s103403513;

public class Assassin extends GameCharacter{

	public Assassin() {
		super(25000, 160, 59, "Assassin");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double normalPunch() {
		// TODO Auto-generated method stub
		return weight*basicPower+0.1*height;
	}

	@Override
	public double CA() {
		return basicPower*weight*5;
	}
	

}
