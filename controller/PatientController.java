package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.DB;
import model.Patient;

public class PatientController implements Initializable{

	
	@FXML JFXListView<Patient> list;
	
	@FXML
    TextField txtId;
	
	@FXML
    TextField txtGender;
	
	@FXML
    TextField txtName;
	
	@FXML
    TextField txtBloodGroup;
	
	List<Patient> list2 = null;
	@FXML
	public void createDatabase() {
		System.out.println("Create");
		DB.createDatabase();
	}
	
	@FXML
	public void populateTableAsset() {
		System.out.println("populate");
		DB.createTable();
		list2 = DB.getPatients();
		populateListView(list2);
	}
	
	private void populateListView(List<Patient> list2) {
		
		ObservableList<Patient> patientData = FXCollections.observableArrayList();

        if(list2 != null) {
        	for (int i = 0; i < list2.size();i++){
                patientData.add(list2.get(i));
            }	
        }
        this.list.setItems(patientData);
	}
	
	@FXML
	public void filterResults() {
		
		List<Patient> patients = DB.getPatients();
		
		Predicate<Patient> byId = null;
		Predicate<Patient> byName = null;
		Predicate<Patient> byGender = null;
		Predicate<Patient> byBlood = null;
		
		if (txtId.getText() != null && !txtId.getText().equals("")) {
			byId  = patient -> patient.getUuid() == Integer.parseInt(txtId.getText());
		}
		
		if (txtName.getText() != null && !txtName.getText().equals("")) {
			byName  = patient -> patient.getName().contains(txtName.getText());
		}

		if (txtGender.getText() != null && !txtGender.getText().equals("")) {
			byGender  = patient -> patient.getGender().contains(txtGender.getText());
		}
		
		if (txtBloodGroup.getText() != null && !txtBloodGroup.getText().equals("")) {
			byBlood  = patient -> patient.getBlood_type().contains(txtBloodGroup.getText());
		}
		
		if( byId != null) {
	        patients = patients.stream().filter(byId).collect(Collectors.toList());
		}
		if( byName != null) {
	        patients = patients.stream().filter(byName).collect(Collectors.toList());
		}
		if( byGender != null) {
	        patients = patients.stream().filter(byGender).collect(Collectors.toList());
		}
		if( byBlood != null) {
	        patients = patients.stream().filter(byBlood).collect(Collectors.toList());
		}
		
		populateListView(patients);
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list2 = DB.getPatients();
		populateListView(list2);
	}

}
