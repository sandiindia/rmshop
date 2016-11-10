package com.sandiindia.rm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandiindia.rm.model.AddShopRequest;
import com.sandiindia.rm.model.Shop;
import com.sandiindia.rm.service.IShopService;

@RestController
public class ShopServiceController {

	@Autowired
	IShopService service;
	/**
	 * POST method to add shop to the shop store 
	 * newly added shop returned with id, lat and long
	 */
	@RequestMapping(value="/shops",method = RequestMethod.POST)
	@ResponseBody
	public Shop addNewShop(AddShopRequest newShop)
	{
		return null;
	}
	
	@RequestMapping(value="/shops/location",method = RequestMethod.GET)
	@ResponseBody
	public Shop findNearestShop(String lat, String longt)
	{
		return null;
	}
	
}
