package gui;

import cms.Address;
import cms.PeopleBag;
import cms.Person;
import cms.Student;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Optional;

/**
 * Created by chris on 5/3/2016.
 */
public interface PeopleScenes {

    PeopleBag pb = new PeopleBag();

    static GridPane setFindStudentPane() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(15);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column1);

        Text addStudentText = new Text("Student: ");
        addStudentText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        grid.add(addStudentText, 0, 0, 2, 1);

        Label fNameLabel = new Label("First Name");
        TextField fNameField = new TextField(MainStage.getSearchStudent().getFirstName());
        grid.add(fNameLabel, 0, 1);
        grid.add(fNameField, 1, 1);

        Label lNameLabel = new Label("Last Name");
        TextField lNameField = new TextField(MainStage.getSearchStudent().getLastName());
        grid.add(lNameLabel, 0, 2);
        grid.add(lNameField, 1, 2);

        Label idLabel = new Label("Student ID");
        TextField idField = new TextField(Integer.toString(MainStage.getSearchStudent().getStudentId()));
        idField.setPromptText("Enter ID to search for");
        grid.add(idLabel, 0, 3);
        grid.add(idField, 1, 3);


        Label phnLabel = new Label("Phone Number");
        TextField phnField = new TextField(MainStage.getSearchStudent().getPhnNbr());
        phnField.setPromptText("e.g. 5551234567");
        grid.add(phnLabel, 0, 4);
        grid.add(phnField, 1, 4);

        Label streetLabel = new Label("Street");
        TextField streetField = new TextField(MainStage.getSearchStudent().getAddress().getStreet());
        grid.add(streetLabel, 0, 5);
        grid.add(streetField, 1, 5);

        Label cityLabel = new Label("City");
        TextField cityField = new TextField(MainStage.getSearchStudent().getAddress().getCity());
        grid.add(cityLabel, 0, 6);
        grid.add(cityField, 1, 6);

        Label stateLabel = new Label("State");
        TextField stateField = new TextField(MainStage.getSearchStudent().getAddress().getState());
        grid.add(stateLabel, 0, 7);
        grid.add(stateField, 1 ,7);

        Label zipLabel = new Label("Zip Code");
        TextField zipField = new TextField(Integer.toString(MainStage.getSearchStudent().getAddress().getZip()));
        grid.add(zipLabel, 0, 8);
        grid.add(zipField, 1, 8);

        Label gpaLabel = new Label("GPA");
        TextField gpaField = new TextField(Double.toString(MainStage.getSearchStudent().getGpa()));
        grid.add(gpaLabel, 0, 9);
        grid.add(gpaField, 1, 9);

        Label majorLabel = new Label("Major");
        TextField majorField = new TextField(MainStage.getSearchStudent().getMajor());
        grid.add(majorLabel, 0, 10);
        grid.add(majorField, 1, 10);

        Label credLabel = new Label("Credits");
        TextField credField = new TextField(Double.toString(MainStage.getSearchStudent().getCurrentCredits()));
        grid.add(credLabel, 0, 11);
        grid.add(credField, 1, 11);

        Label crsTakingLabel = new Label("Courses Taking");
        TextArea crsTakingField = new TextArea();
        crsTakingField.setPrefRowCount(3);
        grid.add(crsTakingLabel, 2, 1);
        grid.add(crsTakingField, 3, 1, 4, 3);

        Label crsTakenLabel = new Label("Courses Taken");
        TextArea crsTakenField = new TextArea();
        crsTakenField.setPrefRowCount(3);
        grid.add(crsTakenLabel, 2, 4);
        grid.add(crsTakenField, 3, 4, 4, 3);

        Label crsNeededLabel = new Label("Courses Needed");
        TextArea crsNeededField = new TextArea();
        crsNeededField.setPrefRowCount(3);
        grid.add(crsNeededLabel, 2, 7);
        grid.add(crsNeededField, 3, 7, 4, 3);

        Button updateButton = new Button("Update");
        grid.add(updateButton, 0, 12, 1, 1);
        updateButton.setOnAction(e -> {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Student?");
            alert.setContentText("Would you like to update this student?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                MainStage.getSearchStudent().setFirstName(fNameField.getText());
                MainStage.getSearchStudent().setLastName(lNameField.getText());
                MainStage.getSearchStudent().setPhnNbr(phnField.getText());
                MainStage.getSearchStudent().setGpa(Double.parseDouble(gpaField.getText()));
                MainStage.getSearchStudent().setMajor(majorField.getText());
                MainStage.getSearchStudent().setCurrentCredits(Double.parseDouble(credField.getText()));
                System.out.println("Student Updated!");
                updateButton.setText("Updated!");
           }
        });

        return grid;
    }

    static GridPane setAddStudentPane() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(15);


        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column1);


        Text addStudentText = new Text("Add Student: ");
        addStudentText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        grid.add(addStudentText, 0, 0, 4, 1);


        Label fNameLabel = new Label("First Name");
        TextField fNameField = new TextField();
        grid.add(fNameLabel, 0, 1);
        grid.add(fNameField, 1, 1);

        Label lNameLabel = new Label("Last Name");
        TextField lNameField = new TextField();
        grid.add(lNameLabel, 0, 2);
        grid.add(lNameField, 1, 2);

        Label idLabel = new Label("Student ID");
        TextField idField = new TextField(Integer.toString(Person.getId() + 1) + " (Auto Generated)");
        idField.setEditable(false);
        grid.add(idLabel, 0, 3);
        grid.add(idField, 1, 3);

        Label phnLabel = new Label("Phone Number");
        TextField phnField = new TextField();
        phnField.setPromptText("e.g. 5551234567");
        grid.add(phnLabel, 0, 4);
        grid.add(phnField, 1, 4);

        Label streetLabel = new Label("Street");
        TextField streetField = new TextField();
        grid.add(streetLabel, 0, 5);
        grid.add(streetField, 1, 5);

        Label cityLabel = new Label("City");
        TextField cityField = new TextField();
        grid.add(cityLabel, 0, 6);
        grid.add(cityField, 1, 6);

        Label stateLabel = new Label("State");
        TextField stateField = new TextField();
        grid.add(stateLabel, 0, 7);
        grid.add(stateField, 1 ,7);

        Label zipLabel = new Label("Zip Code");
        TextField zipField = new TextField();
        grid.add(zipLabel, 0, 8);
        grid.add(zipField, 1, 8);

        Label gpaLabel = new Label("GPA");
        TextField gpaField = new TextField();
        grid.add(gpaLabel, 0, 9);
        grid.add(gpaField, 1, 9);

        Label majorLabel = new Label("Major");
        TextField majorField = new TextField();
        grid.add(majorLabel, 0, 10);
        grid.add(majorField, 1, 10);

        Label credLabel = new Label("Credits");
        TextField credField = new TextField();
        grid.add(credLabel, 0, 11);
        grid.add(credField, 1, 11);

        Button addButton = new Button("Add");
        grid.add(addButton, 0, 12);
        addButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Add Student?");
            alert.setContentText("Would you like to add this student?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                isDouble(gpaField.getText());
                isDouble(credField.getText());
                Student s = new Student (fNameField.getText(), lNameField.getText(), phnField.getText(), new Address(streetField.getText(), cityField.getText(),
                        stateField.getText(), Integer.parseInt(zipField.getText())), Double.parseDouble(gpaField.getText()), majorField.getText(), Double.parseDouble(credField.getText()));
                pb.addStudent(s);
                addButton.setText("Added!");
                System.out.println(pb.displayStudent());
            }
        });

        return grid;

    }

    static GridPane setDeleteStudentPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(15);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column1);

        Text addStudentText = new Text("Delete Student: ");
        addStudentText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        grid.add(addStudentText, 0, 0, 4, 1);

        Label fNameLabel = new Label("First Name");
        TextField fNameField = new TextField(MainStage.getDeleteStudent().getFirstName());
        grid.add(fNameLabel, 0, 1);
        grid.add(fNameField, 1, 1);

        Label lNameLabel = new Label("Last Name");
        TextField lNameField = new TextField(MainStage.getDeleteStudent().getLastName());
        grid.add(lNameLabel, 0, 2);
        grid.add(lNameField, 1, 2);

        Label idLabel = new Label("Student ID");
        TextField idField = new TextField(Integer.toString(MainStage.getDeleteStudent().getStudentId()));
        grid.add(idLabel, 0, 3);
        grid.add(idField, 1, 3);


        Label phnLabel = new Label("Phone Number");
        TextField phnField = new TextField(MainStage.getDeleteStudent().getPhnNbr());
        grid.add(phnLabel, 0, 4);
        grid.add(phnField, 1, 4);

        Label streetLabel = new Label("Street");
        TextField streetField = new TextField(MainStage.getDeleteStudent().getAddress().getStreet());
        grid.add(streetLabel, 0, 5);
        grid.add(streetField, 1, 5);

        Label cityLabel = new Label("City");
        TextField cityField = new TextField(MainStage.getDeleteStudent().getAddress().getCity());
        grid.add(cityLabel, 0, 6);
        grid.add(cityField, 1, 6);

        Label stateLabel = new Label("State");
        TextField stateField = new TextField(MainStage.getDeleteStudent().getAddress().getState());
        grid.add(stateLabel, 0, 7);
        grid.add(stateField, 1 ,7);

        Label zipLabel = new Label("Zip Code");
        TextField zipField = new TextField(Integer.toString(MainStage.getDeleteStudent().getAddress().getZip()));
        grid.add(zipLabel, 0, 8);
        grid.add(zipField, 1, 8);

        Label gpaLabel = new Label("GPA");
        TextField gpaField = new TextField(Double.toString(MainStage.getDeleteStudent().getGpa()));
        grid.add(gpaLabel, 0, 9);
        grid.add(gpaField, 1, 9);

        Label majorLabel = new Label("Major");
        TextField majorField = new TextField(MainStage.getDeleteStudent().getMajor());
        grid.add(majorLabel, 0, 10);
        grid.add(majorField, 1, 10);

        Label credLabel = new Label("Credits");
        TextField credField = new TextField(Double.toString(MainStage.getDeleteStudent().getCurrentCredits()));
        grid.add(credLabel, 0, 11);
        grid.add(credField, 1, 11);

        Label crsTakingLabel = new Label("Courses Taking");
        TextArea crsTakingField = new TextArea();
        crsTakingField.setPrefRowCount(3);
        grid.add(crsTakingLabel, 2, 1);
        grid.add(crsTakingField, 3, 1, 4, 3);

        Label crsTakenLabel = new Label("Courses Taken");
        TextArea crsTakenField = new TextArea();
        crsTakenField.setPrefRowCount(3);
        grid.add(crsTakenLabel, 2, 4);
        grid.add(crsTakenField, 3, 4, 4, 3);

        Label crsNeededLabel = new Label("Courses Needed");
        TextArea crsNeededField = new TextArea();
        crsNeededField.setPrefRowCount(3);
        grid.add(crsNeededLabel, 2, 7);
        grid.add(crsNeededField, 3, 7, 4, 3);

        Button deleteButton = new Button("Delete");
        grid.add(deleteButton, 0, 12, 1, 1);
        deleteButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Student?");
            alert.setContentText("Permanently delete this student?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                pb.deleteStudent(MainStage.getDeleteStudent().getStudentId());
                System.out.println("Student Deleted!");
                deleteButton.setText("Deleted!");
                fNameField.clear();
                lNameField.clear();
                idField.clear();
                phnField.clear();
                streetField.clear();
                cityField.clear();
                stateField.clear();
                zipField.clear();
                gpaField.clear();
                majorField.clear();
                credField.clear();
            }
        });

        return grid;
    }

    static boolean isDouble(String message) {
        try {
            double number = Double.parseDouble(message);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Integer" + message + " not valid!");
            return false;
        }
    }

}

class InvalidIdException extends Exception{

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }



}




