import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

public class Get200 extends BaseClass {
	
	@Test
	public void baseUrlReturns200() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL);
		response = client.execute(get);
		
		int statusCode = response
						.getStatusLine()
						.getStatusCode();
		
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void rateLimitReturns200() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL+"/rate_limit");
		response = client.execute(get);
		
		int statusCode = response
						.getStatusLine()
						.getStatusCode();
		
		assertEquals(statusCode, 200);
	}
	
	@Test
	public void searchReposReturns200() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL+"/search/repositories?q=java");
		response = client.execute(get);
		
		int statusCode = response
						.getStatusLine()
						.getStatusCode();
		
		assertEquals(statusCode, 200);
	}
	
	
	
}
