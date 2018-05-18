package exceptions;

public class InvalidSuitException extends Exception
{
    public InvalidSuitException (String errorMessage)
    {
        super(errorMessage);
    }

    public InvalidSuitException (Throwable error)
    {
        super(error);
    }

    public InvalidSuitException (String errorMessage, Throwable error)
    {
        super(errorMessage, error);
    }
}
