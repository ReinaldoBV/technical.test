package com.azurian.technical.test;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.azurian.technical.test.rest.model.PersonResponse;

/**
 * The Class PagingController.
 */
@Controller
public class PagingController {
	
	/** The rest client. */
	RestClient restClient = new RestClient();
	
	/**
	 * Paging.
	 *
	 * @param p the p
	 * @param s the s
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/paging")
	public String paging(@RequestParam String p, @RequestParam String s, Map<String, Object> model) {
		
		PersonResponse personResponse = restClient.get(p, s);
		
		if (personResponse!=null && personResponse.getEmbedded()!=null && personResponse.getEmbedded().getPeople()!=null) {
			
			model.put("personResponse", personResponse);
			
		} else {
			
			model.put("personResponse", new ArrayList<>());
		}
		
		return "list";
	}

	/**
	 * Index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/list")
	public String index(Map<String, Object> model) {
		
		return paging("0", "20", model);		
	}
}