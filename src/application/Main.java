package application;
	
import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
	private int j;

	@Override
	public void start(Stage primaryStage) {
		try {
			//o stackPane e a cena à qual ele é adicionado sao a base da janela
			StackPane rootMesmo = new StackPane();
			Scene scene0 = new Scene(rootMesmo, 1500, 1500);
			
			//a grade no qual os itens sao distribuidos
			GridPane grade = new GridPane();
			
			grade.setHgap(10);
			grade.setVgap(10);
			grade.setPadding(new Insets(25, 25, 25, 25));
			
			
			//grade.setBackground(new Background(new BackgroundFill(Color.rgb(200, 100, 200), CornerRadii.EMPTY, Insets.EMPTY)));
			rootMesmo.setBackground(new Background(new BackgroundFill(Color.rgb(250, 255, 119), CornerRadii.EMPTY, Insets.EMPTY)));
			
			//geChildren serve pra subordinar a grade ao painel base(gridPane)
			rootMesmo.getChildren().addAll(grade);
			//grade.setAlignment(Pos.CENTER);
			
			//define a cena/gridpane como base
			primaryStage.setScene(scene0);
			
			//Scene scene = new Scene(grade, 500, 500);
			//primaryStage.setScene(scene);
			
			
			Text titulo = new Text(" Teste");
			
			titulo.setFont(Font.font("politica", FontWeight.LIGHT, 60));
			grade.add(titulo, 2, 0, 6, 1);
			titulo.setTextAlignment(TextAlignment.CENTER);
			titulo.setFill(Color.rgb(200, 100, 200));
			grade.setAlignment(Pos.CENTER);
			
			//Label textoBusca = new Label("busca:");
			//grade.add(textoBusca, 0, 1);
			
			TextField caixaBusca = new TextField("busca:");
			caixaBusca.setMinSize(226, 20);
			grade.add(caixaBusca, 0, 1);
			//caixaBusca.setAlignment(Pos.CENTER);
			
			//Button botao = new Button("Erro 500");
			//HBox hCaixa = new HBox(10);
			//hCaixa.getChildren().add(botao);
			//grade.add(hCaixa, 0, 4);
			
			final Text actiontarget = new Text();
			grade.add(actiontarget, 0, 6);
			
			
			Button[] botoes = new Button[70];
			HBox[] hCaixas = new HBox[70];
			
			int horizontal = 0;
			int vertical = 2;
			
			
			BackEnd m1 = new BackEnd();
			//pegando o metodo que tem a lista com o nome de todos os arquivos
			String [] nomes = m1.listarUsuariosPraInterface("");
			String [] nomesSemTxt = new String[nomes.length];
			
			for(int i = 0; i<2; i++) {
				grade.getColumnConstraints().add(new ColumnConstraints(150));
			}
			
			
			//remove o .txt do nome do arquivo para imprimir só o nome dos usuarios na tela
			for(int i = 0; i<nomes.length; i++) {
				nomesSemTxt[i] = nomes[i].replace(".txt","");
			}
			
			
			
			for(j = 0; j<nomesSemTxt.length; j++) {
				
				botoes[j] = new Button(nomesSemTxt[j]);
				botoes[j].setMinWidth(150);
				botoes[j].setMaxWidth(150);
				
				hCaixas[j] = new HBox(10);
				hCaixas[j].getChildren().add(botoes[j]);
				
				//botoes[i].setBackground(new Background(new BackgroundFill(Color.rgb(200, 100, 200), new CornerRadii(2), Insets.EMPTY)));
				if(horizontal>4) {
					vertical++;
					horizontal = 0;
					grade.add(hCaixas[j], horizontal, vertical);
					
				}
				else {
					grade.add(hCaixas[j], horizontal, vertical);
					horizontal++;
					System.out.println(horizontal);
				}
				System.out.println("fora"+j);
				
				
				
			}
			
			
			for(j = 0; j<nomesSemTxt.length; j++) {
				final int m = j;
				botoes[j].setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent e) {
						
						
						StackPane root = new StackPane();
						/*
						StackPane rootPane = new StackPane();
						Scene scene = new Scene(rootPane, 600, 600);
					    ScrollPane scrollPane = new ScrollPane();
					    scrollPane.setFitToHeight(true);
					    
					    BorderPane root = new BorderPane(scrollPane);
					    root.setPadding(new Insets(15));
					    */
						ScrollBar s1 = new ScrollBar();
				        s1.setMax(500);
				        s1.setMin(0);
				        s1.setValue(100);
				        s1.setUnitIncrement(30);
				        s1.setBlockIncrement(35);
				        
				        s1.setOrientation(Orientation.VERTICAL);
						
				        s1.valueProperty().addListener((ObservableValue<? extends Number> ov, 
				                Number old_val, Number new_val) -> {
				                    System.out.println(-new_val.doubleValue());
				            });  
				        
						GridPane grade2 = new GridPane();
						
						grade2.setHgap(10);
						grade2.setVgap(10);
						grade2.setPadding(new Insets(25, 25, 25, 25));
						Scene scene3 = new Scene(root, 1500, 1500);
						root.getChildren().addAll(grade2);
						grade2.setAlignment(Pos.BASELINE_CENTER);
						primaryStage.setScene(scene3);
						scene3.getWindow().centerOnScreen();
						root.setBackground(new Background(new BackgroundFill(Color.rgb(250, 230, 119), CornerRadii.EMPTY, Insets.EMPTY)));
						
						//Scene scene4 = new Scene(root, 400, 400);

						//rootPane.getChildren().addAll(grade2,root);
						//primaryStage.setScene(scene);
						//primaryStage.show();
						
						/*
						ScrollBar sc = new ScrollBar();
						sc.setMin(0);
						sc.setMax(100);
						sc.setValue(50);
						
						sc.setLayoutX(scene3.getWidth()-sc.getWidth());
				        sc.setMin(0);
				        sc.setOrientation(Orientation.VERTICAL);
				        sc.setPrefHeight(180);
				        sc.setMax(360);
				        root.getChildren().addAll(sc);
				        */
				        
						actiontarget.setText(m1.texto(nomesSemTxt[m]));
				        //Text t = new Text(m1.texto(nomesSemTxt[m]));
				        System.out.println("t");
				        
				        Button volta = new Button("Voltar");
						HBox caixa2 = new HBox(10);
						caixa2.getChildren().add(volta);
						grade2.add(caixa2, 0, 4);
						
						volta.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e) {
								start(primaryStage);
							}
							});
						
						Text titulo = new Text(nomesSemTxt[m]);
						titulo.setFont(Font.font("politica", FontWeight.BLACK, 30));
						
						grade2.add(titulo, 0, 2);
						grade2.add(actiontarget, 0, 3);
						actiontarget.setFont(Font.font("politica", FontWeight.LIGHT, 20));
						actiontarget.setFill(Color.rgb(200, 100, 200));
						
						
						//VER O GRID:
						//grade2.setGridLinesVisible(true);
						
					}
				});
			}
			
			/*
			botao.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e) {
					
					
					GridPane grade2 = new GridPane();
					grade2.setAlignment(Pos.CENTER);
					grade2.setHgap(10);
					grade2.setVgap(10);
					grade2.setPadding(new Insets(25, 25, 25, 25));
					Scene scene3 = new Scene(grade2, 300, 275);
					primaryStage.setScene(scene3);
					
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("aconteceu");
					grade2.add(actiontarget, 0, 6);
				}
			});
			*/
			
			//float[] hsb = Color.RGBtoHSB(23, 66, 99, null);
			//Scene scene2 = new Scene(root,900,400);
			
			//VER O GRID:
			//grade.setGridLinesVisible(true);
			
			scene0.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene2);
			scene0.getWindow().centerOnScreen();
			primaryStage.show();
			primaryStage.setTitle("WIKing");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
