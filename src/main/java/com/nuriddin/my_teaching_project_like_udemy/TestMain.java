package com.nuriddin.my_teaching_project_like_udemy;


// t.me/superJavaDeveloper 01.07.2022;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\zuxra\\Desktop\\YouTube-Playlist.xlsx";
        FileInputStream file = new FileInputStream(fileLocation);
            Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING: data.get(i).add(cell.getRichStringCellValue().getString()); break;
                    case NUMERIC: if (DateUtil.isCellDateFormatted(cell)) {
                        data.get(i).add(cell.getDateCellValue() + "");
                    } else {
                        data.get(i).add(cell.getNumericCellValue() + "");
                    } break;
                    case BOOLEAN: data.get(i).add(cell.getBooleanCellValue() + ""); break;
                    case FORMULA: data.get(i).add(cell.getCellFormula() + ""); break;
                    default: data.get(i).add(" ");
                }
            }
            i++;
        }
        System.out.println(data);

    }

}
