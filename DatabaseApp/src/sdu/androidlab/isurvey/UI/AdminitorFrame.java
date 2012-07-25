package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminitorFrame extends JInternalFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = -7229601890404021284L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			
				try {
					AdminitorFrame frame = new AdminitorFrame();
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
	public AdminitorFrame() {
	
		setTitle("\u7BA1\u7406\u5458\u4FE1\u606F");
		setClosable(true);

		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);

		setBounds(100, 100, 688, 247);
		
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("我的信息", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 77, 76, 115, 104, 129, 0 };
		gbl_panel.rowHeights = new int[] { 15, 29, 25, 25, 30, 29,
		        0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
		        Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		        Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		JLabel lblid = new JLabel("\u6211\u7684 Id\uFF1A");
		lblid.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.insets = new Insets(0, 0, 5, 5);
		gbc_lblid.anchor = GridBagConstraints.EAST;
		gbc_lblid.gridx = 1;
		gbc_lblid.gridy = 1;
		panel.add(lblid, gbc_lblid);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 1;
		panel.add(textField_6, gbc_textField_6);
		
		JLabel label = new JLabel("\u6211\u7684\u540D\u5B57\uFF1A");
		label.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u6211\u7684\u7535\u8BDD\uFF1A");
		label_6.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 2;
		panel.add(label_6, gbc_label_6);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel label_5 = new JLabel("\u6211\u7684\u5BC6\u7801\uFF1A");
		label_5.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 3;
		panel.add(label_5, gbc_label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 3;
		panel.add(textField_4, gbc_textField_4);
		
		JLabel label_3 = new JLabel("\u6211\u7684\u90E8\u95E8\uFF1A");
		label_3.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 3;
		panel.add(textField_3, gbc_textField_3);
		
		JLabel label_1 = new JLabel("\u6211\u7684\u5DE5\u8D44\uFF1A");
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 4;
		panel.add(label_1, gbc_label_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 4;
		panel.add(textField_5, gbc_textField_5);
		
		JLabel label_4 = new JLabel("\u6211\u7684\u804C\u4F4D\uFF1A");
		label_4.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 4;
		panel.add(label_4, gbc_label_4);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 5;
		panel.add(button, gbc_button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 5;
		panel.add(button_1, gbc_button_1);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("其他人", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null },
		        { null, null, null, null, null, null, null }, }, new String[] {
		        "Id", "\u540D\u79F0", "\u5BC6\u7801",
		        "\u6240\u5C5E\u90E8\u95E8", "\u804C\u4F4D", "\u5DE5\u8D44",
		        "\u7535\u8BDD" }));
		table.setFont(new Font("华文行楷", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
	}
}
