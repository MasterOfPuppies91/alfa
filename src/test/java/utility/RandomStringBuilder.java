package utility;

public class RandomStringBuilder {

    public static String getRandomString(String acceptedSymbols, int length) {
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            randomString.append(acceptedSymbols.charAt((int) (acceptedSymbols.length() * Math.random())));
        }
        return randomString.toString();
    }
}
