/*
 * 4. Develop a Java program which defines a class named Person that contains
 * as private attributes: name (String), latitude and longitude (float). The
 * class contains an explicit constructor without parameters that will
 * initialize the latitude and longitude with 0 and the string with null. A
 * finalize() method will be used as a destructor from C++ and will display a
 * message. The mutator methods, setName(), setLongitude() and setLatitude()
 * will be defined to modify the attributes of the class. Define appropriate
 * accessor methods. Instantiate n objects, read the corresponding data from
 * the keyboard and display the information related to all the objects.
 */

import java.util.Scanner;

public class Person {
    String name;
    float latitude, longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    Person() {
        name = null;
        latitude = 0;
        longitude = 0;
    }

    @Override
    protected void finalize() {
        System.err.println("Destroying Person object!");
    }
}

class PersonDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Person p1 = new Person();
        System.out.print("Enter the name of the first person: ");
        p1.setName(in.next());
        System.out.print("Enter the longitude and latitude of the person: ");
        p1.setLongitude(in.nextFloat());
        p1.setLatitude(in.nextFloat());

        System.out.println("The properties of the first person are:");
        displayPerson(p1);
        p1.finalize();

        Person p2 = new Person();
        System.out.print("Enter the name of the second person: ");
        p2.setName(in.next());
        System.out.print("Enter the longitude and latitude of the person: ");
        p2.setLongitude(in.nextFloat());
        p2.setLatitude(in.nextFloat());

        System.out.println("The properties of the second person are:");
        displayPerson(p2);
        p2.finalize();
    }

    public static void displayPerson(Person p) {
        System.out.printf("Name: %s\n", p.getName());
        System.out.printf("Longitude & latitude: %f %f\n", p.getLongitude(), p.getLatitude());
    }
}
