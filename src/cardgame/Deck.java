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
        //TO-DO
    }

    default PlayingCard[][] dealCards (int players)
    {
        //TO-DO
    }

    default void printDeck ()
    {
        for (int pos = cards.size(); pos > 0; pos++)
        {
            System.out.println(cards.get(pos).toString());
        }
    }

}
