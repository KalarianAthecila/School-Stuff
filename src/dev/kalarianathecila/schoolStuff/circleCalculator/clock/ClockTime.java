package dev.kalarianathecila.schoolStuff.circleCalculator.clock;

public class ClockTime {
    private int hours;
    private int minutes;
    private int seconds;

    public ClockTime(int hours, int minutes, int seconds) {
        setTime(hours, minutes, seconds);
    }

    public void setTime(int hours, int minutes, int seconds) {
        if (!isValid(hours, minutes, seconds)) {
            throw new IllegalArgumentException("Invalid time: " + hours + ":" + minutes + ":" + seconds);
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours must be between 0 and 23.");
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59.");
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void nextStep() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }

    public int toTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public boolean isEqualTo(ClockTime other) {
        return hours == other.hours && minutes == other.minutes && seconds == other.seconds;
    }

    public static boolean isValid(int hours, int minutes, int seconds) {
        return hours >= 0 && hours <= 23
                && minutes >= 0 && minutes <= 59
                && seconds >= 0 && seconds <= 59;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

