package cardgame;

public abstract class PlayingCard
{
    protected final String suit;
    protected final String rank;

    public PlayingCard (String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public String getRank()
    {
        return rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public abstract int compareTo (PlayingCard compareCard);

    public String toString()
    {
        return suit + " " + rank;
    }
}
