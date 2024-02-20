package Assign6.Part2;

abstract public class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;
    SwimBehaviour swimBehaviour;

    public void setFlyBehaviour(FlyBehaviour fb) {
        flyBehaviour = fb;
    }

    public void setQuackBehaviour(QuackBehaviour qb) {
        quackBehaviour = qb;
    }

    public void setSwimBehaviour(SwimBehaviour sb) {
        swimBehaviour = sb;
    }
    
    abstract public void display();

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void performSwim() {
        swimBehaviour.swim();
    }
}