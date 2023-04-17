/*
 * 9. Define a class named Student that has as private attributes the name,
 * tel. number and average mark (constructors, setters, getters). In the main
 * method create a uni-dimensional array of Student objects with the
 * dimension specified by the user. The data corresponding to each object is
 * read from the keyboard, respecting the format name^^^tel. number^^^average
 * mark. If the data specific to the telephone number is not valid (10 numeric
 * characters, with or without special characters like blank, - or .), the
 * user is asked to re-enter the entire array of characters. Display the
 * students ordered by name and by average mark.
 */

import java.util.Scanner;

public class Student {
    String name, telephone;
    float averageMark;

    public Student() {
        this.name = "";
        this.telephone = "";
        this.averageMark = 0f;
    }

    public Student(String name, String telephone, float averageMark) {
        this.name = name;
        if (validateTelephone(telephone))
            this.telephone = telephone;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean setTelephone(String telephone) {
        if (validateTelephone(telephone)) {
            this.telephone = telephone;
            return true;
        } else return false;
    }

    private boolean validateTelephone(String telephone) {
        telephone = telephone.replaceAll("[^0-9]", "");
        return telephone.length() == 10;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }
}

class studentDriver {
    public static void main(String[] args) {
        System.out.print("Enter the number of students you want to input: ");

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if (x < 1) {
            System.err.print("Not enough students!");
            System.exit(1);
        }
        Student[] students = new Student[x];

        for (int i = 0; i < students.length; i++) {
            System.out.printf("Enter student #%d: ", i);
            String read = in.next();
            String[] data = read.split("\\^\\^\\^");

            students[i] = new Student();
            while (!students[i].setTelephone(data[1])) {
                System.out.println("Sorry, re-enter the student data\n");
                data = in.next().split("\\^\\^\\^");
            }
            students[i].setName(data[0]);
            students[i].setAverageMark(Float.parseFloat(data[2]));
        }

        System.out.println("\nStudents sorted by mark:\n");
        sortMark(students);
        printStudents(students);

        System.out.println("\nStudents sorted by name:\n");
        sortName(students);
        printStudents(students);
    }

    public static void sortMark(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++)
                if (students[i].getAverageMark() < students[j].getAverageMark()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
        }
    }

    public static void sortName(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++)
                if (students[i].getName().compareTo(students[j].getName()) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
        }
    }

    public static void printStudents(Student[] students) {
        for (Student i : students) {
            System.out.printf("Name: %s\n", i.getName());
            System.out.printf("Telephone: %s\n", i.getTelephone());
            System.out.printf("Average mark: %f\n\n", i.getAverageMark());
        }
    }
}
