/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class MonHoc81 {
    private String maMon;
    private int soTinChi;
    private String tenMon;

    // Constructor
    public MonHoc81(String maMon, int soTinChi, String tenMon) {
        this.maMon = maMon;
        this.soTinChi = soTinChi;
        this.tenMon = tenMon;
    }

    // Getters and Setters
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
}

