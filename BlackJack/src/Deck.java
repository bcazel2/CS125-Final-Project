import java.lang.Math;

public class Deck {
	public int[] deckArray;

	Deck() {
		this.deckArray = new int[52];
		for(int i = 0; i < deckArray.length; i++) {
			deckArray[i] = i+1;
		}
	}
	
	//Returns card value
	public int getRandomCard() {
		return (int) (Math.random()*52);
	}
	
	public int getCardValue(int value) {
		int cardValue = 0;
		
		while (value > 13) {
			value -= 13;
		}
		
		//Assume aces are 11 to begin with
		if (value == 1) 
			cardValue = 11;
		else if (value == 2)
			cardValue = 2;
		else if (value == 3)
			cardValue = 3;
		else if (value == 4)
			cardValue = 4;
		else if (value == 5)
			cardValue = 5;
		else if (value == 6)
			cardValue = 6;
		else if (value == 7)
			cardValue = 7;
		else if (value == 8)
			cardValue = 8;
		else if (value == 9)
			cardValue = 9;
		else if (value == 10)
			cardValue = 10;
		else if (value == 11)
			cardValue = 10;
		else if (value == 12)
			cardValue = 10;
		else if (value == 13)
			cardValue = 10;
		
		return cardValue;
	}
	
	public String getCardFaceValue(int value) {
		int suitCount = 1;
			//1-104 is Hearts
			//104-208 is Diamonds
			//209-312 is Clubs
			//313-416 is Spades
		String suit = "";
		String cardValue = "";
		
		while(value > 13) {
			value -= 13;
			suitCount++;
		}
				
		if (suitCount <= 8)
			suit = "Hearts";
		else if (suitCount <= 16)
			suit = "Diamonds";
		else if (suitCount <= 24)
			suit = "Clubs";
		else if (suitCount <= 32)
			suit = "Spades";
		
		if (value == 1) 
			cardValue = "Ace";
		else if (value == 2)
			cardValue = "Two";
		else if (value == 3)
			cardValue = "Three";
		else if (value == 4)
			cardValue = "Four";
		else if (value == 5)
			cardValue = "Five";
		else if (value == 6)
			cardValue = "Six";
		else if (value == 7)
			cardValue = "Seven";
		else if (value == 8)
			cardValue = "Eight";
		else if (value == 9)
			cardValue = "Nine";
		else if (value == 10)
			cardValue = "Ten";
		else if (value == 11)
			cardValue = "Jack";
		else if (value == 12)
			cardValue = "Queen";
		else if (value == 13)
			cardValue = "King";
				
		return cardValue + " of " + suit;
	
	}
}
