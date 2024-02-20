package Assign6.Part2;

public class Main {
    public static void main(String[] args) {
        RedHeadDuck redHeadDuck = new RedHeadDuck();
        redHeadDuck.display();
        redHeadDuck.performSwim();
        redHeadDuck.performFly();
        redHeadDuck.performQuack();

        DecoyDuck decoyDuck = new DecoyDuck();
        decoyDuck.display();
        decoyDuck.performFly();
        decoyDuck.performQuack();
        decoyDuck.performSwim();
    }
}
