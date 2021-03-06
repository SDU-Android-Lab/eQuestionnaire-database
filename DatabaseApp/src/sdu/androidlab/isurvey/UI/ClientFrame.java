package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sdu.androidlab.isurvey.Data.Client;
import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.DataModel.ClientManager;

public class ClientFrame extends BaseFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = 4468419334611984185L;
	private JTable table;
	private ClientManager manager;
	
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
		JScrollPane scrollPane = new JScrollPane(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u770B\u95EE\u5377");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				int index = table.getSelectedRow();
				if(index>=0&&index<manager.getClient().size()){
					Client client = (Client) manager.getClient().get(index);
					if (client != null) {
						QuestionnaireFrame frame = UIFactory
								.getQuestionnaireFrame();
						frame.setCid(client.cid);
						frame.setVisible(true);
					}
				}
			}
		});
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

	/**
	 * @see sdu.androidlab.isurvey.UI.BaseFrame#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
	
		List<Data> list = manager.getClient();
		if(list!=null){
			Object[][] objects = new Object[list.size()][9];
			int i = 0;
			Client client = null;
			for (Data data : list) {
				client = (Client) data;
				objects[i][0] = client.cid;
				objects[i][1] = client.companyName;
				objects[i][2] = client.password;
				objects[i][3] = client.field;
				objects[i][4] = client.email;
				objects[i][5] = client.province;
				objects[i][6] = client.city;
				objects[i][7] = client.street;
				objects[i++][8] = client.phone;
			}
			table.setModel(new DefaultTableModel(objects,
			        new String[] { "Id", "\u516C\u53F8\u540D", "\u5BC6\u7801",
			                "\u516C\u53F8\u9886\u57DF", "\u90AE\u7BB1",
			                "\u7701\u4EFD", "\u57CE\u5E02", "\u8857\u9053",
			                "\u8054\u7CFB\u7535\u8BDD" }));
		}
	}
	
	/**
	 * @return the manager
	 */
    public ClientManager getManager() {
    
	    return manager;
    }

	/**
     * @param manager the manager to set
     */
    public void setManager(ClientManager manager) {
    
	    this.manager = manager;
    }
}
