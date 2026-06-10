package utilities;

public class TestContext {

    private static ThreadLocal<String> customerId =
            new ThreadLocal<>();

    private static ThreadLocal<String> accountId =
            new ThreadLocal<>();

    public static String getCustomerId() {
        return customerId.get();
    }

    public static void setCustomerId(String id) {
        customerId.set(id);
    }

    public static String getAccountId() {
        return accountId.get();
    }

    public static void setAccountId(String id) {
        accountId.set(id);
    }
}