package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.Personnel;
import sdu.androidlab.isurvey.DataModel.PersonnelManager;

public class PersonnelFrame extends BaseFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = -443130469672678264L;
	private JButton btnadd;
	private JButton btndelete;
	private JScrollPane scrollPane;
	private JTable table;
	private PersonnelManager manager;
	
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
		scrollPane = new JScrollPane(table);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.SOUTH);
		
		btnadd = new JButton("\u6DFB\u52A0");
		btnadd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnadd.setFont(new Font("�����п�", Font.PLAIN, 16));
		panel.add(btnadd);
		
		btndelete = new JButton("\u5220\u9664");
		btndelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

			}
		});
		btndelete.setFont(new Font("�����п�", Font.PLAIN, 16));
		panel.add(btndelete);

	}
	
	/**
	 * @see sdu.androidlab.isurvey.UI.BaseFrame#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
	
		List<Data> list = manager.getPersonnel();
		if (list != null) {
			Object[][] objects = new Object[9][list.size()];
			int i = 0;
			Personnel personnel = null;
			for (Data data : list) {
				personnel = (Personnel) data;
				objects[0][i] = personnel.id;
				objects[1][i] = personnel.name;
				objects[2][i] = personnel.email;
				objects[3][i] = personnel.province;
				objects[4][i] = personnel.city;
				objects[5][i] = personnel.street;
				objects[6][i] = personnel.tell;
				objects[7][i] = personnel.salay;
				objects[8][i++] = personnel.administor_aid;
			}
			table.setModel(new DefaultTableModel(objects, new String[] { "id",
			        "\u540D\u5B57", "\u90AE\u7BB1", "\u7701\u4EFD",
			        "\u57CE\u5E02", "�ֵ�", "�绰", "����", "��������ԱId", }));
		}
	}

	/**
	 * @return the manager
	 */
	public PersonnelManager getManager() {
	
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(PersonnelManager manager) {
	
		this.manager = manager;
	}
}