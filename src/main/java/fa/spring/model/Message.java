package fa.spring.model;

public class Message<E> {
	private String message = "";
	private E data;
	private String error = "";
	public Message(String message, E data, String error) {
		super();
		this.message = message;
		this.data = data;
		this.error = error;
	}


	
	
}
