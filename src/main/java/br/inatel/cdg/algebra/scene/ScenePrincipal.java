package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.components.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ScenePrincipal {

    private Button btnCalcCoefAngular, btnCalcCoefLinear; //Button representa botoes
    private Label labelP1x,labelP1y,labelP2x,labelP2y,labelCoefAng,labelCoefLin; //Label representam rótulos
    private TextField textFieldP1x, textFieldP2x,textFieldP1y,textFieldP2y,textFieldCoefLin,textFieldCoefAng; //TextField Representam áreas de texto
    private Reta reta = new Reta();
    public void criaScenePrincipal(Stage stage){


        //----------Area de texto P1.x---------------------------
        //Criando os labels para os pontos e os campos de texto para os dados
        labelP1x = new Label("Ponto P1.X"); //rótulos
        textFieldP1x = new TextField(); //área de texto onde vc digitara alguma coisa

        //HBox é usado para agrupar elementos horizontalmente
        HBox horizontalP1x = new HBox(labelP1x, textFieldP1x); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais


        //----------Area de texto P1.y---------------------------
        labelP1y = new Label("Ponto P1.Y");
        textFieldP1y = new TextField();
        HBox horizontalP1y = new HBox(labelP1y, textFieldP1y);

        //----------Area de texto P2.x---------------------------
        labelP2x = new Label("Ponto P2.X");
        textFieldP2x = new TextField();
        HBox horizontalP2x = new HBox(labelP2x, textFieldP2x);

        //----------Area de texto P2.y---------------------------
        labelP2y = new Label("Ponto P2.Y");
        textFieldP2y = new TextField();
        HBox horizontalP2y = new HBox(labelP2y, textFieldP2y);


        //----------Area de texto coeficiente angular---------------------------
        //Agora vamos criar a area que mostrará o que foi digitado
        textFieldCoefAng = new TextField();
        textFieldCoefAng.setEditable(false);//vamos deixar false para apenas mostrar texto
        textFieldCoefAng.setText("Coeficiente Angular: ");


        //----------Area de texto coeficiente linear---------------------------
        textFieldCoefLin = new TextField();
        textFieldCoefLin.setEditable(false);
        textFieldCoefLin.setText("Coeficiente Linear: ");
        HBox horizontalResults = new HBox(textFieldCoefAng, textFieldCoefLin);


        //----------Area de botao coeficiente angular---------------------------
        //Criamos o botão
        btnCalcCoefAngular = new Button("Calcula coeficiente angular");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefAngular.setOnAction(evento -> {
            double p1x = Double.parseDouble(textFieldP1x.getText());
            double p1y = Double.parseDouble(textFieldP1y.getText());
            double p2x = Double.parseDouble(textFieldP2x.getText());
            double p2y = Double.parseDouble(textFieldP2y.getText());
            reta.setPoints(p1x,p1y,p2x,p2y);

            textFieldCoefAng.setText(String.valueOf(reta.angularCoef()));//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });

        //----------Area de botao coeficiente Linear---------------------------
        btnCalcCoefLinear = new Button("Calcula coeficiente linear");
        btnCalcCoefLinear.setOnAction(evento -> {
            double p1x = Double.parseDouble(textFieldP1x.getText());
            double p1y = Double.parseDouble(textFieldP1y.getText());
            double p2x = Double.parseDouble(textFieldP2x.getText());
            double p2y = Double.parseDouble(textFieldP2y.getText());
            reta.setPoints(p1x,p1y,p2x,p2y);

            textFieldCoefLin.setText(String.valueOf(reta.linearCoef()));//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });
        HBox horizontalButtons = new HBox(btnCalcCoefAngular, btnCalcCoefLinear);

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(horizontalP1x, horizontalP1y,horizontalP2x,horizontalP2y,horizontalResults,horizontalButtons);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

}
