package models;

import java.util.ArrayList;

public class Pedido {
	private String idPedido;
	private Cliente comprador;
	private ArrayList<Produto> listaProduto;
	
	public Pedido(String idPedido) {
		this.idPedido = idPedido;
	}
	
	public Pedido(String id_pedido, Cliente comprador) {
		super();
		this.idPedido = idPedido;
		this.comprador = comprador;
	}

	public String getId_pedido() {
		return idPedido;
	}

	public void setId_pedido(String idPedido) {
		this.idPedido = idPedido;
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
