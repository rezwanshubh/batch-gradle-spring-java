package com.barley.batch.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calendar {

    public Calendar() {

    }

    private long Service_ID;
    private boolean Monday;
    private boolean Tuesday;
    private boolean Wednesday;
    private boolean Thursday;
    private boolean Friday;
    private boolean Saturday;
    private boolean Sunday;
    private Date Start_date;
    private Date End_date;


    public long getService_Id() {
        return Service_ID;
    }

    public void setService_Id(long service_Id) {
        Service_ID = service_Id;
    }

    public boolean isMonday() {
        return Monday;
    }

    public void setMonday(boolean monday) {
        Monday = monday;
    }

    public boolean isTuesday() {
        return Tuesday;
    }

    public void setTuesday(boolean tuesday) {
        Tuesday = tuesday;
    }

    public boolean isWednesday() {
        return Wednesday;
    }

    public void setWednesday(boolean wednesday) {
        Wednesday = wednesday;
    }

    public boolean isThursday() {
        return Thursday;
    }

    public void setThursday(boolean thursday) {
        Thursday = thursday;
    }

    public boolean isFriday() {
        return Friday;
    }

    public void setFriday(boolean friday) {
        Friday = friday;
    }

    public boolean isSaturday() {
        return Saturday;
    }

    public void setSaturday(boolean saturday) {
        Saturday = saturday;
    }

    public boolean isSunday() {
        return Sunday;
    }

    public void setSunday(boolean sunday) {
        Sunday = sunday;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(String start_date) {

        try {
            Start_date = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(start_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String end_date) {
        try {
            End_date = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(end_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
