package com.nallani.players;

/**
 * Thrown when a player encounters an unrecoverable error and can't continue playing.
 */
public class PlayException extends Exception {
    public PlayException(String message) {
        super(message);
    }

    public PlayException(String message, Throwable cause) {
        super(message, cause);
    }
}
