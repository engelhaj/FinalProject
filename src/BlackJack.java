import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlackJack extends JPanel{
	private PanelChangeListener listener;
	private JTextField textField;
	/**
	 * Create the panel. 
	 */
	public BlackJack(PanelChangeListener listener){
		setLayout(null);
		
		Player p1 = new Player();
		Deck d1 = new Deck();
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(6, 390, 117, 29);
		btnHelp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.changePanel("RulesPanel");
			}
			
		});
		add(btnHelp);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(6, 285, 61, 16);
		add(lblBalance);
	
		JLabel lblAmountBet = new JLabel("$" + p1.getBalance());
		lblAmountBet.setBounds(62, 285, 61, 16);
		add(lblAmountBet);
		
		textField = new JTextField();
		textField.setBounds(6, 329, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblAmountBetting = new JLabel("Amount Betting");
		lblAmountBetting.setBounds(17, 313, 106, 16);
		add(lblAmountBetting);
		
		JLabel lblNewLabel = new JLabel("Dealer");
		lblNewLabel.setBounds(218, 6, 61, 16);
		add(lblNewLabel);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(218, 395, 61, 16);
		add(lblPlayer);
		
	}
}
