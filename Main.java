/**
 * Driver program that creates standard 52-card deck (as Card array)
 * and prints out each card in deck.
 *
 * @author Christopher Brinson-Allen
 * @version 1.0
 */

public class Main {

	/*
	 * ALGORITHM
	 *
	 * 1. Generate 52 card deck into Card array
	 * - instantiate card array of size 52
	 * - four each suit (4 kinds)
	 * - for each value (1 - 13, inclusive)
	 * -create a new card using current value and suit
	 * -add to array
	 * 2. Print deck (simple)
	 * - for each card in deck (52 cards)
	 * - if 13th card, print newline
	 * - print current card
	 *
	 */
	public static void main(String[] args) {
		/*** RUNNING TESTER ***/
		//uncomment line below to run CardTester:
		//CardTester.main(null);

		/*
		 * card testing portion
		 * Card test1 = new Card(1, Card.DIAMOND),
		 * test2 = new Card(5, Card.HEART),
		 * test3 = new Card(13, Card.CLUB),
		 * test4 = new Card(10, Card.SPADE);
		 * 
		 * 
		 * test1.getPrintCard();
		 * test2.getPrintCard();
		 * test3.getPrintCard();
		 * test4.getPrintCard();
		 */

		/*** DRIVER PROGRAM ***/
		//1. Generate 52 card deck into Card array
		Card[] deck = new Card[52];
		char[] suit = { Card.DIAMOND, Card.HEART, Card.SPADE, Card.CLUB };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				deck[i * 13 + j] = new Card(j + 1, suit[i]);
			}
		}
		// 2. Print deck
		/*
		 * Simple Print
		 * for (int i = 0; i < deck.length; i++) {
		 * if (i % 13 == 0 && i != 0) {
		 * System.out.println();
		 * }
		 * System.out.print(deck[i].getPrintCard());
		 * }
		 */

		// hackerchallenge
		for (int i = 0; i < deck.length; i += 13) { // row of 13 cards
			// get set of cards (row of size 13) and break each into parts based on newline
			// char (each card has 5 parts)
			String[][] cardRow = new String[13][5];

			for (int card = 0; card < cardRow.length; card++) {
				cardRow[card] = deck[i + card].getPrintCard().split("\n");
			}

			// loop through each of the parts for the row of cards
			for (int j = 0; j < 5; j++) {
				for (String[] card : cardRow) {
					System.out.print(card[j] + " ");
				}
				System.out.println();
			}
		}
	}
}