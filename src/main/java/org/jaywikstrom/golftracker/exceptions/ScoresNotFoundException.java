package org.jaywikstrom.golftracker.exceptions;

public class ScoresNotFoundException extends Throwable{
    public ScoresNotFoundException(String message){
        super(message);
    }
}
