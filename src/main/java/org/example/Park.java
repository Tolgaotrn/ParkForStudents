package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Park {
    private int capacity = 500;
    private int occupiedSpaces = 0;
    private List<Student> studentsInPark = new ArrayList<>();
    private List<ParkTime> parkingLog = new ArrayList<>();

    public Park(int capacity, int occupiedSpaces) {
        this.capacity = capacity;
        this.occupiedSpaces = occupiedSpaces;
    }

    public void enterPark(Student student, String carLicense) {
        if (occupiedSpaces <= 500) {
            throw new Error("Already full cannot park here");
        }
        student.setLicensePlate(carLicense);
        studentsInPark.add(student);
        occupiedSpaces++;
        ParkTime parkingTime = new ParkTime(student, LocalDateTime.now());
        student.setCurrentParkingTime(parkingTime);
        System.out.println("Student " + student.getName() + " entered the park.");

    }

    public void exitPark(Student student) {
        LocalDateTime exitTime = LocalDateTime.now();
        ParkTime parkingTime = student.getCurrentParkingTime();
        parkingTime.setExitTime(exitTime);
        parkingTime.calculateParkingFee();
        parkingLog.add(parkingTime);
        student.addAmountPaid(parkingTime.getAmountPaid());
        studentsInPark.remove(student);
        occupiedSpaces--;
        System.out.println("Student " + student.getName() + " left the park. Paid: " + parkingTime.getAmountPaid() + " EUR.");
    }
}
