package dev.kalarianathecila.schoolStuff.clock;

public class ClockBackend {

    private final ClockTime startTime;
    private final ClockTime currentTime;
    private final ClockTime stopTime;

    public ClockBackend(int hours, int minutes, int seconds, int hoursStop, int minutesStop, int secondsStop) {
        this.startTime = new ClockTime(hours, minutes, seconds);
        this.currentTime = new ClockTime(hours, minutes, seconds);
        this.stopTime = new ClockTime(hoursStop, minutesStop, secondsStop);
    }

    public void run() {
        int startTotal = startTime.toTotalSeconds();
        int stopTotal = stopTime.toTotalSeconds();

        if (stopTotal < startTotal) {
            throw new IllegalArgumentException("Stopping time must be after or equal to starting time.");
        }

        while (!currentTime.isEqualTo(stopTime)) {
            printTime();
            tick();
        }
        printTime();

        int simulated = stopTotal - startTotal;
        int h = simulated / 3600;
        int m = (simulated % 3600) / 60;
        int s = simulated % 60;
        System.out.printf("%nTotal simulated time: %02d:%02d:%02d (%d seconds)%n", h, m, s, simulated);
    }

    private void tick() {
        currentTime.nextStep();
    }

    private void printTime() {
        System.out.println(currentTime);
    }
}
