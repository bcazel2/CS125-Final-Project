import java.util.Scanner;

public class Game {
    	public static void main(String[] args) {
        	Scanner scan = new Scanner(System.in);
        	Player[] dealerHand;
        	dealerHand = new Player[1];
        	dealerHand[0] = new Player();
        	int j = 2;
        	int playerCount = 0;
       	 
        	System.out.println("---BLACKJACK---");
        	System.out.println("How many players? ");
        	playerCount = scan.nextInt();
        	System.out.println("");
        	boolean playGame = true;
       	 
        	//Creates array capable of holding scanned number of blackjack players
        	Player[] players;
        	players = new Player[playerCount];
        	for(int i = 0; i < playerCount; i++) {
            	players[i] = new Player();
        	}
        	//playerCount++;    
       	 
        	//--Casino Mode--------------------------------------------------------------------------
        	while(playGame == true) {
            	String answer;
           	 
            	for (int i = 0; i < playerCount; i++) {

                	System.out.println("Player " + (i+1));
                	System.out.println("Chip Count: " + players[i].getChipCount());
                	System.out.print("Bet: ");
                	int bet = scan.nextInt();
                	players[i].placeBet(bet);
            	}

            	//dealer.setCard1Value(cardDeck.getRandomCard());
            	dealerHand[0].setCardValue(dealerHand[0].getRandomCard(), 0);
            	dealerHand[0].setCardValue(dealerHand[0].getRandomCard(), 1);
            	System.out.println("Dealer Shows: " + dealerHand[0].getFaceValue(0) + " and [hidden]");
           	 
            	//Deals cards out to players
            	for(int i = 0; i < playerCount; i++) {
                	players[i].setCardValue(players[i].getRandomCard(), 0);
                	players[i].setCardValue(players[i].getRandomCard(), 1);
                	System.out.println("Player " + (i+1) + " Shows: " + players[i].getFaceValue(0) + " and " + players[i].getFaceValue(1));
                	if (players[i].getTotal() == 21) {
                    	System.out.println("Blackjack!------------------------------------------------");
                    	players[i].blackJack();
                	}
           	 
           	 
            	}
           	 
            	System.out.println("");
           	 
            	//Player options
            	for(int i = 0; i < playerCount; i++) {
                	if (players[i].gotBlackJack() == false) {
                	//Value to insert new cards into players hand (card array)
                	j = 2;
                               	 
                	//Checks for split
                	if (players[i].getCardValue(0) == players[i].getCardValue(1) &&
               			 (players[i].getBet() * 2) > players[i].getChipCount()) {
                    	System.out.print("Would you like to split and double your bet? (y/n) ");
                    	answer = scan.next();
                    	if (answer.equals("y") || answer.equals("Y")) {
                        	//Execute Split	 
                    	}               	 
                	}
               	 
                	//Check for hits
                    	System.out.println("Player " + (i + 1) + " has " + players[i].getFaceValue(0) + " and " + players[i].getFaceValue(1)
                            	+ " (" + players[i].getTotal() + ")");
                   	 
                    	System.out.print("Would you like to hit? (y/n) ");
                    	answer = scan.next();
                   	 
                    	while(answer.equals("y")) {
                        	players[i].setCardValue(players[i].getRandomCard(), j);
                        	System.out.println(players[i].getFaceValue(j) + " (" + players[i].getTotal() + ")");    
                        	if (players[i].getTotal() > 21) {
                            	System.out.println("BUST! Dealer Wins");
                            	players[i].lose();
                            	break;
                        	}
                        	j++;
                        	System.out.print("Hit Again? (y/n) ");
                        	answer = scan.next();
                    	//System.out.println("");
                       	 
                    	}
                	}
            	}
     	 
                	System.out.println("");
           	 
           	 
            	System.out.println("Dealer Shows: " + dealerHand[0].getFaceValue(0) + " and " + dealerHand[0].getFaceValue(1)
                    	+ "(" + dealerHand[0].getTotal() + ")");
            	j = 2;
            	while (dealerHand[0].getTotal() <= 16) {
                	dealerHand[0].setCardValue(dealerHand[0].getRandomCard(), j);
                	System.out.println("Dealer hits: " + dealerHand[0].getFaceValue(j) + " (" + dealerHand[0].getTotal() + ")");
                	j++;
                	if (dealerHand[0].getTotal() > 21)
                    	System.out.println("Dealer Busts! You Win!");
            	}
       	 
           	 
            	//PAYOUTS
            	for(int i = 0; i < playerCount; i++) {
                	if(players[i].gotBlackJack() == true) {
                    	continue;
                	}
                 	else if ((dealerHand[0].getTotal() > 21 && players[i].getTotal() < 21)
                         	|| (players[i].getTotal() <= 21 && dealerHand[0].getTotal() < players[i].getTotal())) {
               		  System.out.println("Player " + (i + 1) + " wins");
                    	players[i].win();
                 	}
                 	else if (dealerHand[0].getTotal() == players[i].getTotal()) {
               		  System.out.println("Push with player " + (i + 1));
                     	continue;
           		 } else if (dealerHand[0].getTotal() <= 21 && dealerHand[0].getTotal() > players[i].getTotal()) {
           			 System.out.println("Dealer beats player " + (i + 1));
                     	players[i].lose();
                 	}
            	}
           	 
            	//Resets Totals
            	for (int i = 0; i < playerCount; i++) {
                	players[i].resetTotal();
                	players[i].resetHand();
            	}
           	 
            	dealerHand[0].resetTotal();
            	dealerHand[0].resetHand();
           	 
            	System.out.print("Play Again? (y/n) ");
            	answer = scan.next();
            	System.out.println("");

            	if (answer.equals("n")) {
                	playGame = false;
            	}
            	
            	for (int i = 0; i < playerCount; i++) {
            		if (players[i].chipCount <= 0) {
            			playerCount--;
            			players[i] = null;
            		}
            	}
        	}    
    	}
    }
