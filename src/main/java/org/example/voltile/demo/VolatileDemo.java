package org.example.voltile.demo;

public class VolatileDemo {
    private  int years;
    private  int months;
    private  int days;

    public int totalDays(){
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

    public void update(int years, int months, int days){
        this.years = years;
        this.months = months;
        this.days = days;
    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        Thread threadUpdate = new Thread(){
            @Override
            public void run() {
                volatileDemo.update(1,0,0);
            }
        };

        Thread threadRead = new Thread(){
            @Override
            public void run() {
                System.out.println("totalDays: " + volatileDemo.totalDays());
            }
        };

        threadUpdate.start();
        threadRead.start();

    }
}
