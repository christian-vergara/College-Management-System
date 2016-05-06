package cms;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by chris on 4/28/2016.
 */
public class MasterCourseBag {

    ArrayList<Course> courseBag = new ArrayList<>();

    public void add(Course course){
        courseBag.add(course);
    }

    public void display(){
        courseBag.toString();
    }

    public void delete(String crsNbr) {
        int index = 0;
        for(int i = 0; i < courseBag.size(); i++) {
            if(crsNbr.equalsIgnoreCase(courseBag.get(i).getCrsNbr())){
                index = i;
            }
        }
        courseBag.remove(index);
    }

    public Course find(String crsNbr) {
        int index = 0;
        for(int i = 0; i < courseBag.size(); i++) {
            if(crsNbr.equalsIgnoreCase(courseBag.get(i).getCrsNbr())){
                index = i;
            }
        }
        return courseBag.get(index);
    }

    public void loadCourse(String file) {
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
