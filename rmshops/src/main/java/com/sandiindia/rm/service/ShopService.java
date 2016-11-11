package com.sandiindia.rm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandiindia.rm.model.Shop;
import com.sandiindia.rm.repository.IShopStore;
import com.sandiindia.rm.util.RmUtil;

@Component
public class ShopService implements IShopService {

	@Autowired
	IShopStore shopStore;
	
	class ShopWithDistance
	{
		public double distance;
		public Shop _shop;
		
		public ShopWithDistance(double shopDistance, Shop shop)
		{
			distance = shopDistance;
			_shop = shop;
		}
	}
	
	public Shop addShop(String name, String streetAddress, String postalCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Shop findNearest(double customerLat, double customerLong) {
		// TODO Auto-generated method stub
		Shop nearest = null;
		ArrayList<Shop> shops = (ArrayList<Shop>) shopStore.getAllShops();
		ShopWithDistance shpd = null;
		double currDist;
		ArrayList<ShopWithDistance> shpds = new ArrayList<ShopWithDistance>();
		
		for (Shop shp : shops)
		{
			currDist = RmUtil.distance(shp.getLatitude(), customerLat, shp.getLongitude(), customerLong, 0.0, 0.0);
			shpd = new ShopWithDistance(currDist, shp);
			shpds.add(shpd);
		}
		
		Collections.sort(shpds, new Comparator<ShopWithDistance>() {
			public int compare(ShopWithDistance shpd1, ShopWithDistance shpd2)
	        {

	            return  (int) (shpd1.distance - shpd2.distance); 
	        }
		});
		
		nearest = !shpds.isEmpty() ? shpds.get(0)._shop : null;
		
		return nearest;
	}

}
