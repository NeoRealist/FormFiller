module by.bobruisk.zhelnov.myproject.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
	requires spire.xls.free;
	requires java.desktop;
	requires org.apache.poi.ooxml;
	requires java.sql;
	requires javafx.graphics;
//	requires spire.xls;


    opens by.bobruisk.zhelnov.myproject.mavenproject1 to javafx.fxml;
    exports by.bobruisk.zhelnov.myproject.mavenproject1;
    opens by.bobruisk.zhelnov.myproject.mavenproject1.Controllers to javafx.fxml;
    exports by.bobruisk.zhelnov.myproject.mavenproject1.Controllers;
}
