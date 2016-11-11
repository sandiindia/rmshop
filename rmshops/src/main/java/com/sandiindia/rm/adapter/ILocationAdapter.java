package com.sandiindia.rm.adapter;

import org.springframework.stereotype.Component;

import com.sandiindia.rm.model.ShopAddress;

@Component
public interface ILocationAdapter {
	public GeoLocation getLocation(ShopAddress address);
}
