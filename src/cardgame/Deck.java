package cardgame;

import java.util.ArrayList;
import java.util.List;

import exceptions.CardStackException;
import skat.SkatCard;

public interface Deck
{
    PlayingCard[] getCards();
    int getCount();
    void addCard(PlayingCard card);
    void insertCard(PlayingCard card, int position);
    PlayingCard drawCard();
    void shuffleDeck();
    void sortDeck();
    PlayingCard[][] dealCards(int players);
    void printDeck();
}
