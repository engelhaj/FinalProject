import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BlackJack extends JPanel{
	private PanelChangeListener listener;
	/**
	 * Create the panel.
	 */
	public BlackJack(PanelChangeListener listener) {
		setLayout(null);
		
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
		
		JLabel lblAmountBet = new JLabel();
		lblAmountBet.setBounds(62, 285, 61, 16);
		add(lblAmountBet);

	}
}
