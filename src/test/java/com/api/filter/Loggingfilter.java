
package com.api.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.api.reporting.ExtentReportManager;
import com.aventstack.extentreports.Status;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class Loggingfilter implements Filter {

    private static final Logger logger = LogManager.getLogger(Loggingfilter.class);

  

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec); // Request is going to be executed
        logResponse(response);
       
        return response; // Test for assertion
    }

    public void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("BASE URI: " + requestSpec.getBaseUri());
        logger.info("Request Header: " + requestSpec.getHeaders());
        logger.info("Request Payload: " + requestSpec.getBody());


    }

    public void logResponse(Response response) {
        logger.info("STATUS CODE: " + response.getStatusCode());
        logger.info("Response Header: " + response.headers());
        logger.info("Response Body: " + response.getBody().prettyPrint());


    }
}
