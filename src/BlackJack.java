import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlackJack extends JPanel{
	private PanelChangeListener listener;
	private JTextField textField;
	double number;
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
		
		textField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				number = Integer.parseInt(textField.getText());
				if(number <= p1.getBalance()){
					//betAmount += number;
					p1.changeBalance(-number);
					lblAmountBet.setText("$" + p1.getBalance());
					textField.setText("");
				}
			
			}
		});
		
		JLabel lblAmountBetting = new JLabel("Amount Betting");
		lblAmountBetting.setBounds(17, 313, 106, 16);
		add(lblAmountBetting);
		
		JLabel lblNewLabel = new JLabel("Dealer");
		lblNewLabel.setBounds(218, 6, 61, 16);
		add(lblNewLabel);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(218, 395, 61, 16);
		add(lblPlayer);
		
		JLabel lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setIcon(new ImageIcon("BlackCard.jpg"));
		lblNewLabel_1.setBounds(171, 155, 116, 80);
		add(lblNewLabel_1);
		
		JLabel lblBetPlaced = new JLabel("Bet Placed:");
		lblBetPlaced.setBounds(120, 285, 73, 16);
		add(lblBetPlaced);
		
		JLabel lblNewLabel_2 = new JLabel("" + number);
		lblNewLabel_2.setBounds(198, 285, 61, 16);
		add(lblNewLabel_2);
		
		
	}
}
