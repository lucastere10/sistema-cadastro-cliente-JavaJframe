package com.project.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField fieldBairro;
	private JTextField fieldLogradouro;
	private JTextField fieldCidade;
	private JTextField fieldUF;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN IN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 11, 231, 33);
		contentPane.add(lblNewLabel_2);
		
		JButton btnRegister = new JButton("Registrer");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegister.setBounds(765, 381, 93, 33);
		contentPane.add(btnRegister);
		
		JPanel panelUser = new JPanel();
		panelUser.setLayout(null);
		panelUser.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "User Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelUser.setBounds(294, 56, 264, 316);
		contentPane.add(panelUser);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(12, 25, 100, 21);
		panelUser.add(lblName);
		
		JFormattedTextField fieldName = new JFormattedTextField();
		fieldName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldName.setBounds(12, 45, 233, 26);
		panelUser.add(fieldName);
		
		JFormattedTextField fieldCPF = new JFormattedTextField((AbstractFormatter) null);
		fieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldCPF.setBounds(12, 102, 233, 26);
		panelUser.add(fieldCPF);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(12, 82, 170, 21);
		panelUser.add(lblCpf);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(12, 139, 100, 21);
		panelUser.add(lblPhoneNumber);
		
		JFormattedTextField fieldPhone = new JFormattedTextField();
		fieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldPhone.setBounds(12, 159, 233, 26);
		panelUser.add(fieldPhone);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(12, 196, 100, 21);
		panelUser.add(lblDateOfBirth);
		
		JFormattedTextField fieldBithdate = new JFormattedTextField();
		fieldBithdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldBithdate.setBounds(12, 216, 233, 26);
		panelUser.add(fieldBithdate);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPosition.setBounds(12, 246, 100, 21);
		panelUser.add(lblPosition);
		
		JComboBox cbPosition = new JComboBox();
		cbPosition.setBounds(12, 265, 233, 27);
		panelUser.add(cbPosition);
		
		JPanel panelAdress = new JPanel();
		panelAdress.setLayout(null);
		panelAdress.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Adress Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelAdress.setBounds(568, 56, 290, 316);
		contentPane.add(panelAdress);
		
		JFormattedTextField jTxtCep = new JFormattedTextField((AbstractFormatter) null);
		jTxtCep.setText("");
		jTxtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jTxtCep.setBounds(12, 48, 170, 26);
		panelAdress.add(jTxtCep);
		
		JLabel lblCEP = new JLabel("Informe o CEP");
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCEP.setBounds(12, 28, 170, 21);
		panelAdress.add(lblCEP);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(192, 46, 81, 28);
		panelAdress.add(btnSearch);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogradouro.setBounds(12, 85, 170, 21);
		panelAdress.add(lblLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBairro.setBounds(12, 143, 170, 21);
		panelAdress.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(12, 198, 170, 21);
		panelAdress.add(lblCidade);
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUF.setBounds(223, 198, 52, 21);
		panelAdress.add(lblUF);
		
		JFormattedTextField fieldNumber = new JFormattedTextField();
		fieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldNumber.setBounds(12, 278, 73, 26);
		panelAdress.add(fieldNumber);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(12, 257, 73, 21);
		panelAdress.add(lblNumero);
		
		fieldBairro = new JTextField();
		fieldBairro.setEditable(false);
		fieldBairro.setColumns(10);
		fieldBairro.setBounds(12, 161, 263, 26);
		panelAdress.add(fieldBairro);
		
		fieldLogradouro = new JTextField();
		fieldLogradouro.setEditable(false);
		fieldLogradouro.setColumns(10);
		fieldLogradouro.setBounds(12, 106, 263, 26);
		panelAdress.add(fieldLogradouro);
		
		fieldCidade = new JTextField();
		fieldCidade.setEditable(false);
		fieldCidade.setColumns(10);
		fieldCidade.setBounds(12, 219, 199, 26);
		panelAdress.add(fieldCidade);
		
		fieldUF = new JTextField();
		fieldUF.setEditable(false);
		fieldUF.setColumns(10);
		fieldUF.setBounds(223, 219, 52, 26);
		panelAdress.add(fieldUF);
		
		JFormattedTextField fieldComplemento = new JFormattedTextField();
		fieldComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldComplemento.setBounds(95, 278, 178, 26);
		panelAdress.add(fieldComplemento);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComplemento.setBounds(95, 257, 178, 21);
		panelAdress.add(lblComplemento);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setLayout(null);
		panelRegister.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Register Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRegister.setBounds(20, 55, 264, 317);
		contentPane.add(panelRegister);
		
		JLabel lblName_1 = new JLabel("Username");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName_1.setBounds(12, 25, 100, 21);
		panelRegister.add(lblName_1);
		
		JFormattedTextField fieldUsername = new JFormattedTextField();
		fieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldUsername.setBounds(12, 45, 233, 26);
		panelRegister.add(fieldUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 82, 100, 21);
		panelRegister.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JFormattedTextField fieldEmail = new JFormattedTextField();
		fieldEmail.setBounds(12, 102, 233, 26);
		panelRegister.add(fieldEmail);
		fieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 198, 233, 26);
		panelRegister.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(12, 256, 233, 26);
		panelRegister.add(passwordField_1);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRepeatPassword.setBounds(12, 235, 170, 21);
		panelRegister.add(lblRepeatPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(12, 177, 170, 21);
		panelRegister.add(lblPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 156, 233, 2);
		panelRegister.add(separator);
	}
}
