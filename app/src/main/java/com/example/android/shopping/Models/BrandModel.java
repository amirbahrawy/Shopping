package com.example.android.shopping.Models;

import java.util.List;

public class BrandModel {
    private String title,categ;
    private int img;
    private List<ProudctModel> proudcts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public List<ProudctModel> getProudcts() {
        return proudcts;
    }

    public void setProudcts(List<ProudctModel> proudcts) {
        this.proudcts = proudcts;
    }

    public BrandModel(String title, String categ, int img, List<ProudctModel> proudcts) {
        this.title = title;
        this.categ = categ;
        this.img = img;
        this.proudcts = proudcts;
    }
}
