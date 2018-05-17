package Exceptions;

public class InvalidRankException extends Exception
{
    public InvalidRankException (String errorMessage)
    {
        super(errorMessage);
    }

    public InvalidRankException (Throwable error)
    {
        super(error);
    }

    public InvalidRankException (String errorMessage, Throwable error)
    {
        super(errorMessage, error);
    }
}
