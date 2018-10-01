package entities;

public class User {

	// For tests using JSON Object
	
	public static final String LOGIN = "login";
	public static final String ID = "id";

	// For jackson library in order to do the unmarshalling
	
	private String login;
	private int id;
	
	public String getLogin() {
		return login;
	}
	
	public int getId() {
		return id;
	}
	
	
}
