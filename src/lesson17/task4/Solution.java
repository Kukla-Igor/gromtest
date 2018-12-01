package lesson17.task4;

public class Solution {
    public static void main(String[] args) {
        System.out.println(validate("https://www.kfngkfdsj.com"));
        String string = "https://kfngkfdsj.com";
        String string2 = string.substring(0, string.length() - 4);
        System.out.println(string2);


    }


    public static boolean validate(String address) {

        if (address.endsWith(".com") || address.endsWith(".org") || address.endsWith(".net")) {
            String newAddress = address.substring(0, address.length() - 4);
            if (newAddress.contains("www.")) {
                if (newAddress.substring(0, 7).equals("http://") && isWord(newAddress.substring(11)))
                    return true;
                if (address.substring(0, 8).equals("https://") && (isWord(newAddress.substring(12))))

                    return true;
            }
            else
            if (newAddress.substring(0, 7).equals("http://") && isWord(newAddress.substring(7)))
                return true;
            if (address.substring(0, 8).equals("https://") && (isWord(newAddress.substring(8))))

                return true;
        }
        return false;
    }

    public static boolean isWord(String word) {
        if (word.isEmpty())
            return false;
        byte[] bytes = word.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (!Character.isLetterOrDigit(bytes[i])) {
                return false;
            }
        }
        return true;
    }
}
