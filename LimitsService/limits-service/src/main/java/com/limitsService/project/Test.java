package com.limitsService.project;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) {
        String excelFilePath = "C:/Users/surya/OneDrive/Desktop/Nikhil/spring-microservices-master (1)/Practice/LimitsService/limits-service/src/main/java/com/limitsService/project/DOC-20231220-WA0003..xlsx";
        String wordFilePath = "word-document.docx";

        try (FileInputStream excelFile = new FileInputStream(excelFilePath);
             XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
             XWPFDocument document = new XWPFDocument();
             FileOutputStream out = new FileOutputStream(wordFilePath)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            Row columnHeader = sheet.getRow(1);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            rowIterator.next();
            int rowCounts=1;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();

                Iterator<Cell> cellIterator = row.cellIterator();
                StringBuilder rowContent = new StringBuilder();
                int i=0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if(i==0) {
                        rowContent.append(Integer.toString(rowCounts)+" ").append(columnHeader.getCell(i)).append(" - ").append(new BigDecimal(cell.toString()).toPlainString());
                    }else{
                        rowContent.append(columnHeader.getCell(i)).append(" - ").append(cell.toString());
                    }
                    run.setText(rowContent.toString());

                    run.setText("\n");
                    rowContent = new StringBuilder();
                    i++;
                    if(i==9){
                        break;
                    }
                    run.addBreak();
                }
                rowCounts++;
                if(rowCounts==101){
                    break;
                }

                run.setText("\n\n");
            }

            document.write(out);
            System.out.println("Word document created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
