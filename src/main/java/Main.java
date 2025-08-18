import java.util.*;

class Codec {
    public String encode(List<String> strs) {
        // Initialize an empty string to hold the encoded string.
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            // Append the length, the delimiter, and the string itself.
            encodedString.append(s.length()).append("/").append(s);
        }

        System.out.println(encodedString.toString());
        return encodedString.toString();
    }
    public List<String> decode(String s) {
        // Initialize a list to hold the decoded strings.
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            System.out.println(i);
            // Find the delimiter.
            int delim = s.indexOf("/", i);
            // Get the length, which is before the delimiter.
            int length = Integer.parseInt(s.substring(i, delim));
            /* Get the string, which is of
            length after the delimiter. */
            String str = s.substring(delim + 1, delim + 1 + length);
            // Add the string to the list.
            decodedStrings.add(str);
            // Move the index to the start of the next length.
            i = delim + 1 + length;
        }
        return decodedStrings;
    }
}
public class Main {
    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> input = Arrays.asList("123/", "4/world",  "cutie");
        String encoded = codec.encode(input);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded:");
        for (String s : decoded) {
            System.out.println(s);
        }
    }
}
