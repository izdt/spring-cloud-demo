package  com.abc.sc.consumerdemo.remote.vo;

import java.util.ArrayList;

public class UserInfo {
	private int id;
	private String name;
	private ArrayList<UserItem> items;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the items
	 */
	public ArrayList<UserItem> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<UserItem> items) {
		this.items = items;
	}

}
