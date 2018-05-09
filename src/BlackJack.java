import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BlackJack extends JPanel{
	private PanelChangeListener listener;
	private JTextField textField;
	double number;
	double multiplier;
	/**
	 * Create the panel. 
	 */
	public BlackJack(PanelChangeListener listener){
		
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
		setLayout(null);
		add(btnHelp);
	
		JLabel lblBetPlaced = new JLabel("Bet Placed: $" + p1.getbetAmount());
		lblBetPlaced.setBounds(6, 261, 130, 16);
		add(lblBetPlaced);
		
		JLabel lblAmountBet = new JLabel("Balance: $" + p1.getBalance());
		lblAmountBet.setBounds(6, 284, 130, 16);
		add(lblAmountBet);
		
		textField = new JTextField();
		textField.setBounds(6, 318, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		textField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(textField.getText());
				if(number <= p1.getBalance() && 0 <= p1.getbetAmount() && number >= 0 && getTotalValueOfHand(p1) == 0){
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
		lblAmountBetting.setBounds(6, 304, 106, 16);
		add(lblAmountBetting);
		
		JLabel lblDealerLabel = new JLabel("Dealer");
		lblDealerLabel.setBounds(218, 6, 61, 16);
		add(lblDealerLabel);
		
		JLabel lblPlayerLabel = new JLabel("Player");
		lblPlayerLabel.setBounds(218, 395, 61, 16);
		add(lblPlayerLabel);
		
		JLabel lbldeckImage = new JLabel("");
		lbldeckImage.setBounds(171, 155, 116, 80);
		lbldeckImage.setIcon(new ImageIcon("BlackCard.jpg"));
		add(lbldeckImage);
		
		JLabel lblPlayerTotal = new JLabel("");
		lblPlayerTotal.setBounds(206, 353, 61, 16);
		add(lblPlayerTotal);

		JLabel lblDealerTotal = new JLabel("");
		lblDealerTotal.setBounds(206, 64, 61, 16);
		add(lblDealerTotal);

		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setBounds(6, 342, 117, 29);
		add(btnEndTurn);
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTotalValueOfHand(p1) > 0 && getTotalValueOfHand(dealer) > 0){	
					multiplier = whoWinsWhat(p1,dealer);
					number = number * multiplier;
					p1.changeBalance(number);
					p1.setbetAmount(0);
					lblAmountBet.setText("Balance: $" + p1.getBalance());
					lblBetPlaced.setText("Bet Placed: $" + p1.getbetAmount());
					p1.resetHand();
					dealer.resetHand();
					lblPlayerTotal.setText(" " + getTotalValueOfHand(p1));
					lblDealerTotal.setText("" + getTotalValueOfHand(dealer));
				}
			}
		});

		
		JLabel lblCardsLeft = new JLabel("Cards Left: " + d1.getAvCards().size());
		lblCardsLeft.setBounds(6, 169, 117, 16);
		add(lblCardsLeft);
		
		
		JButton btnHit = new JButton("Hit");
		btnHit.setBounds(6, 367, 117, 29);
		add(btnHit);
		btnHit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(d1.getAvCards().size() < 4){
					d1.reset();
				}
				else if(getTotalValueOfHand(p1) == 0 && getTotalValueOfHand(dealer) == 0){ //Deals two cards to the player's and dealer's hands
					p1.addCard(d1.hit());
					dealer.addCard(d1.hit());
					p1.addCard(d1.hit());
					dealer.addCard(d1.hit());
					lblPlayerTotal.setText(" " + getTotalValueOfHand(p1));
					lblDealerTotal.setText("" + /*dealer.getHand().get(0).getValue()*/ getTotalValueOfHand(dealer));
				}
				else if(getTotalValueOfHand(p1) < 21){ 
					p1.addCard(d1.hit());
				}
				else if(canHit(dealer) == true){
					dealer.addCard(d1.hit());
				}
				if(d1.getAvCards().size() == 0){
					lbldeckImage.setVisible(false);
				}
				lblPlayerTotal.setText(" " + getTotalValueOfHand(p1));
				lblDealerTotal.setText("" + /*dealer.getHand().get(0).getValue()*/ getTotalValueOfHand(dealer));
				lblCardsLeft.setText("Cards Left: " + d1.getAvCards().size());
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
		
	public static boolean canHit(Player player){//Checks specifically if the dealer can hit, he can not hit if on or above 17
		if(getTotalValueOfHand(player) >= 17){
			return false;
		}
		return true;
	}
	
	public static double whoWinsWhat(Player p1, Player p2){ //We are comparing the first player to the second player, returns a multiplier  of how much money the first player  will recieve
		if(getTotalValueOfHand(p1) > 21 || getTotalValueOfHand(p1) < getTotalValueOfHand(p2) && getTotalValueOfHand(p2) < 21){ //If p1's hand is less than the other player's hand or is over 21 
			return 0.0; //gets nothing back
		}
		if(getTotalValueOfHand(p1) > getTotalValueOfHand(p2) && getTotalValueOfHand(p1) < 21 ||
				getTotalValueOfHand(p2) > 21 && getTotalValueOfHand(p1) < 21){ //If p1's hand is greater than the other player's hand and is less than 21  
			return 2.0; //gets their money back and gets another set of it 
		}
		if(getTotalValueOfHand(p1) > getTotalValueOfHand(p2) && getTotalValueOfHand(p1) == 21 ||
				getTotalValueOfHand(p2) > 21 && getTotalValueOfHand(p1) == 21){//If p1's hand is greater than the other player's hand and is equal to 21
			return 2.5; //gets their money back and gets another set of it with an additional half of the amount as well
		}
		return 1.0;//If its a tie
	}
}
