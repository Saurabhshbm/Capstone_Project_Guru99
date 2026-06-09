package utilities;

public class TestContext {

    private static String customerId;

    private static String accountId;

    public static String getCustomerId() {
        return customerId;
    }

    public static void setCustomerId(String customerId) {
        TestContext.customerId = customerId;
    }

    public static String getAccountId() {
        return accountId;
    }

    public static void setAccountId(String accountId) {
        TestContext.accountId = accountId;
    }
}