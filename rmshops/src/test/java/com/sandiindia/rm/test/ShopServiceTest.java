package com.sandiindia.rm.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sandiindia.rm.application.ShopsApplication;
import com.sandiindia.rm.model.Shop;
import com.sandiindia.rm.model.ShopAddress;
import com.sandiindia.rm.repository.IShopStore;
import com.sandiindia.rm.service.IShopService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ShopsApplication.class)
public class ShopServiceTest {

	@Autowired
	IShopService service;
	@Autowired
	IShopStore shopStore;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddShop() {
		Shop shop = new Shop();
		shop.setShopId("shop111");
		shop.setName("Pita Inn");
		shop.setLatitude(42.0598158);
		shop.setLongitude(-87.8440398);
		ShopAddress address = new ShopAddress();
		address.setStreetAddress("9854 N Milwaukee Ave");
		address.setPostalCode("60016");
		shop.setAddress(address);

		Shop newShop = service.addShop("Pita Inn", "9854 N Milwaukee Ave", "60016");
		assertEquals(shop, newShop);
	}

	@Test
	public void testFindNearest() {
		Shop shop = new Shop();
		shop.setShopId("shop111");
		shop.setName("Pita Inn");
		shop.setLatitude(42.0598158);
		shop.setLongitude(-87.8440398);
		ShopAddress address = new ShopAddress();
		address.setStreetAddress("9854 N Milwaukee Ave");
		address.setPostalCode("60016");
		shop.setAddress(address);
		shopStore.getAllShops().add(shop);
		
		Shop shop2 = new Shop();
		shop2.setShopId("shop112");
		shop2.setName("Pita Inn");
		shop2.setLatitude(42.0438609);
		shop2.setLongitude(-87.7478043);
		ShopAddress address2 = new ShopAddress();
		address2.setStreetAddress("4710 Dempster St");
		address2.setPostalCode("60076");
		shop2.setAddress(address2);
		shopStore.getAllShops().add(shop2);
		
		Shop nearestShop = service.findNearest(42.0598158, -87.8440398);
		assertEquals(shop, nearestShop);
		//1830 W Palm Dr, Mt Prospect, IL 60056, USA
		nearestShop = service.findNearest(42.0468333, -87.965921);
		assertEquals(shop, nearestShop);
		
		//4100 Crain Street, Skokie, IL 60076, USA
		nearestShop = service.findNearest(42.039099, -87.7327707);
		assertEquals(shop2, nearestShop);
		
	}

}
