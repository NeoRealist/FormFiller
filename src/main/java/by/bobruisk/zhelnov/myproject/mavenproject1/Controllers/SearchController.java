package by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;

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
		orderIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		streetColumn.setCellValueFactory(cellData -> cellData.getValue().streetProperty());
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());

		List<Order> orders = Order.getOrders();
//		orders.add(new Order(1, "New York", "New York")); // 8,323,340
//		orders.add(new Order(2, "Colorado", "Denver"));
//		orders.add(new Order(3, "Missouri", "Kansas City"));
//		orders.add(new Order(4, "Nebraska", "Custer"));
//		orders.add(new Order(5, "Iowa", "Black Hawk"));
//		orders.add(new Order(6, "Nevada", "Las Vegas"));
//		orders.add(new Order(7, "California", "San Diego")); // 1.54m
//		orders.add(new Order(8, "Illinois", "Chicago")); // 2.2m
//		orders.add(new Order(9, "Massachusetts", "Boston")); // 4.3m
//		orders.add(new Order(10, "Vermont", "Montpellier"));
//		orders.add(new Order(11, "Alberta", "Revelstoke"));
//		orders.add(new Order(12, "Manitoba", "Winnipeg"));
//		orders.add(new Order(13, "British Colombia", "Terrace"));

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

//        System.out.println(exampleTable.getSelectionModel().getSelectedItem().toString());
//        System.out.println(exampleTable.getItems().get(2).toString());

//		exampleTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
//			@Override
//			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
//				// Check whether item is selected and set value of selected item to Label
//				if (exampleTable.getSelectionModel().getSelectedItem() != null) {
//					TableViewSelectionModel<Order> selectionModel = exampleTable.getSelectionModel();
//					ObservableList<?> selectedCells = selectionModel.getSelectedCells();
//					TablePosition<Object, ?> tablePosition = (TablePosition<Object, ?>) selectedCells.get(0);
//					Object val = tablePosition.getTableColumn().getCellData(newValue);
//					System.out.println("Selected Value " + val);
//				}
//			}
//
//		});
		setClickedCell();
//		System.out.println(selectedCell = getClickedCell());
//		System.out.println(selectedRow);

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
				|| Integer.valueOf(order.getId()).toString().equals(searchText);
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

	@FXML
	public void clickItem(MouseEvent event) {
		if (event.getClickCount() == 2) // Checking double click
		{
			System.out.println(exampleTable.getSelectionModel().getSelectedItem().getId());
			System.out.println(exampleTable.getSelectionModel().getSelectedItem().getStreet());
			System.out.println(exampleTable.getSelectionModel().getSelectedItem().getCity());
			System.out.println(event);
		}
	}
	
	@FXML
	private Button get;
	
	public void getSearchBoxText() {
		System.out.println(selectedRow);
	}
	
	

	public static Order selectedRow = null;
	

	
	private void setClickedCell() {

		exampleTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				String selectedRowString;
				// Check whether item is selected and set value of selected item to Label
				if (exampleTable.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel<Order> selectionModel = exampleTable.getSelectionModel();
					ObservableList<?> selectedCells = selectionModel.getSelectedCells();
//					System.out.println(selectionModel.getSelectedIndex());
//					// выбрать определённую строку из выбранной строки
					System.out.println(exampleTable.getItems().get(selectionModel.getSelectedIndex()));
					TablePosition<Object, ?> tablePosition = (TablePosition<Object, ?>) selectedCells.get(0);
					Object val = tablePosition.getTableColumn().getCellData(newValue);
					searchBox.setText(val.toString());
					System.out.println("Selected Value " + val);
					selectedRowString = exampleTable.getItems().get(selectionModel.getSelectedIndex()).getId() + " "
							+  exampleTable.getItems().get(selectionModel.getSelectedIndex()).getCity() + " "
							+  exampleTable.getItems().get(selectionModel.getSelectedIndex()).getStreet();
					selectedRow = exampleTable.getItems().get(selectionModel.getSelectedIndex());
//					selectedRow = selectedRowString;
					System.out.println(selectedRow);


//					System.out.println(selectedCell);
				}

			}

		});
		
//		return selectedCell;

	}

}