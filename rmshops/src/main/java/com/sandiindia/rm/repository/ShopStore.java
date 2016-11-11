package com.sandiindia.rm.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sandiindia.rm.model.Shop;

@Component
public class ShopStore implements IShopStore {

	private static ArrayList<Shop> shops = new ArrayList<Shop>();
	
	public void save(Shop shop) {
		// TODO Auto-generated method stub
		shops.add(shop);
	}

	public List<Shop> getAllShops() {
		// TODO Auto-generated method stub
		return shops;
	}
}
