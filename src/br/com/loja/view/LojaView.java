package br.com.loja.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import br.com.loja.controller.ProdutoController;
import br.com.loja.model.ComboboxModelProduto;
import br.com.loja.model.ProdutoModel;
import br.com.loja.model.TableModelProduto;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import net.miginfocom.swing.MigLayout;

public class LojaView extends JFrame {

	private List<ProdutoModel> produtoModel = new ArrayList<>();;
	private ProdutoController produtoController;
	private TableModelProduto tableModel = new TableModelProduto(produtoModel);
	private ComboboxModelProduto comboboxMode;

	private JMenuItem itemSair;
	private JTable tabelaProdutos;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JComboBox<ProdutoModel> cbListProdutos;
	private JSpinner spnPreco, spnQuantidade, spnQtdEdit;
	private JPanel contentPane, panelProd, cadastrar, panelRemover;
	private JTextField txtProdutoEdit, txtPrecoEdit, txtProduto;
	private JTable tableRemover;

	/**
	 * Create the frame.
	 */
	public LojaView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 333);

		/*
		 * Configutacao do MENU
		 */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivos = new JMenu("Arquivos");
		menuBar.add(mnArquivos);

		/*
		 * Acao do menu SOBRE
		 */
		JMenuItem itemSobre = new JMenuItem("Sobre");
		mnArquivos.add(itemSobre);

		JSeparator separator = new JSeparator();
		mnArquivos.add(separator);

		/*
		 * Acao do menu SAIR
		 */
		itemSair = new JMenuItem("Sair");
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.exit(0); //finaliza todo o sistema
				dispose(); // encerra a aplicacao e limpa os recursos da JVM
			}
		});
		mnArquivos.add(itemSair);

		/*
		 * Chamada da aba ADICIONAR pelo menu ADICIONAR PRODUTOS
		 */
		JMenu mnAdcionar = new JMenu("Adicionar");
		menuBar.add(mnAdcionar);
		JMenuItem itemAddProdutos = new JMenuItem("Add Produtos");
		itemAddProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		mnAdcionar.add(itemAddProdutos);

		/*
		 * Chama da aba EDITAR pelo menu EDITAR PRODUTOS
		 */
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		JMenuItem itemEditarProdutos = new JMenuItem("Editar Produtos");
		itemEditarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		mnEditar.add(itemEditarProdutos);

		/*
		 * Chama da aba REMOVER pelo menu REMOVER PRODUTOS
		 */
		JMenu mnRemover = new JMenu("Remover");
		menuBar.add(mnRemover);
		JMenuItem itemRemoverProdutos = new JMenuItem("Remover Produtos");
		itemRemoverProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		mnRemover.add(itemRemoverProdutos);

		/*---------------------------------------*/
		/*
		 * Configuracao do painel geral da tela
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*---------------------------------------*/
		/*
		 * Configuracao do painel das abas PRODUTOS, ADICIONAR, EDITAR e REMOVER
		 */
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 48, 521, 233);
		contentPane.add(tabbedPane);

		/*
		 * Configuracao da aba PRODUTOS
		 */
		panelProd = new JPanel();
		tabbedPane.addTab("Produtos", null, panelProd, null);
		panelProd.setLayout(new GridLayout(1, 0, 0, 0));

		scrollPane = new JScrollPane();
		panelProd.add(scrollPane);

		// configuracao da tabela para apresentar os dados do ArrayList
		tabelaProdutos = new JTable(tableModel);
		scrollPane.setViewportView(tabelaProdutos);
		tabelaProdutos.setModel(tableModel);

		/*
		 * Configuracao da aba CADASTRAR
		 */
		cadastrar = new JPanel();
		tabbedPane.addTab("Cadastrar", null, cadastrar, null);
		GridBagLayout gbl_cadastrar = new GridBagLayout();
		gbl_cadastrar.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_cadastrar.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_cadastrar.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_cadastrar.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		cadastrar.setLayout(gbl_cadastrar);

		/*
		 * Configuracao dos JLabels
		 */
		// JLabel PRODRUTO
		JLabel lblCadProduto = new JLabel("Produto:");
		lblCadProduto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCadProduto = new GridBagConstraints();
		gbc_lblCadProduto.anchor = GridBagConstraints.EAST;
		gbc_lblCadProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCadProduto.gridx = 1;
		gbc_lblCadProduto.gridy = 0;
		cadastrar.add(lblCadProduto, gbc_lblCadProduto);

		// JLabel PRECO
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPreco = new GridBagConstraints();
		gbc_lblPreco.anchor = GridBagConstraints.EAST;
		gbc_lblPreco.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreco.gridx = 1;
		gbc_lblPreco.gridy = 1;
		cadastrar.add(lblPreco, gbc_lblPreco);

		// JLabel QUANTIDADE
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 1;
		gbc_lblQuantidade.gridy = 2;
		cadastrar.add(lblQuantidade, gbc_lblQuantidade);

		// JLabel TOTAL EM ESTOQUE
		JLabel lblTotalEmEstoque = new JLabel("Total em estoque: R$");
		GridBagConstraints gbc_lblTotalEmEstoque = new GridBagConstraints();
		gbc_lblTotalEmEstoque.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalEmEstoque.gridx = 6;
		gbc_lblTotalEmEstoque.gridy = 3;
		cadastrar.add(lblTotalEmEstoque, gbc_lblTotalEmEstoque);

		/*
		 * Configuracao dos campos de entrada de dados
		 */
		// JTextField TXTPRODUTO
		txtProduto = new JTextField();
		GridBagConstraints gbc_txtProduto = new GridBagConstraints();
		gbc_txtProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProduto.gridwidth = 7;
		gbc_txtProduto.insets = new Insets(0, 0, 5, 5);
		gbc_txtProduto.gridx = 2;
		gbc_txtProduto.gridy = 0;
		cadastrar.add(txtProduto, gbc_txtProduto);
		txtProduto.setColumns(10);

		// JSpinner PRECO
		spnPreco = new JSpinner();
		spnPreco.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		GridBagConstraints gbc_spnPreco = new GridBagConstraints();
		gbc_spnPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnPreco.gridwidth = 2;
		gbc_spnPreco.insets = new Insets(0, 0, 5, 5);
		gbc_spnPreco.gridx = 2;
		gbc_spnPreco.gridy = 1;
		cadastrar.add(spnPreco, gbc_spnPreco);
		// Configura o campo PRECO
		JSpinner.NumberEditor numberEditor = new JSpinner.NumberEditor(spnPreco, "0.00");
		spnPreco.setEditor(numberEditor);

		// JSpinner QUANTIDADE
		spnQuantidade = new JSpinner();
		spnQuantidade.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		GridBagConstraints gbc_spnQuantidade = new GridBagConstraints();
		gbc_spnQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnQuantidade.gridwidth = 2;
		gbc_spnQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_spnQuantidade.gridx = 2;
		gbc_spnQuantidade.gridy = 2;
		cadastrar.add(spnQuantidade, gbc_spnQuantidade);

		// JLabel TOTAL EM ESTOQUE configuracao
		JLabel lblTotEstoque = new JLabel("0,00");
		lblTotEstoque.setFont(new Font("SansSerif", Font.BOLD, 16));
		GridBagConstraints gbc_lblTotEstoque = new GridBagConstraints();
		gbc_lblTotEstoque.gridwidth = 2;
		gbc_lblTotEstoque.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotEstoque.gridx = 7;
		gbc_lblTotEstoque.gridy = 3;
		cadastrar.add(lblTotEstoque, gbc_lblTotEstoque);

		/*
		 * Configuracao dos botoes
		 */
		/*
		 * Acao do botao CADASTRAR
		 */
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// chama o metodo CADASTRAR()
				produtoModel.add(produtoController.cadastrar(txtProduto, spnPreco, spnQuantidade));
				tableModel.fireTableDataChanged();

			}
		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridwidth = 2;
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 4;
		cadastrar.add(btnCadastrar, gbc_btnCadastrar);

		/*
		 * Acao do botao LIMPAR
		 */
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// chama o metodo LIMPAR()
				produtoController.limpar(txtProduto, spnPreco, spnQuantidade);

			}
		});
		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.gridwidth = 2;
		gbc_btnLimpar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpar.gridx = 3;
		gbc_btnLimpar.gridy = 4;
		cadastrar.add(btnLimpar, gbc_btnLimpar);

		/*---------------------------------------*/
		/*
		 * Configuracao da aba EDITAR
		 */
		JLayeredPane layeredPaneEditProdutos = new JLayeredPane();
		tabbedPane.addTab("Editar", null, layeredPaneEditProdutos, null);

		/*
		 * Configuracao dos JLabels
		 */
		layeredPaneEditProdutos.setLayout(new MigLayout("", "[85px][18px][102px][39px][254px]", "[26px][28px][28px][28px][28px]"));
		// JLabel PRODRUTO
		JLabel label = new JLabel("Produto:");
		layeredPaneEditProdutos.add(label, "cell 0 1,alignx right,aligny center");

		// JLabel PRECO
		JLabel label_1 = new JLabel("Pre\u00E7o:");
		layeredPaneEditProdutos.add(label_1, "cell 0 2,alignx right,aligny center");

		// JLabel QUANTIDADE
		JLabel label_2 = new JLabel("Quantidade:");
		layeredPaneEditProdutos.add(label_2, "cell 0 3,alignx right,aligny center");

		/*
		 * Configuracao dos campos de entrada de dados
		 */
		// JComboBox LIST PRODUTOS
		comboboxMode = new ComboboxModelProduto(produtoModel);
		cbListProdutos = new JComboBox<>();
		cbListProdutos.setModel(comboboxMode);
		// insere o item selecionado no JTextField
		cbListProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtProdutoEdit.setText(produtoModel.get(cbListProdutos.getSelectedIndex()).getProduto());
				txtPrecoEdit.setText(Double.toString(produtoModel.get(cbListProdutos.getSelectedIndex()).getPreco()));
				spnQtdEdit.setValue(produtoModel.get(cbListProdutos.getSelectedIndex()).getQtd());
			}
		});
		layeredPaneEditProdutos.add(cbListProdutos, "cell 0 0 5 1,grow");

		// JTextField PRODUTO EDIT
		txtProdutoEdit = new JTextField();
		txtProdutoEdit.setColumns(10);
		layeredPaneEditProdutos.add(txtProdutoEdit, "cell 1 1 4 1,grow");

		// JTextField PRECO EDIT
		txtPrecoEdit = new JTextField();
		txtPrecoEdit.setColumns(10);
		layeredPaneEditProdutos.add(txtPrecoEdit, "cell 1 2 4 1,grow");

		// JSpinner QUANTIDADE EDIT
		spnQtdEdit = new JSpinner();
		layeredPaneEditProdutos.add(spnQtdEdit, "cell 1 3 2 1,grow");

		/*
		 * Configuracao dos botoes
		 */
		/*
		 * Acao do botao SALVAR
		 */
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				produtoController.editar(produtoModel, txtProdutoEdit, txtPrecoEdit, spnQtdEdit, cbListProdutos);
			}
		});
		layeredPaneEditProdutos.add(btnSalvar, "cell 2 4,grow");

		/*
		 * Acao do botao LISTAR
		 */
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				produtoController.listar(produtoModel);
			}
		});
		layeredPaneEditProdutos.add(btnListar, "cell 4 4,alignx left,aligny center");

		/*---------------------------------------*/
		/*
		 * Configuracao da aba REMOVER
		 */
		panelRemover = new JPanel();
		tabbedPane.addTab("Remover", null, panelRemover, null);
		panelRemover.setLayout(new MigLayout("", "[][][grow]", "[][grow]"));
		
		// JLabel
		JLabel lblSelecioneOItem = new JLabel("Selecione o item:");
		panelRemover.add(lblSelecioneOItem, "cell 0 0,alignx right");
		
		// botao REMOVER
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				produtoController.remover(produtoModel, tableRemover.getSelectedRow());
			}
		});
		panelRemover.add(btnRemover, "cell 1 0");
		
		// tabela
		JScrollPane scrollPaneRemover = new JScrollPane();
		panelRemover.add(scrollPaneRemover, "cell 0 1 10 1,grow");
		// configuracao da tabela para apresentar os dados do ArrayList
		tableRemover = new JTable(tableModel);
		scrollPaneRemover.setViewportView(tableRemover);
		tableRemover.setModel(tableModel);
		scrollPaneRemover.setViewportView(tableRemover);

		/*---------------------------------------*/
		/*
		 * Configuracao da imagem de fundo
		 */
		JLabel lblControleDeEstoque = new JLabel("");
		lblControleDeEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblControleDeEstoque.setIcon(new ImageIcon(LojaView.class.getResource("/br/com/loja/img/estoque.jpg")));
		lblControleDeEstoque.setBounds(0, 0, 521, 281);
		contentPane.add(lblControleDeEstoque);

	}
}
