package maven.Twitter.Testpage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Twitterchecktest {
	@Test
	public void getTwitter() throws JSONException, IllegalStateException, IOException{
		
		Twitterapicheck twiap = new Twitterapicheck();
		HttpResponse resp=twiap.getData();
		System.out.println(resp.getStatusLine().getStatusCode());
		assertEquals(200,resp.getStatusLine().getStatusCode());
		JSONObject jobject = new JSONObject(IOUtils.toString(resp.getEntity().getContent()));
		System.out.println(jobject.get("screen_name"));
		assertEquals("rinityagi",jobject.get("screen_name"));
		
		
	}

	@Test(dataProvider="postCheck")
	public void postTwitter(String name,String location ) throws JSONException, IllegalStateException, IOException{
		
		Twitterapicheck twiap = new Twitterapicheck();
		 JSONObject job= new JSONObject();
		    job.put("name", name);
		    job.put("location", location);
		
			HttpResponse resp=twiap.postData(job );

		System.out.println(resp.getStatusLine().getStatusCode());
		assertEquals(200,resp.getStatusLine().getStatusCode());
		JSONObject jobject = new JSONObject(IOUtils.toString(resp.getEntity().getContent()));
		System.out.println(jobject.get("name"));
		assertEquals("rinityagi",jobject.get("name"));
		System.out.println(jobject.get("followers_count"));
		assertEquals(2,jobject.get("followers_count"));
      
		
		
	}
	
	 @DataProvider
	 public Object[][] postCheck() {
	        return new Object[][]{{"shashank", "seattle"}, {"shubham", "newyork"}};
	    }


}
