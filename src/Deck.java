import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> avCards;
	private ArrayList<Card> disCards;
	public Deck(){
		avCards = new ArrayList<>();
		disCards = new ArrayList<>();
		initializeDeck();
		System.out.println("====Length When first made====");
		System.out.println(avCards.size());
		System.out.println(disCards.size());
		System.out.println("====Length After Drawing Card====");
		hit();
		System.out.println(avCards.size());
		System.out.println(disCards.size());
		System.out.println("====Length After Reset====");
		reset();
		System.out.println(avCards.size());
		System.out.println(disCards.size());
	}
	private void initializeDeck(){
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
		for(int i = 0; i < suits.length; i++){
			for(int j = 0; j < ranks.length; j++){
				avCards.add(new Card(ranks[j], suits[i]));
			}
		}
		Collections.shuffle(avCards);
	}
	public Card hit(){ //hit means to drawCard
		Card chosenCard = avCards.get(0);
		disCards.add(chosenCard);
		avCards.remove(chosenCard);
		return chosenCard;
		
	}
	public void reset(){
		for(int i = 0; i < disCards.size() ;i++){
			avCards.add(disCards.get(i));
		}
		disCards.clear();
		Collections.shuffle(avCards);
	}
	public ArrayList<Card> getAvCards() {
		return avCards;
	}
	public ArrayList<Card> getDisCards() {
		return disCards;
	}
	
	
	

	
}
