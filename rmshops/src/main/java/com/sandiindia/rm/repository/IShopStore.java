package com.sandiindia.rm.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sandiindia.rm.model.Shop;
@Component
public interface IShopStore {
	public void save(Shop shop);
	public List<Shop> getAllShops();
	
}
