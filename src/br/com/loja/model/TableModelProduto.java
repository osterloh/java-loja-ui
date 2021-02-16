package br.com.loja.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelProduto extends AbstractTableModel {

	private List<ProdutoModel> produto = new ArrayList<ProdutoModel>();
	private String[] colunas = { "ID", "Produto", "Preco", "Quantidade" };
	private final int col_id = 0;
	private final int col_produto = 1;
	private final int col_preco = 2;
	private final int col_qtd = 3;

	public TableModelProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

	@Override
	public String getColumnName(int indice) {
		// retorna o nome da coluna de acordo com seu indice
		return colunas[indice];
	}

	@Override
	public int getColumnCount() {
		// retorna o total de colunas da tabela
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// retorna o total de itens(que virarao linhas) da nossa lista
		return produto.size();

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// preenche cada celula da tabela

		switch (columnIndex) {
		case col_id:
			return produto.indexOf(produto.get(rowIndex));

		case col_produto:
			return produto.get(rowIndex).getProduto();

		case col_preco:
			return produto.get(rowIndex).getPreco();

		case col_qtd:
			return produto.get(rowIndex).getQtd();
		}

		return null;
	}

}
