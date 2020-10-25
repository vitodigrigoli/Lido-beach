package net.vdg.bean;

import java.io.Serializable;
import java.util.LinkedList;

public class CartBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private LinkedList<FoodBean> list = new LinkedList<FoodBean>();
	private float total = 0;
	
	public LinkedList<FoodBean> getList() {
		return list;
	}
	public void setCart(LinkedList<FoodBean> list) {
		this.list = list;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	

}
