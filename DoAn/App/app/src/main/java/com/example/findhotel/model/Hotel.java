package com.example.findhotel.model;

public class Hotel {
    private int maSo;
    private String tenKachSan;
    private String diaChi;
    private String giaTien;
    private byte[] hinh;

    public Hotel() {
        this.maSo = 0;
        this.tenKachSan = "";
        this.diaChi = "";
        this.giaTien = "0";
        this.hinh = null;
    }

    public Hotel(int maSo, String tenKachSan, String diaChi, String giaTien, byte[] hinh) {
        this.maSo = maSo;
        this.tenKachSan = tenKachSan;
        this.diaChi = diaChi;
        this.giaTien = giaTien;
        this.hinh = hinh;
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getTenKachSan() {
        return tenKachSan;
    }

    public void setTenKachSan(String tenKachSan) {
        this.tenKachSan = tenKachSan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }
}
