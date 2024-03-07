package Assign7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            if(msg.equalsIgnoreCase("HELLO")){
                throw new CustomException();
            }
            else{
                System.out.println("Message is: "+msg);
            }
        }
        catch(CustomException e){
            System.out.println("Exception: "+e);
        }
        finally{
            System.out.println("finally block is always executed");
        }
    }
}
