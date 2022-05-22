package com.vikasietum.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikasietum.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Value("${menu.pizza.path}")
    private String pizzaFilePath;
    @Value("${menu.topping.path}")
    private String toppingFilePath;

    @Value("${menu.sideitem.path}")
    private String sideItemFilePath;

    public List<Pizza> getPizzas() throws IOException {
        Path fileName
                = Path.of(pizzaFilePath);
        String pizzaString = Files.readString(fileName);
        List<Pizza> pizzas = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            pizzas = mapper.readValue(Paths.get(pizzaFilePath).toFile(), new TypeReference<List<Pizza>>(){});
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pizzas;
    }

    public List<Topping> getToppings() throws IOException {
        List<Topping> toppings = null;
        Path fileName
                = Path.of(toppingFilePath);
        String toppingString = Files.readString(fileName);
        try {
            ObjectMapper mapper = new ObjectMapper();
            toppings = mapper.readValue(toppingString, new TypeReference<List<Topping>>() {
            });
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toppings;
    }

    public List<Crust> getCrusts() {
        List<Crust> crusts = new ArrayList<Crust>();
        crusts.add(Crust.NEW_HAND_TOSSED);
        crusts.add(Crust.CHEESE_BURST);
        crusts.add(Crust.WHEAT_THIN_CRUST);
        crusts.add(Crust.FRESH_PAN_PIZZA);
        return crusts;
    }

    public List<SideItem> getSideItems() throws IOException {
        List<SideItem> sideItems = null;
        Path fileName
                = Path.of(sideItemFilePath);
        String sideItemString = Files.readString(fileName);
        try {
            ObjectMapper mapper = new ObjectMapper();
            sideItems = mapper.readValue(sideItemString, new TypeReference<List<SideItem>>(){});
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sideItems;

    }

    public Menu getMenu() throws IOException {
        Menu menu = new Menu();

        menu.setPizzas(getPizzas());
        menu.setToppings(getToppings());
        menu.setSideItems(getSideItems());
        menu.setCrusts(getCrusts());
        return menu;
    }

    public void setPizzaFilePath(String pizzaFilePath) {
        this.pizzaFilePath = pizzaFilePath;
    }

    public void setToppingFilePath(String toppingFilePath) {
        this.toppingFilePath = toppingFilePath;
    }

    public void setSideItemFilePath(String sideItemFilePath) {
        this.sideItemFilePath = sideItemFilePath;
    }
}
