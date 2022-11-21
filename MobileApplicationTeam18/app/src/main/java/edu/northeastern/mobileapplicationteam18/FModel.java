package edu.northeastern.mobileapplicationteam18;

public class FModel {
    Integer imageRes;
    String Name, Details;

    public FModel(Integer imageRes, String name, String details) {
        this.imageRes = imageRes;
        this.Name = name;
        this.Details = details;
    }

    public Integer getImageRes() {
        return imageRes;
    }

    public void setImageRes(Integer imageRes) {
        this.imageRes = imageRes;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
