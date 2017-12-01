package com.barley.batch.model;

import java.sql.Time;

public class Stops {


    private long Stop_ID;
    private String Stop_Code;
    private String Stop_Name;
    private double Stop_Lat;
    private double Stop_Lon;
    private long Zone_ID;
    private String Alias;
    private String Stop_Area;
    private String Stop_Desc;
    private double Lest_X;
    private double Lest_Y;
    private String Zone_Name;

    public long getStop_ID() {
        return Stop_ID;
    }

    public void setStop_ID(long stop_ID) {
        Stop_ID = stop_ID;
    }

    public String getStop_Code() {
        return Stop_Code;
    }

    public void setStop_Code(String stop_Code) {
        Stop_Code = stop_Code;
    }

    public String getStop_Name() {
        return Stop_Name;
    }

    public void setStop_Name(String stop_Name) {
        Stop_Name = stop_Name;
    }

    public double getStop_Lat() {
        return Stop_Lat;
    }

    public void setStop_Lat(double stop_Lat) {
        Stop_Lat = stop_Lat;
    }

    public double getStop_Lon() {
        return Stop_Lon;
    }

    public void setStop_Lon(double stop_Lon) {
        Stop_Lon = stop_Lon;
    }

    public long getZone_ID() {
        return Zone_ID;
    }

    public void setZone_ID(long zone_ID) {
        Zone_ID = zone_ID;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getStop_Area() {
        return Stop_Area;
    }

    public void setStop_Area(String stop_Area) {
        Stop_Area = stop_Area;
    }

    public String getStop_Desc() {
        return Stop_Desc;
    }

    public void setStop_Desc(String stop_Desc) {
        Stop_Desc = stop_Desc;
    }

    public double getLest_X() {
        return Lest_X;
    }

    public void setLest_X(double lest_X) {
        Lest_X = lest_X;
    }

    public double getLest_Y() {
        return Lest_Y;
    }

    public void setLest_Y(double lest_Y) {
        Lest_Y = lest_Y;
    }

    public String getZone_Name() {
        return Zone_Name;
    }

    public void setZone_Name(String zone_Name) {
        Zone_Name = zone_Name;
    }



}
