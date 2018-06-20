package com.abc.sc.consumerdemo.model;

public class DemoItem {
	private String mobile;
	private String address;
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	public DemoItem(String mobile,String address){
		this.mobile = mobile;
		this.address = address;
	}
}