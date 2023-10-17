package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Address {
	private int addressId;
	private String addressName;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String addressName) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressName=" + addressName + "]";
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

}
