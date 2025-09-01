package ru.netology;

import java.util.Objects;

public class Item {

    protected String nameItem;
    protected String classProduct;
    protected String manufacturer;
    protected int ratingItem;


    public Item (String name, String classProduct, String manufacturer){
        this.nameItem = name;
        this.classProduct = classProduct;
        this.manufacturer = manufacturer;
        this.ratingItem = 0;
    }

    public String getNameItem() {
        return nameItem;
    }

    public String getClassProduct() {
        return classProduct;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRatingItem() {
        return ratingItem;
    }

    public void addRatingItem() {
        ++ratingItem;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Item item = (Item) object;
        return ratingItem == item.ratingItem && Objects.equals(nameItem, item.nameItem) && Objects.equals(classProduct, item.classProduct) && Objects.equals(manufacturer, item.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameItem, classProduct, manufacturer, ratingItem);
    }
}
