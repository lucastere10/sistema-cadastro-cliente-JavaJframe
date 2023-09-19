package com.project.models;

import java.sql.Date;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Order {
	private int idorder;
	private int idclient;
	private Client client;
	private LocalDateTime order_date;
	private ArrayList<Product> productcart = new ArrayList<>();
}
