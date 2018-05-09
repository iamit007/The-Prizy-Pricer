package com.ea.app.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

	public List<String> getStoresUtil(){
		return Arrays.asList(
				"TRENDZ",
				"GALAXY",
				"STREAX",
				"TAKEAWAY",
				"BESTBUY"
				);

	}


}
















