package com.sandiindia.rm.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sandiindia.rm.model.ShopAddress;
@Component
public class GoogleGeocodingAdapter implements ILocationAdapter {
	@Value("${adapter.google.apikey}")
	private String apiKey;
	
	@Value("${adapter.google.apiurl}")
	private String apiUrl;
	
	public GeoLocation getLocation(ShopAddress address) {
		// TODO Auto-generated method stub
		return null;
	}

}
