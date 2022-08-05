package ir.ciph3r.mercury.utility;

import java.util.Arrays;

public class ArrayUtils {

    public static String createStringFromArray(String[] args, int from, int to) {
        StringBuilder builder = new StringBuilder();
        for (String s : Arrays.copyOfRange(args, from, to)) {
            builder.append(s).append(" ");
        }
        return builder.toString();
    }
}
