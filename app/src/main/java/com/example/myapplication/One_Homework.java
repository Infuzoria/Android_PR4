package com.example.myapplication;

public class One_Homework {
    private String name; // название
    private int pictureResource; // ресурс флага

    public One_Homework(String name, int picture){

        this.name=name;
        this.pictureResource = picture;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPictureResource() {
        return this.pictureResource;
    }

    public void setPictureResource(int pictureResource) {
        this.pictureResource = pictureResource;
    }
}
