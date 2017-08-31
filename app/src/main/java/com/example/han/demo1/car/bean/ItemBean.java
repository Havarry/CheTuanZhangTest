package com.example.han.demo1.car.bean;

/**
 * Created by 15622
 * Timer 2017/3/9
 */

public class ItemBean {
    private int ImageId;
    private  String Details;

    public ItemBean(int imageId, String details) {
        ImageId = imageId;
        Details = details;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
