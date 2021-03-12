package ui;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
    private ScrollPane libraryBooksTable;

    @FXML
    private ScrollPane clientListTable;
    
    // ****** section two ******
    @FXML
    private BorderPane sectionTwoBorderPane;

    @FXML
    private AnchorPane mainSectionTwoPane;
    
    	// * second section two *
    
    @FXML
    private Label bookNameTxF;

    @FXML
    private Label bookLocationTxF;
    
    
    // ****** menu options actions ******
    @FXML
    void openSectionOne(ActionEvent event) {
    	mainBorderPane.setCenter(sectionOneAnchorPane);
    	
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
    @FXML
    void searchBook(ActionEvent event) {
    	System.out.println("Search book button working");
    }
    
    @FXML
    void addBookToList(ActionEvent event) {
    	System.out.println("add book to list button working");
    }
    
    @FXML
    void removeBookFromList(ActionEvent event) {
    	System.out.println("remove book from list button working");
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
    }
    @FXML
    void generateISNBList(ActionEvent event) {
    	System.out.println("generate isnb list button working");
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
    
}
