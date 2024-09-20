/**
 * @author Ramadan ismaeL
 */

package englishtraingcenter;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

import englishtraingcenter.Models.Model;

public class App extends Application {
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewsFactory().showLoginWindow();
    }
    public static void main(String[] args) {
        launch(args);
    }

}