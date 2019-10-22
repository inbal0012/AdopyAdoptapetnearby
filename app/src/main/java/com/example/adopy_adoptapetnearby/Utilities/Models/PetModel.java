package com.example.adopy_adoptapetnearby.Utilities.Models;

import com.google.gson.annotations.SerializedName;

public class PetModel {
    @SerializedName("name")
    private String Name;
    @SerializedName("bitmap")
    private String Bitmap;
    @SerializedName("info")
    private String Info;
    @SerializedName("date")
    private String Date;
    @SerializedName("location")
    private String Location;
    @SerializedName("immunized")
    private Boolean Immunized;
    @SerializedName("age")
    private String Age;
    @SerializedName("price")
    private String Price;
    @SerializedName("owner")
    private String PostOwner;

    public PetModel(String name, String bitmap, String info, String date, String location, Boolean immunized, String age, String price, String postOwner) {
        Name = name;
        Bitmap = bitmap;
        Info = info;
        Date = date;
        Location = location;
        Immunized = immunized;
        Age = age;
        Price = price;
        PostOwner = postOwner;
    }

    public PetModel() {
    }

    public String getPostOwner() {
        return PostOwner;
    }

    public void setPostOwner(String postOwner) {
        PostOwner = postOwner;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBitmap() {
        return Bitmap;
    }

    public void setBitmap(String  bitmap) {
        Bitmap = bitmap;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Boolean getImmunized() {
        return Immunized;
    }

    public void setImmunized(Boolean immunized) {
        Immunized = immunized;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
