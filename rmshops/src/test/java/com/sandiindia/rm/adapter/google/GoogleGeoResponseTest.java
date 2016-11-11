package com.sandiindia.rm.adapter.google;

import static org.junit.Assert.*;

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

import com.sandiindia.rm.adapter.GeoLocation;
import com.sandiindia.rm.adapter.ILocationAdapter;
import com.sandiindia.rm.application.ShopsApplication;
import com.sandiindia.rm.model.ShopAddress;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=ShopsApplication.class)
public class GoogleGeoResponseTest {

	@Autowired
	ILocationAdapter locationAdapter;
	
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
	public void test() {
		ShopAddress address = new ShopAddress();
		address.setStreetAddress("1830 W Palm Dr, Mt Prospect, IL");
		address.setPostalCode("60056");		
		GeoLocation expected = new GeoLocation();
		expected.setLat(42.0468471);
		expected.setLingtd(-87.96372989999999);
		
		GeoLocation actual = locationAdapter.getLocation(address);
		assertEquals(expected, actual);

		address.setStreetAddress("1844 W Palm Dr, Mt Prospect, IL");
		address.setPostalCode("60056");		
		
		actual = locationAdapter.getLocation(address);
		assertNotEquals(expected, actual);

	}



}
