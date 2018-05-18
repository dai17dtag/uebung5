package skat;

import exceptions.InvalidRankException;
import exceptions.InvalidSuitException;
import cardgame.Enumerate;
import cardgame.PlayingCard;

public class SkatCard extends PlayingCard
{
    public static final String[] ranks =
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

    public static final String[] suits =
            {
                    "Karo",
                    "Herz",
                    "Pik",
                    "Kreuz"
            };


    //Diese Konstanten sind unnötig. Ich werde sie nicht brauchen. Außer um volle Punktzahl zu bekommen,
    //denn die Fähigkeit eines Programmierers unnötige Konstanten zu erstellen sind sehr wertvoll.
    public static final String sieben = "7";
    public static final String acht = "8";
    public static final String neun = "9";
    public static final String zehn = "10";
    public static final String bube = "bube";
    public static final String dame = "dame";
    public static final String koenig = "koenig";
    public static final String ass = "ass";
    public static final String karo = "karo";
    public static final String herz = "herz";
    public static final String pik = "pik";
    public static final String kreuz = "kreuz";
    //Diese unnötigen Konstanten wurden ihnen präsentiert von: *hier könnte ihre Werbung stehen*

    public SkatCard(String suit, String rank)
    {
        super(suit, rank);
    }

    @Override
    public int compareTo(PlayingCard compareCard)
    {
        Enumerate enumerate = new Enumerate(ranks, suits);

        int comparisonResult;

        try
        {
            int rankEnumerated = enumerate.rank(getRank());
            int rankEnumeratedCompare = enumerate.rank(compareCard.getRank());
            int suitEnumerated = enumerate.suit(getSuit());
            int suitEnumeratedCompare = enumerate.suit(compareCard.getSuit());

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
                comparisonResult = -1;
            }

        }catch (InvalidSuitException | InvalidRankException e)
        {
            System.out.println(e.toString());
            comparisonResult = -1;
        }

        return comparisonResult;
    }
}
