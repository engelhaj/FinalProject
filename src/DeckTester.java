import java.util.ArrayList;
import java.util.Arrays;

public class DeckTester {

	public static void main(String[] args){
		Deck d1 = new Deck();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setBalance(50.00);
		p1.addCard(d1.drawCard());
		System.out.println("====Player 1 Info====");
		System.out.println(p1.getHand());
		p1.changeBalance(-5);
		System.out.println(p1.getBalance());
		p1.changeBalance(10);
		System.out.println(p1.getBalance());
		System.out.println(d1.getAvCards().size());
		System.out.println("====Player 2 Info====");
		p2.addCard(d1.drawCard());
		p2.addCard(d1.drawCard());
		System.out.println(d1.getAvCards().size());

	}
	
	public int getTotalValueOfHand(Player p1){
		int total = 0;
		for(int i = 0; i < p1.getHand().size(); i++){
			total += p1.getHand().get(i).getValue(i);
		}
		return total;
	}
}
