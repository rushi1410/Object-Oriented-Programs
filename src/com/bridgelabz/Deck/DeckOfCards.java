package com.bridgelabz.Deck;

import static com.bridgelabz.Deck.Main.*;

import java.util.Random;

public class DeckOfCards {
	String[] suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
	String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	String[] cards = new String[]{};

	public static int numberOfCardsToEach = 9;
	DeckOfCards(){
		for (String suit : suits) {
			for (String rank : ranks) {
				cards = addCardToDeck(cards, rank + " " + suit);
			}
		}
	}

	public static String[] addCardToDeck(String[] cardsArray, String newCard){
		String[] newCardsArray = new String[cardsArray.length + 1];
		if (cardsArray.length != 0) {
			System.arraycopy(cardsArray, 0, newCardsArray, 0, cardsArray.length);
			newCardsArray[cardsArray.length] = newCard;
		} else {
			newCardsArray[0] = newCard;
		}
		return newCardsArray;
	}


	void shuffleCards(String[] cardsArray){
		Random rand = new Random();
		for (int i = 0; i < cardsArray.length; i++) {
			int randomIndexToSwap = rand.nextInt(cardsArray.length);
			String temp = cardsArray[randomIndexToSwap];
			cardsArray[randomIndexToSwap] = cardsArray[i];
			cardsArray[i] = temp;
		}
	}

	public static void distributeCards(){
		int cardsIndex = 0;
		for(Player player: playersList){
			for (int i = 0; i < numberOfCardsToEach; i++) {
				player.cards = DeckOfCards.addCardToDeck(player.cards, deckOfCards.cards[cardsIndex]);
				cardsIndex++;
			}
		}
	}
	String[] sortPlayerCards(String[] cards){
		String[] sortedCardsArray = new String[cards.length];
		int cardIndex = 0;
		for (String rank : ranks) {
			for (String card : cards) {
				if (card.contains(rank)) {
					sortedCardsArray[cardIndex] = card;
					cardIndex++;
				}
			}
		}
		return sortedCardsArray;
	}
}
