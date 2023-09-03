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
import javax.swing.text.MaskFormatter;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

public class TelaRegistro extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;

	//PROCURAR CEP
	String logradouro;      
	String bairro;
	String cidade;
	String uf;
	private JTextField jTxtBairro;
	private JTextField jTxtLogradouro;
	private JTextField jTxtCidade;
	private JTextField jTxtEstado;

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
	 * @throws ParseException 
	 */
	public TelaRegistro() throws ParseException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("NOVO COLABORADOR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(12, 12, 231, 33);
		contentPane.add(lblNewLabel_2);
		
		//MÁSCARAS
		MaskFormatter mascaraCpf= new MaskFormatter("###.###.###-##");
		MaskFormatter mascaraCep = new MaskFormatter("##.###-###");
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMessageDialog(null, "Usuário Cadastrado com Sucesso!");
			}
		});
		btnRegistrar.setBounds(490, 421, 88, 26);
		contentPane.add(btnRegistrar);
			
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 57, 264, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 25, 100, 21);
		panel.add(lblNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JFormattedTextField formattedTextFieldNome = new JFormattedTextField();
		formattedTextFieldNome.setBounds(12, 45, 233, 26);
		panel.add(formattedTextFieldNome);
		formattedTextFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JFormattedTextField formattedTextFieldCPF = new JFormattedTextField(mascaraCpf);
		formattedTextFieldCPF.setBounds(12, 103, 233, 26);
		panel.add(formattedTextFieldCPF);
		formattedTextFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 234, 233, 26);
		panel.add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(12, 292, 233, 26);
		panel.add(passwordFieldRepeat);
		
		JLabel lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setBounds(12, 271, 170, 21);
		panel.add(lblRepetirSenha);
		lblRepetirSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 213, 170, 21);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(12, 83, 170, 21);
		panel.add(lblCpf);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(12, 141, 100, 21);
		panel.add(lblEndereo);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JFormattedTextField formattedTextEmail = new JFormattedTextField();
		formattedTextEmail.setBounds(12, 161, 233, 26);
		panel.add(formattedTextEmail);
		formattedTextEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 199, 233, 2);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_1.setBounds(288, 57, 290, 352);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JFormattedTextField jTxtCep = new JFormattedTextField(mascaraCep);
		jTxtCep.setBounds(12, 48, 170, 26);
		panel_1.add(jTxtCep);
		jTxtCep.setText("");
		jTxtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCEP = new JLabel("Informe o CEP");
		lblCEP.setBounds(12, 28, 170, 21);
		panel_1.add(lblCEP);
		lblCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(194, 47, 81, 26);
		panel_1.add(btnBuscar);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(12, 121, 170, 21);
		panel_1.add(lblLogradouro);
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(12, 179, 170, 21);
		panel_1.add(lblBairro);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(12, 234, 170, 21);
		panel_1.add(lblCidade);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblUF = new JLabel("UF");
		lblUF.setBounds(223, 234, 52, 21);
		panel_1.add(lblUF);
		lblUF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JFormattedTextField formattedTextFieldNumero = new JFormattedTextField();
		formattedTextFieldNumero.setBounds(12, 314, 73, 26);
		panel_1.add(formattedTextFieldNumero);
		formattedTextFieldNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(12, 293, 170, 21);
		panel_1.add(lblNumero);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		jTxtBairro = new JTextField();
		jTxtBairro.setBounds(12, 197, 263, 26);
		panel_1.add(jTxtBairro);
		jTxtBairro.setEditable(false);
		jTxtBairro.setColumns(10);
		
		jTxtLogradouro = new JTextField();
		jTxtLogradouro.setBounds(12, 142, 263, 26);
		panel_1.add(jTxtLogradouro);
		jTxtLogradouro.setEditable(false);
		jTxtLogradouro.setColumns(10);
		
		jTxtCidade = new JTextField();
		jTxtCidade.setBounds(12, 255, 199, 26);
		panel_1.add(jTxtCidade);
		jTxtCidade.setEditable(false);
		jTxtCidade.setColumns(10);
		
		jTxtEstado = new JTextField();
		jTxtEstado.setBounds(223, 255, 52, 26);
		panel_1.add(jTxtEstado);
		jTxtEstado.setEditable(false);
		jTxtEstado.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Alterar Manualmente");
		chckbxNewCheckBox.setBounds(11, 99, 154, 24);
		panel_1.add(chckbxNewCheckBox);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object value = jTxtCep.getValue();
				String stringValue = "";
				if (value != null) {
				    stringValue = value.toString();
				    stringValue = stringValue.replaceAll("[^\\d-]|-(?=\\D)", "");
				}
				System.out.println(stringValue);
				buscarCep(stringValue);
			}
		});
	}
	
	//função para buscar cep
    public void buscarCep(String cep) 
    {
        String json;        
        
        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            logradouro = array[7];            
            bairro = array[15];
            cidade = array[19]; 
            uf = array[23];
            
            jTxtLogradouro.setText(logradouro);
            jTxtBairro.setText(bairro);
            jTxtCidade.setText(cidade);
            jTxtEstado.setText(uf);
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
			System.out.println(logradouro + " " + bairro + " " + cidade + " " + uf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
