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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lingtd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoLocation other = (GeoLocation) obj;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lingtd) != Double.doubleToLongBits(other.lingtd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GeoLocation [lat=" + lat + ", lingtd=" + lingtd + "]";
	}
	
	
}
