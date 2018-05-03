import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RulesPanel extends JPanel{
	
	private JPanel contentPane;
	private PanelChangeListener listener;
	/**
	 * Create the panel.
	 */
	public RulesPanel(PanelChangeListener listener) {
		setLayout(null);
		
		JLabel lblRules = new JLabel("Rules");
		lblRules.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblRules.setBounds(180, 6, 72, 31);
		add(lblRules);
		
		JLabel lblHowToWin = new JLabel("How to Win:");
		lblHowToWin.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHowToWin.setBounds(6, 43, 78, 16);
		add(lblHowToWin);
		
		JLabel lblGetSum = new JLabel("1. Get 21 with the sum of the cards");
		lblGetSum.setBounds(16, 73, 222, 16);
		add(lblGetSum);
		
		JLabel lblInYourHand = new JLabel("in your hand without going over.");
		lblInYourHand.setBounds(36, 101, 216, 16);
		add(lblInYourHand);
		
		JLabel lblGetA = new JLabel("2. Get a higher sum in your hand");
		lblGetA.setBounds(20, 129, 336, 16);
		add(lblGetA);
		
		JLabel lblThanTheDealer = new JLabel("than the Dealer.");
		lblThanTheDealer.setBounds(36, 153, 117, 16);
		add(lblThanTheDealer);
		
		JLabel lblRankings = new JLabel("Special Rankings:");
		lblRankings.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblRankings.setBounds(6, 181, 117, 16);
		add(lblRankings);
		
		JLabel lblRoyals = new JLabel("Royals = 10");
		lblRoyals.setBounds(36, 209, 95, 16);
		add(lblRoyals);
		
		JLabel lblAces = new JLabel("Aces = 11 or 1");
		lblAces.setBounds(36, 237, 126, 16);
		add(lblAces);
		
		JLabel lblBetting = new JLabel("Betting:");
		lblBetting.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblBetting.setBounds(6, 265, 117, 16);
		add(lblBetting);
		
		JLabel lblBlackjack = new JLabel("BlackJack = x1.5");
		lblBlackjack.setBounds(36, 293, 117, 16);
		add(lblBlackjack);
		
		JLabel lblWin = new JLabel("Win = x1.0");
		lblWin.setBounds(36, 321, 87, 16);
		add(lblWin);
		
		JLabel lblTie = new JLabel("Tie = x0.0");
		lblTie.setBounds(36, 349, 87, 16);
		add(lblTie);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 391, 117, 29);
		btnBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listener.changePanel("BlackJack");
			}
			
		});
		add(btnBack);
		
		JLabel lblYouCan = new JLabel("3. You can tie by having the ");
		lblYouCan.setBounds(263, 73, 201, 16);
		add(lblYouCan);
		
		JLabel lblSameSumAs = new JLabel("same sum as the Dealer. ");
		lblSameSumAs.setBounds(285, 101, 159, 16);
		add(lblSameSumAs);
		
		
	}
}
