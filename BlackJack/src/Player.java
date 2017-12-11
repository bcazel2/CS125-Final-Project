import java.lang.Math;

public class Player {
	public int chipCount;
	private int betSize;
	public int total;
	public boolean blackJack;
	public boolean hasAce;
	Deck cardDeck = new Deck();
	
	int randCount = 0;
	int[] array = new int[10];
	
	public Player() {
		this.chipCount = 1000;
		blackJack = false;
	}
	
	public void setChipCount(final int value) {
		this.chipCount = value;
	}
	
	public int getChipCount() {
		return this.chipCount;
	}
	
	public void placeBet(int bet) {
		this.betSize = bet;
	}
	
	public int getBet() {
		return this.betSize;
	}
	
	public int getRandomCard() {
		int rand = (int) (Math.random()*416 + 1);			
		return rand;
	}
	
	//Sets card value 1-52
	public void setCardValue(int value, int index) {
		this.array[index] = value;
		if (cardDeck.getCardValue(value) == 11) {
			this.hasAce = true;
		}	
	}
		
	public int getCardValue(int index) {
		return this.array[index];
	}
		
	public String getFaceValue(int index) {
		return cardDeck.getCardFaceValue(this.array[index]);
	}
	
	
	public int getNumericalValue(int value) {
		return cardDeck.getCardValue(value);
	}
	
	public void resetTotal() {
		this.total = 0;
	}
	
	public void resetHand() {
		for(int i = 0; i < this.array.length; i++) {
			this.array[i] = 0;
			this.blackJack = false;
		}
	}
	
	public int getTotal() {
		int total = 0;
		for (int i = 0; i < this.array.length; i++) {
			total += cardDeck.getCardValue(this.array[i]);
		}
		
		return total;

	}
	
	//If lose, subtract bet size
	public void lose() {
		this.chipCount -= this.getBet();
	}
	
	//If win, pay bet size
	public void win() {
		this.chipCount += this.getBet();
	}
	
	//If blackjack, pay 3 to 2
	public void blackJack() {
		this.chipCount = chipCount + (this.getBet() + this.getBet()/2);
		this.blackJack = true;
	}
	
	public boolean gotBlackJack() {
		return this.blackJack;
	}
}
