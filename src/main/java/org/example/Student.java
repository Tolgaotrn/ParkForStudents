package org.example;

public class Student {
    private String studentId;
    private String licencePlate;
    private String name;
    private String surname;
    private double totalAmount;
    private ParkTime cgurrentParkingTime;
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.totalAmount = 0;
    }

    public void setLicensePlate(String licensePlate) {
        this.licencePlate = licensePlate;
    }

    public String getName() {
        return name;
    }

    public void setCurrentParkingTime(ParkTime parkingTime) {
        this.currentParkingTime = parkingTime;
    }

    public ParkTime getCurrentParkingTime() {
        return currentParkingTime;
    }

    public void addAmountPaid(double amount) {
        this.totalAmount += amount;
    }

    public double getTotalPaid() {
        return totalAmount;
    }
}

