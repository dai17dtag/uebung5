package main;

import cardgame.Enumerate;
import cardgame.PlayingCard;
import skat.SkatCard;
import skat.SkatGame;

public class Main
{
    public static void main(String[] args)
    {
        SkatGame test = new SkatGame();
        PlayingCard testcard = test.drawCard();
        System.out.println(test.getCount());
    }
}
