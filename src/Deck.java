import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> avCards;
	private ArrayList<Card> disCards;
	private ArrayList<Card> drawnCards;
	public Deck(){
		avCards = new ArrayList<>();
		disCards = new ArrayList<>();
		initializeDeck();
		System.out.println(avCards);
		System.out.println(drawnCards);
		System.out.println(disCards);
		hit();
		System.out.println(avCards);
		System.out.println(drawnCards);
		System.out.println(disCards);	
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
		Card choosenCard = avCards.get(0);
		disCards.add(choosenCard);
		avCards.remove(choosenCard);
		drawnCards.add(choosenCard);
		return choosenCard;
		
	}
//	public int addUpValues(){
//		int total = 0;
//		for(int i = 0; i < drawnCards.size(); i++){
//			total += drawnCards[i].getValue();
//		}
//	}
	

	
}
