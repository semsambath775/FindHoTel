package com.example.findhotel.model;

public class RecentsData {
    String hotelName;
    String hotelAddress;
    String hotelPrice;
    Integer imageUrl;


    public RecentsData(String hotelName, String hotelAddress, String hotelPrice, Integer imageUrl) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelPrice = hotelPrice;
        this.imageUrl = imageUrl;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
