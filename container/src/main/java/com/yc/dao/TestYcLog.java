package com.yc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestYcLog {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestYcLog.class);
        logger.info("yc业务类的日志(info)");
        logger.error("yc业务类的日志(error)");
    }
}
