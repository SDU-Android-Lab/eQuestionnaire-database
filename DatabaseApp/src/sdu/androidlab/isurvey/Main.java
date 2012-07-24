package sdu.androidlab.isurvey;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.skin.SubstanceNebulaLookAndFeel;

public class Main extends JFrame {
	
	/**
     * 
     */
	private static final long serialVersionUID = 7553840264354930341L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		
		try {
			UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
		} catch (Exception e) {
			System.out.println("Substance Raven Graphite failed to initialize");
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
			
				Main frame = new Main();
				frame.setVisible(true);
			}
		});

	}
	
	/**
	 * Create the frame.
	 */
	public Main() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
}
