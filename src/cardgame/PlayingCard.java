package cardgame;

import Exceptions.InvalidRankException;
import Exceptions.InvalidSuitException;

public abstract class PlayingCard
{
    public final String suit;
    public final String rank;

    public PlayingCard (String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public int compareTo (PlayingCard compareCard)
    {
        int comparisonResult;

        try
        {
            int rankEnumerated = Enumerate.rank(rank);
            int rankEnumeratedCompare = Enumerate.rank(compareCard.rank);
            int suitEnumerated = Enumerate.suit(suit);
            int suitEnumeratedCompare = Enumerate.suit(compareCard.suit);

            if (
                    rankEnumerated == rankEnumeratedCompare
                    && suitEnumerated == suitEnumeratedCompare
               )
            {
                comparisonResult = 0;
            }
            else if (
                    rankEnumerated > rankEnumeratedCompare
                    || suitEnumerated > suitEnumeratedCompare
                    )
            {
                comparisonResult = 1;
            }
            else
            {
                comparisonResult = 0;
            }

        }catch (InvalidSuitException | InvalidRankException e)
        {
            System.out.println(e.toString());
            comparisonResult = -1;
        }

        return comparisonResult;
    }

    public String toString()
    {
        return suit + " " + rank;
    }
}
