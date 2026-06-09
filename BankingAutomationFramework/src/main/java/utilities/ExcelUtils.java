package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    public static void loadExcel(String sheetName) {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/testdata/BankingData.xlsx");

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static String getCellData(
            int rowNumber,
            int columnNumber) {

        return sheet
                .getRow(rowNumber)
                .getCell(columnNumber)
                .toString();
    }

    public static int getRowCount() {

        return sheet.getLastRowNum();
    }
}