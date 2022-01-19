package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        boolean boo = true;
        char ch = 'C';
        byte by = 127;
        short sh = 255;
        int i = 32000;
        long lo = 63;
        float fl = 38;
        double dou = 308;
        LOG.debug("primitives: "
                 + "boolean - {}, char - {}, byte - {},  short - {}, int - {}, long - {}, float - {}, double - {}",
                boo, ch, by, sh, i, lo, fl, dou);
    }
}
