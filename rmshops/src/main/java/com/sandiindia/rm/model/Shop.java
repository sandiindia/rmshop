package com.sandiindia.rm.model;

public class Shop {
	public String shopId;
	public String name;
	public ShopAddress address;
	public String Longitude;
	public String Latitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShopAddress getAddress() {
		return address;
	}

	public void setAddress(ShopAddress address) {
		this.address = address;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Latitude == null) ? 0 : Latitude.hashCode());
		result = prime * result + ((Longitude == null) ? 0 : Longitude.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Shop other = (Shop) obj;
		if (Latitude == null) {
			if (other.Latitude != null)
				return false;
		} else if (!Latitude.equals(other.Latitude))
			return false;
		if (Longitude == null) {
			if (other.Longitude != null)
				return false;
		} else if (!Longitude.equals(other.Longitude))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
