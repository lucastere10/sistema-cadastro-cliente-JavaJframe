package com.project.panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JEditorPane;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

//import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.serratec.conexao.Conexao;
import com.serratec.dao.ClienteDAO;
import com.serratec.dao.ProdutoDAO;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class TelaProdutoCRUD extends JFrame {

	private JPanel contentPane;
	private static ClassConnection conexao;
	private static String schema;
    NumberFormat amountFormat = NumberFormat.getCurrencyInstance(Locale.US);
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutoCRUD frame = new TelaProdutoCRUD(conexao, schema);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void UpdateComboBox(JComboBox<String> comboBox) {
		ResultSet tabela;
		ProdutoDAO name = new ProdutoDAO(conexao,schema);
		tabela = name.carregarProduto();
		try {
			while (tabela.next()) {
				comboBox.addItem(tabela.getString("nome"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Deu ruim nos valores");// TODO: handle exception
		}
	}
	
	private void UpdateValuesComboBox(JFormattedTextField nome,
			JFormattedTextField preco,
			JFormattedTextField estoque,
			JTextPane descricao,
			JComboBox<String> categoria,
			JComboBox<String> comboBox) {
		ResultSet tabela;
		ProdutoDAO name = new ProdutoDAO(conexao,schema);
		tabela = name.carregarProduto();
		try {
			while (tabela.next()) {
				if (tabela.getString("nome").equals(comboBox.getSelectedItem().toString())) {
					nome.setText(tabela.getString("nome"));
					descricao.setText(tabela.getString("descricao"));
					preco.setText(String.valueOf(tabela.getDouble("vl_venda")));
					estoque.setText(String.valueOf(tabela.getInt("qtd_estoque")));
					//categoria.setText(tabela.getString("email"));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Deu ruim nos valores");// TODO: handle exception
		}
	}
	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaProdutoCRUD(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 728);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("CRUD");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Produto");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Pedido");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("PRODUTO CRUD");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(35, 28, 267, 37);
		contentPane.add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 76, 424, 206);
		contentPane.add(panel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(22, 136, 100, 21);
		panel.add(lblNome);
		
		JFormattedTextField formattedTextFieldNome = new JFormattedTextField();
		formattedTextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldNome.setBounds(22, 156, 233, 26);
		panel.add(formattedTextFieldNome);
			
		JLabel lblCpf = new JLabel("Preço de Venda");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(287, 80, 100, 21);
		panel.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Estoque");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(287, 136, 123, 21);
		panel.add(lblEmail);
		
		JFormattedTextField formattedTextFieldEstoque = new JFormattedTextField();
		formattedTextFieldEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldEstoque.setBounds(287, 156, 112, 26);
		panel.add(formattedTextFieldEstoque);
		
	    //MaskFormatter currencyMask = new MaskFormatter();
		JFormattedTextField formattedTextFieldPreco = new JFormattedTextField();
		formattedTextFieldPreco.setText(" ");
		formattedTextFieldPreco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldPreco.setBounds(287, 100, 112, 26);
		panel.add(formattedTextFieldPreco);
		
		JFormattedTextField formattedTextFieldCusto = new JFormattedTextField();
		formattedTextFieldCusto.setText(" ");
		formattedTextFieldCusto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldCusto.setBounds(287, 42, 112, 26);
		panel.add(formattedTextFieldCusto);
		
		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCusto.setBounds(287, 22, 100, 21);
		panel.add(lblCusto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 26, 233, 105);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "ID Produto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JComboBox<String> comboBoxIdProduto = new JComboBox<String>();
		comboBoxIdProduto.setBounds(10, 24, 213, 26);
		panel_1.add(comboBoxIdProduto);
					
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(109, 50, 123, 21);
		panel_1.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JComboBox<String> comboBoxCategoria = new JComboBox<String>();
		comboBoxCategoria.setBounds(109, 68, 114, 26);
		panel_1.add(comboBoxCategoria);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Op\u00E7\u00F5es", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(819, 293, 179, 213);
		contentPane.add(panel_1_2);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setBounds(10, 31, 150, 33);
		panel_1_2.add(btnAdicionar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(10, 75, 150, 33);
		panel_1_2.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setBounds(10, 119, 150, 33);
		panel_1_2.add(btnDeletar);
		
		JButton btnCategoria = new JButton("Categoria");
		btnCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCategoria.setBounds(10, 163, 150, 33);
		panel_1_2.add(btnCategoria);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Descri\u00E7\u00E3o", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(469, 76, 403, 206);
		contentPane.add(panel_1_1);
		
		JTextPane textPaneDescricao = new JTextPane();
		textPaneDescricao.setBounds(20, 26, 358, 154);
		panel_1_1.add(textPaneDescricao);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateValuesComboBox(
						formattedTextFieldNome,
						formattedTextFieldPreco,
						formattedTextFieldEstoque,
						textPaneDescricao,
						comboBoxCategoria,
						comboBoxIdProduto);
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(10, 61, 89, 33);
		panel_1.add(btnPesquisar);
		
		UpdateComboBox(comboBoxIdProduto);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 293, 774, 315);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "Estoque", "Preco", "Custo", "Nome", "ID Produto"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
}
