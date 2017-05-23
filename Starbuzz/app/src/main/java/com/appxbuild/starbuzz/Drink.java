package com.appxbuild.starbuzz;

/**
 * Created by appxbuild on 09/05/17.
 */

public class Drink {


    private String name;
    private String description;
    private int imageResourceId;

    //drinks is an array of Drinks
    public static final Drink[] drinks = {

            new Drink("Latte", "A couple of espresso shots with steamed milk", R.drawable.cherry_coke),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.coke_zero),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh", R.drawable.vanilla_coke)
    };
    //Each Drink has a name, description, and an image resource
    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description; this.imageResourceId = imageResourceId;
    }
    public String getDescription() { return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
