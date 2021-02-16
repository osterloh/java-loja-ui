package br.com.loja.model;

public class ProdutoModel {

	// ATRIBUTOS
	private String produto;
	private double preco;
	private int qtd;
	private double totEstoque;

	// METODOS
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getTotEstoque() {
		return totEstoque;
	}

	public void setTotEstoque(double totEstoque) {
		this.totEstoque = totEstoque;
	}

	@Override
	public String toString() {
		return this.produto + " - R$" + getPreco() + " - Qtd: " + getQtd();
	}
	
}
