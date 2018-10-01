import static entities.User.LOGIN;
import static entities.User.ID;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class BodyTestWithSimpleMap extends BaseClass {
	
	@Test
	public void returnCorrectLogin() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL+"/users/rdhananjay7");
		response = client.execute(get);
		
		String jsonResponse = EntityUtils.toString(response.getEntity());
		JSONObject jsonObject = new JSONObject(jsonResponse);
		
		// We have to cast the return value with respect to the type of key we are interested in.
		//  As return value can be of any type, that's why the return type is Object
		
		String loginValue = (String) getValueFor(jsonObject, LOGIN);
		
		assertEquals(loginValue, "rdhananjay7");
		
	}
	
	@Test
	public void returnCorrectId() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL+"/users/rdhananjay7");
		response = client.execute(get);
		
		String jsonResponse = EntityUtils.toString(response.getEntity());
		JSONObject jsonObject = new JSONObject(jsonResponse);
		
		// We have to cast the return value with respect to the type of key we are interested in.
		//  As return value can be of any type, that's why the return type is Object
		
		Integer loginID = (Integer) getValueFor(jsonObject, ID);
		
		assertEquals(loginID, Integer.valueOf(10107604));
		
	}

	// Return value can be of any type, that's why the return type is Object
	
	private Object getValueFor(JSONObject jsonObject, String key) {

		return jsonObject.get(key);
		
	}
	

}
