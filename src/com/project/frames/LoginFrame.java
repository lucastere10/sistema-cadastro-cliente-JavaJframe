package com.project.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.project.connect.ClassConnection;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private static ClassConnection conn;
	private static String schema;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame(conn, schema);
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
	public LoginFrame(ClassConnection con, String schema) {
		this.conn = con;
		this.schema = schema;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginTitle = new JLabel("Login");
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginTitle.setBounds(114, 43, 87, 40);
		contentPane.add(lblLoginTitle);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(51, 187, 214, 30);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Submit");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(109, 244, 105, 30);
		contentPane.add(btnLogin);
		
		JFormattedTextField loginField = new JFormattedTextField();
		loginField.setBounds(51, 120, 214, 30);
		contentPane.add(loginField);
		
		JButton btnRegister = new JButton("Register\r\n");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(109, 285, 105, 30);
		contentPane.add(btnRegister);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(51, 104, 70, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(51, 172, 70, 14);
		contentPane.add(lblPassword);
	}
}
