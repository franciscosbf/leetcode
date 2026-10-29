namespace _8.Solution;

public class Solution {
    public int MyAtoi(string s) {
        int i = 0;
        int n = s.Length;

        // Whitespace: skip leading spaces
        while (i < n && s[i] == ' ') {
            i++;
        }

        // Signedness: an optional single '+' or '-'
        int sign = 1;
        if (i < n && (s[i] == '+' || s[i] == '-')) {
            sign = s[i] == '-' ? -1 : 1;
            i++;
        }

        // Conversion: accumulate digits until a non-digit or the end of the string.
        // Leading zeros need no special handling, they just keep result at 0.
        int result = 0;
        while (i < n && char.IsAsciiDigit(s[i])) {
            int digit = s[i] - '0';

            // Rounding: check for overflow *before* doing result * 10 + digit.
            // int.MaxValue = 2147483647, so overflow happens if result is already
            // past 214748364, or equal to it and the next digit is greater than 7.
            // For negatives the limit is 2147483648, which also lands here (digit 8),
            // and clamping to int.MinValue gives the right answer.
            if (result > int.MaxValue / 10 || (result == int.MaxValue / 10 && digit > int.MaxValue % 10)) {
                return sign == 1 ? int.MaxValue : int.MinValue;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
