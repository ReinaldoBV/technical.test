package com.azurian.technical.test;

import com.azurian.technical.test.rest.model.PersonResponse;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * The Class RestClient.
 */
public class RestClient {
	
	/** The gson. */
	Gson gson = new Gson();
	
	/** The client. */
	OkHttpClient client = new OkHttpClient();

	/**
	 * Gets the.
	 *
	 * @param page the page
	 * @param size the size
	 * @return the person response
	 */
	public PersonResponse get(String page, String size) {

		Request request = new Request.Builder()
		  .url("http://localhost:8080/people?page="+page+"&size="+size)
		  .get()
		  .addHeader("content-type", "application/json")
		  .build();

		PersonResponse dteResponse = new PersonResponse();
		
		try {
		
			Response response = client.newCall(request).execute();
			
			if (response!=null && response.code()==200 && response.body()!=null) {
				
				String resp = response.body().string();
				
				dteResponse = gson.fromJson(resp, PersonResponse.class);
			
			} else {
			
				System.out.println("response is null");
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return dteResponse;
	}
}
