package com.vikasietum.controller;

import com.vikasietum.model.Menu;
import com.vikasietum.service.MenuService;
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
    public ResponseEntity<Menu> getMenu() throws IOException {

        return new ResponseEntity<>(menuService.getMenu(), HttpStatus.OK);
    }

}





