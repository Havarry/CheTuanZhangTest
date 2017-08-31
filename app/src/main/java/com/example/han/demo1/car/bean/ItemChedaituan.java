package com.example.han.demo1.car.bean;

/**
 * Created by 15622 on 2017/3/10.
 */

public class ItemChedaituan {
    private int imageId;
    private String textView1;
    private String textView2;
    private String textView3;

    public ItemChedaituan(int imageId, String textView1, String textView2, String textView3) {
        this.imageId = imageId;
        this.textView1 = textView1;
        this.textView2 = textView2;
        this.textView3 = textView3;
    }
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTextView1() {
        return textView1;
    }

    public void setTextView1(String textView1) {
        this.textView1 = textView1;
    }

    public String getTextView2() {
        return textView2;
    }

    public void setTextView2(String textView2) {
        this.textView2 = textView2;
    }

    public String getTextView3() {
        return textView3;
    }

    public void setTextView3(String textView3) {
        this.textView3 = textView3;
    }
}
