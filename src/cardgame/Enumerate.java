package cardgame;

import exceptions.InvalidRankException;
import exceptions.InvalidSuitException;

public class Enumerate
{
    String[] ranks;
    String[] suits;

    public Enumerate (String[] ranks, String[] suits)
    {
        this.ranks = ranks;
        this.suits = suits;
    }

    public int rank (String rank) throws InvalidRankException
    {
        int enumeratedRank = -1;

        for (int pos = 0; pos < ranks.length; pos++)
        {
            if (ranks[pos].matches(rank))
            {
                enumeratedRank = pos;
            }
        }

        if (enumeratedRank == -1)
        {
            throw new InvalidRankException("Rank is: " + rank + ", value not valid.");
        }

        return enumeratedRank;
    }

    public int suit (String suit) throws InvalidSuitException
    {
        int enumeratedSuit = -1;

        for (int pos = 0; pos < suits.length; pos++)
        {
            if (suits[pos].matches(suit))
            {
                enumeratedSuit = pos;
            }
        }

        if (enumeratedSuit == -1)
        {
            throw new InvalidSuitException("Suit is: " + suit + ", value not valid.");
        }

        return enumeratedSuit;
    }
}
