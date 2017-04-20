package maven.walmmart.testwa;

import java.io.IOException;
import static org.testng.Assert.*;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import maven.walmmart.WalmartF2F.Lookupid;

public class CandiadateTest {
	
	@Test
	public void testItunes() throws ClientProtocolException, IOException, org.json.JSONException{
	
		Lookupid look= new Lookupid();
		HttpResponse response = look.httpGet("https://itunes.apple.com/lookup?id=909253");
	    System.out.println("status code is ::"+response.getStatusLine().getStatusCode());
	    assertEquals(200,response.getStatusLine().getStatusCode());	  //response code
	    
	    JSONObject object = new JSONObject(IOUtils.toString(response.getEntity().getContent()));
	    System.out.println("response is:"+ object); 
	    
	    System.out.println("result:"+object.get("results"));
	   
	    
	    JSONArray arr =object.getJSONArray("results");
	    for(int i=0;i<arr.length();i++){
	    	JSONObject resultobj= arr.getJSONObject(i);
	    	System.out.println(resultobj.get("artistId"));
	    	System.out.println(resultobj.get("artistName"));
	    	System.out.println(resultobj.get("amgArtistId"));
	    }
	
	   
	   
	 	   
		
	}
	

}
