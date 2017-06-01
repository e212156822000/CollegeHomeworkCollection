package ce1002.s103403513;

public class Ryu extends GameCharacter{
    public Ryu(){
        super(45000,175,68,"Ryu");
    }

    @Override
    public double normalPunch () {
        //Ryu formula: basic power*weight*1.5
        return basicPower*weight*1.5;
    }

    @Override
    public double CA () {
        return basicPower*weight*5;
    }
    //CA formula : weight*basicPower*5;
}
