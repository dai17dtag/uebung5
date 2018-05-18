package skat;

import cardgame.Deck;
import cardgame.PlayingCard;

public class SkatGame implements Deck
{
    public static final int cardsInGame = 32;
    public static final int playerCount = 3;
    public static final int cardsPerPlayer = 10;
    private int count;

    private PlayingCard[] cards = new SkatCard[cardsInGame];

    public SkatGame()
    {
        int stackPos = 0;

        for (int posA = 0; posA < SkatCard.suits.length; posA++)
        {
            for (int posB = 0; posB < SkatCard.ranks.length; posB++)
            {
                cards[stackPos] = new SkatCard(SkatCard.suits[posA], SkatCard.ranks[posB]);
                stackPos++;
            }
        }
        count = cardsInGame;
    }


    public PlayingCard[] getCards()
    {
        int cardsInStack = getCount();
        PlayingCard[] returnStack;

        if (cardsInStack > 0)
        {
            returnStack = new SkatCard[cardsInStack];

            for (int copyPos = 0; copyPos < cardsInStack; copyPos++)
            {
                returnStack[copyPos] = new SkatCard(cards[copyPos].getSuit(), cards[copyPos].getRank());
            }
        }
        else
        {
            returnStack = null;
        }

        return returnStack;
    }


    public int getCount()
    {
        return count;
    }


    public void addCard(PlayingCard card)
    {
        int cardCount = getCount();

        boolean validCard = true;

        for (int pos = 0; pos < cardCount; pos++)
        {
            if
                    (
                            card == null ||
                            (cards[pos].getRank() == card.getRank()
                            && cards[pos].getSuit() == card.getSuit())
                            || !(card instanceof SkatCard)
                    )
            {
                validCard = false;
                break;
            }
        }

        if (cardCount < cardsInGame && validCard)
        {
            cards[cardCount] = card;
            count++;
        }
    }


    public void insertCard(PlayingCard card, int position)
    {
        int cardCount = getCount();

        boolean validCard = true;

        for (int pos = 0; pos < cardCount; pos++)
        {
            if
                    (
                            card == null ||
                            (cards[pos].getRank() == card.getRank()
                            && cards[pos].getSuit() == card.getSuit())
                            || !(card instanceof SkatCard)
                    )
            {
                validCard = false;
                break;
            }
        }

        if (cardCount < 32 && validCard)
        {
            for (int pos = cardsInGame - 1; pos > position; pos--)
            {
                cards[pos] = cards[pos - 1];
            }

            cards[position] = card;
            count++;
        }
    }


    public PlayingCard drawCard()
    {
        PlayingCard drawnCard;
        int cardCount = getCount();
        if (cardCount > 0)
        {

            drawnCard = cards[cardCount - 1];
            cards[cardCount - 1] = null;
            count--;
        }
        else
        {
            drawnCard = null;
        }

        return drawnCard;
    }


    public void shuffleDeck()
    {
        if (cardsInGame > 0)
        {


            for (int i = 0; i < 5; i++)
            {
                for (int pos = 0; pos < cardsInGame; pos++)
                {
                    switchCards(pos, (int) (Math.random() * cardsInGame));
                }
            }
        }
    }


    public void sortDeck()
    {
        int cardsInStack = getCount();

        if (cardsInStack > 0)
        {
            boolean sorted = true;

            do
            {
                sorted = true;
                for (int pos = 1; pos < cardsInStack; pos++)
                {
                    if (cards[pos].compareTo(cards[pos - 1]) == -1)
                    {
                        switchCards(pos - 1, pos);
                        sorted = false;
                    }
                }
            } while (!sorted);
        }
    }


    public PlayingCard[][] dealCards(int players)
    {
        PlayingCard[][] returnDeck;

        if (playerCount != players)
        {
            returnDeck = null;
        }
        else
        {
            returnDeck = new PlayingCard[playerCount][cardsPerPlayer];

            for (int cardPos = 0; cardPos < cardsPerPlayer; cardPos++)
            {
                for (int playerPos = 0; playerPos < playerCount; playerPos++)
                {
                    returnDeck[playerPos][cardPos] = drawCard();
                }
            }
        }

        return returnDeck;
    }


    public void printDeck()
    {
        for (PlayingCard elem : cards)
        {
            if (elem != null)
            {
                System.out.println(elem.toString());
            }
        }
    }

    private void switchCards(int lowerPos, int upperPos)
    {
        PlayingCard temp = cards[lowerPos];
        cards[lowerPos] = cards[upperPos];
        cards[upperPos] = temp;
    }
}
