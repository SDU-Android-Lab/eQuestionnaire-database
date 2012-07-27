package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sdu.androidlab.isurvey.Data.Administor;
import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.DataModel.AdminitorManager;
import sdu.androidlab.isurvey.Database.SqlHelper;

public class AdminitorFrame extends BaseFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = -7229601890404021284L;
	private JTextField name;
	private JTextField post;
	private JTextField tell;
	private JTextField department;
	private JTextField password;
	private JTextField salary;
	private JTextField id;
	private JTable table;
	private JButton confirm;
	private AdminitorManager manager;
	
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
		gbl_panel.rowHeights = new int[] { 15, 29, 25, 25, 30, 29, 0 };
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
		
		id = new JTextField();
		id.setEditable(false);
		id.setColumns(10);
		GridBagConstraints gbc_id = new GridBagConstraints();
		gbc_id.insets = new Insets(0, 0, 5, 5);
		gbc_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_id.gridx = 2;
		gbc_id.gridy = 1;
		panel.add(id, gbc_id);
		
		JLabel label = new JLabel("\u6211\u7684\u540D\u5B57\uFF1A");
		label.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);
		
		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 2;
		gbc_name.gridy = 2;
		panel.add(name, gbc_name);
		name.setColumns(10);
		
		JLabel label_6 = new JLabel("\u6211\u7684\u7535\u8BDD\uFF1A");
		label_6.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 2;
		panel.add(label_6, gbc_label_6);
		
		tell = new JTextField();
		GridBagConstraints gbc_tell = new GridBagConstraints();
		gbc_tell.insets = new Insets(0, 0, 5, 0);
		gbc_tell.fill = GridBagConstraints.HORIZONTAL;
		gbc_tell.gridx = 4;
		gbc_tell.gridy = 2;
		panel.add(tell, gbc_tell);
		tell.setColumns(10);

		JLabel label_5 = new JLabel("\u6211\u7684\u5BC6\u7801\uFF1A");
		label_5.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 3;
		panel.add(label_5, gbc_label_5);
		
		password = new JTextField();
		password.setColumns(10);
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.gridx = 2;
		gbc_password.gridy = 3;
		panel.add(password, gbc_password);
		
		JLabel label_3 = new JLabel("\u6211\u7684\u90E8\u95E8\uFF1A");
		label_3.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		department = new JTextField();
		department.setEditable(false);
		department.setColumns(10);
		GridBagConstraints gbc_department = new GridBagConstraints();
		gbc_department.insets = new Insets(0, 0, 5, 0);
		gbc_department.fill = GridBagConstraints.HORIZONTAL;
		gbc_department.gridx = 4;
		gbc_department.gridy = 3;
		panel.add(department, gbc_department);
		
		JLabel label_1 = new JLabel("\u6211\u7684\u5DE5\u8D44\uFF1A");
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 4;
		panel.add(label_1, gbc_label_1);
		
		salary = new JTextField();
		salary.setEditable(false);
		salary.setColumns(10);
		GridBagConstraints gbc_salary = new GridBagConstraints();
		gbc_salary.insets = new Insets(0, 0, 5, 5);
		gbc_salary.fill = GridBagConstraints.HORIZONTAL;
		gbc_salary.gridx = 2;
		gbc_salary.gridy = 4;
		panel.add(salary, gbc_salary);
		
		JLabel label_4 = new JLabel("\u6211\u7684\u804C\u4F4D\uFF1A");
		label_4.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 4;
		panel.add(label_4, gbc_label_4);

		post = new JTextField();
		post.setEditable(false);
		post.setColumns(10);
		GridBagConstraints gbc_post = new GridBagConstraints();
		gbc_post.insets = new Insets(0, 0, 5, 0);
		gbc_post.fill = GridBagConstraints.HORIZONTAL;
		gbc_post.gridx = 4;
		gbc_post.gridy = 4;
		panel.add(post, gbc_post);
		
		confirm = new JButton("\u786E\u5B9A");
		confirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				int option = JOptionPane.showConfirmDialog(AdminitorFrame.this,
				        "您真的要修改吗");
				if (option == JOptionPane.OK_OPTION) {
					Administor administor = new Administor();
					administor.aname = name.getText();
					administor.apassword = password.getText();
					administor.atell = tell.getText();
					SqlHelper helper = new SqlHelper();
					helper.updata(manager.getSelf(), administor);
				} else {
					Administor self = manager.getSelf();
					name.setText(self.aname);
					tell.setText(self.atell);
					password.setText(self.apassword);
				}
			}
		});
		confirm.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.gridx = 4;
		gbc_confirm.gridy = 5;
		panel.add(confirm, gbc_confirm);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("其他人", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFont(new Font("华文行楷", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * @see sdu.androidlab.isurvey.UI.BaseFrame#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
	
		Administor self = manager.getSelf();
		List<Data> other = manager.getOther();

		if (self != null) {
			id.setText(self.aid.toString());
			name.setText(self.aname);
			department.setText(self.adepartment);
			password.setText(self.apassword);
			post.setText(self.apost);
			tell.setText(self.atell);
			
		}
		
		if (other != null) {
			Object[][] objects = new Object[5][other.size() - 1];
			int i = 0;
			for (Data data : other) {
				Administor ad = (Administor) data;
				if (ad.aid.intValue() != manager.getId().intValue()) {
					objects[0][i] = ad.aid;
					objects[1][i] = ad.aname;
					objects[2][i] = ad.adepartment;
					objects[3][i] = ad.apost;
					objects[4][i++] = ad.atell;
				}
			}
			table.setModel(new DefaultTableModel(objects, new String[] { "Id",
			        "\u540D\u79F0", "\u6240\u5C5E\u90E8\u95E8", "\u804C\u4F4D",
			        "\u7535\u8BDD" }));
		}
	}

	/**
	 * @return the manager
	 */
	public AdminitorManager getManager() {
	
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(AdminitorManager manager) {
	
		this.manager = manager;
	}
}
