package sdu.androidlab.isurvey;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.skin.SubstanceNebulaLookAndFeel;


public class Main extends JFrame {
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
		} catch (Exception e) {
			System.out.println("Substance Raven Graphite failed to initialize");
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
			
				Main frame = new Main();
				frame.setVisible(true);
			}
		});

	}
	
	/**
	 * Create the frame.
	 */
	public Main() {
	
		setTitle("isurvery-\u7535\u5B50\u8C03\u67E5\u95EE\u5377\u7CFB\u7EDF");
		// getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 973, 751);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6253\u5F00");
		mnNewMenu.setFont(new Font("华文行楷", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("\u5E10\u53F7\u8BBE\u7F6E");
		menu.setFont(new Font("华文行楷", Font.PLAIN, 16));
		mnNewMenu.add(menu);
		
		JMenu menu_1 = new JMenu("\u7BA1\u7406\u5458\u4FE1\u606F");
		menu_1.setFont(new Font("华文行楷", Font.PLAIN, 16));
		mnNewMenu.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u5458\u5DE5\u7BA1\u7406");
		menu_2.setFont(new Font("华文行楷", Font.PLAIN, 16));
		mnNewMenu.add(menu_2);
		
		JMenu menu_3 = new JMenu("\u5BA2\u6237\u4FE1\u606F");
		menu_3.setFont(new Font("华文行楷", Font.PLAIN, 16));
		mnNewMenu.add(menu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		AccountFrame accountFrame = new AccountFrame();
		accountFrame.setVisible(true);
		accountFrame.setBounds(10, 10, 332, 189);
		desktopPane.add(accountFrame);
		
		PersonnelFrame personnelFrame = new PersonnelFrame();
		personnelFrame.setVisible(true);
		personnelFrame.setBounds(10, 449, 793, 201);
		desktopPane.add(personnelFrame);
		
		AdminitorFrame adminitorFrame = new AdminitorFrame();
		adminitorFrame.setVisible(true);
		adminitorFrame.setBounds(351, 10, 492, 348);
		desktopPane.add(adminitorFrame);
		
		ClientFrame clientFrame = new ClientFrame();
		clientFrame.setVisible(true);
		clientFrame.setBounds(10, 219, 332, 222);
		desktopPane.add(clientFrame);
	}
}