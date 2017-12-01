package com.barley.batch.model;

import org.springframework.context.annotation.Primary;

public class Routes {

    private long Route_ID;
    private long Agency_ID;
    private String Route_Short_Name;
    private String Route_Long_Name;
    private int Route_Type;
    private String Route_Color;
    private String Competent_Authority;


    public long getRoute_ID() {
        return Route_ID;
    }

    public void setRoute_ID(long route_ID) {
        Route_ID = route_ID;
    }

    public long getAgency_ID() {
        return Agency_ID;
    }

    public void setAgency_ID(long agency_ID) {
        Agency_ID = agency_ID;
    }

    public String getRoute_Short_Name() {
        return Route_Short_Name;
    }

    public void setRoute_Short_Name(String route_Short_Name) {
        Route_Short_Name = route_Short_Name;
    }

    public String getRoute_Long_Name() {
        return Route_Long_Name;
    }

    public void setRoute_Long_Name(String route_Long_Name) {
        Route_Long_Name = route_Long_Name;
    }

    public int getRoute_Type() {
        return Route_Type;
    }

    public void setRoute_Type(int route_Type) {
        Route_Type = route_Type;
    }

    public String getRoute_Color() {
        return Route_Color;
    }

    public void setRoute_Color(String route_Color) {
        Route_Color = route_Color;
    }

    public String getCompetent_Authority() {
        return Competent_Authority;
    }

    public void setCompetent_Authority(String competent_Authority) {
        Competent_Authority = competent_Authority;
    }



}
