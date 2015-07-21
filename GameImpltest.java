/*
 * This software is produced by VIKAS M C Unauthorized redistribution, reproduction or usage of this
 * software in whole or in part without the express written consent of VIKAS M C is strictly prohibited.
 * Copyright @ 2015 VIKAS M C. ALL RIGHTS RESERVED.
 */

package com.game.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.game.exception.GameException;
import com.game.functional.GameImpl;
import com.game.service.Game;

/**
 * Class to test Game
 * 
 * @author vikas.mc
 *
 */
public class GameImpltest {

    public static Logger logger = LoggerFactory.getLogger(GameImpltest.class);

    String pattern = "Milliseconds since program start: %r %n";

    PatternLayout layout = new PatternLayout(pattern);

    ConsoleAppender appender = new ConsoleAppender(layout);

    private Game game;

    List<String> metadata;

    /**
     * Before the test case
     */
    @Before
    public void testGame() {
        prepareMetaData();
        MockitoAnnotations.initMocks(this);
        logger.debug("GameImpltest : In before ");
    }

    /**
     * Preparation of Data
     */
    private void prepareMetaData() {
        metadata = new ArrayList<String>();
        metadata.add("FRIENDS");
        metadata.add("LOVERS");
        metadata.add("AFFECTION");
        metadata.add("MARRIAGE");
        metadata.add("ENEMY");
        metadata.add("SISTER");
        game = new GameImpl(metadata);
    }

    @Test
    public void testgame() {
        Assert.assertNotNull(game);
    }

    /**
     * Positive Senarios
     * 
     * @throws GameException
     */
    @Test
    public void testsenario() throws GameException {
        System.out.println(game.GetChar(game.GetCount("ABCD", "WXYZ")));
    }

    /**
     * Test Game when First Name is empty expected THE_FIRST_NAME_IS_EMPTY
     * 
     * @throws GameException(THE_FIRST_NAME_IS_EMPTY)
     */
    @Test
    public void testNegativesenario() {
        try {
            game.GetChar(game.GetCount("", "WXYZ"));
        } catch (GameException e) {
            Assert.assertEquals("THE_FIRST_NAME_IS_EMPTY", e.getMessage());
            logger.error("THE_FIRST_NAME_IS_EMPTY");
        }

    }

    /**
     * Test Game when Second Name is empty expected THE_SECOND_NAME_IS_EMPTY
     * 
     * @throws GameException(THE_SECOND_NAME_IS_EMPTY)
     */
    @Test
    public void testNegativesenario2() {
        try {
            game.GetChar(game.GetCount("ABCD", ""));
        } catch (GameException e) {
            Assert.assertEquals("THE_SECOND_NAME_IS_EMPTY", e.getMessage());
            logger.error("THE_SECOND_NAME_IS_EMPTY");
        }
    }
}
