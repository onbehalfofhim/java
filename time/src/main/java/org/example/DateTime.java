package org.example;

public class DateTime extends Time {
    private static final int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int year;
    private int month;
    private int day;

    public DateTime(int year, int month, int day, int hour, int minutes, int seconds) throws InvalidTimeException {
        super(hour, minutes, seconds);
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidTimeException {
        if (year == 0) throw new InvalidTimeException("Invalid year's value");
        this.year = year;
    }

    public int getMonth() { return month; }

    public void setMonth(int month) throws InvalidTimeException {
        if (month < 0 || month > 12) throw new InvalidTimeException("Invalid month's value");
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws InvalidTimeException {
        if (day <= 0 || day > getDaysInMonth(month, year)) throw new InvalidTimeException("Invalid day's value");
        this.day = day;
    }

    public void setDate(int day, int month, int year) throws InvalidTimeException {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeap(year)) return 29;
        return daysInMonths[month - 1];
    }

    public void shiftDays(int days) {
        if(days >= 0){
            day += days;
            while (day > getDaysInMonth(month, year)) {
                day -= getDaysInMonth(month, year);
                month = month % 12 + 1;
                if (month == 1) {
                    year++;
                    if (year == 0) year = 1;
                }
            }
        } else {
            day += days;
            while (day <= 0) {
                month = (10 + month) % 12 + 1; //(12 + month - 1 - 1) % 12 + 1
                day += getDaysInMonth(month, year);
                if (month == 12) {
                    year--;
                    if (year == 0) year = -1;
                }
            }
        }
    }

    @Override
    protected void hook(int days) {
        shiftDays(days);
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%4d %02d:%02d:%02d", day, month, year, getHour(), getMinutes(), getSeconds());
    }
}
