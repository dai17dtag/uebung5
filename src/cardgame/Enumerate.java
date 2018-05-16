package cardgame;

import Exceptions.InvalidRankException;
import Exceptions.InvalidSuitException;

public class Enumerate
{
    private static final String[] ranks =
            {
                    "7",
                    "8",
                    "9",
                    "10",
                    "Bube",
                    "Dame",
                    "Koenig",
                    "Ass"
            };

    private static final String[] suits =
            {
                    "Karo",
                    "Herz",
                    "Pik",
                    "Kreuz"
            };

    public static int rank (String rank) throws InvalidRankException
    {
        int enumeratedRank = -1;

        for (int pos = 0; pos < ranks.length; pos++)
        {
            if (ranks[pos].contentEquals(rank))
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

    public static int suit (String suit) throws InvalidSuitException
    {
        int enumeratedSuit = -1;

        for (int pos = 0; pos < ranks.length; pos++)
        {
            if (ranks[pos].contentEquals(suit))
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
