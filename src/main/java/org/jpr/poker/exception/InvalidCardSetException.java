package org.jpr.poker.exception;

/**
 * @author prabeenjayaraj
 * Exception that will be thrown when we find
 * and invalid card or card hand
 */
public class InvalidCardSetException extends Exception {

    public InvalidCardSetException(String message) {

        super(message);
    }


}
