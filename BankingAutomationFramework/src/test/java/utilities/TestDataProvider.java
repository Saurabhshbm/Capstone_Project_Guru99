package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "customerData")
    public static Object[][] getCustomerData() {

        int rowCount =
                ExcelUtils.getRowCount(
                        "CustomerData");

        Object[][] data =
                new Object[rowCount][7];

        for (int i = 1; i <= rowCount; i++) {

            data[i - 1][0] =
                    ExcelUtils.getCellData(
                            "CustomerData",
                            i,
                            0);

            data[i - 1][1] =
                    ExcelUtils.getCellData(
                            "CustomerData",
                            i,
                            1);

            data[i - 1][2] =
                    ExcelUtils.getCellData(
                            "CustomerData",
                            i,
                            2);

            data[i - 1][3] =
                    ExcelUtils.getCellData(
                            "CustomerData",
                            i,
                            3);

            data[i - 1][4] =
                    ExcelUtils.getCellData(
                            "CustomerData",
                            i,
                            4);

            data[i - 1][5] =
                    ExcelUtils.getCellData(
                            "CustomerData",
                            i,
                            5);

            data[i - 1][6] =
                    ExcelUtils.getCellData(
                            "CustomerData",
                            i,
                            6);
        }

        return data;
    }
}