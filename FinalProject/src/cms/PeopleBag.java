package cms;

import java.io.*;
import java.util.ArrayList;

public class PeopleBag {

	public ArrayList<Student> studentArray = new ArrayList<>(0);

    public void addStudent(Student p){
        studentArray.add(p);
    }

    public String displayStudent(){
        return  studentArray.toString();
    }

    public Student findStudent(int id){
        int index = 0;
        for (int i = 0; i < studentArray.size(); i++) {
            if (studentArray.get(i).getStudentId() == id) {
                index = i;
            }
        }
            return studentArray.get(index);
    }

    public void deleteStudent(int id){
        int index = 0;
        for (int i = 0; i <  studentArray.size(); i++) {
            if( studentArray.get(i).getStudentId() == id){
                index = i;
            }
            studentArray.remove(index);
        }
    }

    public void loadStudent(String file) {
        //String firstName, String lastName, String phnNbr, Address address, double gpa, String major, Course[] cTaken, Course[] cTaking, Course[] cNeeded,
        //double currentCredits
        FileReader fopen;
        BufferedReader opened;
        String line;

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (objectInputStream.readObject() != null) {
                String fName = (String) objectInputStream.readObject();
                String lName = (String) objectInputStream.readObject();
                String phnNbr = (String) objectInputStream.readObject();
                Address address = (Address) objectInputStream.readObject();
                double gpa = (double) objectInputStream.readObject();
                String major = (String) objectInputStream.readObject();
                ArrayList cTaken = (ArrayList) objectInputStream.readObject();
                ArrayList cTaking = (ArrayList) objectInputStream.readObject();
                ArrayList cNeeded = (ArrayList) objectInputStream.readObject();
                double credits = (double) objectInputStream.readObject();
                Student student = new Student(fName, lName, phnNbr, address, gpa, major, cTaken, cTaking, cNeeded, credits);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Person> facultyArray = new ArrayList<>();

    public void addFaculty(Person p){
        facultyArray.add(p);
    }

    public String displayFaculty(){
        return  facultyArray.toString();
    }

    public Person findFaculty(int id){
        int index = 0;
        for (int i = 0; i <  facultyArray.size(); i++) {
            if( facultyArray.get(i).getId() == id){
                index = i;
            }
        }
        return  facultyArray.get(index);
    }

    public void deleteFaculty(int id){
        int index = 0;
        for (int i = 0; i <  facultyArray.size(); i++) {
            if( facultyArray.get(i).getId() == id){
                index = i;
            }
            facultyArray.remove(index);
        }
    }

    public void loadFaculty(String file) {
        //String firstName, String lastName, String phnNbr, Address homeAddress, Address officeAddress, String title,
       // String department, int payScale
        FileReader fopen;
        BufferedReader opened;
        String line;

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (objectInputStream.readObject() != null) {
                String fName = (String) objectInputStream.readObject();
                String lName = (String) objectInputStream.readObject();
                String phnNbr = (String) objectInputStream.readObject();
                Address address = (Address) objectInputStream.readObject();
                Address officeAddress = (Address) objectInputStream.readObject();
                String title = (String) objectInputStream.readObject();
                String department = (String) objectInputStream.readObject();
                int payScale = (int) objectInputStream.readObject();
                new Faculty(fName, lName, phnNbr, address, officeAddress, title, department, payScale);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    }

    class InvalidIdException extends Exception{
        InvalidIdException(String s) {
            super(s);
        }
    }



