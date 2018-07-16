package com.example.demo;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import javax.servlet.http.HttpServlet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebHandler;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends  ServletHttpHandlerAdapter {

	  private static  RouterFunction<ServerResponse> routingFunction() {
		  DemoHandler handler = new  DemoHandler();
		    return route(path("/demo/getpdf"), handler::getpdf);
		}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        this(WebHttpHandlerBuilder.webHandler((WebHandler) toHttpHandler(routingFunction()))
                .build());
        // TODO Auto-generated constructor stub
    }

    MainServlet(HttpHandler httpHandler) {
        super(httpHandler);
    }

}
