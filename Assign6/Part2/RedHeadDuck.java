package Assign6.Part2;

public class RedHeadDuck extends Duck {
    
    public RedHeadDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
        swimBehaviour = new Swim();
    }
    
    @Override
    public void display() {
        System.out.println("I'm a red head duck!!! Lmao");
    }
}
