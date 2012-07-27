package sdu.androidlab.isurvey.UI;

import java.awt.BorderLayout;
import java.awt.Font;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sdu.androidlab.isurvey.Constant.DatabaseInfo;
import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Data.Problem;
import sdu.androidlab.isurvey.Data.Questionnaire;
import sdu.androidlab.isurvey.DataModel.QuestionnarieManager;


public class QuestionnaireFrame extends BaseFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = 6657390263404145175L;
	private JTable table;
	private QuestionnarieManager manager;
	private JComboBox<String> comboBox;
	private JLabel id;
	private JLabel simpleSize;
	private JLabel createData;
	private JLabel finishData;
	private JLabel template;
	private JLabel cost;
	private JLabel note;
	private JButton button;
	private Long cid;
	
	/**
	 * Create the frame.
	 */
	public QuestionnaireFrame(Long cid) {
	
		this.cid = cid;

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
		
		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
			
				int index = comboBox.getSelectedIndex();
				if (index >= 0) {
					Questionnaire ques = (Questionnaire) manager.getList().get(
					        index);
					setQuesInfo(ques);
					if (table.isShowing()) {
						manager.showProblem(ques.qid);
					}
				}
			}
		});
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
		
		id = new JLabel("");
		id.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_id = new GridBagConstraints();
		gbc_id.insets = new Insets(0, 0, 5, 5);
		gbc_id.gridx = 3;
		gbc_id.gridy = 0;
		panel.add(id, gbc_id);
		
		JLabel label = new JLabel("\u6837\u672C\u91CF\uFF1A");
		label.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		simpleSize = new JLabel("");
		simpleSize.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_simpleSize = new GridBagConstraints();
		gbc_simpleSize.insets = new Insets(0, 0, 5, 0);
		gbc_simpleSize.gridx = 5;
		gbc_simpleSize.gridy = 0;
		panel.add(simpleSize, gbc_simpleSize);
		
		JLabel label_5 = new JLabel("\u521B\u5EFA\u65E5\u671F\uFF1A");
		label_5.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 1;
		panel.add(label_5, gbc_label_5);
		
		createData = new JLabel("");
		createData.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_createData = new GridBagConstraints();
		gbc_createData.insets = new Insets(0, 0, 5, 5);
		gbc_createData.gridx = 1;
		gbc_createData.gridy = 1;
		panel.add(createData, gbc_createData);
		
		JLabel label_7 = new JLabel("\u5B8C\u6210\u65E5\u671F\uFF1A");
		label_7.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 2;
		gbc_label_7.gridy = 1;
		panel.add(label_7, gbc_label_7);
		
		finishData = new JLabel("");
		finishData.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_finishData = new GridBagConstraints();
		gbc_finishData.insets = new Insets(0, 0, 5, 5);
		gbc_finishData.gridx = 3;
		gbc_finishData.gridy = 1;
		panel.add(finishData, gbc_finishData);
		
		JLabel label_9 = new JLabel("\u6A21\u7248\u540D\u79F0\uFF1A");
		label_9.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 4;
		gbc_label_9.gridy = 1;
		panel.add(label_9, gbc_label_9);
		
		template = new JLabel("");
		template.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_template = new GridBagConstraints();
		gbc_template.insets = new Insets(0, 0, 5, 0);
		gbc_template.gridx = 5;
		gbc_template.gridy = 1;
		panel.add(template, gbc_template);
		
		JLabel label_11 = new JLabel("\u4EF7\u683C\uFF1A");
		label_11.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 0, 5);
		gbc_label_11.gridx = 0;
		gbc_label_11.gridy = 2;
		panel.add(label_11, gbc_label_11);
		
		cost = new JLabel("");
		cost.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_cost = new GridBagConstraints();
		gbc_cost.insets = new Insets(0, 0, 0, 5);
		gbc_cost.gridx = 1;
		gbc_cost.gridy = 2;
		panel.add(cost, gbc_cost);
		
		JLabel label_13 = new JLabel("\u5907\u6CE8\uFF1A");
		label_13.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 0, 5);
		gbc_label_13.gridx = 2;
		gbc_label_13.gridy = 2;
		panel.add(label_13, gbc_label_13);
		
		note = new JLabel("");
		note.setFont(new Font("华文行楷", Font.PLAIN, 18));
		GridBagConstraints gbc_note = new GridBagConstraints();
		gbc_note.insets = new Insets(0, 0, 0, 5);
		gbc_note.gridwidth = 2;
		gbc_note.gridx = 3;
		gbc_note.gridy = 2;
		panel.add(note, gbc_note);
		
		button = new JButton("\u67E5\u770B\u95EE\u9898");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (table.isShowing()) {
					button.setText("查看问题");
					table.setVisible(false);
				} else {
					button.setText("隐藏问题");
					table.setVisible(true);
				}
			}
		});
		button.setFont(new Font("华文行楷", Font.PLAIN, 16));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 5;
		gbc_button.gridy = 2;
		panel.add(button, gbc_button);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		manager = new QuestionnarieManager(this, cid);
		manager.initManager();
	}

	/**
	 * @see sdu.androidlab.isurvey.UI.BaseFrame#update(java.util.Observable,
	 *      java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		List<Data> list = manager.getList();
		if (list != null) {
			Questionnaire ques = null;
			for (Data data : list) {
				ques = (Questionnaire) data;
				if (ques.client == cid) {
					setQuesInfo(ques);
				}
				comboBox.addItem(ques.name);
			}
		}
		
		List<Data> pList = manager.getpManager().getList();
		if (pList != null) {
			Object[][] objects = new Object[5][pList.size()];
			Problem pro = null;
			int i = 0;
			for (Data data : pList) {
				pro = (Problem) data;
				objects[0][i] = pro.pid;
				switch (pro.type) {
					case DatabaseInfo.PRO_JD:
						objects[1][i] = DatabaseInfo.PRO_JDSTR;
						break;
					case DatabaseInfo.PRO_XZ:
						objects[1][i] = DatabaseInfo.PRO_XZSTR;
				}
				objects[2][i] = pro.content;
				objects[3][i] = pro.image;
				objects[4][i++] = pro.audio;
			}
			
			table.setModel(new DefaultTableModel(objects, new String[] { "Id",
			        "\u7C7B\u578B", "\u5185\u5BB9", "\u56FE\u7247\u8DEF\u5F84",
			        "\u97F3\u9891\u8DEF\u5F84" }));
		}

	}
	
	private void setQuesInfo(Questionnaire ques) {
	
		id.setText(ques.qid.toString());
		createData.setText(ques.createDate.toString());
		finishData.setText(ques.finishDate.toString());
		switch(ques.template){
			case DatabaseInfo.QUES_TEMPLATE1:
				template.setText(DatabaseInfo.QUES_TEMPLATESTR1);
				break;
			case DatabaseInfo.QUES_TEMPLATE2:
				template.setText(DatabaseInfo.QUES_TEMPLATESTR2);
				break;
			case DatabaseInfo.QUES_TEMPLATE3:
				template.setText(DatabaseInfo.QUES_TEMPLATESTR3);
		}
		simpleSize.setText(ques.sampleSize + " 份");
		cost.setText(ques.cost.toString() + " 元");
		note.setText(ques.note);
	}
	

	/**
	 * @return the manager
	 */
    public QuestionnarieManager getManager() {
    
	    return manager;
    }

	/**
     * @param manager the manager to set
     */
    public void setManager(QuestionnarieManager manager) {
    
	    this.manager = manager;
    }
	
}
