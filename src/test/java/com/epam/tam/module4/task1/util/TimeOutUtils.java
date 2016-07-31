package com.epam.tam.module4.task1.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class TimeOutUtils {

    private static final Logger LOG = LogManager.getLogger(TimeOutUtils.class);

    public static void sleepInSeconds(int timeoutInSeconds) {
        LOG.info(String.format("Sleeping %s seconds...", timeoutInSeconds));
        Sleeper.sleepTightInSeconds(timeoutInSeconds);
    }

}
