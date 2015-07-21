/*
 * This software is produced by VIKAS M C Unauthorized redistribution, reproduction or usage of this
 * software in whole or in part without the express written consent of VIKAS M C is strictly prohibited.
 * Copyright @ 2015 VIKAS M C. ALL RIGHTS RESERVED.
 */

package com.game.functional;

import java.util.List;

import com.game.exception.GameException;
import com.game.service.Game;

/**
 * 
 * @author vikas.mc
 *
 */
public class GameImpl implements Game {

    public List<String> METADATA;

    public GameImpl(List<String> METADATA) {
        this.METADATA = METADATA;
    }

    /**
     * {@inheritDoc}
     * @throws GameException 
     */
    public int GetCount(String firstName, String secondName) throws GameException {
        int count = 0;
        int totalLength=0;
        int count2 = 0;
        char[] first;
        char[] second;
        if(firstName.isEmpty())throw new GameException("THE_FIRST_NAME_IS_EMPTY");
        if (secondName.isEmpty())throw new GameException("THE_SECOND_NAME_IS_EMPTY");
        first = firstName.toLowerCase().toCharArray();
        second = secondName.toLowerCase().toCharArray();
        totalLength = firstName.length() + secondName.length();
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    first[i] = ' ';
                    second[j] = ' ';
                }
            }
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] == ' ') {
                count++;
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (second[i] == ' ') {
                count2++;
            }
        }
        return totalLength - count - count2;
    }

    /**
     * {@inheritDoc}
     */
    public String GetChar(int number) {
        int k = 0;
        int sum = 0;
        while (true) {
            k = sum + (number % METADATA.size());
            if (k == 1 || k == METADATA.size()) {
                sum = 0;
            } else if (k == 0) {
                k = number;
            } else {
                sum = k - 1;
                if (k > 6) {
                    sum = (k % METADATA.size() - 1);
                }
            }
            if (k <= METADATA.size() && k != 0) {
                METADATA.remove(k - 1);
            } else {
                k = k % METADATA.size();
                if (k != 0)
                    METADATA.remove(k - 1);
                else
                    METADATA.remove(METADATA.size() - 1);
                if (k == 1)
                    sum = 0;
            }
            if (METADATA.size() == 1)
                break;
            k = 0;
        }
        return METADATA.get(0);
    }

}
