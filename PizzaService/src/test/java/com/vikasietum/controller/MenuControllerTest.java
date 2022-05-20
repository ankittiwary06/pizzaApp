package com.vikasietum.controller;

import com.vikasietum.model.Crust;
import com.vikasietum.model.Menu;
import com.vikasietum.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MenuControllerTest {
    @InjectMocks
    MenuController menuController = new MenuController();
    @Mock
    MenuService menuService;

    @Test
    public void getMenuTest() throws IOException {
        Menu menu = new Menu();
        List<Crust> crusts = new ArrayList<>();
        crusts.add(Crust.NEW_HAND_TOSSED);
        crusts.add(Crust.WHEAT_THIN_CRUST);
        menu.setCrusts(crusts);
        Mockito.when(menuService.getMenu()).thenReturn(menu);

        ResponseEntity<Menu> menuResponseEntity = menuController.getMenu();
        Menu menuResponse = menuResponseEntity.getBody();
        assert menuResponse.getCrusts().get(0) == menu.getCrusts().get(0);
        assert menuResponse.getCrusts().get(1) == menu.getCrusts().get(1);

    }
}
