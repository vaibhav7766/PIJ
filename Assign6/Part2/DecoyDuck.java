package Assign6.Part2;

public class DecoyDuck extends Duck {
    
    public DecoyDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Squeak();
        swimBehaviour = new SwimNoWay();
    }
    
    @Override
    public void display() {
        System.out.println("I'm a decoy duck!!! lmao");
    }
    
}
