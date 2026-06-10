package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    private static Workbook workbook;

    static {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/testdata/TestData.xlsx");

            workbook =
                    new XSSFWorkbook(fis);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static String getCellData(
            String sheetName,
            int row,
            int column) {

        Sheet sheet =
                workbook.getSheet(sheetName);

        return sheet.getRow(row)
                .getCell(column)
                .toString();
    }

    public static int getRowCount(
            String sheetName) {

        return workbook.getSheet(sheetName)
                .getLastRowNum();
    }
}