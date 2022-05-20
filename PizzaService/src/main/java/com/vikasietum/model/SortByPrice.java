package com.vikasietum.model;

import java.util.Comparator;

public class SortByPrice implements Comparator<Topping> {


    @Override
    public int compare(Topping o1, Topping o2) {
        if(o1.price < o2.price)
            return -1;
        if(o1.price > o2.price)
            return 1;
        return 0;

    }
}
