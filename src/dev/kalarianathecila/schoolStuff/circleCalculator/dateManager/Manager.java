package dev.kalarianathecila.schoolStuff.circleCalculator.dateManager;

import java.util.Scanner;

public class Manager {
    private int day;
    private int month;
    private int year;

    private int weekday;

    private String weekdayOutput = "Monday"; // Placeholder for weekday output

    void setDay(int day) {
        this.day = day;
    }

    void setMonth(int month) {
        this.month = month;
    }

    void setYear(int year) {
        this.year = year;
    }

    void readDate() {
        int day;
        int month;
        int year;

        Scanner scn = new Scanner(System.in);

        System.out.println("Day:");
        setDay(scn.nextInt());
        System.out.println("Month:");
        setMonth(scn.nextInt());
        System.out.println("Year:");
        setYear(scn.nextInt());
    }

    void setTestDate() {
        setDay(1);
        setMonth(1);
        setYear(2000);
    }

    void showClassicDateFormat() {
        String classicFormat = day + "." + month + "." + year;
        System.out.print("Classic format: ");
        System.out.println(classicFormat);
    }

    void showInternationalDateFormat() {
        String internationalFormat = year + "-" + month + "-" + day;
        System.out.print("International format: ");
        System.out.println(internationalFormat);
    }

    void showDay() {
        System.out.print("Day: ");
        System.out.println(day);
    }

    void showMonth() {
        System.out.print("Month: ");
        System.out.println(month);
    }

    void showYear() {
        System.out.print("Year: ");
        System.out.println(year);
    }

    void showWeekday() {
        weekday=(day+(13*(month+1))/5+year+(year/4)-(year/100)+(year/400))%7;
        if (weekday==0){
            weekdayOutput="Saturday";
        } else if (weekday==1) {
            weekdayOutput="Sunday";
        } else if (weekday==2) {
            weekdayOutput="Monday";
        } else if (weekday==3) {
            weekdayOutput="Tuesday";
        } else if (weekday==4) {
            weekdayOutput="Wednesday";
        } else if (weekday==5) {
            weekdayOutput="Thursday";
        } else if (weekday==6) {
            weekdayOutput="Friday";
        } else if (weekday<-1) {
            weekdayOutput="Error";
        } else if (weekday>6) {
            weekdayOutput="Error";
        } else {
            weekdayOutput="Error";
        }
        System.out.print("Weekday: ");
        System.out.println(weekdayOutput);
    }

    void showEasterDate() {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 16;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 16;
        int k = c % 16;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;

        System.out.print("Easter date: ");
        System.out.println(day + "." + month + "." + year);
    }

    void showMonthNameSequential() {
        String monthname = "";

        if (month == 1) {
            monthname = "January";
        } else if (month == 2) {
            monthname = "February";
        } else if (month == 3) {
            monthname = "March";
        } else if (month == 4) {
            monthname = "April";
        } else if (month == 5) {
            monthname = "May";
        } else if (month == 6) {
            monthname = "June";
        } else if (month == 7) {
            monthname = "July";
        } else if (month == 8) {
            monthname = "August";
        } else if (month == 9) {
            monthname = "September";
        } else if (month == 10) {
            monthname = "October";
        } else if (month == 11) {
            monthname = "November";
        } else if (month == 12) {
            monthname = "December";
        } else {
            monthname = "Invalid month";
        }
        System.out.print("Month name: ");
        System.out.println(monthname);
    }

    void showMonthNameCase() {
        String monthname = "";

        switch (month) {
            case 1:
                monthname = "January";
                break;
            case 2:
                monthname = "February";
                break;
            case 3:
                monthname = "March";
                break;
            case 4:
                monthname = "April";
                break;
            case 5:
                monthname = "May";
                break;
            case 6:
                monthname = "June";
                break;
            case 7:
                monthname = "July";
                break;
            case 8:
                monthname = "August";
                break;
            case 9:
                monthname = "September";
                break;
            case 10:
                monthname = "October";
                break;
            case 11:
                monthname = "November";
                break;
            case 12:
                monthname = "December";
                break;
            default:
                monthname = "Invalid month";
        }
        System.out.print("Month name: ");
        System.out.println(monthname);
    }

    void showMonthNameArray() {
        String[] monthNames = {
            "Invalid month", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        String monthname;
        if (month >= 1 && month <= 12) {
            monthname = monthNames[month];
        } else {
            monthname = monthNames[0];
        }

        System.out.print("Month name: ");
        System.out.println(monthname);
    }

    void showMonthNameCaseSwitch(){
        int lastMonthDay;
        boolean oddYear = false;

        switch (month) {
            case 1,3,5,7,8,10,12 -> lastMonthDay = 31;
            case 4,6,9,11  -> lastMonthDay = 30;
            case 2->{
                if (oddYear) {
                    lastMonthDay = 29;
                }else {
                    lastMonthDay = 28;
                }
            }
            default -> System.out.println("ungültige Monatsnummer");

        }
    }

    void showMonthNameCaseSwitchWithException(){
        int lastMonthDay;
        boolean oddYear = false;
        lastMonthDay = switch (month) {
            case 1,3,5,7,8,10,12 -> 31;
            case 4,6,9,11 -> 30;
            case 2->{
                if (oddYear) {
                    yield 29;
                }else {
                    yield 28;
                }

            }

            default -> throw new IllegalArgumentException("Unexpected value: " + month);

        };
    }
}
