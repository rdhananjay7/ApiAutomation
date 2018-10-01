import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import WebAPIAutomation.WebAPIAutomation.ResponseUtils;

public class ResponseHeaders extends BaseClass {
	

	@Test
	public void contentTypeIsJson() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL);	
		response = client.execute(get);
		
		Header contentHeader = response.getEntity().getContentType();	
		String value = contentHeader.getValue(); 
		
		assertEquals(value, "application/json; charset=utf-8");		
	}
	
	/*
	 * Improved version of the previous test
	 * for the case where you just want to check the media type.
	 */
	
	@Test
	public void contentTypeIsJsonImproved() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL);	
		response = client.execute(get);
		
		ContentType contentType = ContentType.getOrDefault(response.getEntity());
		assertEquals(contentType.getMimeType(), "application/json");
		
	}
	
	
	@Test
	public void checkServerHeader() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL);	
		response = client.execute(get);
		
		String headerValue = ResponseUtils.getHeader(response, "Server");
		assertEquals(headerValue, VALUE_HEADER_SERVER);
		
	}
	
	@Test
	public void checkHeaderJava8Way() throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(TARGET_URL);	
		response = client.execute(get);
		
		String headerValue = ResponseUtils.getHeaderJava8Way(response, "X-RateLimit-Limit");
		assertEquals(headerValue, VALUE_HEADER_XRATELIMIT);
		
	}
	
	@Test
	public void checkIfHeaderIsPresent() throws ClientProtocolException, IOException, AssertionError {
		
		HttpGet get = new HttpGet(TARGET_URL);
		response = client.execute(get);
		
		
		Boolean isPresent = ResponseUtils.checkIfHeaderIsPresent(response, "ETag");
		assertTrue(isPresent);
		
	}
	
}
