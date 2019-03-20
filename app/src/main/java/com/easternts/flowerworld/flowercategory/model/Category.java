package com.easternts.flowerworld.flowercategory.model;


/**
 * Created by SVF 15213 on 12-06-2016.
 */
public class Category {
    private int mCategoryId;
    private int mCategoryName;
    private int mImageId;

    public Category(int categoryid, int categoryname, int imageid) {
        this.mCategoryId = categoryid;
        this.mCategoryName = categoryname;
        this.mImageId = imageid;
    }

    public int getmCategoryId() {
        return mCategoryId;
    }

    public void setmCategoryId(int mCategoryId) {
        this.mCategoryId = mCategoryId;
    }

    public int getmCategoryName() {
        return mCategoryName;
    }

    public void setmCategoryName(int mCategoryName) {
        this.mCategoryName = mCategoryName;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }
}
