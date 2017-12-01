package com.barley.batch.model;

public class Trips {


    private long Route_ID;
    private long Service_ID;
    private long Trip_ID;
    private  String Trip_Headsign;
    private String Trip_Long_Name;
    private String Direction_Code;
    private  long Shape_ID;
    private boolean Wheelchair_Accessible;



    public long getRoute_ID() {
        return Route_ID;
    }

    public void setRoute_ID(long route_ID) {
        Route_ID = route_ID;
    }

    public long getService_ID() {
        return Service_ID;
    }

    public void setService_ID(long service_ID) {
        Service_ID = service_ID;
    }

    public long getTrip_ID() {
        return Trip_ID;
    }

    public void setTrip_ID(long trip_ID) {
        Trip_ID = trip_ID;
    }

    public String getTrip_Headsign() {
        return Trip_Headsign;
    }

    public void setTrip_Headsign(String trip_Headsign) {
        Trip_Headsign = trip_Headsign;
    }

    public String getTrip_Long_Name() {
        return Trip_Long_Name;
    }

    public void setTrip_Long_Name(String trip_Long_Name) {
        Trip_Long_Name = trip_Long_Name;
    }

    public String getDirection_Code() {
        return Direction_Code;
    }

    public void setDirection_Code(String direction_Code) {
        Direction_Code = direction_Code;
    }

    public long getShape_ID() {
        return Shape_ID;
    }

    public void setShape_ID(long shape_ID) {
        Shape_ID = shape_ID;
    }

    public boolean isWheelchair_Accessible() {
        return Wheelchair_Accessible;
    }

    public void setWheelchair_Accessible(boolean wheelchair_Accessible) {
        Wheelchair_Accessible = wheelchair_Accessible;
    }

}
