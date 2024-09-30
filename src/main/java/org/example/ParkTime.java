package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class ParkTime {
    private Student student;
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;
    private double totalPaidInAmonth;


    public ParkTime(Student student, LocalDateTime enterTime) {
        this.student = student;
        this.enterTime = enterTime;
        this.totalPaidInAmonth = 0;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void calculateParkingFee() {
        Duration duration = Duration.between(enterTime, exitTime);
        long minutes = duration.toMinutes();
        this.totalPaidInAmonth = (minutes / 15) * 0.10;
    }

    public double getAmountPaid() {
        return totalPaidInAmonth;
    }
}

}


