package org.jaywikstrom.golftracker.exceptions;

/*
    This class is used to throw an exceptions if ratings are not found
 */

public class RatingsNotFoundException  extends Throwable{
    public RatingsNotFoundException(String message){
        super(message);
    }
}
