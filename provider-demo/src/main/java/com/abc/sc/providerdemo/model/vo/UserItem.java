
package  com.abc.sc.providerdemo.model.vo;

public class UserItem {
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
	public UserItem(String mobile,String address){
		this.mobile = mobile;
		this.address = address;
	}
}
