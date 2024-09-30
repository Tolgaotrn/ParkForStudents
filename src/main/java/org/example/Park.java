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
        if (capacity <= occupiedSpaces) {
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
    // Tests from chatgpt
    public static void main(String[] args) {
        // Create a park with 500 spaces
        Park park = new Park(500, 0);

        // Create students
        Student student1 = new Student("S001", "John");
        Student student2 = new Student("S002", "Alice");
        Student student3 = new Student("S003", "Bob");

        // Students entering the park
        park.enterPark(student1, "ABC123");
        park.enterPark(student2, "XYZ987");

        // Simulate student1 leaving after some time
        park.exitPark(student1);

        // Another student entering the park
        park.enterPark(student3, "LMN456");

        // Simulate student2 leaving
        park.exitPark(student2);

        // Simulate student3 leaving
        park.exitPark(student3);
    }
}
