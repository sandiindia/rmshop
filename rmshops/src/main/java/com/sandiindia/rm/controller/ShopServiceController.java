package com.sandiindia.rm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandiindia.rm.exception.ShopServiceException;
import com.sandiindia.rm.model.AddShopRequest;
import com.sandiindia.rm.model.Shop;
import com.sandiindia.rm.service.IShopService;

@RestController
public class ShopServiceController {
	private final static Logger log = Logger.getLogger(ShopServiceController.class);
	
	@Autowired
	IShopService service;
	
	/**
	 * POST method to add shop to the shop store 
	 * newly added shop returned with id, lat and long
	 */
	@RequestMapping(value="v1/shops",method = RequestMethod.POST)
	@ResponseBody
	public Shop addNewShop(@RequestBody AddShopRequest newShop)
	{
		log.info("adding["+newShop.getShopName()+","+newShop.getStreetAddress()+","+newShop.getPostalCode()+"]");
		
		if ((newShop!= null)  && (newShop.getPostalCode() == null || newShop.getStreetAddress() == null || newShop.getShopName() == null))
			throw new ShopServiceException("All fields are mandatory");
		
		return service.addShop(newShop.getShopName(), newShop.getStreetAddress(), newShop.getPostalCode());
	}
	
	@RequestMapping(value="v1/shops/location/nearest",method = RequestMethod.GET)
	@ResponseBody
	public Shop findNearestShop(@RequestParam("customerLatitude") double lat, @RequestParam("customerLongitude") double longt)
	{
		log.info("Finding["+lat+","+longt+"]");
		return service.findNearest(lat, longt);
	}
	
}
