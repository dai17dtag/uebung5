package exceptions;

public class CardStackException extends Exception
{
    public CardStackException (String errorMessage)
    {
        super(errorMessage);
    }

    public CardStackException (Throwable error)
    {
        super(error);
    }

    public CardStackException (String errorMessage, Throwable error)
    {
        super(errorMessage, error);
    }
}
