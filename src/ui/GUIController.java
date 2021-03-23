package ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TableColumn;
import model.*;

public class GUIController {

	// ****** Panes ******
	@FXML
	private BorderPane mainBorderPane;

	@FXML
	private AnchorPane sectionOneAnchorPane;

	// ****** menu options ******
	@FXML
	private MenuItem openSectionOne;

	@FXML
	private MenuItem openSectionTwo;

	@FXML
	private MenuItem openSectionThree;

	@FXML
	private MenuItem openSectionFour;

	// ****** section one ******
	@FXML
	private TextField searchBookTxF;

	@FXML
	private TableView<Book> allBooksTable;

	@FXML
	private TableColumn<Book, String> bookName;

	@FXML
	private TableColumn<Book, Double> bookPrice;

	@FXML
	private TableView<?> clientListTable;

	@FXML
	private Button addBookToListB;

	@FXML
	private Button generateISNBB;

	@FXML
	private Button removeBookFromListB;

	@FXML
	private TableView<Book> clientIsnbList;

	@FXML
	private TableColumn<Book, String> bookNameList;

	@FXML
	private TableColumn<Book, Double> bookPriceList;

	@FXML
	private TableColumn<Book, Integer> bookIsnbList;

	// * section one register client *
	@FXML
	private Button registerClient;

	@FXML
	private TextField clientNameTxtF;

	@FXML
	private TextField idClientTxtF;

	@FXML
	private AnchorPane registerClientAP;

	@FXML
	private BorderPane dualPaneSectionOne;

	// ****** section two ******

	@FXML
	private TableView<Book> sTwoBookTable;

	@FXML
	private TableColumn<Book, String> BookNameSectionTwo;

	@FXML
	private TableColumn<Book, Integer> IsbnSectionTwo;

	@FXML
	private BorderPane sectionTwoBorderPane;

	@FXML
	private AnchorPane mainSectionTwoPane;

	@FXML
	private Label clientNameSTLabel;

	@FXML
	private Button insertionB;

	@FXML
	private Button shellB;

	@FXML
	private Button radixB;

	// * second section two *

	@FXML
	private Label bookNameTxF;

	@FXML
	private Label bookLocationTxF;

	@FXML
	private Button finishButton;

	// ****** section three ******

	@FXML
	private TextField searchClientTxF;

	@FXML
	private TableView<Client> clientTable;

	@FXML
	private TableColumn<Client, Integer> clientIdColumn;

	@FXML
	private TableColumn<Client, Double> clientTimeColumn;

	@FXML
	private TableView<Book> bookTable;

	@FXML
	private TableColumn<Book, String> bookNameSectionThreeColumn;

	@FXML
	private TableColumn<Book, Double> bookPriceSectionThreeColumn;

	// ****** section four ******
	@FXML
	private Label nextClientTxL;

	@FXML
	private Label clientNameOneTxL;

	@FXML
	private TableView<Book> registerOneTable;

	@FXML
	private TableColumn<Book, String> bookNameRegisterOneColumn;

	@FXML
	private TableColumn<Book, Double> bookPriceRegisterOneColumn;

	@FXML
	private TableView<Book> registerTwoTable;

	@FXML
	private TableColumn<Book, String> bookNameRegisterTwoColumn;

	@FXML
	private TableColumn<Book, Double> bookPriceRegisterTwoColumn;

	@FXML
	private TableView<Book> registerThreeTable;

	@FXML
	private TableColumn<Book, String> bookNameRegisterThreeColumn;

	@FXML
	private TableColumn<Book, Double> bookPriceRegisterThreeColumn;

	@FXML
	private TableView<Book> registerFourTable;

	@FXML
	private TableColumn<Book, String> bookNameRegisterFourColumn;

	@FXML
	private TableColumn<Book, Double> bookPriceRegisterFourColumn;

	@FXML
	private Label clientNameTwoTxL;

	@FXML
	private Label clientNameThreeTxL;

	@FXML
	private Label clientNameFourTxL;

	@FXML
	private Button ROneButton;

	@FXML
	private Button RTwoButton;

	@FXML
	private Button RThreeButton;

	@FXML
	private Button RFourButton;

	// ****** model interaction ******

	private Bookstore bookS;

	private final String BOOKSFILE = "data/bookList.csv";

	private boolean isClientSelecting;

	private boolean isClientSelectingSTwo;

	private int sectionTwoBookIndex;

	@SuppressWarnings("unchecked")
	public GUIController() {
		sectionTwoBookIndex = 0;
		isClientSelectingSTwo = false;
		bookS = null;
		isClientSelecting = false;
		clientIsnbList = new TableView<Book>();
		bookNameList = new TableColumn<Book, String>("Book");
		bookPriceList = new TableColumn<Book, Double>("Price");
		bookIsnbList = new TableColumn<Book, Integer>("isbn");
		clientIsnbList.getColumns().addAll(bookNameList, bookPriceList, bookIsnbList);

		sTwoBookTable = new TableView<Book>();
		BookNameSectionTwo = new TableColumn<Book, String>("Book");
		IsbnSectionTwo = new TableColumn<Book, Integer>("isbn");

		clientTable = new TableView<Client>();
		clientIdColumn = new TableColumn<Client, Integer>("id");
		clientTimeColumn = new TableColumn<Client, Double>("timeInStore");
		
		registerOneTable = new TableView<Book>();
		bookNameRegisterOneColumn = new TableColumn<Book, String>("name");
		bookPriceRegisterOneColumn = new TableColumn<Book, Double>("price");
		
		registerTwoTable = new TableView<Book>();
		bookNameRegisterTwoColumn = new TableColumn<Book, String>("name");
		bookPriceRegisterTwoColumn = new TableColumn<Book, Double>("price");
		
		registerThreeTable = new TableView<Book>();
		bookNameRegisterThreeColumn = new TableColumn<Book, String>("name");
		bookPriceRegisterThreeColumn = new TableColumn<Book, Double>("price");
		
		registerFourTable = new TableView<Book>();
		bookNameRegisterFourColumn = new TableColumn<Book, String>("name");
		bookPriceRegisterFourColumn = new TableColumn<Book, Double>("price");
		
		
	}

	public void initialize() {
		if (bookS == null) {
			bookS = new Bookstore();
			try {

				bookS.importDataBooksList(BOOKSFILE);

			} catch (IOException ioException) {
				errorLoadingBookListAlert();

			}
			loadAllBooksTable();

		}
	}
	
	// ****** filling and setting ******

	// * fill tables *
	private void loadAllBooksTable() {
		ObservableList<Book> observableList;
		observableList = FXCollections.observableArrayList(bookS.getBooksAvailable());
		allBooksTable.getItems().clear();
		allBooksTable.setItems(observableList);
		bookName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPrice.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

	}

	private void updateAllBooksTable(ObservableList<Book> observableList) {
		allBooksTable.setItems(observableList);
		bookName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPrice.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

	}

	private void updateISNBListTable(ObservableList<Book> observableList) {
		clientIsnbList.setItems(observableList);
		bookNameList.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPriceList.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
		bookIsnbList.setCellValueFactory(new PropertyValueFactory<Book, Integer>("isbn"));

	}

	private void loadIsbnSectionTwo(ObservableList<Book> observableList) {
		sTwoBookTable.setItems(observableList);
		BookNameSectionTwo.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		IsbnSectionTwo.setCellValueFactory(new PropertyValueFactory<Book, Integer>("isbn"));
	}

	private void loadClientListSectionThree(ObservableList<Client> observableList) {
		clientTable.setItems(observableList);
		clientIdColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
		clientTimeColumn.setCellValueFactory(new PropertyValueFactory<Client, Double>("timeInStore"));

	}

	private void loadBooksSectionThree(ObservableList<Book> observableList) {
		bookTable.setItems(observableList);
		bookNameSectionThreeColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPriceSectionThreeColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

	}
	
	private void loadRegisterOneTable(ObservableList<Book> observableList) {
		registerOneTable.setItems(observableList);
		bookNameRegisterOneColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPriceRegisterOneColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

	}
	
	private void loadRegisterTwoTable(ObservableList<Book> observableList) {
		registerTwoTable.setItems(observableList);
		bookNameRegisterTwoColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPriceRegisterTwoColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

	}
	
	private void loadRegisterThreeTable(ObservableList<Book> observableList) {
		registerThreeTable.setItems(observableList);
		bookNameRegisterThreeColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPriceRegisterThreeColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

	}
	
	private void loadRegisterFourTable(ObservableList<Book> observableList) {
		registerThreeTable.setItems(observableList);
		bookNameRegisterThreeColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		bookPriceRegisterThreeColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

	}

	// * Alerts setup *
	private void errorLoadingBookListAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Book list error.");
		error.setHeaderText("couldn not load book list information");
		error.setContentText("Error loading book information, please try again, "
				+ "if the error keeps happening the list book file is ether corrupted missing.");
		error.showAndWait();
	}

	private void lastRegisterAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Only one register Open.");
		error.setHeaderText("there is only one register available.");
		error.setContentText("Please open al least one more register in order to close this one.");
		error.showAndWait();
	}

	private void noBookSelectedAlert() {
		Alert error = new Alert(AlertType.INFORMATION);
		error.setTitle("No book selected");
		error.setContentText("Please select one book in order to add or remove from the lists.");
		error.showAndWait();
	}

	private void noClientSelectedAlert() {
		Alert error = new Alert(AlertType.INFORMATION);
		error.setTitle("No client selected");
		error.setContentText("Please select one client in order to show the clients books in the basket.");
		error.showAndWait();
	}

	private void emptyFieldsAlert(String emptyFields) {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Fields are empty");
		error.setHeaderText("Some fields are empty");
		error.setContentText("Please fill the required fields: " + emptyFields);
		error.showAndWait();

	}

	private void wrongFieldsAlert(String fields) {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Fields are in the wrong format");
		error.setHeaderText("Some fields are not accepted");
		error.setContentText("The ID field format needs to be numbers: " + fields);
		error.showAndWait();

	}

	private void isnbListAddedAlert() {
		Alert error = new Alert(AlertType.INFORMATION);
		error.setTitle("The isnb list is created");
		error.setContentText("The ISNB list is created and added to the client");
		error.showAndWait();

	}

	private void emptyIsnbListAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("The isnb list is empty");
		error.setContentText("Cant generate an empty ISNB list. Please select al least one book.");
		error.showAndWait();

	}

	private void clientIsSelectingAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("The client is selecting ISNB");
		error.setContentText("Please finish selecting ISNB codes to change section.");
		error.showAndWait();

	}
	
	private void clientInRegisterAlert() {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("Client is in this register");
		error.setContentText("Please wait untill the client leaves the register to close it.");
		error.showAndWait();
	}

	// ****** menu options actions ******

	@FXML
	void openSectionOne(ActionEvent event) {
		mainBorderPane.setCenter(sectionOneAnchorPane);
		loadAllBooksTable();
	}

	@FXML
	void openSectionTwo(ActionEvent event) {
		openSectiontwo();

	}

	private void openSectiontwo() {
		if (!isClientSelecting) {
			try {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionTwoPane.fxml"));
				fxmlLoader.setController(this);

				Parent Pane = fxmlLoader.load();

				mainBorderPane.setCenter(Pane);

				if (isClientSelectingSTwo) {
					setSectionTwoSecondary();

				}

				String clientName = bookS.getClients().get(0).getName();
				clientNameSTLabel.setText(clientName);

				loadIsbnSectionTwo(getBooks());

				insertionB.setDisable(false);
				shellB.setDisable(false);
				radixB.setDisable(false);

			} catch (IOException ioException) {
				// TODO: handle exception with an alert that displays the content of the error.

			} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
				clientNameSTLabel.setText("No Clients In this section");
				insertionB.setDisable(true);
				shellB.setDisable(true);
				radixB.setDisable(true);

			}

		} else {
			clientIsSelectingAlert();

		}
	}

	private ObservableList<Book> getBooks() {
		Client client = bookS.getClients().get(0);
		ObservableList<Book> books = FXCollections.observableArrayList();
		for (int i = 0; i < client.getIsnbList().length; i++) {
			books.add(bookS.searchBook(client.getIsnbList()[i]));

		}

		return books;
	}

	@FXML
	void openSectionThree(ActionEvent event) {
		if (!isClientSelecting) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionThreePane.fxml"));
				fxmlLoader.setController(this);

				Parent Pane = fxmlLoader.load();

				mainBorderPane.setCenter(Pane);

				if (bookS.getClientsQueue().size > 0) {
					ArrayList<Client> a = bookS.getClientsQueue().toArray();
					ObservableList<Client> oList = FXCollections.observableArrayList(a);
					loadClientListSectionThree(oList);

				}

			} catch (IOException ioException) {
				// TODO: handle exception with an alert that displays the content of the error.
			}

		} else {
			clientIsSelectingAlert();

		}

	}

	@FXML
	void openSectionFour(ActionEvent event) {
		if (!isClientSelecting) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionFourPane.fxml"));
				fxmlLoader.setController(this);

				Parent Pane = fxmlLoader.load();

				mainBorderPane.setCenter(Pane);
				
				loadSectionFour();

			} catch (IOException ioException) {
				// TODO: handle exception with an alert that displays the content of the error.
			}

		} else {
			clientIsSelectingAlert();

		}

	}
	
	private void loadSectionFour() {
		if (!bookS.getClientsQueue().isEmpty()) {
			nextClientTxL.setText(bookS.getClientsQueue().front().getT().getName());
		}else {
			nextClientTxL.setText("No client in queue");
		}
		
		if (bookS.getCashiers()[0].getClient() != null) {
			loadRegisterOne();
			clientNameOneTxL.setText(bookS.getCashiers()[0].getClient().getName());
		}else {
			clientNameOneTxL.setText("No client in cashier");
		}
		
		if (bookS.getCashiers()[1].getClient() != null) {
			loadRegisterTwo();
			clientNameTwoTxL.setText(bookS.getCashiers()[1].getClient().getName());
		}else {
			clientNameTwoTxL.setText("No client in cashier");
		}
		
		if (bookS.getCashiers()[2].getClient() != null) {
			loadRegisterThree();
			clientNameThreeTxL.setText(bookS.getCashiers()[2].getClient().getName());
		}else {
			clientNameThreeTxL.setText("No client in cashier");
		}
		
		if (bookS.getCashiers()[3].getClient() != null) {
			loadRegisterFour();
			clientNameFourTxL.setText(bookS.getCashiers()[3].getClient().getName());
		}else {
			clientNameFourTxL.setText("No client in cashier");
		}
		
	}
	
	private void loadRegisterOne() {
		ObservableList<Book> oList = FXCollections.observableArrayList(bookS.getCashiers()[0].toArrayBooks());
		loadRegisterOneTable(oList);
		
	}
	
	private void loadRegisterTwo() {
		ObservableList<Book> oList = FXCollections.observableArrayList(bookS.getCashiers()[1].toArrayBooks());
		loadRegisterTwoTable(oList);
		
	}
	
	private void loadRegisterThree() {
		ObservableList<Book> oList = FXCollections.observableArrayList(bookS.getCashiers()[2].toArrayBooks());
		loadRegisterThreeTable(oList);
		
	}
	
	private void loadRegisterFour() {
		ObservableList<Book> oList = FXCollections.observableArrayList(bookS.getCashiers()[3].toArrayBooks());
		loadRegisterFourTable(oList);
		
	}
	

	// ****** section one actions ******

	// * register client *
	@FXML
	void registerClient(ActionEvent event) {
		String clientName = clientNameTxtF.getText();
		String clientId = idClientTxtF.getText();

		String emptyFields = "";
		if ((clientName + "").equals("")) {
			emptyFields += "client Name";
		}

		if ((clientId + "").equals("")) {
			emptyFields += "Client ID";
		}

		try {
			if (emptyFields.equals("")) {
				bookS.addClient(clientName, Integer.parseInt(clientId));
				AnchorPane aPane = new AnchorPane();
				aPane.getChildren().add(clientIsnbList);
				dualPaneSectionOne.setCenter(aPane);
				addBookToListB.setDisable(false);
				removeBookFromListB.setDisable(false);
				generateISNBB.setDisable(false);

				isClientSelecting = true;

			} else {
				emptyFieldsAlert(emptyFields);

			}

		} catch (NumberFormatException numberFormatException) {
			wrongFieldsAlert("Client ID");

		}

	}

	@FXML
	void addBookToList(ActionEvent event) {
		int selectedIndex = allBooksTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			ObservableList<Book> observableList = clientIsnbList.getItems();

			observableList.add(allBooksTable.getSelectionModel().getSelectedItem());
			allBooksTable.getItems().remove(selectedIndex);
			updateISNBListTable(observableList);

		} else {
			noBookSelectedAlert();

		}

	}

	@FXML
	void removeBookFromList(ActionEvent event) {
		int selectedIndex = clientIsnbList.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			ObservableList<Book> observableList = allBooksTable.getItems();

			observableList.add(clientIsnbList.getSelectionModel().getSelectedItem());
			clientIsnbList.getItems().remove(selectedIndex);
			updateAllBooksTable(observableList);

		} else {
			noBookSelectedAlert();

		}

	}

	@FXML
	void showReview(ActionEvent event) {

		if (allBooksTable.getSelectionModel().getSelectedIndex() >= 0) {
			Alert windowInformation = new Alert(AlertType.INFORMATION);
			windowInformation.setTitle("Review");
			windowInformation
					.setHeaderText("Review Of " + allBooksTable.getSelectionModel().getSelectedItem().getName());
			windowInformation.setContentText(allBooksTable.getSelectionModel().getSelectedItem().getReview());
			windowInformation.showAndWait();
		} else {
			noBookSelectedAlert();
		}

	}

	@FXML
	void showFirstChapter(ActionEvent event) {
		if (allBooksTable.getSelectionModel().getSelectedIndex() >= 0) {

			Alert windowInformation = new Alert(AlertType.INFORMATION);
			windowInformation.setTitle("First Chapter");
			windowInformation
					.setHeaderText("Chapter 1: " + allBooksTable.getSelectionModel().getSelectedItem().getName());
			windowInformation.setContentText(
					"Chapter 1: " + allBooksTable.getSelectionModel().getSelectedItem().getInitialChapters());
			windowInformation.showAndWait();
		} else {
			noBookSelectedAlert();
		}
	}

	@FXML
	void generateISNBList(ActionEvent event) {
		if (clientIsnbList.getItems().size() != 0) {
			Iterator<Book> iterator = clientIsnbList.getItems().iterator();
			while (iterator.hasNext()) {
				Book b = (Book) iterator.next();
				bookS.getClients().get(bookS.getClients().size() - 1).addIsbn(b.getIsbn());
			}

			isnbListAddedAlert();

			dualPaneSectionOne.getChildren().clear();
			dualPaneSectionOne.setCenter(registerClientAP);
			loadAllBooksTable();

			clientNameTxtF.setText("");
			
			idClientTxtF.setText("");
			
			isClientSelecting = false;

			addBookToListB.setDisable(true);
			removeBookFromListB.setDisable(true);
			generateISNBB.setDisable(true);

			clientIsnbList.getItems().clear();

		} else {
			emptyIsnbListAlert();
		}

	}

	// ****** section two change panes ******
	private void setSectionTwoSecondary() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionTwoSecondPane.fxml"));
			fxmlLoader.setController(this);

			Parent Pane = fxmlLoader.load();

			sectionTwoBorderPane.setRight(Pane);

			int isbn = bookS.getClients().get(0).getIsnbList()[sectionTwoBookIndex];
			sectionTwoBookIndex++;
			bookNameTxF.setText(bookS.searchBook(isbn).getName() + "");
			bookLocationTxF.setText(bookS.searchLocation(isbn) + "");

		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		}

	}

	// ****** section two main pane actions ******
	@FXML
	void insertionSort(ActionEvent event) {
		setSectionTwoSecondary();
		bookS.getClients().get(bookS.getClients().size() - 1).sortIsnbList(1);
		loadIsbnSectionTwo(getBooks());
		isClientSelectingSTwo = true;
	}

	@FXML
	void shellSort(ActionEvent event) {
		setSectionTwoSecondary();
		bookS.getClients().get(bookS.getClients().size() - 1).sortIsnbList(2);
		loadIsbnSectionTwo(getBooks());
		isClientSelectingSTwo = true;
	}

	@FXML
	void radixSort(ActionEvent event) {
		setSectionTwoSecondary();
		bookS.getClients().get(bookS.getClients().size() - 1).sortIsnbList(3);
		loadIsbnSectionTwo(getBooks());
		isClientSelectingSTwo = true;
	}

	// ****** section two main secondary pane actions ******

	@FXML
	void nextBook(ActionEvent event) {
		try {
			int isbn = bookS.getClients().get(bookS.getClients().size() - 1).getIsnbList()[sectionTwoBookIndex + 1];
			sectionTwoBookIndex++;
			bookNameTxF.setText(bookS.searchBook(isbn).getName() + "");
			bookLocationTxF.setText(bookS.searchLocation(isbn) + "");

		} catch (IndexOutOfBoundsException idBoundsException) {
			finishButton.setDisable(false);

		}

	}

	@FXML
	void previousBook(ActionEvent event) {
		try {
			int isbn = bookS.getClients().get(bookS.getClients().size() - 1).getIsnbList()[sectionTwoBookIndex - 1];
			sectionTwoBookIndex--;
			bookNameTxF.setText(bookS.searchBook(isbn).getName() + "");
			bookLocationTxF.setText(bookS.searchLocation(isbn) + "");

		} catch (IndexOutOfBoundsException idBoundsException) {

		}

	}

	@FXML
	void finishSectionTwo(ActionEvent event) {
		Iterator<Book> iterator = sTwoBookTable.getItems().iterator();
		
		while (iterator.hasNext()) {
			Book b = (Book) iterator.next();
			bookS.getClients().get(0).addBookToBasket(b);
		}
		
		bookS.addClientToQueue(bookS.getClients().get(0));	
		bookS.getClients().remove(0);
		
		isClientSelectingSTwo = false;
		sectionTwoBookIndex = 0;
		openSectiontwo();

	}

	// ****** section three actions******

	@FXML
	void checkBooks(ActionEvent event) {
		
		if (clientTable.getSelectionModel().getSelectedIndex() >= 0 ) {
			Client client = (Client)clientTable.getSelectionModel().getSelectedItem();
			ObservableList<Book> observableList = FXCollections.observableArrayList(client.getBasket().toArray());
			loadBooksSectionThree(observableList);

		}else {
			noClientSelectedAlert();
			
		}
		
	}

	@FXML
	void searchClient(ActionEvent event) {

	}

	// ****** section four pane actions ******
	private boolean isRegisterOpen(int regNumber) {
		switch (regNumber) {
		case 1:
			if (bookS.getCashiers()[0].isAvaliable()) {
				return true;
			} else {
				return false;
			}

		case 2:
			if (bookS.getCashiers()[1].isAvaliable()) {
				return true;
			} else {
				return false;
			}

		case 3:
			if (bookS.getCashiers()[2].isAvaliable()) {
				return true;
			} else {
				return false;
			}

		case 4:
			if (bookS.getCashiers()[3].isAvaliable()) {
				return true;
			} else {
				return false;
			}

		default:
			break;
		}
		return false;
	}

	@FXML
	void nextStep(ActionEvent event) {
		bookS.nextStep();
		loadSectionFour();
	}
	
	private void closeRegister(int regNumber) {

		switch (regNumber) {
		case 1:
			if (bookS.getCashiers()[0].getClient() == null) {
				clientNameOneTxL.setText("Register closed");
				registerOneTable.setDisable(true);
				ROneButton.setText("Open register");
				bookS.getCashiers()[0].setAvaliable(false);
			
			}else {
				clientInRegisterAlert();
				
			}
			
			break;
		case 2:
			if (bookS.getCashiers()[1].getClient() == null) {
				clientNameTwoTxL.setText("Register closed");
				registerTwoTable.setDisable(true);
				RTwoButton.setText("Open register");
				bookS.getCashiers()[1].setAvaliable(false);
			
			}else {
				clientInRegisterAlert();
				
			}
			
			break;
		case 3:
			if (bookS.getCashiers()[2].getClient() == null) {
				clientNameThreeTxL.setText("Register closed");
				registerThreeTable.setDisable(true);
				RThreeButton.setText("Open register");
				bookS.getCashiers()[2].setAvaliable(false);
			
			}else {
				clientInRegisterAlert();
				
			}
			
			break;
		case 4:
			if (bookS.getCashiers()[3].getClient() == null) {
				clientNameFourTxL.setText("Register closed");
				registerFourTable.setDisable(true);
				RFourButton.setText("Open register");
				bookS.getCashiers()[3].setAvaliable(false);
			
			}else {
				clientInRegisterAlert();
				
			}
			
			break;
		default:
			break;
		}
	}

	private void openRegister(int regNumber) {
		switch (regNumber) {
		case 1:
			clientNameOneTxL.setText("Register open");
			registerOneTable.setDisable(false);
			ROneButton.setText("Close register");
			bookS.getCashiers()[0].setAvaliable(true);
			
			break;
		case 2:
			clientNameTwoTxL.setText("Register open");
			registerTwoTable.setDisable(false);
			RTwoButton.setText("Close register");
			bookS.getCashiers()[1].setAvaliable(true);
			
			break;
		case 3:
			clientNameThreeTxL.setText("Register open");
			registerThreeTable.setDisable(false);
			RThreeButton.setText("Close register");
			bookS.getCashiers()[2].setAvaliable(true);
			
			break;
		case 4:
			clientNameFourTxL.setText("Register open");
			registerFourTable.setDisable(false);
			RFourButton.setText("Close register");
			bookS.getCashiers()[3].setAvaliable(true);
			
			break;
		default:
			break;
		}
	}
	
	@FXML
	void activeDesactiveROne(ActionEvent event) {
		if (isRegisterOpen(1)) {
			if (isRegisterOpen(2) || isRegisterOpen(3) || isRegisterOpen(4)) {
				closeRegister(1);
			} else {
				lastRegisterAlert();
			}
		} else {
			openRegister(1);
		}

	}
	
	@FXML
	void activeDesactiveRTwo(ActionEvent event) {
		if (isRegisterOpen(2)) {
			if (isRegisterOpen(1) || isRegisterOpen(3) || isRegisterOpen(4)) {
				closeRegister(2);
			} else {
				lastRegisterAlert();
			}
		} else {
			openRegister(2);
		}
	}

	@FXML
	void activeDesactiveRThree(ActionEvent event) {
		if (isRegisterOpen(3)) {
			if (isRegisterOpen(1) || isRegisterOpen(2) || isRegisterOpen(4)) {
				closeRegister(3);
			} else {
				lastRegisterAlert();
			}
		} else {
			openRegister(3);
		}
	}

	@FXML
	void activeDesactiveRFour(ActionEvent event) {
		if (isRegisterOpen(4)) {
			if (isRegisterOpen(1) || isRegisterOpen(3) || isRegisterOpen(2)) {
				closeRegister(4);
			} else {
				lastRegisterAlert();
			}
		} else {
			openRegister(4);
		}
	}

}
