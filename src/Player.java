import java.util.ArrayList;

public class Player {
	private double balance = 100;
	private ArrayList<Card> hand;
	private double betAmount = 0; 
	
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
	public void resetHand(){
		hand.clear();
	}
	public void addCard(Card card){
		hand.add(card);
	}
	public double getbetAmount(){
		return betAmount;
	}
	public double changebetAmount(double amount){
		betAmount = betAmount - (amount*-1);
		return betAmount;
	}
	public void setbetAmount(double betAmount){
		this.betAmount = betAmount;
	}
}
