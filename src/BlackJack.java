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
		Player dealer = new Player();
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
	
		JLabel lblBetPlaced = new JLabel("Bet Placed: $" + p1.getbetAmount());
		lblBetPlaced.setBounds(6, 261, 117, 16);
		add(lblBetPlaced);
		
		JLabel lblAmountBet = new JLabel("Balance: $" + p1.getBalance());
		lblAmountBet.setBounds(6, 289, 106, 16);
		add(lblAmountBet);
		
		textField = new JTextField();
		textField.setBounds(0, 329, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				number = Integer.parseInt(textField.getText());
				if(number <= p1.getBalance() && 0 <= p1.getbetAmount() && number >= 0){
					//betAmount += number;
					p1.changeBalance(-number);
					p1.changebetAmount(number);
					lblAmountBet.setText("Balance: $" + p1.getBalance());
					lblBetPlaced.setText("Bet Placed: $" + p1.getbetAmount());
					textField.setText("");
				}
			
			}
		});
		
		JLabel lblAmountBetting = new JLabel("Amount Betting:");
		lblAmountBetting.setBounds(6, 313, 106, 16);
		add(lblAmountBetting);
		
		JLabel lblDealerLabel = new JLabel("Dealer");
		lblDealerLabel.setBounds(218, 6, 61, 16);
		add(lblDealerLabel);
		
		JLabel lblPlayerLabel = new JLabel("Player");
		lblPlayerLabel.setBounds(218, 395, 61, 16);
		add(lblPlayerLabel);
		
		JLabel lbldeckImage = new JLabel("");
		lbldeckImage.setIcon(new ImageIcon("BlackCard.jpg"));
		lbldeckImage.setBounds(171, 155, 116, 80);
		add(lbldeckImage);
		
		JLabel lblPlayerTotal = new JLabel("");
		lblPlayerTotal.setBounds(206, 347, 61, 16);
		add(lblPlayerTotal);

		JLabel lblDealerTotal = new JLabel("");
		lblDealerTotal.setBounds(206, 64, 61, 16);
		add(lblDealerTotal);
		
		JButton btnHit = new JButton("Hit");
		btnHit.setBounds(6, 367, 117, 29);
		add(btnHit);
		btnHit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getTotalValueOfHand(p1) == 0 && getTotalValueOfHand(dealer) == 0){
					p1.addCard(d1.hit());
					p1.addCard(d1.hit());
					dealer.addCard(d1.hit());
					dealer.addCard(d1.hit());
					lblPlayerTotal.setText(" " + getTotalValueOfHand(p1));
					lblDealerTotal.setText("" + getTotalValueOfHand(dealer));
				}
				else if(getTotalValueOfHand(p1) <= 21 && getTotalValueOfHand(p1) > 0){ //We know they will both be greater than 0 after the first if statement
					if(d1.getAvCards().size() == 0){
						lbldeckImage.setVisible(false);
						//lblTotal.setText(" " + getTotalValueOfHand(p1));
						//validate();
					}
					if(canHit(dealer) == true){
						dealer.addCard(d1.hit());
					}
					lblPlayerTotal.setText(" " + getTotalValueOfHand(p1));
					lblDealerTotal.setText("" + getTotalValueOfHand(dealer));
				}
			}
		});
		
		
	}
	public static int getTotalValueOfHand(Player player){ //Adds up the total value of the player's hand
		int total = 0;
		for(int i = 0; i < player.getHand().size(); i++){
			total += player.getHand().get(i).getValue();
		}
		return total;
	}
		
	public static boolean canHit(Player player){
		if(getTotalValueOfHand(player) >= 17){
			return false;
		}
		return true;
	}
}
