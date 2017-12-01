package com.greentickets.batch.model;

public class FareRules {

    private long Fare_ID;
    private long Route_ID;
    private long Origin_ID;
    private long Destination_ID;



    public long getFare_ID() {
        return Fare_ID;
    }

    public void setFare_ID(long fare_ID) {
        Fare_ID = fare_ID;
    }

    public long getRoute_ID() {
        return Route_ID;
    }

    public void setRoute_ID(long route_ID) {
        Route_ID = route_ID;
    }

    public long getOrigin_ID() {
        return Origin_ID;
    }

    public void setOrigin_ID(long origin_ID) {
        Origin_ID = origin_ID;
    }

    public long getDestination_ID() {
        return Destination_ID;
    }

    public void setDestination_ID(long destination_ID) {
        Destination_ID = destination_ID;
    }
}
