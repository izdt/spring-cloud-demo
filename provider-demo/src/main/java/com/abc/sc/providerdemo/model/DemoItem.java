package com.abc.sc.providerdemo.model;

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
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	public DemoItem(){}
	public DemoItem(String mobile,String address){
		this.mobile = mobile;
		this.address = address;
	}
}