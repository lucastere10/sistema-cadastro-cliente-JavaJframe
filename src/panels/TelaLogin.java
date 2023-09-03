package panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SISTEMA DE CADASTRO");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(63, 38, 240, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("DEPOSITO SERRANO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(63, 11, 240, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(97, 97, 46, 14);
		contentPane.add(lblNewLabel);
		
		JFormattedTextField frmtdtxtfldLogin = new JFormattedTextField();
		frmtdtxtfldLogin.setToolTipText("Matrícula do Usuário");
		frmtdtxtfldLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmtdtxtfldLogin.setBounds(97, 115, 156, 33);
		contentPane.add(frmtdtxtfldLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(97, 174, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Senha do Usuário");
		passwordField.setBounds(97, 191, 156, 33);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("passwordField");
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(131, 249, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrar.setBounds(131, 283, 89, 23);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_3 = new JLabel("By: Lucas Caldas");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 357, 106, 23);
		contentPane.add(lblNewLabel_3);
	}
}
