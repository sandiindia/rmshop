package com.sandiindia.rm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=ShopsApplication.class)
public class ShopStoreTest {

	private Shop shop;
	
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
		shop = new Shop();
		shop.setShopId("shop111");
		shop.setName("Pita Inn");
		shop.setLatitude(42.0598158);
		shop.setLongitude(-87.8440398);

		ShopAddress address = new ShopAddress();
		address.setStreetAddress("9854 N Milwaukee Ave");
		address.setPostalCode("60016");

		shop.setAddress(address);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		shopStore.save(shop);
		assertTrue(shopStore.getAllShops().size() > 0);
	}

	@Test
	public void testGetAllShops() {
		assertNotNull(shopStore.getAllShops().get(0));
	}

}
