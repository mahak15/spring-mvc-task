package com.mvc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController  extends AbstractController {
    private String message;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("HelloWorld");
        model.addObject("msg", "Hello World.");
        return model;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}