package com.ntn.testhometiki.utils;

import java.util.regex.Pattern;

/*If the keyword is more than one word, then display in two lines.
  These two lines should have minimum difference in length.
  For example: "nguyễn nhật ánh" should be "nguyễn\nnhật ánh", not "nguyễn nhật\nánh".
  Because difference in length of "nguyễn" and "nhật ánh" is less than difference in length
  of "nguyễn nhật" and "ánh".
*/
public class FormatKeywork {

    public static String splitKeyword(String string) {
        String stringCorrect = makeStringCorrect(string);
        if (stringCorrect.isEmpty() || isOneWord(stringCorrect)) {
            return stringCorrect;
        }
        return splitWord(new StringBuilder(stringCorrect),stringCorrect.length());
    }

    private static String splitWord(StringBuilder sb, int minDifference) {
        int index = 0;
        int length = sb.length();
        int min = minDifference;

        for (int i = 0; i < length; i++) {
            char ch = sb.charAt(i);
            if (ch == ' ') {
                int l2 = length - i - 1;
                int difference = Math.abs(l2 - i);
                if (difference <= min) {
                    index = i;
                    if (difference == 0) {
                        break;
                    }
                    min = difference;
                }
            }
        }
        sb.setCharAt(index, '\n');
        return sb.toString();
    }

    // Check if the string is a word or not
    private static boolean isOneWord(String string) {
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (ch == ' ') {
                return false;
            }
        }
        return true;
    }

    // Remove leading, trailing and duplicate whitespace
    private static String makeStringCorrect(String string) {
        return string.trim().replace(Pattern.compile("[\\s]").toString(), " ");
    }
}
