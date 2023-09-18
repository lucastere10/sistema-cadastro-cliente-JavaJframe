package com.project.models;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
	private int idorder;
	private int idclient;
	private Date order_date;
	private ArrayList<Product> productcart = new ArrayList<>();
}
