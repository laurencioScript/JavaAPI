package br.pro.loja.pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ItemSelectable;
import java.text.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.pro.api.dao.ClienteDao;
import br.pro.api.dao.GenericDao;
import br.pro.api.dao.ItemVendaDao;
import br.pro.api.dao.ProdutoDao;
import br.pro.api.dao.VendaDao;
import br.pro.api.model.ClienteModel;
import br.pro.api.model.ItemVendaModel;
import br.pro.api.model.ProdutoModel;
import br.pro.api.model.VendaModel;

import javax.swing.ListSelectionModel;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private JTable tb_cliente;
	private JTextField tfd_nome_cliente;
	private JTextField tfd_cpf_cliente;
	private JTextField tfd_telefone_cliente;
	private JTextField tfd_email_cliente;
	private JTable tb_vendas;
	private JTable tb_itens;
	private JTable tb_produto;
	private JTextField tfd_nome_produto;
	private JTextField tfd_preco_produto;
	private JTextField tfd_qtd_produto;
	private JTextField tfd_descricao_produto;
	private JTable tb_itens_loja;
	JButton btn_novo_cliente;
	JButton btn_salvar_cliente;
	JButton btn_cancelar_cliente;
	JButton btn_excluir_cliente;
	JButton btn_novo_produto;
	JButton btn_salvar_produto;
	JButton btn_cancelar_produto;
	JButton btn_excluir_produto;
	JComboBox cb_cliente_loja;
	JButton btn_comprar_loja;
	JButton btn_limpar_loja;
	JButton btn_vender_loja;
	JComboBox cb_produto;
	ClienteDao cliente_dao = new ClienteDao("cliente");
	ProdutoDao produto_dao = new ProdutoDao("produto");
	VendaDao venda_dao = new VendaDao("venda");
	ItemVendaDao item_dao = new ItemVendaDao("itemVenda");
	ItemVendaModel[] itens ;
	JLabel label_total;
	JPanel pnl_loja ;
	ClienteModel[] clientes;
	ProdutoModel[] produtos;
	VendaModel[] vendas;
	ItemVendaModel[] todos_itens;
	JPanel panel_2 ;
	
	private JTextField tfd_codigo_cliente;
	private JTextField tfd_codigo_produto;
	private JTextField tfd_qtd_loja;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public Index() {
		setTitle("Loja");
		loadDate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 680);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 845, 607);
		contentPane.add(tabbedPane);
		
		JPanel pnl_cliente = new JPanel();
		tabbedPane.addTab("Cliente", null, pnl_cliente, null);
		pnl_cliente.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 22, 750, 205);
		pnl_cliente.add(scrollPane);
		
		tb_cliente = new JTable();
		tb_cliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_cliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tb_cliente.setModel(new DefaultTableModel(new Object[][] {},new String[] {"ID", "Nome", "CPF", "Telefone", "Email"}));
		scrollPane.setViewportView(tb_cliente);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(40, 308, 750, 246);
		pnl_cliente.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 46, 70, 15);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(30, 86, 70, 15);
		panel.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(30, 131, 70, 15);
		panel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 184, 70, 15);
		panel.add(lblEmail);
		
		tfd_nome_cliente = new JTextField();
		tfd_nome_cliente.setBounds(101, 44, 244, 19);
		panel.add(tfd_nome_cliente);
		tfd_nome_cliente.setColumns(10);
		
		tfd_cpf_cliente = new JTextField();
		tfd_cpf_cliente.setBounds(101, 84, 145, 19);
		panel.add(tfd_cpf_cliente);
		tfd_cpf_cliente.setColumns(10);
		
		tfd_telefone_cliente = new JTextField();
		tfd_telefone_cliente.setBounds(101, 129, 145, 19);
		panel.add(tfd_telefone_cliente);
		tfd_telefone_cliente.setColumns(10);
		
		tfd_email_cliente = new JTextField();
		tfd_email_cliente.setBounds(101, 182, 244, 19);
		panel.add(tfd_email_cliente);
		tfd_email_cliente.setColumns(10);
		
		btn_salvar_cliente = new JButton("salvar");
		
		btn_salvar_cliente.setBounds(439, 179, 117, 25);
		panel.add(btn_salvar_cliente);
		
		btn_cancelar_cliente = new JButton("cancelar");
	
		
		btn_cancelar_cliente.setBounds(588, 179, 117, 25);
		panel.add(btn_cancelar_cliente);
		
		tfd_codigo_cliente = new JTextField();
		tfd_codigo_cliente.setVisible(false);
		tfd_codigo_cliente.setBounds(279, 84, 114, 19);
		panel.add(tfd_codigo_cliente);
		tfd_codigo_cliente.setColumns(10);		
				
		btn_novo_cliente = new JButton("novo");
		btn_novo_cliente.setBounds(275, 250, 117, 25);
		pnl_cliente.add(btn_novo_cliente);
		btn_novo_cliente.setActionCommand("Novo");
		
		btn_excluir_cliente = new JButton("excluir");
		
		btn_excluir_cliente.setBounds(450, 250, 117, 25);
		pnl_cliente.add(btn_excluir_cliente);
		
		
		// PAINEL PRODUTO
		
		JPanel pnl_produto = new JPanel();
		tabbedPane.addTab("Produto", null, pnl_produto, null);
		pnl_produto.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(32, 28, 775, 242);
		pnl_produto.add(scrollPane_3);
		
		tb_produto = new JTable();
		tb_produto.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Nome", "Descrição", "Preço", "Quantidade"}));
		scrollPane_3.setViewportView(tb_produto);
		
		btn_novo_produto = new JButton("novo");
		btn_novo_produto.setBounds(269, 299, 117, 25);
		pnl_produto.add(btn_novo_produto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(32, 336, 775, 218);
		pnl_produto.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(12, 37, 70, 15);
		panel_1.add(lblNome_1);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(12, 81, 70, 15);
		panel_1.add(lblDescrio);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(12, 163, 70, 15);
		panel_1.add(lblPreo);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(12, 124, 91, 15);
		panel_1.add(lblQuantidade);
		
		tfd_nome_produto = new JTextField();
		tfd_nome_produto.setBounds(106, 35, 294, 19);
		panel_1.add(tfd_nome_produto);
		tfd_nome_produto.setColumns(10);
		
		tfd_preco_produto = new JTextField();
		tfd_preco_produto.setBounds(106, 161, 132, 19);
		panel_1.add(tfd_preco_produto);
		tfd_preco_produto.setColumns(10);
		
		tfd_qtd_produto = new JTextField();
		tfd_qtd_produto.setBounds(106, 122, 132, 19);
		panel_1.add(tfd_qtd_produto);
		tfd_qtd_produto.setColumns(10);
		
		tfd_descricao_produto = new JTextField();
		tfd_descricao_produto.setBounds(106, 79, 294, 19);
		panel_1.add(tfd_descricao_produto);
		tfd_descricao_produto.setColumns(10);
		

		btn_salvar_produto = new JButton("salvar");
		btn_salvar_produto.setBounds(466, 158, 117, 25);
		panel_1.add(btn_salvar_produto);
		
		btn_cancelar_produto = new JButton("cancelar");
		btn_cancelar_produto.setBounds(606, 158, 117, 25);
		panel_1.add(btn_cancelar_produto);
		
		tfd_codigo_produto = new JTextField();
		tfd_codigo_produto.setVisible(false);
		tfd_codigo_produto.setBounds(263, 122, 114, 19);
		panel_1.add(tfd_codigo_produto);
		tfd_codigo_produto.setColumns(10);
		
		btn_excluir_produto = new JButton("excluir");
		btn_excluir_produto.setBounds(447, 299, 117, 25);
		pnl_produto.add(btn_excluir_produto);
		
		// PAINEL LOJA
		
		pnl_loja = new JPanel();
		tabbedPane.addTab("Loja", null, pnl_loja, null);
		pnl_loja.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(404, 86, 397, 427);
		pnl_loja.add(scrollPane_5);
		
		tb_itens_loja = new JTable();
		tb_itens_loja.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Produto", "Quantidade", "Valor"}));
		scrollPane_5.setViewportView(tb_itens_loja);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(26, 38, 70, 15);
		pnl_loja.add(lblCliente);
		
		String[] x = new String[clientes.length];
		for(int i =0;i<clientes.length;i++) {
			x[i] = clientes[i].getNome();
		}
		
		cb_cliente_loja = new JComboBox(x);
		cb_cliente_loja.setBounds(99, 33, 160, 24);
		pnl_loja.add(cb_cliente_loja);
		
		btn_vender_loja = new JButton("vender");
		btn_vender_loja.setBounds(529, 33, 117, 25);
		pnl_loja.add(btn_vender_loja);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(49, 401, 91, 15);
		pnl_loja.add(lblValorTotal);
		
		label_total = new JLabel("0");
		label_total.setBounds(164, 401, 70, 15);
		pnl_loja.add(label_total);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(37, 86, 308, 200);
		pnl_loja.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(12, 41, 70, 15);
		panel_2.add(lblProduto);
		
		JLabel lblQuantidade_1 = new JLabel("Quantidade");
		lblQuantidade_1.setBounds(12, 84, 90, 15);
		panel_2.add(lblQuantidade_1);
		
		
		x = new String[produtos.length];
		for(int i =0;i<produtos.length;i++) {
			x[i] = produtos[i].getNome();
		}
		
		cb_produto = new JComboBox(x);
		cb_produto.setBounds(110, 36, 152, 24);
		panel_2.add(cb_produto);
		
		btn_comprar_loja = new JButton("comprar");		
		btn_comprar_loja.setBounds(88, 139, 117, 25);
		panel_2.add(btn_comprar_loja);
		
		tfd_qtd_loja = new JTextField();
		tfd_qtd_loja.setBounds(108, 82, 154, 19);
		panel_2.add(tfd_qtd_loja);
		tfd_qtd_loja.setColumns(10);
		
		btn_limpar_loja = new JButton("limpar");
		btn_limpar_loja.setBounds(674, 33, 117, 25);
		pnl_loja.add(btn_limpar_loja);
		
		JPanel pnl_historico = new JPanel();
		tabbedPane.addTab("Historico", null, pnl_historico, null);
		pnl_historico.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 29, 623, 239);
		pnl_historico.add(scrollPane_1);
		
		tb_vendas = new JTable();
		tb_vendas.setModel(new DefaultTableModel(new Object[][] {},new String[] {"ID","Cliente", "Data Venda", "Valor Total"}
		));
		scrollPane_1.setViewportView(tb_vendas);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(38, 286, 775, 271);
		pnl_historico.add(scrollPane_2);
		
		tb_itens = new JTable();
		tb_itens.setModel(new DefaultTableModel(new Object[][] {},new String[] {"ID", "Produto", "Preço", "Quantidade"}));
		scrollPane_2.setViewportView(tb_itens);
		
		JButton btn_relatorio_historico = new JButton("relatorio");
		btn_relatorio_historico.setBounds(688, 90, 117, 25);
		pnl_historico.add(btn_relatorio_historico);
		
		JButton btn_limpar_historico = new JButton("limpar");
		btn_limpar_historico.setBounds(688, 150, 117, 25);
		pnl_historico.add(btn_limpar_historico);
		
		
		// EVENTOS

		tb_cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = tb_cliente.getSelectedRow();
				if(index >=0 && index<clientes.length) {
					painel_cliente("Alternativo");
					
					tfd_codigo_cliente.setText(clientes[index].getCodigo()+"");
					tfd_nome_cliente.setText(clientes[index].getNome()+"");
					tfd_telefone_cliente.setText(clientes[index].getTelefone()+"");
					tfd_cpf_cliente.setText(clientes[index].getCpf()+"");
					tfd_email_cliente.setText(clientes[index].getEmail()+"");
					
					
				}
				
			}
		});
		
		btn_salvar_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo = tfd_codigo_cliente.getText();
				ClienteModel cliente = new ClienteModel();
				cliente.setNome(tfd_nome_cliente.getText());
				cliente.setCpf(tfd_cpf_cliente.getText());
				cliente.setTelefone(tfd_telefone_cliente.getText());
				cliente.setEmail(tfd_email_cliente.getText());
				
				if(codigo.length() <= 0) {
					cliente_dao.store(cliente);
				}
				else {
					cliente.setCodigo(Long.parseLong(codigo));
					cliente_dao.update(cliente);
				}
				
				loadDate();
				
				String[] x = new String[clientes.length];
				for(int i =0;i<clientes.length;i++) {
					x[i] = clientes[i].getNome();
				}
				pnl_loja.remove(cb_cliente_loja);
				cb_cliente_loja = new JComboBox(x);
				cb_cliente_loja.setBounds(99, 33, 160, 24);
				pnl_loja.add(cb_cliente_loja);
				
				loadTable();
				painel_cliente("Disable");
				
			}
		});

		btn_cancelar_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painel_cliente("Disable");
			}
		});
		
		btn_novo_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painel_cliente("Novo");
			
			}
		});
		
		btn_excluir_cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = tfd_codigo_cliente.getText();
				cliente_dao.delete(Long.parseLong(codigo));
				loadTable();
				painel_cliente("Disable");
			}
		});
		
		btn_salvar_produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String codigo = tfd_codigo_produto.getText();
				
				
				ProdutoModel produto = new ProdutoModel();
				produto.setNome(tfd_nome_produto.getText());
				produto.setPreco( BigDecimal.valueOf(Double.parseDouble(tfd_preco_produto.getText()) ));
				produto.setQtd(Integer.parseInt(tfd_qtd_produto.getText()));
				produto.setDescricao(tfd_descricao_produto.getText());
				
				if(codigo.length() <= 0) {
					produto_dao.store(produto);
				}
				else {
					produto.setCodigo(Long.parseLong(codigo));
					
					produto_dao.update(produto);
				}
				
				loadDate();
				
				String[] x = new String[produtos.length];
				for(int i =0;i<produtos.length;i++) {
					x[i] = produtos[i].getNome();
				}
				
				panel_2.remove(cb_produto);
				cb_produto = new JComboBox(x);
				cb_produto.setBounds(110, 36, 152, 24);
				panel_2.add(cb_produto);
				
				loadTable();
				painel_produto("Disable");
				
			}
		});
		
		tb_produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = tb_produto.getSelectedRow();
				if(index >=0 && index<produtos.length) {
					painel_produto("Alternativo");
					
					tfd_codigo_produto.setText(produtos[index].getCodigo()+"");
					tfd_descricao_produto.setText(produtos[index].getDescricao());
					tfd_nome_produto.setText(produtos[index].getNome());
					tfd_preco_produto.setText(produtos[index].getPreco()+"");
					tfd_qtd_produto.setText(produtos[index].getQtd()+"");
					
					
				}
				
			}
		});
		
		btn_novo_produto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel_produto("Novo");
			}
		});
		
		btn_cancelar_produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				painel_produto("Disable");
			}
		});
		
		btn_excluir_produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String codigo = tfd_codigo_produto.getText();
				produto_dao.delete(Long.parseLong(codigo));
				loadTable();
				painel_produto("Disable");
				
			}
			
		});
		
		btn_vender_loja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VendaModel venda = new VendaModel();
				ClienteModel cliente;
				BigDecimal valorTotal;
		 
				int index_cliente = cb_cliente_loja.getSelectedIndex();
				cliente = clientes[index_cliente];
				valorTotal = new BigDecimal(Double.parseDouble(label_total.getText()));
				venda.setCliente(cliente);
				venda.setPrecoTotal(valorTotal);
				Gson g = new Gson();
				venda_dao.store(venda);
				
				vendas = g.fromJson(venda_dao.index(), VendaModel[].class);
				
				venda = vendas[vendas.length-1];
				for(int x = 0; x<itens.length;x++) {
					itens[x].setVenda(venda);;
					item_dao.store(itens[x]);
					ProdutoModel p = itens[x].getProduto();
					p.setQtd(p.getQtd()-itens[x].getQtd());
					produto_dao.update(p);
				}
				
				itens = new ItemVendaModel[0];
				
				DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Produto", "Valor", "Quantidade"},0); 
				
				
				label_total.setText("0");
				tb_itens_loja.setModel(modelo);
				
				loadTable();
				
			}});
		
		btn_comprar_loja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				try {
					int codigo_produto = cb_produto.getSelectedIndex();
					int qtde_loja = Integer.parseInt(tfd_qtd_loja.getText());
					int qtde_estoque = produtos[codigo_produto].getQtd();
					
					
					if( qtde_loja <= qtde_estoque   && qtde_loja > 0 ) {
						ItemVendaModel[] auxiliar = itens;
						
						itens = new ItemVendaModel[auxiliar.length+1];
						
						for(int i = 0; i<auxiliar.length;i++) {
							itens[i] = auxiliar[i];
						}
						
						ItemVendaModel produto = new ItemVendaModel();
						
						produto.setProduto(produtos[codigo_produto]);
						BigDecimal y = new BigDecimal(tfd_qtd_loja.getText());
						BigDecimal valor = y. multiply(produtos[codigo_produto].getPreco());
						produto.setQtd(qtde_loja);
						produto.setValor(valor);
						
						itens[auxiliar.length] = produto; 
						
						DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Produto", "Valor", "Quantidade"},0); 
						
						BigDecimal total = new BigDecimal(0);
						
						for(int i = 0; i < itens.length; i++) {
							Object linha[] = new Object[] {itens[i].getProduto().getNome(),itens[i].getValor(),itens[i].getQtd()};
							modelo.addRow(linha);
							total = total.add(itens[i].getValor());
							
						}
						label_total.setText(total.toString());
						tb_itens_loja.setModel(modelo);
					
					}
					else {
						JOptionPane.showMessageDialog(null, "Quantidade invalida");
					}
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Quantidade invalida");
				}
				
				
						
				
			}
		});
		
		btn_limpar_loja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				itens = new ItemVendaModel[0];
				
				DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Produto", "Valor", "Quantidade"},0); 
				
				
				for(int i = 0; i < itens.length; i++) {
					Object linha[] = new Object[] {itens[i].getProduto().getNome(),itens[i].getValor(),itens[i].getQtd()};
					modelo.addRow(linha);
					
				}
				label_total.setText("0");
				tb_itens_loja.setModel(modelo);
				
			}
		});
		
		tb_vendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		
				int index = tb_vendas.getSelectedRow();
				List<ItemVendaModel> itens = new ArrayList<ItemVendaModel>() {};
				Long codigo_venda = vendas[index].getCodigo();				
				Gson g = new Gson();
				for(int i=0;i<todos_itens.length;i++) {			
					if(todos_itens[i].getVenda().getCodigo() == codigo_venda) {
						itens.add(todos_itens[i]);
					}					
				}
				
				
				DefaultTableModel modelo ;
				
				modelo = new DefaultTableModel(new Object[]{"ID", "Produto", "Preço", "Quantidade"},0);
				
				for(int i = 0; i < itens.size(); i++) {
					Object linha[] = new Object[] {itens.get(i).getCodigo(),itens.get(i).getProduto().getNome(),itens.get(i).getValor(),itens.get(i).getQtd()};
					modelo.addRow(linha);
				}
				
				tb_itens.setModel(modelo);		 
				
			}
		});

		btn_limpar_historico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for(int i =0;i<vendas.length;i++) {
					
					for(int x=0;x<todos_itens.length;x++) {
						
						if(todos_itens[x].getVenda().getCodigo() == vendas[i].getCodigo()) {
							item_dao.delete(todos_itens[x].getCodigo());
						}
						
					}
					venda_dao.delete(vendas[i].getCodigo());
				}
				
						
				loadTable();
			}
		});
		
		// My Function
		
		loadTable();
		painel_cliente("Disable");
		painel_produto("Disable");

	}
	
	public void loadDate(){
		Gson gson = new Gson();
		clientes = gson.fromJson(cliente_dao.index(),ClienteModel[].class);
		produtos = gson.fromJson(produto_dao.index(),ProdutoModel[].class);
		
		vendas = gson.fromJson(venda_dao.index(), VendaModel[].class);
		
		todos_itens = gson.fromJson(item_dao.index(),ItemVendaModel[].class);
		itens = new ItemVendaModel[0];
		
	}
	
	public void loadTableHistorico() {
		
	}
	
	public void painel_cliente(String modo) {
		switch(modo) {
			case"Disable":
					tfd_cpf_cliente.setEnabled(false);
					tfd_email_cliente.setEnabled(false);
					tfd_nome_cliente.setEnabled(false);
					tfd_telefone_cliente.setEnabled(false);
					btn_cancelar_cliente.setEnabled(false);
					btn_salvar_cliente.setEnabled(false);
					btn_novo_cliente.setEnabled(true);
					btn_excluir_cliente.setEnabled(false);
					tfd_nome_cliente.setText("");
					tfd_cpf_cliente.setText("");
					tfd_telefone_cliente.setText("");
					tfd_email_cliente.setText("");
					tfd_codigo_cliente.setText("");
					break;
				
				case "Novo":
					tfd_cpf_cliente.setEnabled(true);
					tfd_email_cliente.setEnabled(true);
					tfd_nome_cliente.setEnabled(true);
					tfd_telefone_cliente.setEnabled(true);
					btn_cancelar_cliente.setEnabled(true);
					btn_salvar_cliente.setEnabled(true);
					break;
				
			
				case "Alternativo":
					btn_excluir_cliente.setEnabled(true);
					tfd_cpf_cliente.setEnabled(true);
					tfd_email_cliente.setEnabled(true);
					tfd_nome_cliente.setEnabled(true);
					tfd_telefone_cliente.setEnabled(true);
					btn_cancelar_cliente.setEnabled(true);
					btn_novo_cliente.setEnabled(false);
					btn_salvar_cliente.setEnabled(true);
					break;
				
				}
			}

	public void loadTable() {
		
		loadDate();
		
		DefaultTableModel modelo ;
		
		modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF", "Telefone", "Email"},0);
		
		for(int i = 0; i < this.clientes.length; i++) {
			Object linha[] = new Object[] {clientes[i].getCodigo(),clientes[i].getNome(),clientes[i].getCpf(),clientes[i].getTelefone(),clientes[i].getEmail()};
			modelo.addRow(linha);
		}
		
		tb_cliente.setModel(modelo);
		
		modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Preço", "Quantidade"},0); 
		
		for(int i = 0; i < this.produtos.length; i++) {
			Object linha[] = new Object[] {produtos[i].getCodigo(),produtos[i].getNome(),produtos[i].getPreco(),produtos[i].getQtd()};
			modelo.addRow(linha);
		}
		
		tb_produto.setModel(modelo);
		
		modelo = new DefaultTableModel(new Object[]{"ID", "Cliente", "Data", "Valor Total"},0); 
		
		for(int i = 0; i < this.vendas.length; i++) {
			Object linha[] = new Object[] {vendas[i].getCodigo(),vendas[i].getCliente().getNome(),vendas[i].getDataVenda().toGMTString(),vendas[i].getPrecoTotal()};
			modelo.addRow(linha);
		}
		
		tb_vendas.setModel(modelo);
		

		modelo = new DefaultTableModel(new Object[]{"ID", "Produto", "Preço", "Quantidade"},0);
		
		tb_itens.setModel(modelo);
		
		
		
		
		
	}
	
	public void painel_produto(String modo) {
		switch(modo) {
			case"Disable":
					tfd_descricao_produto.setEnabled(false);
					tfd_nome_produto.setEnabled(false);
					tfd_preco_produto.setEnabled(false);
					tfd_qtd_produto.setEnabled(false);
					
					tfd_descricao_produto.setText("");
					tfd_nome_produto.setText("");
					tfd_preco_produto.setText("");
					tfd_qtd_produto.setText("");
					tfd_codigo_produto.setText("");
					
					btn_cancelar_produto.setEnabled(false);
					btn_salvar_produto.setEnabled(false);
					btn_novo_produto.setEnabled(true);
					btn_excluir_produto.setEnabled(false);
				
					break;
				
				case "Novo":
					tfd_descricao_produto.setEnabled(true);
					tfd_nome_produto.setEnabled(true);
					tfd_preco_produto.setEnabled(true);
					tfd_qtd_produto.setEnabled(true);
					
					btn_cancelar_produto.setEnabled(true);
					btn_salvar_produto.setEnabled(true);
					break;
				
			
				case "Alternativo":
					btn_excluir_produto.setEnabled(true);
					
					tfd_descricao_produto.setEnabled(true);
					tfd_nome_produto.setEnabled(true);
					tfd_preco_produto.setEnabled(true);
					tfd_qtd_produto.setEnabled(true);
					
					btn_cancelar_produto.setEnabled(true);
					btn_novo_produto.setEnabled(false);
					btn_salvar_produto.setEnabled(true);
					break;
				
				
			}
		}

	
	
}

