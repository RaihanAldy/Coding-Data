package com.example.ayamku;

public class Ayamku {

    private String nama;
    private String npm;
    private String nohp;
    private int img;
    public Ayamku(String nama, String npm, String nohp,int img) {
        this.nama = nama;
        this.npm = npm;
        this.nohp = nohp;
        this.img=img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
    public void setImg(int img) {
        this.img = img;
    }
    public int getImg() {
        return img;
    }
}
