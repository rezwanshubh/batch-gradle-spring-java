package com.barley.batch.model;

import java.util.Date;

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

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getException_Type() {
        return Exception_Type;
    }

    public void setException_Type(int exception_Type) {
        Exception_Type = exception_Type;
    }


}
