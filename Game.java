/*
 * This software is produced by VIKAS M C Unauthorized redistribution, reproduction or usage of this
 * software in whole or in part without the express written consent of VIKAS M C is strictly prohibited.
 * Copyright @ 2015 VIKAS M C. ALL RIGHTS RESERVED.
 */

package com.game.service;

import com.game.exception.GameException;

/**
 * 
 * @author vikas.mc
 *
 */
public interface Game {

    /**
     * @param a String
     * @param b String
     * @return int
     * @throws GameException 
     */
    int GetCount(String a, String b) throws GameException;

    /**
     * 
     * @param matadata List<String>
     * @param i int
     * @return String
     */
    String GetChar(int i);

}
