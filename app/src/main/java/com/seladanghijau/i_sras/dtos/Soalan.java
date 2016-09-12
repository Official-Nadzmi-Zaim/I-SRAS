package com.seladanghijau.i_sras.dtos;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class Soalan {
    private int soalanId, soalanNo, soalanType, soalanCategory;
    private String soalanDesc;

    // constructor
    public Soalan() {
        soalanId = 0;
        soalanNo = 0;
        soalanType = 0;
        soalanDesc = "";
        soalanCategory = 0;
    }

    public Soalan(int soalanId, int soalanNo, int soalanType, String soalanDesc, int soalanCategory) {
        this.soalanId = soalanId;
        this.soalanNo = soalanNo;
        this.soalanType = soalanType;
        this.soalanDesc = soalanDesc;
        this.soalanCategory = soalanCategory;
    }

    // getter
    public int getSoalanId() { return soalanId; }
    public int getSoalanNo() { return soalanNo; }
    public int getSoalanType() { return soalanType; }
    public String getSoalanDesc() { return soalanDesc; }
    public int getSoalanCategory() { return soalanCategory; }

    // setter
    public void setSoalanId(int soalanId) { this.soalanId = soalanId; }
    public void setSoalanNo(int soalanNo) { this.soalanNo = soalanNo; }
    public void setSoalanType(int soalanType) { this.soalanType = soalanType; }
    public void setSoalanDesc(String soalanDesc) { this.soalanDesc = soalanDesc; }
    public void setSoalanCategory(int soalanCategory) { this.soalanCategory = soalanCategory; }
}
