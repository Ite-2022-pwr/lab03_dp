module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires spring.webflux;
    requires com.fasterxml.jackson.databind;
    requires spring.web;
    requires spring.context;
    requires reactor.core;

    opens pl.pwr.ite.client to javafx.fxml, javafx.graphics;
    opens pl.pwr.ite.client.view.controller to javafx.fxml, javafx.graphics;
    opens pl.pwr.ite.client.model.dto to com.fasterxml.jackson.databind, java.base;
    opens pl.pwr.ite.client.model.enums to com.fasterxml.jackson.databind, javafx.fxml;
    opens pl.pwr.ite.client.model.filter to com.fasterxml.jackson.databind, javafx.fxml;
    opens pl.pwr.ite.client.view.model to javafx.base;
    opens pl.pwr.ite.client.view.controller.citizen to javafx.fxml, javafx.graphics;
    opens pl.pwr.ite.client.view.controller.inspector to javafx.fxml, javafx.graphics;
    opens pl.pwr.ite.client.view.controller.manager to javafx.fxml, javafx.graphics;

}