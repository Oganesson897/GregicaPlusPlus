package me.oganesson.gregica.api;

import org.apache.logging.log4j.Logger;

public class GCLog {
    public static Logger logger;

    public GCLog() {
    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }
}
