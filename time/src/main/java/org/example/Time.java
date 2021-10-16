package org.example;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hour, int minutes, int seconds) throws InvalidTimeException {
        setHour(hour);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public int getHour() {
        return hours;
    }

    public void setHour(int hour) throws InvalidTimeException {
        if (hour < 0 || hour > 23)
            throw new InvalidTimeException("Invalid hour's value");
        this.hours = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) throws InvalidTimeException {
        if (minutes < 0 || minutes > 59)
            throw new InvalidTimeException("Invalid minute's value");
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) throws InvalidTimeException {
        if (seconds < 0 || seconds > 59)
            throw new InvalidTimeException("Invalid second's value");
        this.seconds = seconds;
    }

    public void shiftSeconds(int offset) {
        int minutesOffset = floorDiv(seconds + offset, 60);
        seconds = floorMod(seconds + offset, 60);
        int hoursOffset = floorDiv(minutes + minutesOffset, 60);
        minutes = floorMod(minutes + minutesOffset, 60);
        int daysOffset = floorDiv(hours + hoursOffset, 24);
        hours = floorMod(hours + hoursOffset, 24);
        hook(daysOffset);
    }

    protected void hook(int days) {    }

    private int floorDiv(int dividend, int divider) {
        return dividend / divider - Boolean.compare(dividend < 0, false);
    }

    private int floorMod(int dividend, int divider) {
        return (dividend % divider + divider) % divider;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
