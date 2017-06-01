package ce1002.s103403513;

public class Akimison extends GameCharacter{

	public Akimison() {
		super(40000, 175, 69, "Akimison");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double normalPunch() {
		// TODO Auto-generated method stub
		return weight*basicPower*0.5+0.5*height;
	}

	@Override
	public double CA() {
		// TODO Auto-generated method stub
		return weight*basicPower*6;
	}

}
