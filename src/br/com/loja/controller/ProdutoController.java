package br.com.loja.controller;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import br.com.loja.model.ProdutoModel;

public class ProdutoController {

	public static void limpar(JTextField txtProduto, JSpinner spnPreco, JSpinner spnQuantidade) {
		txtProduto.setText("");
		spnPreco.setValue(0.00);
		spnQuantidade.setValue(0);
	}

	public static ProdutoModel cadastrar(JTextField txtProduto, JSpinner spnPreco, JSpinner spnQuantidade) {
		ProdutoModel prod = new ProdutoModel();

		prod.setProduto(txtProduto.getText());
		prod.setPreco((Double) spnPreco.getValue());
		prod.setQtd((int) spnQuantidade.getValue());
		prod.setTotEstoque(prod.getTotEstoque() + ((Double) spnPreco.getValue() * (int) spnQuantidade.getValue()));
		
		return prod;
	}

	public static void editar(List<ProdutoModel> produto, JTextField txtProdutoEdit, JTextField txtPrecoEdit, JSpinner spnQtdEdit, JComboBox cbListProduto) {
		ProdutoModel produtoModel = new ProdutoModel();
		
		produtoModel.setProduto(txtProdutoEdit.getText());
		produtoModel.setPreco(Double.parseDouble(txtPrecoEdit.getText()));
		produtoModel.setQtd(Integer.parseInt(spnQtdEdit.getValue().toString()));
		produtoModel.setTotEstoque(Double.parseDouble(txtPrecoEdit.getText()) * Integer.parseInt(spnQtdEdit.getValue().toString()));
		
		produto.set(cbListProduto.getSelectedIndex(), produtoModel);
		
	}
	
	public static void remover(List<ProdutoModel> produto, int item) {
		produto.remove(item);
	}

	public static void listar(List<ProdutoModel> produto) {
		System.out.println("--- DADOS CADASTRADOS ---");

		System.out.printf("| %2s | %10s | %8s | %4s | %9s |\n", "Id", "Produto", "Preco", "Qtd", "R$ Total");
		for (int i = 0; i < produto.size(); i++) {
			System.out.printf("| %2d | %10s | R$%6.2f | %4d | R$%7.2f |\n", (i), produto.get(i).getProduto(),
					produto.get(i).getPreco(), produto.get(i).getQtd(), produto.get(i).getTotEstoque());
		}
	}

}
