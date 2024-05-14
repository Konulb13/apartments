package org.example;

public class Apartments {
    private int id;
private int quantity_of_flat;
private int price;
private String district;
private String address;
private int area;

    public Apartments() {
    }

    public Apartments(int id, int quantity_of_flat, String district, int price, String address, int area) {
        this.id = id;
        this.quantity_of_flat = quantity_of_flat;
        this.district = district;
        this.price = price;
        this.address = address;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity_of_flat() {
        return quantity_of_flat;
    }

    public void setQuantity_of_flat(int quantity_of_flat) {
        this.quantity_of_flat = quantity_of_flat;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{id=" + id + ", quantity_of_flat=" + quantity_of_flat+ "price=" + price+", district=" + district + ", address=" + address + ", area=" + area + "}";
    }
}
