/**
 * @author Ramadan ismaeL
 */

package englishtraingcenter.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewsFactory {
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/englishtraingcenter/Controllers/Login.fxml"));
        createStage(loader);
    }

    public void showDashboardWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/englishtraingcenter/Controllers/Dashboard.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch(Exception erro) {
            System.out.println(erro.getMessage());
            erro.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}
