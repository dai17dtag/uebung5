package cardgame;

import java.util.ArrayList;
import java.util.List;

public interface Deck
{
    List<PlayingCard> cards = new ArrayList<PlayingCard>();

    default PlayingCard[] getCards()
    {
        PlayingCard[] returnDeck = new PlayingCard[cards.size()];
        cards.toArray();

        for (int pos = 0; pos < returnDeck.length; pos++)
        {
            returnDeck[pos] = cards.get(pos);
        }

        return returnDeck;
    }

    default int getCount ()
    {
        return cards.size();
    }

    default void addCard (PlayingCard card)
    {
        cards.add(card);
    }

    default void insertCard (PlayingCard card, int pos)
    {
        cards.add(pos, card);
    }

    default PlayingCard drawCard ()
    {
        return cards.get(cards.size()-1);
    }

    default void shuffleDeck ()
    {
        List<PlayingCard> temp = new ArrayList<PlayingCard>(cards);
        cards.clear();

        while (temp.size() > 0)
        {
            int cardPos = (int) (Math.random() * temp.size());

            cards.add(temp.get(cardPos));
            temp.remove(cardPos);
        }
    }

    default void sortDeck ()
    {
        boolean sorted = true;

        do
        {
            for (int pos = 1; pos < cards.size(); pos++)
            {
                if (cards.get(pos).compareTo(cards.get(pos - 1)) != 1)
                {
                    PlayingCard temp = cards.get(pos);
                    cards.remove(pos); cards.add(pos, cards.get(pos -1));
                    cards.remove(pos - 1); cards.add(pos - 1, temp);
                }
            }
        }while (!sorted);
    }

    default PlayingCard[][] dealCards (int players)
    {
        PlayingCard[][] returnDeck = new PlayingCard[players][];

        int deckSizeUpper = cards.size() / players;
        int deckSizeLower = (cards.size() /players) - 1;
        int countLower = cards.size() % players;
        int cardsLeft = cards.size();

        for (int pos = players; pos > 0; pos--)
        {
            int handSize = pos > countLower ? deckSizeUpper : deckSizeLower;
            returnDeck[pos] = new PlayingCard[handSize];
        }

        int posInHand = 0;

        while (cardsLeft > 0)
        {
            for (int pos = 0; pos < players; pos++)
            {
                returnDeck[pos][posInHand] = cards.get(cardsLeft - 1);
                cardsLeft--;
            }

            posInHand++;
        }

        return returnDeck;
    }

    default void printDeck ()
    {
        for (int pos = cards.size(); pos > 0; pos++)
        {
            System.out.println(cards.get(pos).toString());
        }
    }

}
