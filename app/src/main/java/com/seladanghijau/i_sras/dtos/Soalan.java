package com.seladanghijau.i_sras.dto;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class Soalan {
    private int soalanId, soalanNo, soalanType;
    private String soalanDesc, soalanCategory, soalanKeyCategory;

    // constructor
    public Soalan() {
        soalanId = 0;
        soalanNo = 0;
        soalanType = 0;
        soalanDesc = "";
        soalanCategory = "";
        soalanKeyCategory = "";
    }

    public Soalan(int soalanId, int soalanNo, int soalanType, String soalanDesc, String soalanCategory, String soalanKeyCategory) {
        this.soalanId = soalanId;
        this.soalanNo = soalanNo;
        this.soalanType = soalanType;
        this.soalanDesc = soalanDesc;
        this.soalanCategory = soalanCategory;
        this.soalanKeyCategory = soalanKeyCategory;
    }

    // getter
    public int getSoalanId() { return soalanId; }
    public int getSoalanNo() { return soalanNo; }
    public int getSoalanType() { return soalanType; }
    public String getSoalanDesc() { return soalanDesc; }
    public String getSoalanCategory() { return soalanCategory; }
    public String getSoalanKeyCategory() { return soalanKeyCategory; }

    // setter
    public void setSoalanId(int soalanId) { this.soalanId = soalanId; }
    public void setSoalanNo(int soalanNo) { this.soalanNo = soalanNo; }
    public void setSoalanType(int soalanType) { this.soalanType = soalanType; }
    public void setSoalanDesc(String soalanDesc) { this.soalanDesc = soalanDesc; }
    public void setSoalanCategory(String soalanCategory) { this.soalanCategory = soalanCategory; }
    public void setSoalanKeyCategory(String soalanKeyCategory) { this.soalanKeyCategory = soalanKeyCategory; }
}
