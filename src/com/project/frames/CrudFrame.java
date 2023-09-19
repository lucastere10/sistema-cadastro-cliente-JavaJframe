package com.project.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CrudFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudFrame frame = new CrudFrame();
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
	public CrudFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 708);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCRUD = new JMenu("CRUD");
		menuBar.add(menuCRUD);
		
		JMenuItem menuItemClient = new JMenuItem("Client");
		menuCRUD.add(menuItemClient);
		
		JMenuItem menuItemProduct = new JMenuItem("Product");
		menuCRUD.add(menuItemProduct);
		
		JMenuItem menuItemOrder = new JMenuItem("Order");
		menuCRUD.add(menuItemOrder);
		
		JMenu menuUser = new JMenu("User");
		menuBar.add(menuUser);
		
		JMenuItem menuItemEdit = new JMenuItem("Edit");
		menuUser.add(menuItemEdit);
		
		JMenuItem menuItemLogout = new JMenuItem("Logout");
		menuUser.add(menuItemLogout);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		menuUser.add(mntmNewMenuItem_1);
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		JMenuItem menuItemAbout = new JMenuItem("About");
		menuHelp.add(menuItemAbout);
		
		JMenuItem menuItemHotkeys = new JMenuItem("Hotkeys");
		menuHelp.add(menuItemHotkeys);
		
		JMenuItem menuItemCredits = new JMenuItem("Credits");
		menuHelp.add(menuItemCredits);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelClient = new JPanel();
		panelClient.setLayout(null);
		contentPane.add(panelClient, "name_2508051270700");
		
		JLabel lblClienteCrud = new JLabel("CLIENTE CRUD");
		lblClienteCrud.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblClienteCrud.setBounds(10, 11, 234, 37);
		panelClient.add(lblClienteCrud);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setLayout(null);
		panelSearch.setBorder(new TitledBorder(null, "ID Produto", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelSearch.setBounds(10, 59, 264, 105);
		panelClient.add(panelSearch);
		
		JComboBox<String> comboBoxIdProduto = new JComboBox<String>();
		comboBoxIdProduto.setBounds(10, 24, 231, 26);
		panelSearch.add(comboBoxIdProduto);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(10, 61, 96, 33);
		panelSearch.add(btnPesquisar);
		
		JRadioButton RadioNome = new JRadioButton("Nome");
		RadioNome.setBounds(124, 68, 69, 23);
		panelSearch.add(RadioNome);
		
		JRadioButton RadioCpf = new JRadioButton("CPF");
		RadioCpf.setBounds(195, 68, 63, 23);
		panelSearch.add(RadioCpf);
		
		JPanel panelOptions = new JPanel();
		panelOptions.setLayout(null);
		panelOptions.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Op\u00E7\u00F5es", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOptions.setBounds(584, 59, 179, 381);
		panelClient.add(panelOptions);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setBounds(10, 31, 150, 33);
		panelOptions.add(btnAdicionar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(10, 75, 150, 33);
		panelOptions.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletar.setBounds(10, 119, 150, 33);
		panelOptions.add(btnDeletar);
		
		JButton btnCategoria = new JButton("Limpar");
		btnCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCategoria.setBounds(10, 337, 150, 33);
		panelOptions.add(btnCategoria);
		
		JPanel panelUser = new JPanel();
		panelUser.setLayout(null);
		panelUser.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "User Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelUser.setBounds(10, 175, 264, 265);
		panelClient.add(panelUser);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(12, 25, 100, 21);
		panelUser.add(lblName);
		
		JFormattedTextField fieldName = new JFormattedTextField();
		fieldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldName.setBounds(12, 45, 233, 26);
		panelUser.add(fieldName);
		
		JFormattedTextField fieldCPF = new JFormattedTextField((Object) null);
		fieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldCPF.setBounds(12, 102, 233, 26);
		panelUser.add(fieldCPF);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(12, 82, 170, 21);
		panelUser.add(lblCpf);
		
		JFormattedTextField fieldBithdate = new JFormattedTextField();
		fieldBithdate.setBounds(12, 217, 233, 26);
		panelUser.add(fieldBithdate);
		fieldBithdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(12, 196, 100, 21);
		panelUser.add(lblDateOfBirth);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JFormattedTextField fieldPhone = new JFormattedTextField();
		fieldPhone.setBounds(12, 159, 233, 26);
		panelUser.add(fieldPhone);
		fieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(12, 139, 100, 21);
		panelUser.add(lblPhoneNumber);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelAdress = new JPanel();
		panelAdress.setLayout(null);
		panelAdress.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Adress Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelAdress.setBounds(284, 59, 290, 381);
		panelClient.add(panelAdress);
		
		JFormattedTextField jTxtCep = new JFormattedTextField((Object) null);
		jTxtCep.setText("");
		jTxtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jTxtCep.setBounds(12, 60, 170, 26);
		panelAdress.add(jTxtCep);
		
		JLabel lblCEP = new JLabel("Informe o CEP");
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCEP.setBounds(12, 28, 170, 21);
		panelAdress.add(lblCEP);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(192, 60, 81, 28);
		panelAdress.add(btnSearch);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogradouro.setBounds(12, 140, 170, 21);
		panelAdress.add(lblLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(12, 198, 170, 21);
		panelAdress.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(12, 253, 170, 21);
		panelAdress.add(lblCidade);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUF.setBounds(223, 253, 52, 21);
		panelAdress.add(lblUF);
		
		JFormattedTextField fieldNumber = new JFormattedTextField();
		fieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldNumber.setBounds(12, 333, 73, 26);
		panelAdress.add(fieldNumber);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(12, 312, 73, 21);
		panelAdress.add(lblNumero);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(12, 216, 263, 26);
		panelAdress.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(12, 161, 263, 26);
		panelAdress.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(12, 274, 199, 26);
		panelAdress.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(223, 274, 52, 26);
		panelAdress.add(textField_3);
		
		JFormattedTextField fieldComplemento = new JFormattedTextField();
		fieldComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldComplemento.setBounds(95, 333, 178, 26);
		panelAdress.add(fieldComplemento);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComplemento.setBounds(95, 312, 178, 21);
		panelAdress.add(lblComplemento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 112, 270, 2);
		panelAdress.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 451, 753, 175);
		panelClient.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panelProduct = new JPanel();
		panelProduct.setLayout(null);
		contentPane.add(panelProduct, "name_2508059405700");
		
		JLabel lblCrudProduct = new JLabel("CRUD Product");
		lblCrudProduct.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrudProduct.setBounds(10, 11, 199, 34);
		panelProduct.add(lblCrudProduct);
		
		JPanel panelOrder = new JPanel();
		panelOrder.setLayout(null);
		contentPane.add(panelOrder, "name_2508068157600");
		
		JLabel lblCrudOrder = new JLabel("CRUD Order");
		lblCrudOrder.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrudOrder.setBounds(10, 11, 199, 34);
		panelOrder.add(lblCrudOrder);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
