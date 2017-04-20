package maven.walmmart.WalmartF2F;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;



public class Lookupid {
	
	public HttpResponse httpGet(String url) throws ClientProtocolException, IOException{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new  HttpGet(url);
	    
		HttpResponse httpre =  (HttpResponse) client.execute(get);
		
	   	return httpre;
		
	}

	
}
