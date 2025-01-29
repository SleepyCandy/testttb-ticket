package com.ttbtest.saleandservice.ticket.config;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Enumeration;

import static org.slf4j.LoggerFactory.*;

@Component
public class HeaderLoggingFilter implements Filter {

    private static final Logger logger = getLogger(HeaderLoggingFilter.class);

    @Override
    public void doFilter(jakarta.servlet.ServletRequest request,
                         jakarta.servlet.ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        logger.info("Incoming Headers:");

        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                logger.info("{}: {}", headerName, httpRequest.getHeader(headerName));
            }
        }

        chain.doFilter(request, response);
    }
}
