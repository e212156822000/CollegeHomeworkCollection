package ce1002.s103403513;
/*
This class is an abstract class.
Which means that you can not use this class to declare a variable.
You can only use it's child to declare a variable.
 */
public abstract class GameCharacter {
    protected double health;
    protected double height; //protested means only Class and it's children can access.
    protected double weight;
    protected double basicPower;
    protected String name;
    public GameCharacter(double health,double height, double weight, String name){
        this.health = health;
        this.height = height;
        this.weight = weight;
        this.name = name;
        basicPower= 15;
    }
    public String getName(){
        return name;
    };
    public double getHealth(){
        return health;
    };
    public void setHealth(double health){
        this.health = health;
    };
    public abstract double normalPunch ();//abstract means this method should be implement in it's child class.
    public abstract double CA();
}
