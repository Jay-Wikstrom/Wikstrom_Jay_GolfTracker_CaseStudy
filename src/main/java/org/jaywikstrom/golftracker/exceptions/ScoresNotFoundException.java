package org.jaywikstrom.golftracker.exceptions;

/*
    This class is used to throw an exceptions if scores are not found
 */

public class ScoresNotFoundException extends Throwable{
    public ScoresNotFoundException(String message){
        super(message);
    }
}
