package maven.Twitter.Base;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpBase {

	String endpoint="https://api.twitter.com/1.1/";
	 protected HttpClient htclient = HttpClientBuilder.create().build();

	public HttpGet get(String resource){
	HttpGet get = new HttpGet(endpoint+resource);
	return get;
	}
	
	   public HttpPost post(String resource){
		HttpPost post = new HttpPost(endpoint+resource);
		return post;
		}
		
	
}
