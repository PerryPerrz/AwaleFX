module ia.awalefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ia.awalefx to javafx.fxml;
    exports ia.awalefx;
    exports ia.awalefx.designPattern;
    opens ia.awalefx.designPattern to javafx.fxml;
}