package application;

import java.util.ArrayList;
import java.util.stream.Collectors;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	
	ArrayList<Product> Products = new ArrayList<Product>();
	ArrayList<Product> Cart = new ArrayList<Product>();
	
	@Override
	public void start(Stage primaryStage) {
		productsList();
		
		Font Roboto = Font.loadFont(getClass().getResourceAsStream("Roboto-SemiBold.ttf"), 16);
		
		VBox Categories = new VBox(15);
		Categories.setPadding(new Insets(20));
		Categories.setStyle("-fx-background-color: #FFFFFF;");
		
		Label Welcome = new Label("Welcome to our store!");
		Welcome.setFont(Font.font("Book Antiqua", FontWeight.BOLD, 30));
		Categories.setAlignment(Pos.TOP_CENTER);
		
		Label label = new Label("Choose a category:");
		label.setFont(Font.font("Book Antiqua", FontWeight.BOLD, 20));
		
		GridPane categoryGrid = new GridPane();
		categoryGrid.setPadding(new Insets(20));
		categoryGrid.setHgap(100); 
		categoryGrid.setVgap(20); 
		categoryGrid.setAlignment(Pos.CENTER);
	
		Button shoesCategory = new Button("Shoes");
		shoesCategory.setFont(Font.font("Roboto", FontWeight.BOLD, FontPosture.ITALIC, 15));
		shoesCategory.setFont(Roboto);
		
		Button shirtsCategory = new Button("Shirts");
		shirtsCategory.setFont(Font.font("Roboto", FontWeight.BOLD, FontPosture.ITALIC, 15));
		shirtsCategory.setFont(Roboto);
		
		Button cartButton = new Button("Check your cart - 🛒");
		cartButton.setFont(Font.font("Century", FontWeight.BOLD, FontPosture.ITALIC, 15));
		
		
		ImageView shoeCat = new ImageView(new Image("file:///C:/Users/moham/eclipse-workspace/onlineShop/src/application/shoe1.png"));
		shoeCat.setFitWidth(150);
		shoeCat.setFitHeight(150);
		shoesCategory.setGraphic(shoeCat);
		shoesCategory.setBackground(Background.EMPTY);
		ImageView shirtCat = new ImageView(new Image("file:///C:/Users/moham/eclipse-workspace/onlineShop/src/application/shirt2.png"));
		shirtCat.setFitWidth(120);
		shirtCat.setFitHeight(150);
		shirtsCategory.setGraphic(shirtCat);
		shirtsCategory.setBackground(Background.EMPTY);

		shoesCategory.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

		shoesCategory.setOnMouseEntered(e -> {
			shoesCategory.setStyle("-fx-background-color: #cccccc; -fx-text-fill: black;");
			shoesCategory.setScaleX(1.05);
			shoesCategory.setScaleY(1.05);
		});

		shoesCategory.setOnMouseExited(e -> {
			shoesCategory.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");
			shoesCategory.setScaleX(1.0);
			shoesCategory.setScaleY(1.0);
		});
		
		shirtsCategory.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");

		shirtsCategory.setOnMouseEntered(e -> {
			shirtsCategory.setStyle("-fx-background-color: #cccccc; -fx-text-fill: black;");
			shirtsCategory.setScaleX(1.05);
			shirtsCategory.setScaleY(1.05);
		});

		shirtsCategory.setOnMouseExited(e -> {
			shirtsCategory.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black;");
			shirtsCategory.setScaleX(1);
			shirtsCategory.setScaleY(1);
		});

		
		categoryGrid.add(shoesCategory, 0, 0);
		categoryGrid.add(shirtsCategory, 1, 0);
		
		shoesCategory.setOnAction(e -> showProducts(primaryStage, "Shoes"));
		shirtsCategory.setOnAction(e -> showProducts(primaryStage, "Shirts"));
		cartButton.setOnAction(e-> showCart(primaryStage));
		
		Categories.getChildren().addAll(Welcome, label, categoryGrid, cartButton);
		
		Scene scene = new Scene(Categories, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Shopping site");
		primaryStage.show();
		
	}
	
	private void productsList() { //A list of all products organised by category
		 if (!Products.isEmpty()) return; //to make sure items don't get duplicated after pressing Return and going back into the same products menu again
		 
		Products.add(new Product("Shoes", "Nike", "NikeShoe", 120, "Shoe1.png"));
		Products.add(new Product("Shoes", "Adidas", "AdidasShoe", 100, "Shoe1.png"));
		Products.add(new Product("Shoes", "Skechers", "SkechersShoe", 60, "Shoe1.png"));
		Products.add(new Product("Shoes", "Puma", "PumaShoe", 90, "Shoe1.png"));
		
		Products.add(new Product("Shirts", "Nike", "NikeShirt", 70, "shirt2.png"));
		Products.add(new Product("Shirts", "AE", "AEShirt", 50, "shirt2.png"));
		Products.add(new Product("Shirts", "CK", "CKShirt", 90, "shirt2.png"));
		Products.add(new Product("Shirts", "Gucci", "GucciShirt", 150, "shirt2.png"));
		
	}
	
	private void showProducts(Stage primaryStage, String category) {
		
		VBox productList = new VBox(20); //the main VBox that holds EVERYTHING in the products listing
		productList.setPadding(new Insets(20));
		productList.setStyle("-fx-background-color: #FFFFFF;");
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(productList);
		scrollPane.setFitToWidth(true);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		
		Label catTitle = new Label(category + "\n\n\n");
		catTitle.setFont(Font.font("", FontWeight.EXTRA_BOLD, 25));
		catTitle.setUnderline(true);
		productList.setAlignment(Pos.TOP_CENTER);
		
		productList.getChildren().add(catTitle);
		
		
		ArrayList<Product> chosenCategory = new ArrayList<Product>();
		
		for (Product product : Products) { //Check all the products within the same category as the user's choice and at them to the new ArrayList
			if(product.getCategory().equals(category)) {
				chosenCategory.add(product);
			}
		}
		
		for (Product product : chosenCategory) {
			
			HBox Holder = new HBox(10); //an HBox to hold both the images and the VBox of the product's comboBoxes and Buttons
			
			VBox prods = new VBox(10); //a VBox that holds all the info, comboBoxes and Buttons
			
			Label prodName = new Label("Product Name: " + product.getName() + ", Price: $" + product.getPrice());
			prodName.setFont(Font.font("Century", FontWeight.BOLD, 15));
			
			ImageView img = new ImageView(new Image("file:///C:/Users/moham/eclipse-workspace/onlineShop/src/application/" + product.getImgFileName()));
			img.setFitWidth(150);
			img.setFitHeight(150);
			
			ComboBox<String> sizeBox = new ComboBox<String>();
			sizeBox.getItems().addAll("S", "M", "L", "XL");
			
			ComboBox<String> colorBox = new ComboBox<String>();
			colorBox.getItems().addAll("Black", "Red", "Blue", "Yellow");
			
			Text FAIL = new Text("");
			FAIL.setFill(Color.TRANSPARENT);
			FAIL.setFont(Font.font("Book Antiqua", 10));
			
			Button cartButton = new Button("Add to Cart");
			
			cartButton.setOnAction(e-> {
				String SelectedSize = sizeBox.getValue();
				String SelectedColor = colorBox.getValue();
				
				if(SelectedSize != null && SelectedColor != null) {
					product.setSelectedSize(SelectedSize);
					product.setSelectedColor(SelectedColor);
					Cart.add(product);
					System.out.println("Item added successfully");
					FAIL.setFill(Color.TRANSPARENT);
				}else if(SelectedSize!= null && SelectedColor == null){
					FAIL.setText("Please choose a color!");
					FAIL.setFill(Color.RED);
				}else if(SelectedSize == null && SelectedColor != null){
					FAIL.setText("Please choose a size!");
					FAIL.setFill(Color.RED);
				}else {
					FAIL.setText("Please choose both a size and a color!");
					FAIL.setFill(Color.RED);
				}
			});
			
			prods.getChildren().addAll(prodName, sizeBox, colorBox, cartButton, FAIL); //add the stuff to the VBox
			Holder.getChildren().addAll(img, prods); //add the VBox to the HBox
			productList.getChildren().add(Holder); //add the HBox (that holds a VBox) to the VBox
			
		}
		
		Scene productScene = new Scene(scrollPane, 600, 600);
		primaryStage.setScene(productScene);
		
		Button returnButton = new Button("Return");
		returnButton.setOnAction(e-> start(primaryStage));
		
		productList.getChildren().add(returnButton);
		
		Button cartButton = new Button("Check your cart - 🛒");
		cartButton.setOnAction(e-> showCart(primaryStage));
		
		productList.getChildren().add(cartButton);
		
	}
	
	private void showCart(Stage primaryStage) {
		if(Cart.isEmpty()) {
			Alert emptyCart = new Alert(Alert.AlertType.ERROR);
			emptyCart.setTitle("Cart's Empty");
			emptyCart.setHeaderText(null);
			emptyCart.setContentText("You haven't added anything to your cart yet!");
			emptyCart.showAndWait();
			return;
		}
		
		VBox cartItems = new VBox(10);
		
		int Total = 0;
		
		for (Product product : Cart) {
			HBox cartItemsInfo = new HBox(10);
			Label itemName = new Label("Product Name: " + product.getName() + "\n"
							+ "Size: " + product.getSelectedSize() + "\n"
									+ "Color: " + product.getSelectedColor() + "\n"
											+ "Price: $" + product.getPrice());
			
			itemName.setFont(Font.font("Book Antiqua", FontWeight.BOLD, 15));
			
			ImageView img = new ImageView(new Image("file:///C:/Users/moham/eclipse-workspace/onlineShop/src/application/" + product.getImgFileName()));
			img.setFitWidth(150);
			img.setFitHeight(150);
			
			cartItemsInfo.getChildren().addAll(img, itemName);
			
			cartItems.getChildren().addAll(cartItemsInfo);
			
			Total += product.getPrice();
		}
		
		Label cartTotal = new Label("Your cart's total is: $" + Total);
		cartTotal.setFont(Font.font("Book Antiqua", FontWeight.BOLD, 20));
		
		cartItems.getChildren().add(cartTotal);
		
		Scene itemScene = new Scene(cartItems, 600, 600);
		primaryStage.setScene(itemScene);
		
		Button returnButton = new Button("Return");
		returnButton.setOnAction(e-> start(primaryStage));
		
		cartItems.getChildren().add(returnButton);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
