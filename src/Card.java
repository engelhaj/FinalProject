
public class Card {

	private String rank;
	private String suit;
	private int value;
	
	public Card(String rank, String suit){
		this.rank = rank;
		this.suit = suit;
		setValue();

	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	private void setValue(){
		switch(rank){
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "10":
			value = Integer.parseInt(rank);
			break;
		case "Jack":
		case "Queen":
		case "King":
			value = 10;
			break;
		case "Ace":
			value = 11;
		}
		
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + ", value=" + value + "]";
	}
	
	
	
}
