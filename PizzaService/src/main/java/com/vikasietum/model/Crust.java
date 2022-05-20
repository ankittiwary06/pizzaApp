package com.vikasietum.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Crust {
    NEW_HAND_TOSSED("New hand tossed"), WHEAT_THIN_CRUST("Wheat thin crust"),
    CHEESE_BURST("Cheese Burst"), FRESH_PAN_PIZZA("Fresh pan pizza");
    //   @JsonValue
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    Crust(String name) {
        this.name = name;
    }
}
