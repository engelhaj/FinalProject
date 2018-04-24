import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class RulesPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RulesPanel() {
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
		
		JLabel lblRankings = new JLabel("Rankings:");
		lblRankings.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblRankings.setBounds(6, 181, 78, 16);
		add(lblRankings);

	}
}
