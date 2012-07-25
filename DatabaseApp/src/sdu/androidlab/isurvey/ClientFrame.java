package sdu.androidlab.isurvey;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
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
		table.setFont(new Font("»ªÎÄÐÐ¿¬", Font.PLAIN, 18));
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
	}
	
}
