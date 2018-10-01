import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	
	CloseableHttpClient client;
	CloseableHttpResponse response;

	protected static final String TARGET_URL = "https://api.github.com";
	protected static final String VALUE_HEADER_SERVER = "GitHub.com";
	protected static final String VALUE_HEADER_XRATELIMIT = "60";
	
	@BeforeMethod
	public void setup() {
		client = HttpClientBuilder.create().build();
	}
	
	@AfterMethod
	public void closeResources() throws IOException {
		client.close();
		response.close();
	}
	
}
