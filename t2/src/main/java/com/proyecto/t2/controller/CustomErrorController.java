package com.proyecto.t2.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                // Manejar error 404
                return "/error/error-404";
            } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
                // Manejar error 401
                return "/error/error-401";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                // Manejar error 403
                //return "/error/error-403";
                return "/error/acceso_denegado";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                // Manejar error 500
                return "/error/error-500";
            }
        }
        //manejar otros error
        return "error";
    }


    @Override
    public String toString() {
        return "/error";
    }
    
}
