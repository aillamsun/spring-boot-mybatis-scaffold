package com.scaffold.example.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by sungang on 2017/8/19.
 */
@Component
public class ServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(
                new ErrorPage(HttpStatus.BAD_REQUEST, "/error/notfound"),
                new ErrorPage(HttpStatus.NOT_FOUND, "/error/notfound")
        );
        container.addInitializers();
    }
}
