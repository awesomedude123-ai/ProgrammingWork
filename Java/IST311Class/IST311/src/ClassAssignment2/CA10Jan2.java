package ClassAssignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class CA10Jan2 {
    public static void main(String[] args) {

        Scanner oldScanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = oldScanner.nextLine();
        System.out.println("Enter your collegeId:");
        String collegeId = oldScanner.nextLine();
        System.out.println("Enter semester you are being addmitted in:");
        String admitSem =oldScanner.nextLine();
        Student student = new Student(name, collegeId,admitSem);
        System.out.println(student.getName());
        System.out.println(student.getCollegeId());
        System.out.println(student.getAdmitSem());
        System.out.println(student.getId());

        Course course1 = new Course("Alegbra","FA202201");
        Course course2 = new Course("English","FA202201");
        student.registerCourses(course1);
        student.registerCourses(course2);
        student.listOfCourses();
        student.unregisterCourses(course1);
        student.listOfCourses();

        System.out.println("\nLessons/Assignments.........");
        ArrayList<CourseModule> courseModules = new ArrayList<CourseModule>();
        Lesson lesson = new Lesson(1,"Lesson 1", "this lesson is about algebra");
        Assignment assignment = new Assignment(1,"Assignment 1", "This assignment is about algebra", 10, 8);
        courseModules.add(lesson);
        courseModules.add(assignment);
        for(CourseModule module : courseModules){
            module.contentBeViewed();
            module.toBeGraded();
            System.out.println(module.toString());
        }

    }
}


