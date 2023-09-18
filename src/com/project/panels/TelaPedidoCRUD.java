package com.project.panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;
import java.sql.ResultSet;

import javax.swing.border.TitledBorder;

import com.serratec.conexao.Conexao;
import com.serratec.dao.PedidoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class TelaPedidoCRUD extends JFrame {

	private JPanel contentPane;
	private static ClassConnection conexao;
	private static String schema;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedidoCRUD frame = new TelaPedidoCRUD(conexao,schema);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*private void UpdateComboBox(JComboBox<String> comboBox) {
		ResultSet tabela;
		PedidoDAO name = new PedidoDAO(conexao,schema);
		tabela = name.carregarPedidos();
		try {
			while (tabela.next()) {
				comboBox.addItem(tabela.getString("nome"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Deu ruim nos valores");// TODO: handle exception
		}
	}*/
	
	/**
	 * Create the frame.
	 */
	public TelaPedidoCRUD(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setColumns(4);
		textArea.setBounds(35, 301, 672, 274);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informa\u00E7\u00F5es do Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(426, 86, 281, 201);
		contentPane.add(panel);
		
		JLabel lblCpf = new JLabel("Produto");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(21, 24, 100, 21);
		panel.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Qtd");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(198, 24, 35, 21);
		panel.add(lblEmail);
		
		JFormattedTextField formattedTextEstoque = new JFormattedTextField();
		formattedTextEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextEstoque.setBounds(198, 44, 60, 26);
		panel.add(formattedTextEstoque);
		
		JComboBox comboBoxCliente_1 = new JComboBox();
		comboBoxCliente_1.setBounds(21, 44, 167, 26);
		panel.add(comboBoxCliente_1);
		
		JButton btnAdicionar_2 = new JButton("Adicionar");
		btnAdicionar_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar_2.setBounds(21, 81, 100, 33);
		panel.add(btnAdicionar_2);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemover.setBounds(21, 125, 100, 33);
		panel.add(btnRemover);
		
		JLabel lblPerdidoCrud = new JLabel("PEDIDO CRUD");
		lblPerdidoCrud.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPerdidoCrud.setBounds(35, 38, 227, 37);
		contentPane.add(lblPerdidoCrud);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 86, 163, 94);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ID Pedido", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JComboBox comboBoxIdProduto = new JComboBox();
		comboBoxIdProduto.setBounds(10, 21, 143, 26);
		panel_1.add(comboBoxIdProduto);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(10, 50, 89, 33);
		panel_1.add(btnPesquisar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informa\u00E7\u00F5es do Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(35, 191, 381, 94);
		contentPane.add(panel_2);
		
		JComboBox comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(24, 42, 206, 26);
		panel_2.add(comboBoxCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCliente.setBounds(24, 21, 123, 21);
		panel_2.add(lblCliente);
		
		JFormattedTextField formattedTextEstoque_1 = new JFormattedTextField();
		formattedTextEstoque_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextEstoque_1.setBounds(251, 41, 108, 26);
		panel_2.add(formattedTextEstoque_1);
		
		JLabel lblEmissao = new JLabel("Emissao");
		lblEmissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmissao.setBounds(251, 21, 108, 21);
		panel_2.add(lblEmissao);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Op\u00E7\u00F5es", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(713, 301, 179, 213);
		contentPane.add(panel_1_2);
		
		JButton btnAdicionar_1 = new JButton("Adicionar");
		btnAdicionar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar_1.setBounds(10, 31, 150, 33);
		panel_1_2.add(btnAdicionar_1);
		
		JButton btnAlterar_1 = new JButton("Alterar");
		btnAlterar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar_1.setBounds(10, 75, 150, 33);
		panel_1_2.add(btnAlterar_1);
		
		JButton btnDeletar_1 = new JButton("Deletar");
		btnDeletar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar_1.setBounds(10, 119, 150, 33);
		panel_1_2.add(btnDeletar_1);
		
		JButton btnCategoria_1 = new JButton("Categoria");
		btnCategoria_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCategoria_1.setBounds(10, 163, 150, 33);
		panel_1_2.add(btnCategoria_1);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setEditable(false);
		textArea_1.setColumns(4);
		textArea_1.setBounds(713, 86, 253, 201);
		contentPane.add(textArea_1);
	}
}
