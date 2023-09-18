package com.project.panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;

import com.project.connect.ClassConnection;
import com.serratec.classes.Cliente;
import com.serratec.conexao.Conexao;
import com.serratec.conexao.DadosConexao;
import com.serratec.dao.ClienteDAO;
import com.serratec.uteis.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.TextArea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class TelaClienteCRUD extends JFrame {

	private JPanel contentPane;
	private static ClassConnection conexao;
	private static String schema;
	private JTable tableClientes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteCRUD frame = new TelaClienteCRUD(conexao,schema);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void UpdateComboBox(JComboBox<String> comboBox) {
		ResultSet tabela;
		ClienteDAO name = new ClienteDAO(conexao,schema);
		tabela = name.carregarClientes();
		try {
			while (tabela.next()) {
				comboBox.addItem(tabela.getString("nome"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Deu ruim nos valores");// TODO: handle exception
		}
	}
	
	private void UpdateList(JTable tableClientes) {
	    ResultSet tabela;
	    ClienteDAO name = new ClienteDAO(conexao,schema);
	    tabela = name.carregarClientes();
	    try {
	        DefaultTableModel tableModel = (DefaultTableModel) tableClientes.getModel();
	        while (tabela.next()) {
	            String data[] = {
	                    tabela.getString("idcliente"),
	                    tabela.getString("nome"),
	                    tabela.getString("cpf"),
	                    tabela.getString("email"),
	                    tabela.getString("telefone"),
	                    tabela.getString("endereco"),
	            };
	            tableModel.addRow(data);
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Deu ruim nos valores");
	    }
	}

	private void UpdateValuesComboBox(JFormattedTextField nome,
			JFormattedTextField cpf,
			JFormattedTextField email,
			JFormattedTextField telefone,
			JComboBox<String> comboBox) {
		ResultSet tabela;
		ClienteDAO name = new ClienteDAO(conexao,schema);
		tabela = name.carregarClientes();
		try {
			while (tabela.next()) {
				if (tabela.getString("nome").equals(comboBox.getSelectedItem().toString())) {
					nome.setText(tabela.getString("nome"));
					cpf.setText(tabela.getString("cpf"));
					telefone.setText(tabela.getString("telefone"));
					email.setText(tabela.getString("email"));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Deu ruim nos valores");// TODO: handle exception
		}
	}
	
	//ADICIONAR NOVO CLIENTE
	private void AddClientCRUD() {
		ClienteDAO cdao = new ClienteDAO(conexao,schema);
		Cliente c = new Cliente();
		try {
			//incluirCliente(Cliente cliente);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Deu ruim nos valores");// TODO: handle exception
		}
	}
	
	
	public static void buscarCep(String cep,
			JFormattedTextField logradouro,
			JFormattedTextField bairro,
			JFormattedTextField cidade,
			JFormattedTextField uf
			){
        String json;        

	    try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");

            logradouro.setText(array[7]);            
            bairro.setText(array[15]);
            cidade.setText(array[19]); 
            uf.setText(array[23]);         
            
        } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "CEP não encontrado");// TODO: handle exception
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * Create the frame.
	 */
	public TelaClienteCRUD(Conexao conexao, String schema) { 
		this.conexao = conexao;
		this.schema = schema;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 728);
		
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 189, 282, 206);
		contentPane.add(panel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(22, 22, 100, 21);
		panel.add(lblNome);
		
		JFormattedTextField formattedTextFieldNome = new JFormattedTextField();
		formattedTextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldNome.setBounds(22, 42, 233, 26);
		panel.add(formattedTextFieldNome);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf_1.setBounds(22, 79, 100, 21);
		panel.add(lblCpf_1);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(132, 79, 123, 21);
		panel.add(lblTelefone);
		
		JFormattedTextField formattedTextFieldTelefone = new JFormattedTextField();
		formattedTextFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldTelefone.setBounds(132, 99, 123, 26);
		panel.add(formattedTextFieldTelefone);
		
		JLabel lblCategoria = new JLabel("Email");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoria.setBounds(22, 136, 123, 21);
		panel.add(lblCategoria);
		
		JFormattedTextField formattedTextFieldCpf = new JFormattedTextField();
		formattedTextFieldCpf.setText(" ");
		formattedTextFieldCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldCpf.setBounds(22, 99, 100, 26);
		panel.add(formattedTextFieldCpf);
		
		JFormattedTextField formattedTextFieldEmail = new JFormattedTextField();
		formattedTextFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldEmail.setBounds(22, 155, 233, 26);
		panel.add(formattedTextFieldEmail);
		
		JLabel lblClienteCrud = new JLabel("CLIENTE CRUD");
		lblClienteCrud.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblClienteCrud.setBounds(35, 25, 234, 37);
		contentPane.add(lblClienteCrud);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_1_1.setBounds(327, 73, 290, 319);
		contentPane.add(panel_1_1);
		
		JFormattedTextField jTxtCep = new JFormattedTextField();
		jTxtCep.setText("");
		jTxtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jTxtCep.setBounds(13, 43, 170, 26);
		panel_1_1.add(jTxtCep);
		
		JLabel lblCEP = new JLabel("Informe o CEP");
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCEP.setBounds(13, 23, 170, 21);
		panel_1_1.add(lblCEP);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogradouro.setBounds(13, 80, 88, 21);
		panel_1_1.add(lblLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(13, 138, 170, 21);
		panel_1_1.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(13, 193, 170, 21);
		panel_1_1.add(lblCidade);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUF.setBounds(223, 193, 52, 21);
		panel_1_1.add(lblUF);
		
		JFormattedTextField formattedTextFieldNumero = new JFormattedTextField();
		formattedTextFieldNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldNumero.setBounds(13, 273, 73, 26);
		panel_1_1.add(formattedTextFieldNumero);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(13, 252, 170, 21);
		panel_1_1.add(lblNumero);
			
		JFormattedTextField formattedTextFieldLogradouro = new JFormattedTextField();
		formattedTextFieldLogradouro.setEnabled(false);
		formattedTextFieldLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldLogradouro.setBounds(13, 107, 262, 26);
		panel_1_1.add(formattedTextFieldLogradouro);
		
		JFormattedTextField formattedTextFieldBairro = new JFormattedTextField();
		formattedTextFieldBairro.setEnabled(false);
		formattedTextFieldBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldBairro.setBounds(13, 158, 262, 26);
		panel_1_1.add(formattedTextFieldBairro);
		
		JFormattedTextField formattedTextFieldUf = new JFormattedTextField();
		formattedTextFieldUf.setEnabled(false);
		formattedTextFieldUf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldUf.setBounds(207, 217, 73, 26);
		panel_1_1.add(formattedTextFieldUf);
		
		JFormattedTextField formattedTextFieldCidade = new JFormattedTextField();
		formattedTextFieldCidade.setEnabled(false);
		formattedTextFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldCidade.setBounds(13, 217, 184, 26);
		panel_1_1.add(formattedTextFieldCidade);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 73, 282, 105);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "ID Produto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JComboBox<String> comboBoxIdProduto = new JComboBox<String>();
		comboBoxIdProduto.setBounds(10, 24, 262, 26);
		panel_1.add(comboBoxIdProduto);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateValuesComboBox(
						formattedTextFieldNome,
						formattedTextFieldCpf,
						formattedTextFieldEmail,
						formattedTextFieldTelefone,
						comboBoxIdProduto);
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(10, 61, 96, 33);
		panel_1.add(btnPesquisar);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Alterar Manualmente");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxNewCheckBox.isSelected()) {
		        	formattedTextFieldLogradouro.setEnabled(true);
		        	formattedTextFieldBairro.setEnabled(true);
		        	formattedTextFieldCidade.setEnabled(true);
		        	formattedTextFieldUf.setEnabled(true);
		        } else {
		        	formattedTextFieldLogradouro.setEnabled(false);
		        	formattedTextFieldBairro.setEnabled(false);
		        	formattedTextFieldCidade.setEnabled(false);
		        	formattedTextFieldUf.setEnabled(false);
		        }
		    }
		});
		chckbxNewCheckBox.setBounds(150, 76, 125, 24);
		panel_1_1.add(chckbxNewCheckBox);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep(jTxtCep.getText(),
						formattedTextFieldLogradouro,
						formattedTextFieldBairro,
						formattedTextFieldCidade,
						formattedTextFieldUf
						);
			}
		});
		btnBuscar.setBounds(194, 44, 81, 26);
		panel_1_1.add(btnBuscar);
				
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Op\u00E7\u00F5es", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(627, 73, 179, 249);
		contentPane.add(panel_1_2);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adicionar novo cliente
				
				
			}
		});
		btnAdicionar.setBounds(10, 31, 150, 33);
		panel_1_2.add(btnAdicionar);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(10, 75, 150, 33);
		panel_1_2.add(btnAlterar);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(10, 119, 150, 33);
		panel_1_2.add(btnDeletar);
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCategoria = new JButton("Limpar");
		btnCategoria.setBounds(10, 205, 150, 33);
		panel_1_2.add(btnCategoria);
		btnCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//UPDATES
		UpdateComboBox(comboBoxIdProduto);
		
		JRadioButton RadioNome = new JRadioButton("Nome");
		RadioNome.setBounds(124, 68, 69, 23);
		panel_1.add(RadioNome);
		
		JRadioButton RadioCpf = new JRadioButton("CPF");
		RadioCpf.setBounds(195, 68, 69, 23);
		panel_1.add(RadioCpf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 403, 771, 255);
		contentPane.add(scrollPane);
		
		tableClientes = new JTable();
		scrollPane.setViewportView(tableClientes);
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Cliente", "Nome", "CPF", "Email", "Telefone", "Endereco"
			}
		));
		UpdateList(tableClientes);
		
		
	}
}
