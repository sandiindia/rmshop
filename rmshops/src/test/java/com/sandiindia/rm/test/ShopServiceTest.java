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
import com.sandiindia.rm.service.IShopService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ShopsApplication.class)
public class ShopServiceTest {

	@Autowired
	IShopService service;

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

		Shop newShop = service.findNearest(42.0598158, -87.8440398);
		assertEquals(shop, newShop);
	}

}
