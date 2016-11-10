package com.sandiindia.rm.service;

import org.springframework.stereotype.Component;

import com.sandiindia.rm.model.Shop;

@Component
public interface IShopService {
	public Shop addShop(String name, String streetAddress, String postalCode);

	public Shop findNearest(double customerLat, double customerLong);
}
