module by.bobruisk.zhelnov.myproject.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens by.bobruisk.zhelnov.myproject.mavenproject1 to javafx.fxml;
    exports by.bobruisk.zhelnov.myproject.mavenproject1;
    opens by.bobruisk.zhelnov.myproject.mavenproject1.Controllers to javafx.fxml;
    exports by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;
}
