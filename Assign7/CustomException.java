package Assign7;

public class CustomException extends Exception{
	public CustomException(){
		super("exception has occurred due to hello");
	}

	public CustomException(String msg){
		super(msg);
	}
}
