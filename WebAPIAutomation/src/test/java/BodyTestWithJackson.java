import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import entities.User;


public class BodyTestWithJackson extends BaseClass {

	
	@Test
	public void returnCorrectLogin() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL+"/users/rdhananjay7");
		response = client.execute(get);
		
		User user = ResponseUtils.unmarshall(response, User.class);
		assertEquals(user.getLogin(), "rdhananjay7");
		
	}


	
}
