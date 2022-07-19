package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerTM;

import java.util.Optional;
import java.util.concurrent.LinkedTransferQueue;

public class TableFormController {
    public TableView<CustomerTM> tblCustomer;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSave;
    public Button btnNew;
    public Button btnDelete;

    public void initialize(){
        btnDelete.setDisable(true);
        //tblCustomer.getSelectionModel().selectedItemProperty().addListener(new );

        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<CustomerTM> olCustomer = tblCustomer.getItems();
                CustomerTM selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();

                //if (selectedCustomer == null) return;


                Optional<ButtonType> selectedOption = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this customer", ButtonType.YES, ButtonType.NO).showAndWait();

                if (selectedOption.get()==ButtonType.YES) {

                    olCustomer.remove(selectedCustomer);
                }
                //CustomerTM selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();
                //int selectedIndex = tblCustomer.getSelectionModel().getSelectedIndex();


            }
        });

        tblCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observableValue, CustomerTM previousSelecCustomer, CustomerTM currentlySelectedCustomer) {
                if (currentlySelectedCustomer==null) {
                    btnDelete.setDisable(true);
                    txtId.clear();
                    txtName.clear();
                    txtAddress.clear();
                    txtId.setEditable(true);
                    btnSave.setText("Save Customer");
                    return;
                }

                btnDelete.setDisable(false);
              txtId.setText (currentlySelectedCustomer.getId());
                //txtId.setDisable(true);
                txtId.setEditable(false);
              txtName.setText (currentlySelectedCustomer.getName());
              txtAddress.setText (currentlySelectedCustomer.getAddress());

              btnSave.setText("Update Customer");
            }
        });


        //Lets map colum name
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<CustomerTM> olCustomer= tblCustomer.getItems();
        CustomerTM c001=  new CustomerTM("C001","Kasun", "Panadura");
        CustomerTM c002=  new CustomerTM("C002","Dasun", "Moratuwa");
        CustomerTM c003=  new CustomerTM("C003","Thisun", "Galle");

        olCustomer.add(c001);
        olCustomer.add(c002);
        olCustomer.add(c003);

        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                ObservableList<CustomerTM> olCustomers = tblCustomer.getItems();
                String id =txtId.getText();
                String name =txtName.getText();
                String address =txtAddress.getText();

                if (id.isBlank()){
                    new Alert(Alert.AlertType.ERROR, "Customer Id can't be empty").showAndWait();
                    txtId.requestFocus();
                    return;
                } else if (name.isBlank()) {
                    new Alert(Alert.AlertType.ERROR, "Customer Name can't be empty").showAndWait();
                    txtName.requestFocus();
                    return;
                } else if (address.isBlank()) {
                    new Alert(Alert.AlertType.ERROR, "Customer Address can't be empty").showAndWait();
                    txtAddress.requestFocus();
                    return;
                }
                for (CustomerTM customer : olCustomers) {
                    if (customer.getId().equals(id)){
                        new Alert(Alert.AlertType.ERROR, "Duplicate Customer id").showAndWait();
                        txtId.requestFocus();
                        return;
                    }
                }

                CustomerTM newCustomer = new CustomerTM(id,name,address);
                olCustomers.add(newCustomer);

                txtId.clear();
                txtName.clear();
                txtAddress.clear();

                txtId.requestFocus();
            }
        });

        btnNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tblCustomer.getSelectionModel().clearSelection();
                //txtId.clear();
                //txtName.clear();
                //txtAddress.clear();
                txtId.requestFocus();

            }
        });


    }
}
