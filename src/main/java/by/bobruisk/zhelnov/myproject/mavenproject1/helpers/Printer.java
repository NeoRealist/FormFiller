package by.bobruisk.zhelnov.myproject.mavenproject1.helpers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Printer {
	
	public void printExcelFile(File fileToPrint) {
		String path = fileToPrint.getAbsolutePath();
		{
			try {				
					Workbook w = new XSSFWorkbook(new FileInputStream(path));
					
					for (int i = 0; i < w.getNumberOfSheets(); i++) {
						w.getSheetAt(i).setSelected(true);					
					}	
					
					FileOutputStream fileOut = new FileOutputStream(path);
					w.write(fileOut);
					fileOut.close();
					
					Desktop.getDesktop().print(new File(path));
					
		

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
