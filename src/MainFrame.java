import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MainFrame extends JFrame implements PanelChangeListener{

	private JPanel contentPane;
	private PanelChangeListener listener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new BlackJack(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	@Override
	public void changePanel(String panelName) {
		// TODO Auto-generated method stub
		JPanel newPanel = null;
		
		if(panelName.equals("BlackJack")){
			newPanel = new BlackJack(this);
		}
		 if (panelName.equals("RulesPanel")){
			newPanel = new RulesPanel(this);
		}
		//else if (panelName.equals("SomeOtherOtherPanel"){
		
		if(newPanel != null){
			setContentPane(newPanel);
			validate();
			
		}
	}

}
