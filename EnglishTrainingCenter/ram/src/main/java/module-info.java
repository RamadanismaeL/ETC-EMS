/**
 * @author Ramadan ismaeL
 */

module englishtraingcenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;

    opens englishtraingcenter to javafx.fxml;
    exports englishtraingcenter;
    exports englishtraingcenter.Controllers;
    exports englishtraingcenter.Models;
    exports englishtraingcenter.Views;
}
