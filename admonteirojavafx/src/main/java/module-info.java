module com.ad.admonteirojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;

    opens com.ad.admonteirojavafx to javafx.fxml;
    exports com.ad.admonteirojavafx;
    exports com.ad.admonteirojavafx.controller;
    opens com.ad.admonteirojavafx.controller to javafx.fxml;
}