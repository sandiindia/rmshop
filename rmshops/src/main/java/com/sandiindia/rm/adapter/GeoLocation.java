package com.sandiindia.rm.adapter;

import org.springframework.stereotype.Component;

@Component
public class GeoLocation {
	private double lat;
	private double lingtd;
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLingtd() {
		return lingtd;
	}
	public void setLingtd(double lingtd) {
		this.lingtd = lingtd;
	}
}
