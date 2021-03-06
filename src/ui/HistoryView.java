package ui;

import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the history of a Counter. This has only
 * one component (but you can add more components), so write it in code instead
 * of FXML.
 * 
 * @author Vichaphol Thamsuthikul
 *
 */
public class HistoryView implements java.util.Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a counter to show value of */
	private NumberGame game;
	/** the label that shows the counter value. */
	private Label label;
	/** message set to label*/
	private String message = "";

	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * 
	 * @param counter
	 *            the Counter to show.
	 */
	public HistoryView(NumberGame game) {
		this.game = game;
		initComponents();
	}

	private void initComponents() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		label.setPrefWidth(400);
		label.setPrefHeight(250);
		label.setFont(new Font("Arial", 20.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("History");
		stage.sizeToScene();
	}

	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayCount();
	}

	public void displayCount() {
		message = message.concat("\n" + game.getMessage());
		label.setText(String.format("%s", message));
	}

	@Override
	public void update(Observable o, Object arg) {
		displayCount();
	}
}
