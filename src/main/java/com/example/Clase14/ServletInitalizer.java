package com.example.Clase14;

import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitalizer extends SpringBootServletInitializer {

    @Override

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Clase14Application.class);
    }
}