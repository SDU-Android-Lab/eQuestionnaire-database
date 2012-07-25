package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientFrame extends JInternalFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = 4468419334611984185L;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
	
		setTitle("\u5BA2\u6237\u4FE1\u606F");

		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);

		setBounds(100, 100, 485, 300);
		
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFont(new Font("�����п�", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(new Object[][] {
		        { null, null, null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null, null, null }, },
		        new String[] { "Id", "\u516C\u53F8\u540D", "\u5BC6\u7801",
		                "\u516C\u53F8\u9886\u57DF", "\u90AE\u7BB1",
		                "\u7701\u4EFD", "\u57CE\u5E02", "\u8857\u9053",
		                "\u8054\u7CFB\u7535\u8BDD" }));
		JScrollPane scrollPane = new JScrollPane(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u770B\u95EE\u5377");
		popupMenu.add(menuItem);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
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