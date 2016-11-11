package com.sandiindia.rm.adapter.google;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sandiindia.rm.adapter.GeoLocation;
import com.sandiindia.rm.adapter.ILocationAdapter;
import com.sandiindia.rm.model.ShopAddress;

@Component
@PropertySource("classpath:googleadapter.properties")
public class GoogleGeocodingAdapter implements ILocationAdapter {
	@Value("${adapter.google.apikey}")
	private String apiKey;

	@Value("${adapter.google.apiurl}")
	private String apiUrl;

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	@Autowired
	RestTemplate restClient;
	
	public GeoLocation getLocation(ShopAddress address) {
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("shopaddress", address.getStreetAddress() + " , " + address.getPostalCode());
		uriVariables.put("apikey", apiKey);
		
		GoogleGeoResponse response = restClient.getForObject(apiUrl+"?address={shopaddress}&key={apikey}", GoogleGeoResponse.class, uriVariables);

		GeoLocation geoLocation = new GeoLocation();

		if (response != null) {
			double lat = Double.parseDouble(response.getResults()[0].getGeometry().getLocation().getLat());
			double longtd = Double.parseDouble(response.getResults()[0].getGeometry().getLocation().getLng());
			geoLocation.setLat(lat);
			geoLocation.setLingtd(longtd);
		} else {
			geoLocation = null;
		}

		return geoLocation;
	}
}
