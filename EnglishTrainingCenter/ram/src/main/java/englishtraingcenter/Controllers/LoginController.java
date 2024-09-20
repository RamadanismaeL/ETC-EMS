/**
 * @author Ramadan ismaeL
 */

package englishtraingcenter.Controllers;

import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

import englishtraingcenter.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    private Alert alert;
    private PreparedStatement prepare;
    private ResultSet result;
    private Connection connect;

    @SuppressWarnings("exports")
    public TextField username_fld;
    @SuppressWarnings("exports")
    public PasswordField password_fld;
    @SuppressWarnings("exports")
    public Button login_btn;
    @SuppressWarnings("exports")
    public Button close;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnAction(event -> close());
        login_btn.setOnAction(event -> onLogin());
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

    public void onLogin() {
        String sql = "SELECT * FROM tbuser WHERE username = ? AND password = ?";        
                
        connect = Model.getInstance().getConexaoDAO().connectDAO();
        try {            
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username_fld.getText());
            prepare.setString(2, password_fld.getText());
            
            result = prepare.executeQuery();
            Alert alert;

            if(username_fld.getText().isEmpty() || password_fld.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Mensagem de Erro");
                alert.setHeaderText(null);
                alert.setContentText("Preencha o campo obrigatório!");
                alert.showAndWait();
            } else {
                if(result.next()) {
                    //getData.username = username_fld.getText();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Mensagem de Informação");
                    alert.setHeaderText(null);
                    alert.setContentText("** AVISO **\r\n" + //
                                                "\r\n" + //
                                                "Seja muito bem-vindo!\r\n" + //
                                                "\r\n" + //
                                                "No momento, o sistema está em manutenção e ainda conta com funcionalidades limitadas. \r\n" + //
                                                "\r\n" + //
                                                "Os botões disponíveis e em funcionamento são: Home, Estudante, Formador, Funcionário, Desconectar, Usuário, **Minimizar e Sair.\r\n" + //
                                                "\r\n" + //
                                                "Vale ressaltar que o gerenciamento completo do sistema ainda não foi implementado.");
                    alert.showAndWait();

                    login_btn.getScene().getWindow().hide();
                    Model.getInstance().getViewsFactory().showDashboardWindow();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Messagem de Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuário/Senha inválido!");
                    alert.showAndWait();
                }
            }
        } catch(Exception error) {
            error.printStackTrace();
        } finally {
            try {
                if (connect != null && !connect.isClosed()) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
