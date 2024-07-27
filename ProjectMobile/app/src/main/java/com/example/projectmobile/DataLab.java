package com.example.projectmobile;

public class DataLab {
    String nameLab;
    int srcImage;
    public DataLab(String nameLab,int srcImage){
        this.nameLab = nameLab;
        this.srcImage = srcImage;
    }

    public String getNameLab(){
        return nameLab;
    }

    public int getSrcImage(){
        return srcImage;
    }
}
