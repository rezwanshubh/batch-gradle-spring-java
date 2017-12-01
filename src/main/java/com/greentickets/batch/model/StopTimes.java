package com.greentickets.batch.model;

import java.sql.Time;

public class StopTimes {


    private long Trip_ID;
    private Time Arrival_Time;
    private Time Departure_Time;
    private long Stop_ID;
    private int Stop_Sequence;
    private int Pickup_Type;
    private int Drop_Off_Type;


    public long getTrip_ID() {
        return Trip_ID;
    }

    public void setTrip_ID(long trip_ID) {
        Trip_ID = trip_ID;
    }

    public Time getArrival_Time() {
        return Arrival_Time;
    }

    public void setArrival_Time(Time arrival_Time) {
        Arrival_Time = arrival_Time;
    }

    public Time getDeparture_Time() {
        return Departure_Time;
    }

    public void setDeparture_Time(Time departure_Time) {
        Departure_Time = departure_Time;
    }

    public long getStop_ID() {
        return Stop_ID;
    }

    public void setStop_ID(long stop_ID) {
        Stop_ID = stop_ID;
    }

    public int getStop_Sequence() {
        return Stop_Sequence;
    }

    public void setStop_Sequence(int stop_Sequence) {
        Stop_Sequence = stop_Sequence;
    }

    public int getPickup_Type() {
        return Pickup_Type;
    }

    public void setPickup_Type(int pickup_Type) {
        Pickup_Type = pickup_Type;
    }

    public int getDrop_Off_Type() {
        return Drop_Off_Type;
    }

    public void setDrop_Off_Type(int drop_Off_Type) {
        Drop_Off_Type = drop_Off_Type;
    }
}
