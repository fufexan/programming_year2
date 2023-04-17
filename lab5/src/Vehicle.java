/*
 * 7. Define a class called Vehicle which has as attributes the maximum number
 * of passengers, its color and the maximum speed. Extend the Vehicle class
 * within the MotorizedVehicle class which also includes the geolocation
 * attributes (GPS coordinates – create a class for this type of object GeoLoc)
 * and the moving speed of the vehicle. MotorizedVehicle can move from point A
 * to point B (the points are specified using a Point object which has two
 * GeoLoc attributes) by using the move(Point B) method and which returns the
 * total duration of the trip. Create a new class called Airplane which extends
 * the MotorizedVehicle class and which add the attribute altitude to the
 * move(Point B) method. This method will return the time needed to take the
 * trip by taking into account that the plane will travel on arc of a circle
 * specified through points A and B and the maximum altitude reached by the
 * plane (the maximum altitude is reached half-way between A and B).
 */

import java.util.HashMap;
import java.util.Map;

public class Vehicle {
    int maxPassengers, maxSpeed;
    String color;
}

class MotorizedVehicle extends Vehicle {
    GeoLoc location;
    float currentSpeed;

    public double move(Point b) {
        // use Pythagoras' theorem for computing the distance
        double distance = Math.sqrt(Math.pow(b.lonA() - b.lonB(), 2) + Math.pow(b.latA() - b.latB(), 2));

        return distance * GeoLoc.distancePerDegree / currentSpeed;
    }
}

class Airplane extends MotorizedVehicle {
    float altitude;

    @Override
    public double move(Point b) {
        double latA = Math.toRadians(b.latA());
        double latB = Math.toRadians(b.latB());
        double lonA = Math.toRadians(b.lonA());
        double lonB = Math.toRadians(b.lonB());
        double latM = Math.toRadians((latA + latB) / 2);
        double lonM = Math.toRadians((lonA + lonB) / 2);

        double distance = GeoLoc.earthRadius * Math.acos(Math.sin(latA) * Math.sin(latB) + Math.cos(latA) * Math.cos(latB) * Math.cos(lonB - lonA));
        double firstHalf = distance / 2;
        double horizontalFirstHalf = GeoLoc.earthRadius * Math.acos(Math.sin(latA) * Math.sin(latM) +
                Math.cos(latA) * Math.cos(latM) * Math.cos(lonM - lonA));
        double theta = Math.atan(altitude / 2);
        double height = firstHalf * Math.tan(theta);
        double distanceAtMaxHeight = Math.sqrt(Math.pow(firstHalf, 2) - Math.pow(height, 2));

        return (distanceAtMaxHeight + 2 * (horizontalFirstHalf - distanceAtMaxHeight)) / currentSpeed;
    }
}

class GeoLoc {
    final static int earthRadius = 6371000;
    final static int distancePerDegree = 111;
    Map<String, Float> loc;

    public GeoLoc() {
        this.loc = new HashMap<>();
        this.loc.put("longitude", 0f);
        this.loc.put("latitude", 0f);
    }

    public GeoLoc(float lon, float lat) {
        this.loc = new HashMap<>();
        this.loc.put("longitude", lon);
        this.loc.put("latitude", lat);
    }

    public void setLoc(float lon, float lat) {
        this.loc.replace("longitude", lon);
        this.loc.replace("latitude", lat);
    }

    public float getLon() {
        return this.loc.get("longitude");
    }

    public float getLat() {
        return this.loc.get("latitude");
    }

    public Map<String, Float> getLoc() {
        return loc;
    }
}

class Point {
    public GeoLoc a, b;

    public Point() {
        this.a = new GeoLoc();
        this.b = new GeoLoc();
    }

    public float latA() {
        return this.a.getLat();
    }

    public float latB() {
        return this.b.getLat();
    }

    public float lonA() {
        return this.a.getLon();
    }

    public float lonB() {
        return this.b.getLon();
    }

    public Point(GeoLoc a, GeoLoc b) {
        this.a = a;
        this.b = b;
    }
}
