package com.api.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {

        LOGGER.info("Test Suite Started!!!");
    }

    public void onTestStart(ITestResult result) {

        LOGGER.info("Test Started!!" + result.getMethod().getMethodName());
        LOGGER.info("Description!!"+result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Passed!!" + result.getMethod().getMethodName());

    }

    public  void onTestFailure(ITestResult result) {
        LOGGER.error("Failure!!" + result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Skipped!!" + result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext context) {

        LOGGER.info("Test Suite Completed!!!");
    }
}
