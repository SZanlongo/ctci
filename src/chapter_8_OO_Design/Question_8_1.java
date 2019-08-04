package chapter_8_OO_Design;

import java.util.ArrayList;

enum Suit {
    Spade(0), Heart(1), Diamond(2), Club(3);

    private int val;

    private Suit(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public Suit getSuitVal(int v) {
        switch (v) {
            case 0:
                return Suit.Spade;
            case 1:
                return Suit.Heart;
            case 2:
                return Suit.Diamond;
            case 3:
                return Suit.Club;
            default:
                return null;
        }
    }
}

//Design data structures for a generic deck of cards
//Assume 52-card set
public class Question_8_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}

class Deck<T extends Card> {
    private ArrayList<T> deck;
    private int index = 0;// index of next card to give

    public Deck() {

    }

    public void setDeck(ArrayList<T> deck) {
        this.deck = deck;
    }

    public Card getCard() {
        if (getLeft() <= 0) {
            return null;
        }
        T card = deck.get(index++);
        card.setUsed();
        return card;
    }

    // handout cards
    public Card[] handout(int n) {
        if (n > getLeft()) {
            return null;
        }
        // set of cards to give out
        Card[] give = (Card[]) new Card[n];
        for (int i = 0; i < n; i++) {
            Card card = getCard();
            if (card != null) {
                give[i] = card;
            }
        }
        return give;
    }

    // returns number of cards left
    public int getLeft() {
        return deck.size() - index;
    }

}

abstract class Card {
    protected Suit suit;
    // value of card A-1, (2-10), or J-11, Q-12, K-13
    protected int value;
    private boolean used = false;

    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    // depends on situation
    public abstract int getValue();

    // is card being used?
    public boolean inUse() {
        return used;
    }

    public void setUsed() {
        used = true;
    }

    public void setUnused() {
        used = false;
    }

    public String toString() {
        String out = "";
        String[] cardVal = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        out += cardVal[value - 1];
        String[] suitVal = {"S", "H", "D", "C"};
        out += suitVal[suit.getVal()];
        return out;
    }
}

class Hand<T extends Card> {
    protected ArrayList<T> hand = new ArrayList<T>();

    public void addCard(T card) {
        hand.add(card);
    }

    public boolean removeCard(T card) {
        return hand.remove(card);
    }
}