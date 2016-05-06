package gui;

import cms.Address;
import cms.Student;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import java.util.Optional;

/**
 * Created by chris on 4/28/2016.
 */
public class MainStage extends Application implements PeopleScenes {

    private static Student searchStudent;
    private static Student deleteStudent;
    private static BorderPane root = new BorderPane();
    Address a = new Address("Street", "City", "State", 11792);
    Student student = new Student("First", "Last", "6312736457", a, 3.0, "Info Tech", 22.0);

    public static Student getDeleteStudent() {
        return deleteStudent;
    }

    public static void setDeleteStudent(Student deleteStudent) {
        MainStage.deleteStudent = deleteStudent;
    }

    public static Student getSearchStudent() {
        return searchStudent;
    }

    public static void setSearchStudent(Student searchStudent) {
        MainStage.searchStudent = searchStudent;
    }

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(javafx.stage.Stage stage) throws Exception {
        // TODO Auto-generated method stub
        stage.setTitle("College Management System");
        stage.getIcons().add(new Image("http://preview.turbosquid.com/Preview/2014/05/24__00_33_08/graduationcap.png6b00604c-93dd-4084-a082-5f3d7737e086Original.jpg"));


        Scene scene = new Scene(root, 1280, 720);

        Label label1 = new Label("College Management System");
        label1.setFont(new Font("Arial", 36));

        Reflection refl = new Reflection();
        refl.setFraction(0.8f);
        label1.setEffect(refl);

        root.setCenter(label1);

        // Menu Bar
        MenuBar menuBar = new MenuBar();
        //Binds menuBar width to the width of the stage. Will scale with the stage when expanded.
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.setTop(menuBar);

        // Menus
        Menu fileMenu = new Menu("_File");
        fileMenu.setMnemonicParsing(true);
        //Menu Items
        Menu loadMenu = new Menu("Load");
        MenuItem loadStudents = new MenuItem("Students");
        MenuItem loadFaculty = new MenuItem("Faculty");
        MenuItem loadTextbooks = new MenuItem("Textbooks");
        MenuItem loadCourses = new MenuItem("Courses");
        loadMenu.getItems().addAll(loadStudents, loadFaculty, loadTextbooks, loadCourses);

        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        // Sets exitMenuItem to exit program on action
        exitMenuItem.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Do you want to exit the " +
                    "application?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
                Platform.exit();

        });


        // Adds menu items to the menu, also creates separator within the menu
        fileMenu.getItems().addAll(saveMenuItem, loadMenu, new SeparatorMenuItem(), exitMenuItem);

        // Create camera menu
        Menu studentMenu = new Menu("Student");

        MenuItem addStudent = new MenuItem("Add Student");
        MenuItem findStudent = new MenuItem("Find/Update Student");
        MenuItem deleteStudent = new MenuItem("Delete Student");

        // Add Student Handler
        addStudent.setOnAction(e -> {
            root.setCenter(PeopleScenes.setAddStudentPane());
        });


        // FindStudent Handler
        findStudent.setOnAction(e -> {
//            TextInputDialog dialog = new TextInputDialog();
//            dialog.setTitle("Find by ID");
//            dialog.setHeaderText("Student Lookup");
//            dialog.setContentText("Please enter the student's ID:");
//            dialog.showAndWait();
//            try {
//                testId(pb.findStudent(Integer.parseInt(dialog.getResult())), dialog.getResult());
//                setSearchStudent(pb.findStudent(Integer.parseInt(dialog.getResult())));
//                root.setCenter(PeopleScenes.setFindStudentPane());
//            } catch (InvalidIdException ex) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Invalid ID!");
//                alert.setContentText("Student with ID (" + dialog.getResult() + ") does not exist!");
//                alert.showAndWait();
//                ex.printStackTrace();
//            }

            // temp for editing
            setSearchStudent(student);
            root.setCenter(PeopleScenes.setFindStudentPane());
        });

        //DeleteStudent Handler
        deleteStudent.setOnAction(e -> {
//            TextInputDialog dialog = new TextInputDialog();
//            dialog.setTitle("Find by ID");
//            dialog.setHeaderText("Student Lookup");
//            dialog.setContentText("Please enter the student's ID:");
//            dialog.showAndWait();
//            try {
//                testId(pb.findStudent(Integer.parseInt(dialog.getResult())), dialog.getResult());
//                setDeleteStudent(pb.findStudent(Integer.parseInt(dialog.getResult())));
//                root.setCenter(PeopleScenes.setDeleteStudentPane());
//            } catch (InvalidIdException ex) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Invalid ID!");
//                alert.setContentText("Student with ID (" + dialog.getResult() + ") does not exist!");
//                alert.showAndWait();
//                ex.printStackTrace();
//            }

            //editing
            setDeleteStudent(student);
            root.setCenter(PeopleScenes.setDeleteStudentPane());
        });



        studentMenu.getItems().addAll(findStudent, addStudent, new SeparatorMenuItem(), deleteStudent);

        Menu facultyMenu = new Menu("Faculty");

        MenuItem addFacultyMember = new MenuItem("Add Faculty Member");
        MenuItem findFacultyMember = new MenuItem("Find/Update Faculty Member");
        MenuItem deleteFacultyMember = new MenuItem("Delete Faculty Member");

        facultyMenu.getItems().addAll(findFacultyMember, addFacultyMember, new SeparatorMenuItem(), deleteFacultyMember);


        Menu textbookMenu = new Menu("Textbook");

        MenuItem newTextbook = new MenuItem("New Textbook");
        MenuItem findTextbook = new MenuItem("Find/Update Textbook");
        MenuItem removeTextBook = new MenuItem("Remove Textbook");

        textbookMenu.getItems().addAll(findTextbook, newTextbook, new SeparatorMenuItem(), removeTextBook);

        Menu courseMenu = new Menu("Courses");

        MenuItem createCourse = new MenuItem("Create New Course");
        MenuItem findCourse = new MenuItem("Find/Update Course");
        MenuItem removeCourse = new MenuItem("Remove Course");

        courseMenu.getItems().addAll(findCourse, createCourse, new SeparatorMenuItem(), removeCourse);


        // Adds Menus to menu bar
        menuBar.getMenus().addAll(fileMenu, studentMenu, facultyMenu, textbookMenu, courseMenu);

        stage.setScene(scene);
        stage.show();
    }


    static void testId (Student enteredStudent, String enteredId) throws InvalidIdException {
            if (enteredStudent.getStudentId() != Integer.parseInt(enteredId))
                throw new InvalidIdException("ID Invalid! Doesn't exist!");
            else
                System.out.println("Id Valid!");

        }

    static BorderPane getRoot() {
        return root;
    }
    }


