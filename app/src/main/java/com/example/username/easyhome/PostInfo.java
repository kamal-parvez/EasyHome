package com.example.username.easyhome;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by username on 4/18/18.
 */

public class PostInfo {
    private String div;
    private String area;
    private String renter;
    private String title;
    private String bed;
    private String bath;
    private String size;
    private String features;
    private String address;
    private String description;
    private String rent;
    private String name;
    private String phn;
    private String cat;
    private String email;

    public PostInfo(){

    }

    public PostInfo(String name, String email, String address){
        setName(name);
        setEmail(email);
        setAddress(address);
    }

    public PostInfo(String name, String phn,String cat,  String div, String area, String renter, String title, String rent,  String size
                    ,String bed, String bath, String features, String address, String description){
        setDivision(div);
        setArea(area);
        setRenter(renter);
        setBed(bed);
        setBath(bath);
        setSize(size);
        setFeatures(features);
        setAddress(address);
        setDescription(description);
        setRent(rent);
        setName(name);
        setPhn(phn);
        setCategory(cat);
        setTitle(title);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    ///

    public void setDivision(String str){
        div = str;
    }
    public String getDivision(){
        return div;
    }
    ////

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {

        return title;
    }

    public void setArea(String str){
        area = str;
    }
    public String getArea(){
        return area;
    }
    ////
    public void setRenter(String str){
        renter = str;
    }
    public String getRenter(){
        return renter;
    }
    ////
    public void setBed(String str){
        bed = str;
    }
    public String getBed(){
        return bed;
    }
    ///
    public void setBath(String str){
        bath = str;
    }
    public String getBath(){
        return bath;
    }
    ///
    public void setSize(String str){
        size = str;
    }
    public String getSize(){
        return size;
    }
    ///
    public void setFeatures(String str){
        features = str;
    }
    public String getFeatures(){
        return features;
    }
    ///
    public void setAddress(String str){
        address = str;
    }
    public String getAddress(){
        return address;
    }
    ///

    public void setDescription(String str){
        description = str;
    }
    public String getDescription(){
        return description;
    }
    ////
    public void setRent(String str){
        rent = str;
    }
    public String getRent(){
        return rent;
    }
    ////
    public void setName(String str){
        name = str;
    }
    public String getName(){
        return name;
    }
    ///
    public void setCategory(String str){
        cat = str;
    }
    public String getCategory(){
        return cat;
    }
    ////
    public void setPhn(String str){
        phn = str;
    }
    public String getPhn(){
        return phn;
    }

}
