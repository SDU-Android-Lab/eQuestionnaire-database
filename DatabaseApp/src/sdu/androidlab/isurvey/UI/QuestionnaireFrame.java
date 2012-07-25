package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class QuestionnaireFrame extends JInternalFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = 6657390263404145175L;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			
				try {
					QuestionnaireFrame frame = new QuestionnaireFrame();
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
	public QuestionnaireFrame() {
	
		setTitle("\u95EE\u5377");
	
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
	
		setBounds(100, 100, 789, 354);
		
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 81, 127, 76, 168, 0, 136, 0 };
		gbl_panel.rowHeights = new int[] { 47, 40, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		        Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		JLabel lblId = new JLabel("\u540D\u79F0\uFF1A");
		lblId.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblId_1 = new JLabel("Id\uFF1A");
		lblId_1.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_lblId_1 = new GridBagConstraints();
		gbc_lblId_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblId_1.gridx = 2;
		gbc_lblId_1.gridy = 0;
		panel.add(lblId_1, gbc_lblId_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 0;
		panel.add(label_3, gbc_label_3);
		
		JLabel label = new JLabel("\u6837\u672C\u91CF\uFF1A");
		label.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 5;
		gbc_label_4.gridy = 0;
		panel.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("\u521B\u5EFA\u65E5\u671F\uFF1A");
		label_5.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 1;
		panel.add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 1;
		panel.add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("\u5B8C\u6210\u65E5\u671F\uFF1A");
		label_7.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 2;
		gbc_label_7.gridy = 1;
		panel.add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 1;
		panel.add(label_8, gbc_label_8);
		
		JLabel label_9 = new JLabel("\u6A21\u7248\u540D\u79F0\uFF1A");
		label_9.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 4;
		gbc_label_9.gridy = 1;
		panel.add(label_9, gbc_label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 0);
		gbc_label_10.gridx = 5;
		gbc_label_10.gridy = 1;
		panel.add(label_10, gbc_label_10);
		
		JLabel label_11 = new JLabel("\u4EF7\u683C\uFF1A");
		label_11.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 0, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 2;
		panel.add(label_11, gbc_label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 0, 5);
		gbc_label_12.gridx = 1;
		gbc_label_12.gridy = 2;
		panel.add(label_12, gbc_label_12);
		
		JLabel label_13 = new JLabel("\u5907\u6CE8\uFF1A");
		label_13.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 0, 5);
		gbc_label_13.gridx = 2;
		gbc_label_13.gridy = 2;
		panel.add(label_13, gbc_label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 0, 5);
		gbc_label_14.gridwidth = 2;
		gbc_label_14.gridx = 3;
		gbc_label_14.gridy = 2;
		panel.add(label_14, gbc_label_14);
		
		JButton button = new JButton("\u67E5\u770B\u95EE\u9898");
		button.setFont(new Font("华文行楷", Font.PLAIN, 16));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 5;
		gbc_button.gridy = 2;
		panel.add(button, gbc_button);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {
		        { null, null, null, null, null },
		        { null, null, null, null, null },
		        { null, null, null, null, null },
		        { null, null, null, null, null },
		        { null, null, null, null, null },
		        { null, null, null, null, null },
		        { null, null, null, null, null }, }, new String[] { "Id",
		        "\u7C7B\u578B", "\u5185\u5BB9", "\u56FE\u7247\u8DEF\u5F84",
		        "\u97F3\u9891\u8DEF\u5F84" }));
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPanel.add(scrollPane, BorderLayout.CENTER);

	}
	
}
