package cms;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by chris on 4/28/2016.
 */
public class CourseBag {

    ArrayList<Course> courseTakenBag = new ArrayList<>();

    public void addTaken(Course course) {
        courseTakenBag.add(course);
    }

    public void displayTaken(){
        courseTakenBag.toString();
    }

    public void deleteTaken(String courseNumber){
        for(int i = 0; i < courseTakenBag.size(); i++) {
            if(courseNumber.equalsIgnoreCase(courseTakenBag.get(i).getCrsNbr())){
                courseTakenBag.remove(i);
            }
        }
    }

    public void loadCourseTaken(String file) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (objectInputStream.readObject() != null) {
                String crsTitle = (String) objectInputStream.readObject();
                String crsNbr = (String) objectInputStream.readObject();
                Textbook t = (Textbook) objectInputStream.readObject();
                Faculty f = (Faculty) objectInputStream.readObject();
                double numCredits = (double) objectInputStream.readObject();
                Course course = new Course(crsTitle, crsNbr, t, f, numCredits);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Course> courseTakingBag = new ArrayList<>();

    public void addTaking(Course course) {
        courseTakingBag.add(course);
    }

    public void displayTaking(){
        courseTakingBag.toString();
    }

    public void deleteTaking(String courseNumber){
        for(int i = 0; i < courseTakingBag.size(); i++) {
            if(courseNumber.equalsIgnoreCase(courseTakingBag.get(i).getCrsNbr())){
                courseTakingBag.remove(i);
            }
        }
    }

    public void loadCourseTaking(String file) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (objectInputStream.readObject() != null) {
                String crsTitle = (String) objectInputStream.readObject();
                String crsNbr = (String) objectInputStream.readObject();
                Textbook t = (Textbook) objectInputStream.readObject();
                Faculty f = (Faculty) objectInputStream.readObject();
                double numCredits = (double) objectInputStream.readObject();
                Course course = new Course(crsTitle, crsNbr, t, f, numCredits);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Course> courseNeededBag = new ArrayList<>();

    public void addNeeded(Course course) {
        courseNeededBag.add(course);
    }

    public void displayNeeded(){
        courseNeededBag.toString();
    }

    public void deleteNeeded(String courseNumber){
        for(int i = 0; i < courseNeededBag.size(); i++) {
            if(courseNumber.equalsIgnoreCase(courseNeededBag.get(i).getCrsNbr())){
                courseNeededBag.remove(i);
            }
        }
    }

    public void loadCourseNeeded(String file) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (objectInputStream.readObject() != null) {
                String crsTitle = (String) objectInputStream.readObject();
                String crsNbr = (String) objectInputStream.readObject();
                Textbook t = (Textbook) objectInputStream.readObject();
                Faculty f = (Faculty) objectInputStream.readObject();
                double numCredits = (double) objectInputStream.readObject();
                Course course = new Course(crsTitle, crsNbr, t, f, numCredits);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }





}


