package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import model.IllegalBillAmountException;
import model.IllegalTipRateException;
import model.TipCalculator;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class TipCalculatorDriver extends Application {
	TipCalculator tipCalculator;
	Label titleLabel;
	TextField billText, tipText, tipTotalText, totalText;
	
	@Override
	public void start(Stage primaryStage) {		
		GridPane root = new GridPane();
		tipCalculator = new TipCalculator();
		
		titleLabel = new Label("TIP CALCULATOR");
		titleLabel.setId("titleLabel");
		GridPane.setHalignment(titleLabel, HPos.CENTER);
		
		billText = new TextField("ENTER BILL AMOUNT");
		tipText = new TextField("ENTER TIP RATE (%)");
		tipTotalText = new TextField("TOTAL TIP");
		totalText = new TextField("TOTAL BILL");
		tipTotalText.setEditable(false);
		totalText.setEditable(false);
		
		Button btn = new Button("CALCULATE");
		btn.setId("btn");
		GridPane.setHalignment(btn, HPos.CENTER);
		btn.setMaxWidth(Double.MAX_VALUE);
		while (!(billText.getText().equals("ENTER BILL AMOUNT"))) {
			btn.setText("CLEAR");
			btn.setStyle("-fx-background-color: #d93645");
		}
		btn.setOnAction(new ButtonHandler());
		
		
		root.add(titleLabel, 0, 0);
		root.add(billText, 0, 1);
		root.add(tipText, 0, 2);
		root.add(btn, 0, 3);
		root.add(tipTotalText, 0, 4);
		root.add(totalText, 0, 5);
		
		Scene scene = new Scene(root,600,400);
		try {
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		} catch (Exception e) {
			e.printStackTrace();
		}
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			double billAmount = 0, rate = 0;
			try {
				billAmount = Double.parseDouble(billText.getText());
				rate = Double.parseDouble(tipText.getText());
				tipCalculator.setBillAmount(billAmount);
				tipCalculator.setTipRate(rate);
			} catch (NumberFormatException | IllegalBillAmountException | IllegalTipRateException exception) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("Sorry, there has been an error.");
				alert.setContentText("Bill amount must be greater than $0.00 and the tip rate must be greater than 5%.");
				alert.showAndWait();
			}
			billText.setText(TipCalculator.format(billAmount));
			tipText.setText((int)rate + "%");
			tipCalculator.calculate();
			tipTotalText.setText(TipCalculator.format(tipCalculator.getTipAmount()));
			totalText.setText(TipCalculator.format(tipCalculator.getTotal()));
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
