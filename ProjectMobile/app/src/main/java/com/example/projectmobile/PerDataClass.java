package com.example.projectmobile;

public class PerDataClass {
    private String dataname;
    private String datastatus;
    private String dataemail;
    private int dataImage;

    public PerDataClass(String dataName, String dataStatus, String dataEmail, int dataImage) {
        this.dataname = dataName;
        this.datastatus = dataStatus;
        this.dataemail = dataEmail;
        this.dataImage = dataImage;
    }
    public String getDataName() {
        return dataname;
    }
    public String getDataStatus() {
        return datastatus;
    }
    public String getDataEmail() {
        return dataemail;
    }
    public int getDataImage() {
        return dataImage;
    }

}
