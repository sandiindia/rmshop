package com.sandiindia.rm.repository;

import java.util.List;

import com.sandiindia.rm.model.Shop;

public interface IShopStore {
	public void save(Shop shop);
	public List<Shop> getAllShops();
	
}
