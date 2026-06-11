package utilities;

import java.util.UUID;

public class RandomDataGenerator {

    public static String generateEmail() {

        return "user"
                + UUID.randomUUID()
                .toString()
                .substring(0,6)
                + "@gmail.com";
    }

    public static String generateMobile() {

        String timestamp =
                String.valueOf(System.currentTimeMillis());

        return "98"
                + timestamp.substring(
                        timestamp.length()-8);
    }
}