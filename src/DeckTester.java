import java.util.ArrayList;
import java.util.Arrays;

public class DeckTester {

	public static void main(String[] args){
		Deck d1 = new Deck();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setBalance(50.00);
		p1.addCard(d1.hit());
		System.out.println("= = = = Player 1 Info = = = =");
		System.out.println(p1.getHand());
		//p1.changeBalance(-5);
		//System.out.println(p1.getBalance());
		//p1.changeBalance(10);
		//System.out.println(p1.getBalance());
		//System.out.println(d1.getAvCards().size());
		System.out.println("= = = = Player 2 Info = = = =");
		p2.addCard(d1.hit());
		p2.addCard(d1.hit());
		System.out.println(p2.getHand());
		//System.out.println(d1.getAvCards().size());
		//System.out.println(p2.getHand().get(0).getValue()); //Checks the value of the first card in p2's hand
		//System.out.println(getTotalValueOfHand(p2));
		System.out.println(canHit(p2));
		if(canHit(p2) == true){
			p2.addCard(d1.hit());
		}
		System.out.println(p2.getHand());
		System.out.println(whoWins(p1,p2));
	

	}
	
	public static int getTotalValueOfHand(Player player){ //Adds up the total value of the player's hand
		int total = 0;
		for(int i = 0; i < player.getHand().size(); i++){
			total += player.getHand().get(i).getValue();
		}
		return total;
	}
	
	public static String whoWins(Player p1, Player p2){
		if(getTotalValueOfHand(p1) > getTotalValueOfHand(p2) && getTotalValueOfHand(p1) <= 21 || getTotalValueOfHand(p2) > 21 && getTotalValueOfHand(p1) <= 21){
			return "Player 1 wins";
		}
		if(getTotalValueOfHand(p1) < getTotalValueOfHand(p2) && getTotalValueOfHand(p2) <= 21 || getTotalValueOfHand(p1) > 21 && getTotalValueOfHand(p2) <= 21){
			return "Player 2 wins";
		}
		return "tie";
	}
	
	public static boolean canHit(Player player){
		if(getTotalValueOfHand(player) >= 17){
			return false;
		}
		return true;
	}
}
