module co.edu.uniquindio.reservasevento {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.reservasevento to javafx.fxml;

    exports co.edu.uniquindio.reservasevento.controller;
}

//    exports co.edu.uniquindio.reservasevento;
//    exports co.edu.uniquindio.reservasevento.controller;
//    exports co.edu.uniquindio.reservasevento.exceptions;
//    exports co.edu.uniquindio.reservasevento.model;
//    exports co.edu.uniquindio.reservasevento.utils;
//    exports co.edu.uniquindio.reservasevento.viewController;