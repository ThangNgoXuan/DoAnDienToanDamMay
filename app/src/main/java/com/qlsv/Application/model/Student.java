package com.qlsv.Application.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id
    private String ID;

    private String SClass;
    private String Name;
    private float PointAvg;
    private int TotalCredits;
    private String Ranking;
    private String Major;

    private String Description;
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    public String getID(){
        return ID;
    }
    public void setID(String id){
        this.ID=id;
    }

    public String getSClass(){
        return SClass;
    }
    public void setSClass(String sclass){
        this.SClass=sclass;
    }

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }

    public String getRanking(){
        return Ranking;
    }
    public void setRanking(String Ranking){
        this.Ranking=Ranking;
    }

    public String getMajor(){
        return Major;
    }
    public void setMajor(String Major){
        this.Major=Major;
    }

    public int getTotalCredits(){
        return TotalCredits;
    }
    public void setTotalCredits(int TotalCredits){
        this.TotalCredits=TotalCredits;
    }

    public float getPointAvg(){
        return PointAvg;
    }
    public void setPointAvg(float PointAvg){
        this.PointAvg=PointAvg;
    }
    public Student(){};
    public Student(String MSSV, String SClass, String Name, float PointAvg,int TotalCredits, String Ranking, String Major ){
        this.ID=MSSV;
        this.Major=Major;
        this.Name=Name;
        this.SClass=SClass;
        this.PointAvg=PointAvg;
        this.TotalCredits=TotalCredits;
        this.Ranking=Ranking;
    }
}
