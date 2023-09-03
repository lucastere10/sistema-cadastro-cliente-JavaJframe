package panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 545);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("New menu");
		menuBar.add(menu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(40, 227, 777, 235);
		contentPane.add(list);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setValue(1);
		slider.setMaximum(10);
		slider.setMinorTickSpacing(1);
		slider.setBounds(160, 134, 200, 26);
		contentPane.add(slider);
	}
}
