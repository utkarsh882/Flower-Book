package com.easternts.flowerworld.flowersubcategory.model;

public class FlowerViewModel {
//    Context context;
//    private int packageName = context.getPackageName();

    private int flower_id;
    private int flowername;
    private int flower_description;
    private int flowerimage;
    private int flowerfavorite;
    private int category_id;


    public FlowerViewModel(int flower_id, int flowername, int flower_description, int flowerimage,int flowerfavorite,int category_id) {
        this.flower_id= flower_id;
        this.flowername = flowername;
        this.flower_description = flower_description;
        this.flowerimage = flowerimage;
        this.flowerfavorite = flowerfavorite;
        this.category_id = category_id;
    }


    public int getFlowerfavorite() {
        return flowerfavorite;
    }

    public void setFlowerfavorite(int flowerfavorite) {
        this.flowerfavorite = flowerfavorite;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlowername(int flowername) {
        this.flowername = flowername;
    }

    public int getFlowername() {
        return flowername;
    }

    public int getFlower_description() {
        return flower_description;
    }

    public void setFlower_description(int flower_description) {
        this.flower_description = flower_description;
    }

    public int getFlowerimage() {
        return flowerimage;
    }

    public void setFlowerimage(int flowerimage) {
        this.flowerimage = flowerimage;
    }


}
