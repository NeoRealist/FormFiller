package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import by.bobruisk.zhelnov.myproject.mavenproject1.App;
import by.bobruisk.zhelnov.myproject.mavenproject1.helpers.Order;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SearchController extends App {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	public TableView<Order> exampleTable;
	public TableColumn<Order, Integer> orderIdColumn;
	public TableColumn<Order, String> streetColumn;
	public TableColumn<Order, String> cityColumn;
	public TextField searchBox;

	@FXML
	public void initialize() {

//		try {

//			System.out.println(fillWindow.getPatient());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		selectButton.setOnAction(event -> {
//			FXMLLoader fillWindowLoader = new FXMLLoader(App.class.getResource("mainWindow.fxml"), resources);
//			try {
//				FillWindowController fillWindow = fillWindowLoader.load();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});

		orderIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		streetColumn.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

		Order newOrders = new Order();
		List<Order> orders = newOrders.getOrders();

		FilteredList<Order> filteredData = new FilteredList<>(FXCollections.observableList(orders));
		exampleTable.setItems(filteredData);

		exampleTable.setRowFactory(tableView -> {
			TableRow<Order> row = new TableRow<>();
			row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), false);
			row.itemProperty().addListener((obs, oldOrder, newOrder) -> {
				boolean assignClass = filteredData.contains(newOrder)
						&& (newOrder.getCity().equals("New York") || newOrder.getCity().equals("Boston"));

				row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), assignClass);
			});
			return row;
		});

		searchBox.textProperty().addListener(
				(observable, oldValue, newValue) -> exampleTable.setItems(filterList(orders, newValue.toLowerCase())));

		setClickedCell();

	}

	private Predicate<Order> createPredicate(String searchText) {
		return order -> {
			if (searchText == null || searchText.isEmpty())
				return true;
			return searchFindsOrder(order, searchText);
		};
	}

	private ObservableList<Order> filterList(List<Order> list, String searchText) {
		List<Order> filteredList = new ArrayList<>();

		for (Order order : list) {
			if (searchFindsOrder(order, searchText)) {
				filteredList.add(order);
			}
		}
		return FXCollections.observableList(filteredList);
	}

	private boolean searchFindsOrder(Order order, String searchText) {
		return (order.getCity().toLowerCase().contains(searchText))
				|| (order.getStreet().toLowerCase().contains(searchText))
//				|| Integer.valueOf(order.getId()).toString().equals(searchText);
				|| String.valueOf(order.getId()).contains(searchText);
	}

	@FXML
	private void handleExitButtonClicked(ActionEvent event) {
		Platform.exit();
		event.consume();
	}

	@FXML
	private void handleGitButtonClicked(ActionEvent event) {
		new Application() {
			@Override
			public void start(Stage stage) {
			}
		}.getHostServices().showDocument("https://github.com/edencoding/javafx-ui/");
		event.consume();
	}

	public void handleClearSearchText(ActionEvent event) {
		searchBox.setText("");
		event.consume();
	}

	@FXML
	public void outSelectedItem() {
		System.out.println(exampleTable.getSelectionModel().getSelectedItem());

	}

//	@FXML
//	public void clickItem(MouseEvent event) {
//		if (event.getClickCount() == 2) // Checking double click
//		{
//			System.out.println(exampleTable.getSelectionModel().getSelectedItem().getId());
//			System.out.println(exampleTable.getSelectionModel().getSelectedItem().getStreet());
//			System.out.println(exampleTable.getSelectionModel().getSelectedItem().getCity());
//			System.out.println(event);
//		}
//	}

	@FXML
	private Button selectButton;

	public Button getSelectButton() {
		return selectButton;
	}

	public void getSearchBoxText() {

	}

	public static Order selectedOrderRow = null;

	private void setClickedCell() {

		exampleTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {

				if (exampleTable.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel<Order> selectionModel = exampleTable.getSelectionModel();
					ObservableList<?> selectedCells = selectionModel.getSelectedCells();
//					выбрать определённую столбец из выбранной строки
					TablePosition<Object, ?> tablePosition = (TablePosition<Object, ?>) selectedCells.get(0);
					Object val = tablePosition.getTableColumn().getCellData(newValue);
					searchBox.setText(val.toString());
					selectedOrderRow = exampleTable.getItems().get(selectionModel.getSelectedIndex());

					System.out.println(selectedOrderRow);

				}

			}

		});

	}

}