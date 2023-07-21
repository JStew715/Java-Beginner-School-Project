/******************************************************************************************
* Homework 19
* Author: Javon Stewart
* Project Purpose: Select all the options wanted for a cell phone plan and present the price
* Input: Selecting options from the menus
* Desired Output: The price for each, and the total price displayed
* Variables and Classes: There is one main method
* Testing: When the program is run and the options are selected, the price of each and totals are given
* April 25, 2023
**********************************************************************************************/

package Stewart.mycompany;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    
    //setting the tax rate, replacement insurance price, and wifi price
    private static final double TAX_RATE = 0.06;
    private static final double PHONE_REPLACEMENT_INSURANCE_PRICE = 5.00;
    private static final double WIFI_HOTSPOT_CAPABILITY_PRICE = 10.00;

    //making the data plan, phone, and options price doubles
    private double dataPlanPrice = 0.0;
    private double phonePrice = 0.0;
    private double optionsPrice = 0.0;

    //making labels for each
    private Label dataPlanPriceLabel;
    private Label phonePriceLabel;
    private Label optionsPriceLabel;
    private Label totalPriceLabel;

    @Override
    public void start(Stage primaryStage) {
        
        // Creating the data plan menu
        Menu dataPlanMenu = new Menu("Data Plans");
        MenuItem plan1Item = new MenuItem("8 gigabytes per month: $45.00 per month");
        plan1Item.setOnAction(event -> setDataPlanPrice(45.0));
        MenuItem plan2Item = new MenuItem("16 gigabytes per month: $65.00 per month");
        plan2Item.setOnAction(event -> setDataPlanPrice(65.0));
        MenuItem plan3Item = new MenuItem("20 gigabytes per month: $99.00 per month");
        plan3Item.setOnAction(event -> setDataPlanPrice(99.0));
        dataPlanMenu.getItems().addAll(plan1Item, plan2Item, plan3Item);

        // Creating the phone menu
        Menu phoneMenu = new Menu("Phones");
        MenuItem phone1Item = new MenuItem("Model 100: $299.95");
        phone1Item.setOnAction(event -> setPhonePrice(299.95));
        MenuItem phone2Item = new MenuItem("Model 110: $399.95");
        phone2Item.setOnAction(event -> setPhonePrice(399.95));
        MenuItem phone3Item = new MenuItem("Model 200: $499.95");
        phone3Item.setOnAction(event -> setPhonePrice(499.95));
        phoneMenu.getItems().addAll(phone1Item, phone2Item, phone3Item);

        // Creating the options menu
        Menu optionsMenu = new Menu("Options");
        MenuItem insuranceItem = new MenuItem("Phone Replacement Insurance: $5.00 per month");
        insuranceItem.setOnAction(event -> setOptionsPrice(PHONE_REPLACEMENT_INSURANCE_PRICE));
        MenuItem hotspotItem = new MenuItem("WiFi Hotspot Capability: $10.00 per month");
        hotspotItem.setOnAction(event -> setOptionsPrice(WIFI_HOTSPOT_CAPABILITY_PRICE));
        optionsMenu.getItems().addAll(insuranceItem, hotspotItem);

        // Creating the menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(dataPlanMenu, phoneMenu, optionsMenu);

        // Creating the labels
        dataPlanPriceLabel = new Label();
        phonePriceLabel = new Label();
        optionsPriceLabel = new Label();
        totalPriceLabel = new Label();

        // Creating the layout
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(menuBar, dataPlanPriceLabel, phonePriceLabel, optionsPriceLabel, totalPriceLabel);

        // Making the scene
        Scene scene = new Scene(root, 400, 300);

        // Creating the stage
        primaryStage.setTitle("Cell Phone Packages");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setDataPlanPrice(double price) {
        
        //Adding the data plan price, and making all phone options usable for updatetotalprice
        dataPlanPrice = price;
        dataPlanPriceLabel.setText("Data Plan: $" + String.format("%.2f", dataPlanPrice));
        updateTotalPrice();
}
        //Adding the phone price
    private void setPhonePrice(double price) {
        phonePrice = price * (1 + TAX_RATE);
        phonePriceLabel.setText("Phone: $" + String.format("%.2f", phonePrice));
        updateTotalPrice();
}
        //Adding the options price
    private void setOptionsPrice(double price) {
        optionsPrice += price;
        optionsPriceLabel.setText("Options: $" + String.format("%.2f", optionsPrice));
        updateTotalPrice();
}
        //Getting the total for all options
    private void updateTotalPrice() {
        double totalPrice = dataPlanPrice + phonePrice + optionsPrice;
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
}

    public static void main(String[] args) {
        launch(args);
}
    }