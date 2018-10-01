import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

public class Get404 extends BaseClass {
	
	@Test
	public void invalidUrlReturns404() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL+"/invalid_url");
		response = client.execute(get);
		
		int statusCode = response
						.getStatusLine()
						.getStatusCode();
		
		assertEquals(statusCode, 404);
	}
	
}
