package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;



public class Main extends JFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = 3773402147281722185L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		// JFrame.setDefaultLookAndFeelDecorated(true);
		// JDialog.setDefaultLookAndFeelDecorated(true);
		//
		// try {
		// UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
		// } catch (Exception e) {
		// System.out.println("Substance Raven Graphite failed to initialize");
		// }
		
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
		
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		mnNewMenu.setFont(new Font("�����п�", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenu mnexcel = new JMenu("\u5BFC\u5165Excel");
		mnexcel.setFont(new Font("�����п�", Font.PLAIN, 18));
		mnNewMenu.add(mnexcel);
		
		JMenuItem menuItem = new JMenuItem("\u5458\u5DE5");
		menuItem.setFont(new Font("�����п�", Font.PLAIN, 18));
		mnexcel.add(menuItem);

		JMenu mnexcel_1 = new JMenu("\u5BFC\u51FAExcel");
		mnexcel_1.setFont(new Font("�����п�", Font.PLAIN, 18));
		mnNewMenu.add(mnexcel_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5458\u5DE5");
		menuItem_1.setFont(new Font("�����п�", Font.PLAIN, 18));
		mnexcel_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5BA2\u6237");
		menuItem_2.setFont(new Font("�����п�", Font.PLAIN, 18));
		mnexcel_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u7528\u6237");
		menuItem_3.setFont(new Font("�����п�", Font.PLAIN, 18));
		mnexcel_1.add(menuItem_3);

		JMenu menu = new JMenu("\u6253\u5F00\u7A97\u53E3");
		menu.setFont(new Font("�����п�", Font.PLAIN, 18));
		menuBar.add(menu);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5E10\u53F7\u8BBE\u7F6E");
		menuItem_4.setSelected(true);
		menuItem_4.setFont(new Font("�����п�", Font.PLAIN, 18));
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u7BA1\u7406\u5458\u4FE1\u606F");
		menuItem_5.setFont(new Font("�����п�", Font.PLAIN, 18));
		menu.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5458\u5DE5\u7BA1\u7406");
		menuItem_6.setFont(new Font("�����п�", Font.PLAIN, 18));
		menu.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u5BA2\u6237\u4FE1\u606F");
		menuItem_7.setFont(new Font("�����п�", Font.PLAIN, 18));
		menu.add(menuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		AccountFrame accountFrame = UIFactory.getAccountFrame();
		accountFrame.setVisible(true);
		accountFrame.setBounds(10, 10, 332, 189);
		desktopPane.add(accountFrame);
		
		PersonnelFrame personnelFrame = UIFactory.getPersonnelFrame();
		// personnelFrame.setVisible(true);
		personnelFrame.setBounds(10, 262, 927, 201);
		desktopPane.add(personnelFrame);
		
		AdministartorFrame adminitorFrame = UIFactory.getAdminitorFrame();
		// adminitorFrame.setVisible(true);
		adminitorFrame.setBounds(364, 10, 573, 242);
		desktopPane.add(adminitorFrame);
		
		ClientFrame clientFrame = UIFactory.getClientFrame();
		// clientFrame.setVisible(true);
		clientFrame.setBounds(10, 473, 927, 189);
		desktopPane.add(clientFrame);

		QuestionnaireFrame questionnaireFrame = UIFactory
				.getQuestionnaireFrame();
		// questionnaireFrame.setVisible(true);
		questionnaireFrame.setBounds(10, 197, 732, 147);
		desktopPane.add(questionnaireFrame);
	}
}