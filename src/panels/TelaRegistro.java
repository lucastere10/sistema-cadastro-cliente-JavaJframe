package panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Cliente;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class TelaRegistro extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistro frame = new TelaRegistro();
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
	public TelaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("REGISTRO");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(98, 11, 111, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(73, 67, 100, 21);
		contentPane.add(lblNewLabel);
		
		JFormattedTextField formattedTextFieldNome = new JFormattedTextField();
		formattedTextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldNome.setBounds(73, 87, 170, 26);
		contentPane.add(formattedTextFieldNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(73, 124, 100, 21);
		contentPane.add(lblCpf);
		
		JFormattedTextField formattedTextFieldCPF = new JFormattedTextField();
		formattedTextFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldCPF.setBounds(73, 145, 170, 26);
		contentPane.add(formattedTextFieldCPF);
		
		JFormattedTextField formattedTextFieldEndereco = new JFormattedTextField();
		formattedTextFieldEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		formattedTextFieldEndereco.setBounds(73, 202, 170, 26);
		contentPane.add(formattedTextFieldEndereco);
		
		JLabel lblDataDeNascimento_1 = new JLabel("Endereco");
		lblDataDeNascimento_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNascimento_1.setBounds(73, 182, 170, 21);
		contentPane.add(lblDataDeNascimento_1);
		
		JLabel lblDataDeNascimento_1_1 = new JLabel("Senha");
		lblDataDeNascimento_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNascimento_1_1.setBounds(73, 265, 170, 21);
		contentPane.add(lblDataDeNascimento_1_1);
		
		JLabel lblDataDeNascimento_1_1_1 = new JLabel("Repetir Senha");
		lblDataDeNascimento_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNascimento_1_1_1.setBounds(73, 323, 170, 21);
		contentPane.add(lblDataDeNascimento_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 286, 170, 26);
		contentPane.add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(73, 344, 170, 26);
		contentPane.add(passwordFieldRepeat);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente novoCliente = new Cliente(
						formattedTextFieldNome.getText(),
						formattedTextFieldCPF.getText(),
						String.valueOf(passwordField.getPassword()) ,
						formattedTextFieldEndereco.getText());
				System.out.println("Nome: " + novoCliente.getNome());
				System.out.println("CPF: " + novoCliente.getCpf());
				System.out.println("Endereco: " + novoCliente.getEndereco());
				System.out.println("Senha: " + novoCliente.getSenha());

			}
		});
		btnRegistrar.setBounds(73, 381, 88, 26);
		contentPane.add(btnRegistrar);
	}
}
