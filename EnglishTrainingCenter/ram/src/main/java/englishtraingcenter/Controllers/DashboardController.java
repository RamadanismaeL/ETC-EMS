/**
 * @author Ramadan ismaeL
 */

package englishtraingcenter.Controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import englishtraingcenter.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DashboardController implements Initializable {
    private Alert alert;
    private String css = this.getClass().getResource("/englishtraingcenter/Styles/leftContainer.css").toExternalForm();

    @SuppressWarnings("exports")
    public BorderPane form_main;
    @SuppressWarnings("exports")
    public ImageView marca;
    @SuppressWarnings("exports")
    public Button logout;
    @SuppressWarnings("exports")
    public Button close;
    @SuppressWarnings("exports")
    public Button minimize;
    @SuppressWarnings("exports")
    public AnchorPane form_funcionarios;
    @SuppressWarnings("exports")
    public AnchorPane form_formadores;
    @SuppressWarnings("exports")
    public AnchorPane form_usuarios;
    @SuppressWarnings("exports")
    public AnchorPane form_home;
    @SuppressWarnings("exports")
    public AnchorPane form_estudantes;
    @SuppressWarnings("exports")
    public Button btn_home;
    @SuppressWarnings("exports")
    public Button btn_estudante;
    @SuppressWarnings("exports")
    public Button btn_formador;
    @SuppressWarnings("exports")
    public MenuItem menuItem_funcionario;
    @SuppressWarnings("exports")
    public MenuItem menuItem_usuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_home.setStyle("-fx-background-color: linear-gradient(to bottom right, #643887, #9e5bd4, #ddd)");
        close.setOnAction(event -> close());
        minimize.setOnAction(event -> minimize());
        logout.setOnAction(event -> logout());
        btn_home.setOnAction(event -> formHome());
        btn_estudante.setOnAction(event -> formEstudante());
        btn_formador.setOnAction(event -> formFormador());
        menuItem_funcionario.setOnAction(event -> formFuncionario());
        menuItem_usuario.setOnAction(event -> formUsuario());
    }

    public void close() {
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(" Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Têm certeza que deseja sair?");
        Optional<ButtonType> option = alert.showAndWait();

        if(option.get().equals(ButtonType.OK)) {
            System.exit(0);
        }
    }

    public void minimize() {
        Stage stage = (Stage)form_main.getScene().getWindow();
        stage.setIconified(true);
    }

    public void logout() {
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Mensagem de Confirmação");
        alert.setHeaderText(null);
        alert.setContentText("Têm certeza que deseja Desconectar?");
        Optional<ButtonType> option = alert.showAndWait();

        if(option.get().equals(ButtonType.OK)) {
            logout.getScene().getWindow().hide();            
            Model.getInstance().getViewsFactory().showLoginWindow();
        }
    }

    public void formHome() {        
        form_home.setVisible(true);
        form_formadores.setVisible(false);
        form_funcionarios.setVisible(false);
        form_usuarios.setVisible(false);
        form_estudantes.setVisible(false);
        
        btn_home.setStyle("-fx-background-color: linear-gradient(to bottom right, #643887, #9e5bd4, #ddd)");
        btn_estudante.setStyle(css);
        btn_formador.setStyle(css);
    }    

    public void formEstudante() {        
        form_home.setVisible(false);
        form_formadores.setVisible(false);
        form_funcionarios.setVisible(false);
        form_usuarios.setVisible(false);
        form_estudantes.setVisible(true);
        
        btn_home.setStyle(css);
        btn_estudante.setStyle("-fx-background-color: linear-gradient(to bottom right, #643887, #9e5bd4, #ddd)");
        btn_formador.setStyle(css);
    }

    public void formFormador() {        
        form_home.setVisible(false);
        form_formadores.setVisible(true);
        form_funcionarios.setVisible(false);
        form_usuarios.setVisible(false);
        form_estudantes.setVisible(false);
        
        btn_home.setStyle(css);
        btn_estudante.setStyle(css);
        btn_formador.setStyle("-fx-background-color: linear-gradient(to bottom right, #643887, #9e5bd4, #ddd)");
    }

    public void formFuncionario() {        
        form_home.setVisible(false);
        form_formadores.setVisible(false);
        form_funcionarios.setVisible(true);
        form_usuarios.setVisible(false);
        form_estudantes.setVisible(false);
        
        btn_home.setStyle(css);
        btn_estudante.setStyle(css);
        btn_formador.setStyle(css);
    }

    public void formUsuario() {        
        form_home.setVisible(false);
        form_formadores.setVisible(false);
        form_funcionarios.setVisible(false);
        form_usuarios.setVisible(true);
        form_estudantes.setVisible(false);
        
        btn_home.setStyle(css);
        btn_estudante.setStyle(css);
        btn_formador.setStyle(css);
    }
}
