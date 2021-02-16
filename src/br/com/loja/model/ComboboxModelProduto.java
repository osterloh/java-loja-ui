package br.com.loja.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ComboboxModelProduto extends AbstractListModel implements ComboBoxModel{
	
	private List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
	private ProdutoModel produtoModel;
	
	public ComboboxModelProduto(List<ProdutoModel> produto) {
		this.produtos = produto;
		
	}

	@Override
	public Object getElementAt(int index) {
		// Retorna o elemento do index que retorna a lista
		return this.produtos.get(index);
	}

	@Override
	public int getSize() {
		// Retrna a quantia de eleentos tem no JComboBox
		return produtos.size();
	}

	@Override
	public Object getSelectedItem() {
		// Retorna o item selecionado
		return this.produtoModel;
	}

	@Override
	public void setSelectedItem(Object cbComboBox) {
		if(cbComboBox instanceof ProdutoModel) {
			// Informa o item selecionado
			this.produtoModel = (ProdutoModel) cbComboBox;
			
			// Atualiza o comboBox
			fireContentsChanged(this.produtos, 0, this.produtos.size());
			
		}
		
	}

}
