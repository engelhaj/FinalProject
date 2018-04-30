import java.util.ArrayList;

public class Player {
	private double balance = 500;
	private ArrayList<Card> hand;
	
	public Player(){
		hand = new ArrayList<>();
	}
	
	public double getBalance() {
		return balance;
	}
	public double changeBalance(double amount){
		balance = balance - (amount*-1);
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public void addCard(Card card){
		hand.add(card);
	}
}
