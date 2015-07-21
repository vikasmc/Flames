/*
 * This software is produced by VIKAS M C Unauthorized redistribution, reproduction or usage of this
 * software in whole or in part without the express written consent of VIKAS M C is strictly prohibited.
 * Copyright @ 2015 VIKAS M C. ALL RIGHTS RESERVED.
 */

package com.game.exception;

/**
 * Custom Exception Class
 * @author vikas.mc
 *
 */
public class GameException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String message;
    
    /**
     * Constructor with no argument
     */
    public GameException() {
    }

    /**
     * Constructor with Message
     * @param message
     */
    public GameException(String message) {
        super(message);
        this.message=message;
    }

    /**
     * 
     */
    public String getMessage() {
        return message;
    }
    

}
