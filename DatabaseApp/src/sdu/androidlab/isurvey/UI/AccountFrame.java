package sdu.androidlab.isurvey.UI;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import sdu.androidlab.isurvey.Data.Administor;
import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.DataModel.Account;
import sdu.androidlab.isurvey.DataModel.AccountManager;
import sdu.androidlab.isurvey.DataModel.AdminitorManager;
import sdu.androidlab.isurvey.DataModel.ClientManager;
import sdu.androidlab.isurvey.DataModel.PersonnelManager;
import sdu.androidlab.isurvey.Database.SqlHelper;

public class AccountFrame extends BaseFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = -8241829828055577060L;
	private JPasswordField passwordField;
	private JButton button;
	private JCheckBox checkBox;
	private JComboBox<Integer> comboBox;
	private AccountManager manager;
	private boolean isSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			
				try {
					AccountFrame frame = new AccountFrame();
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
	public AccountFrame() {
	
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 380, 180);
		setTitle("\u5E10\u53F7\u8BBE\u7F6E");
		
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 114, 128, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 36, 30, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0,
		        Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
		        Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblid = new JLabel("\u60A8\u7684 Id\uFF1A");
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.insets = new Insets(0, 0, 5, 5);
		gbc_lblid.gridx = 0;
		gbc_lblid.gridy = 1;
		contentPanel.add(lblid, gbc_lblid);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setEditable(true);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			
				int position = comboBox.getSelectedIndex();
				if (position >= 0) {
					passwordField.setText(manager.getPassword(position));
				}
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		contentPanel.add(comboBox, gbc_comboBox);

		JLabel label = new JLabel("\u60A8\u7684\u5BC6\u7801\uFF1A");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		contentPanel.add(label, gbc_label);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		contentPanel.add(passwordField, gbc_passwordField);
		
		button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				final Integer id = comboBox.getItemAt(comboBox
				        .getSelectedIndex());
				String password = passwordField.getPassword().toString();
				
				Data data = new Administor(id, password);
				if (data.isExist(new SqlHelper())) {

					AdminitorManager adm = new AdminitorManager(UIFactory
					        .getAdminitorFrame(), id);
					adm.initAdminitors();
					UIFactory.getAdminitorFrame().setManager(adm);
					UIFactory.getAdminitorFrame().setVisible(true);

					PersonnelManager psm = new PersonnelManager(UIFactory
					        .getPersonnelFrame());
					psm.initManager();
					UIFactory.getPersonnelFrame().setManager(psm);
					UIFactory.getPersonnelFrame().setVisible(true);
					
					ClientManager cm = new ClientManager(UIFactory
					        .getPersonnelFrame());
					psm.initManager();
					UIFactory.getClientFrame().setManager(cm);
					UIFactory.getClientFrame().setVisible(true);

					JOptionPane.showConfirmDialog(AccountFrame.this, "µÇÂ¼³É¹¦");
					if (isSave) {
						manager.addAccount(id, password);
						manager.saveAllAccount();
					}
				} else {
					JOptionPane.showConfirmDialog(AccountFrame.this,
					        "id »ò ÃÜÂë´íÎó");
				}
			}
		});
		
		checkBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		checkBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if (checkBox.isSelected())
					isSave = true;
				else
					isSave = false;
			}
		});
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 3;
		contentPanel.add(checkBox, gbc_checkBox);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 3;
		contentPanel.add(button, gbc_button);
		
		manager = new AccountManager(this);
		manager.initAllAccount();
	}
	
	/**
	 * @see sdu.androidlab.isurvey.UI.BaseFrame#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
	
		List<Account> list = manager.getAllAccounts();
		if (list != null) {
			for (Account account : list) {
				comboBox.addItem(account.getAccount());
			}
		}
	}
}
