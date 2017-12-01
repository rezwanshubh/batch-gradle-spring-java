package com.greentickets.batch.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarDates {


    private long Service_Id;
    private Date Date;
    private int Exception_Type;



    public long getService_Id() {
        return Service_Id;
    }

    public void setService_Id(long service_Id) {
        Service_Id = service_Id;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(String date) {

        try {
            Date = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getException_Type() {
        return Exception_Type;
    }

    public void setException_Type(int exception_Type) {
        Exception_Type = exception_Type;
    }


}
