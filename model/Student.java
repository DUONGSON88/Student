package model;

import java.util.Arrays;

public class Student{
    private String id;
    private String name;
    private int yearOfBirth;
    private double[] point ;
    private String gender;

    public Student( String id,String name, int yearOfBirth,String gender, double[] point) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender=gender;
        this.point = point;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double[] getPoint() {
        return point;
    }

    public void setPoint(double[] point) {
        this.point = point;
    }
    public double getAvg(){
        double sum=0;
        for (int i = 0; i < point.length; i++) {
            sum+=point[i];
        }
      return sum/point.length;
    }

    @Override
    public String toString() {
        return "Học Sinh" +
                "| Id: " + id +
                "| Họ và Tên: " + name +
                "| Năm Sinh: " + yearOfBirth +
                "| Điểm Toán Lý Hóa: " + Arrays.toString(point)+
                "| Điểm TB Môn: " + getAvg();
    }
}
