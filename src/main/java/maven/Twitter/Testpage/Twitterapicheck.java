package maven.Twitter.Testpage;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import maven.Twitter.Base.HttpBase;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class Twitterapicheck extends HttpBase{
	public HttpResponse getData()//(Get don't have body)
	{
		HttpResponse response = null;
		HttpGet get = get("account/settings.json");
        get.addHeader("content-type", "application/json");
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer("KXyzxADWh9iiHuTzMtfN9UGuM","EXNvjHcJSnCVQ3gCnWT1BEeRahZKNMqfUCMMmc2wy6pORmT7RE");
	    consumer.setTokenWithSecret("119418211-BQ57ztZJGZVoN23cLUY1w4NonF3VV4yp6tL9ysP0", "4ZDo6LqYaibpMhmAImvF061qyXiNjg7U12lucaSLOJ9VJ");
	    try {
        	consumer.sign(get);
        	response=htclient.execute(get);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}catch(OAuthCommunicationException e){
			e.printStackTrace();
		} 		
        catch(OAuthExpectationFailedException e){
			e.printStackTrace();
        }
        catch(OAuthMessageSignerException e){
			e.printStackTrace();

        }
		return response;
		
	}	
	
	
	
	
	public HttpResponse postData(JSONObject job)//(post  have body therefore they have payload anything in resposnse and request of body)
	{
		HttpResponse response = null;
		HttpPost post = post("account/update_profile.json");
		try{
	   
	   	StringEntity entity = new StringEntity(job.toString());//one of the way to set the payload
	    post.setEntity(entity);
        
        post.addHeader("content-type", "application/json");
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer("KXyzxADWh9iiHuTzMtfN9UGuM","EXNvjHcJSnCVQ3gCnWT1BEeRahZKNMqfUCMMmc2wy6pORmT7RE");
	    consumer.setTokenWithSecret("119418211-BQ57ztZJGZVoN23cLUY1w4NonF3VV4yp6tL9ysP0", "4ZDo6LqYaibpMhmAImvF061qyXiNjg7U12lucaSLOJ9VJ");

	    
        	consumer.sign(post);
        	response=htclient.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}catch(OAuthCommunicationException e){
			e.printStackTrace();
		} 		
        catch(OAuthExpectationFailedException e){
			e.printStackTrace();
        }
        catch(OAuthMessageSignerException e){
			e.printStackTrace();

        }
		return response;
		
	}	


	


}
