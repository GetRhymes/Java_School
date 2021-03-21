import javafx.util.Pair;

public class Unpacker {

    private static Boolean checkString(String str) {
        int counterBracket = 0;
        int counter = 0;
        while (counter < str.length()) {
            if (Character.isAlphabetic(str.charAt(counter))) {
                counter++;
            } else if (Character.isDigit(str.charAt(counter)) && counter + 2 < str.length() - 1) {
                if (str.charAt(counter + 1) == '[' && str.charAt(counter + 2) != ']') {
                    counterBracket++;
                    counter += 2;
                } else {
                    return false;
                }
            } else if (str.charAt(counter) == ']') {
                counterBracket--;
                counter++;
            } else return false;
        }
        return counterBracket == 0;
    }

    private static Pair<String, Integer> unpacking(String str) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        int temp = str.length();
        while (counter <= temp - 1) {
            if (str.charAt(counter) == ']') return new Pair<>(result.toString(), counter + 1);
            else if (Character.isDigit(str.charAt(counter))) {
                Pair<String, Integer> res = new Pair<>("", 0);
                for (int it = 0;  it < Character.digit(str.charAt(counter), 10); it++) {
                    res = unpacking(str.substring(counter + 2));
                    result.append(res.getKey());
                }
                counter += res.getValue() + 2;
            } else if (Character.isAlphabetic(str.charAt(counter))) {
                result.append(str.charAt(counter));
                counter++;
            }
        }
        return new Pair<>(result.toString(), counter);
    }

    public static String unpackingString(String str) {
        if (checkString(str)) return unpacking(str).getKey();
        else throw new IllegalArgumentException("Недопустимая строка ввода");
    }
}

