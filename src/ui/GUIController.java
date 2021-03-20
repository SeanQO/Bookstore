package ui;
import java.io.IOException;

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
    private TableColumn<Book, String> bookIsnbList;
    
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
    private TableView<?> sTwoBookTable;
    
    @FXML
    private BorderPane sectionTwoBorderPane;

    @FXML
    private AnchorPane mainSectionTwoPane;
    
    	// * second section two *
    
    @FXML
    private Label bookNameTxF;

    @FXML
    private Label bookLocationTxF;
    
    // ****** section three ******
    
    @FXML
    private TextField searchClientTxF;

    @FXML
    private TableView<?> clientTable;

    @FXML
    private TableView<?> bookTable;
    
    // ****** section four ******
    @FXML
    private Label nextClientTxL;

    @FXML
    private Label clientNameOneTxL;

    @FXML
    private TableView<?> registerOneTable;

    @FXML
    private Label clientNameTwoTxL;

    @FXML
    private TableView<?> registerTwoTable;

    @FXML
    private Label clientNameThreeTxL;

    @FXML
    private TableView<?> registerThreeTable;
    
    @FXML
    private TableView<?> registerFourTable;

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
	
	private final String bOOKSFILE = "data/bookList.csv";
	
	@SuppressWarnings("unchecked")
	public GUIController() {
		bookS = null;
		
		clientIsnbList = new TableView<Book>();
		bookNameList = new TableColumn<Book, String>("Book");
		bookPriceList = new TableColumn<Book, Double>("Price");
		bookIsnbList = new TableColumn<Book, String>("ISNB");
		clientIsnbList.getColumns().addAll(bookNameList, bookPriceList, bookIsnbList);
	}
	
	public void initialize() {
		if (bookS == null) {
			bookS = new Bookstore();
			loadAllBooksTable();

		}
		
	}
	
	// ****** filling and setting ******
	
		// *  fill tables *
    private void loadAllBooksTable() {
    	try {
    		ObservableList<Book> observableList;
        	bookS.importDataBooksList(bOOKSFILE);
        	observableList = FXCollections.observableArrayList(bookS.getBooksAvailable());
        	allBooksTable.setItems(observableList);
        	bookName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        	bookPrice.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));	
        	
		} catch (IOException ioException) {
			errorLoadingBookListAlert();
			
		}
    	
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
    	bookIsnbList.setCellValueFactory(new PropertyValueFactory<Book, String>("ISNB"));
    	
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
    
    // ****** menu options actions ******
    @FXML
    void openSectionOne(ActionEvent event) {
    	mainBorderPane.setCenter(sectionOneAnchorPane);
    	loadAllBooksTable();
    }
    
    @FXML
    void openSectionTwo(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionTwoPane.fxml"));
        	fxmlLoader.setController(this);

        	Parent Pane = fxmlLoader.load();
        
        	mainBorderPane.setCenter(Pane);
        	
        	setSectionTwoMain();
        	
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		}
    	
    }
    
    @FXML
    void openSectionThree(ActionEvent event) {

    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionThreePane.fxml"));
        	fxmlLoader.setController(this);

        	Parent Pane = fxmlLoader.load();
        
        	mainBorderPane.setCenter(Pane);
        	
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		}
    	
    }

    @FXML
    void openSectionFour(ActionEvent event) {

    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionFourPane.fxml"));
        	fxmlLoader.setController(this);

        	Parent Pane = fxmlLoader.load();
        
        	mainBorderPane.setCenter(Pane);
        	
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		}
    	
    }
	
    // ****** section one actions ******
    
		// * register client *
    @FXML
	void registerClient(ActionEvent event) {
    	String clientName = clientNameTxtF.getText();
    	String clientId = idClientTxtF.getText();
    	
    	String emptyFields = "";
    	if ((clientName + "").equals("") ){
    		emptyFields += "client Name";
    	}
    	
    	if ((clientId + "").equals("") ) {
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
    			
    		}else {
    			emptyFieldsAlert(emptyFields);
    			
    		}
    		
		} catch (NumberFormatException numberFormatException) {
			wrongFieldsAlert("Client ID");
			
		}
    	
    	

	}
    

    @FXML
    void searchBook(ActionEvent event) {
    	System.out.println("Search book button working");
    }
    
    @FXML
    void addBookToList(ActionEvent event) {
    	int selectedIndex = allBooksTable.getSelectionModel().getSelectedIndex();
    	
    	if (selectedIndex >= 0) {
    		ObservableList<Book> observableList = clientIsnbList.getItems();
        	
        	observableList.add( allBooksTable.getSelectionModel().getSelectedItem() );
        	allBooksTable.getItems().remove(selectedIndex);
        	updateISNBListTable(observableList);
        	
		}else {
			noBookSelectedAlert();
			
		}
    	
    	
    }
    
    @FXML
    void removeBookFromList(ActionEvent event) {
    	int selectedIndex = clientIsnbList.getSelectionModel().getSelectedIndex();
    	
    	if (selectedIndex >= 0) {
    		ObservableList<Book> observableList = allBooksTable.getItems();
        	
        	observableList.add( clientIsnbList.getSelectionModel().getSelectedItem() );
        	clientIsnbList.getItems().remove(selectedIndex);
        	updateAllBooksTable(observableList);
        	
		}else {
			noBookSelectedAlert();
			
		}
    	
    }
    
    @FXML
    void showFirstChapter(ActionEvent event) {
    	System.out.println("show first chapter button working");
    	
    }

    @FXML
    void showRating(ActionEvent event) {
    	System.out.println("show rating button working");
    }

    @FXML
    void showReviews(ActionEvent event) {
    	System.out.println("show reviews button working");
    	Alert alertReview = new Alert(AlertType.INFORMATION);
    	alertReview.setTitle("Review");
    	alertReview.setHeaderText("Review of " + allBooksTable.getSelectionModel().getSelectedItem().getName());
    	alertReview.setContentText( allBooksTable.getSelectionModel().getSelectedItem().getReview());

    	alertReview.showAndWait();
    }
    
    @FXML
    void generateISNBList(ActionEvent event) {
    	
    }
    
    // ****** section two change panes ******
    
    private void setSectionTwoMain() {
    	sectionTwoBorderPane.setRight(mainSectionTwoPane);
    	
    }
    
    private void setSectionTwoSecondary() {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sectionTwoSecondPane.fxml"));
        	fxmlLoader.setController(this);

        	Parent Pane = fxmlLoader.load();
        
        	sectionTwoBorderPane.setRight(Pane);
        	
		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		}
    	
    }
    
    // ****** section two main pane actions ******
    @FXML
    void oneSortList(ActionEvent event) {
    	setSectionTwoSecondary();
    }

    @FXML
    void threeSortList(ActionEvent event) {
    	setSectionTwoSecondary();
    }

    @FXML
    void twoSortList(ActionEvent event) {
    	setSectionTwoSecondary();
    }
    
    // ****** section two main secondary pane actions ******
    @FXML
    void nextBook(ActionEvent event) {
    	System.out.println("next book button working");
    }

    @FXML
    void previousBook(ActionEvent event) {
    	System.out.println("prev book button working");
    }
    
    // ****** section three actions******
    
    @FXML
    void checkBooks(ActionEvent event) {

    }

    @FXML
    void searchClient(ActionEvent event) {

    }
    
    // ****** section four pane actions ******
    private boolean isRegisterOpen(int regNumber) {
    	switch (regNumber) {
		case 1:
			if (clientNameOneTxL.getText().equals("Register closed")) {
				return false;
			}else {
				return true;
			}
			
		case 2:
			if (clientNameTwoTxL.getText().equals("Register closed")) {
				return false;
			}else {
				return true;
			}
			
		case 3:
			if (clientNameThreeTxL.getText().equals("Register closed")) {
				return false;
			}else {
				return true;
			}
			
		case 4:
			if (clientNameFourTxL.getText().equals("Register closed")) {
				return false;
			}else {
				return true;
			}
			
		default:
			break;
		}
    	return false;
    }
    @FXML
    void nextStep(ActionEvent event) {

    }
    
    @FXML
    void activeDesactiveROne(ActionEvent event) {
    	if (isRegisterOpen(1)) {
			if (isRegisterOpen(2) || isRegisterOpen(3) || isRegisterOpen(4)) {
				closeRegister(1);
			}else {
				lastRegisterAlert();
			}
		}else {
			openRegister(1);
		}
    	
    }
    
    private void closeRegister(int regNumber) {
    	switch (regNumber) {
		case 1:
			clientNameOneTxL.setText("Register closed");
			registerOneTable.setDisable(true);
			ROneButton.setText("Open register");
			break;
		case 2:
			clientNameTwoTxL.setText("Register closed");
			registerTwoTable.setDisable(true);
			RTwoButton.setText("Open register");
			break;
		case 3:
			clientNameThreeTxL.setText("Register closed");
			registerThreeTable.setDisable(true);
			RThreeButton.setText("Open register");
			break;
		case 4:
			clientNameFourTxL.setText("Register closed");
			registerFourTable.setDisable(true);
			RFourButton.setText("Open register");
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
			break;
		case 2:
			clientNameTwoTxL.setText("Register open");
			registerTwoTable.setDisable(false);
			RTwoButton.setText("Close register");
			break;
		case 3:
			clientNameThreeTxL.setText("Register open");
			registerThreeTable.setDisable(false);
			RThreeButton.setText("Close register");
			break;
		case 4:
			clientNameFourTxL.setText("Register open");
			registerFourTable.setDisable(false);
			RFourButton.setText("Close register");
			break;
		default:
			break;
		}
	}
    
    @FXML
    void activeDesactiveRTwo(ActionEvent event) {
    	if (isRegisterOpen(2)) {
			if (isRegisterOpen(1) || isRegisterOpen(3) || isRegisterOpen(4)) {
				closeRegister(2);
			}else {
				lastRegisterAlert();
			}
		}else {
			openRegister(2);
		}
    }

    @FXML
    void activeDesactiveRThree(ActionEvent event) {
    	if (isRegisterOpen(3)) {
			if (isRegisterOpen(1) || isRegisterOpen(2) || isRegisterOpen(4)) {
				closeRegister(3);
			}else {
				lastRegisterAlert();
			}
		}else {
			openRegister(3);
		}
    }
    
    @FXML
    void activeDesactiveRFour(ActionEvent event) {
    	if (isRegisterOpen(4)) {
			if (isRegisterOpen(1) || isRegisterOpen(3) || isRegisterOpen(2)) {
				closeRegister(4);
			}else {
				lastRegisterAlert();
			}
		}else {
			openRegister(4);
		}
    }
    
}
