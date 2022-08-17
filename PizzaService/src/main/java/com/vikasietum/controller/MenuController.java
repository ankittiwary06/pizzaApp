package com.vikasietum.controller;

import com.vikasietum.exception.PizzasNotFoundException;
import com.vikasietum.exception.ToppingsNotFoundException;
import com.vikasietum.model.AppResponse;
import com.vikasietum.model.ErrorResponse;
import com.vikasietum.model.Menu;
import com.vikasietum.model.MenuResponse;
import com.vikasietum.service.MenuService;
import com.vikasietum.util.ErrorCodes;
import com.vikasietum.util.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
//@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public ResponseEntity<AppResponse> getMenu() {

        ResponseEntity<AppResponse> responseEntity;
        try {

            MenuResponse menuResponse= new MenuResponse();
            menuResponse.setMenu(menuService.getMenu());
            responseEntity= new ResponseEntity<>(menuResponse, HttpStatus.OK);
        }

        catch(PizzasNotFoundException exception){

            ErrorResponse errorResponse=new ErrorResponse();
            errorResponse.setCode(ErrorCodes.PIZZA_NOT_FOUND);
            errorResponse.setMessage(ErrorMessages.PIZZA_ERROR_MESSAGE);
            responseEntity= new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch(ToppingsNotFoundException exception)
        {
            ErrorResponse errorResponse=new ErrorResponse();
            errorResponse.setCode(ErrorCodes.TOPPING_NOT_FOUND);
            errorResponse.setMessage(ErrorMessages.TOPPINGS_ERROR_MESSAGE);
            responseEntity= new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        catch(Exception exception)
        {
            ErrorResponse errorResponse=new ErrorResponse();
            errorResponse.setCode(ErrorCodes.GENERIC_ERROR_CODE);
            errorResponse.setMessage(ErrorMessages.GENERIC_ERROR_MESSAGE);
            //TODO log the exception here
            responseEntity=new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}






