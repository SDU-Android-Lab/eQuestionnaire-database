package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PersonnelFrame extends JInternalFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = -443130469672678264L;
	private JButton btnadd;
	private JButton btndelete;
	private JScrollPane scrollPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			
				try {
					PersonnelFrame frame = new PersonnelFrame();
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
	public PersonnelFrame() {
	
		setTitle("\u5458\u5DE5\u7BA1\u7406");

		setResizable(true);

		setMaximizable(true);
		setIconifiable(true);

		setClosable(true);

		setBounds(100, 100, 818, 227);
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
		        new Object[][] {
		                { null, null, null, null, null, null, null, null, null,
		                        null },
		                { null, null, null, null, null, null, null, null, null,
		                        null },
		                { null, null, null, null, null, null, null, null, null,
		                        null },
		                { null, null, null, null, null, null, null, null, null,
		                        null },
		                { null, null, null, null, null, null, null, null, null,
		                        null },
		                { null, null, null, null, null, null, null, null, null,
		                        null },
		                { null, null, null, null, null, null, null, null, null,
		                        null }, }, new String[] { "id", "\u540D\u5B57",
		                "\u5BC6\u7801", "\u90AE\u7BB1", "\u7701\u4EFD",
		                "\u57CE\u5E02", "街道", "电话", "工资", "所属管理员Id", }));
		scrollPane = new JScrollPane(table);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.SOUTH);
		
		btnadd = new JButton("\u6DFB\u52A0");
		btnadd.setFont(new Font("华文行楷", Font.PLAIN, 16));
		panel.add(btnadd);
		
		btndelete = new JButton("\u5220\u9664");
		btndelete.setFont(new Font("华文行楷", Font.PLAIN, 16));
		panel.add(btndelete);

	}
	
}