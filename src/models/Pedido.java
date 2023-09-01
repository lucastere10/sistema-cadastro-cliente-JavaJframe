package models;

import java.util.ArrayList;

public class Pedido {
	private String id_pedido;
	private Cliente comprador;
	private ArrayList<Produto> listaProduto;
	
	public Pedido(String id_pedido, Cliente comprador, ArrayList<Produto> listaProduto) {
		super();
		this.id_pedido = id_pedido;
		this.comprador = comprador;
		this.listaProduto = listaProduto;
	}

	public String getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(String id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public ArrayList<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(ArrayList<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
		
}
