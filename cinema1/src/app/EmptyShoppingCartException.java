package app;

public class EmptyShoppingCartException extends RuntimeException{
	public EmptyShoppingCartException(String msg){
		super(msg);
	}
}
