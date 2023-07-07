package com.cloudpay.recruitment.compression;

import com.cloudpay.recruitment.compression.exception.InvalidFormatException;

public class StringDecompressionRle {
	
	
    public static String process(String input) throws InvalidFormatException {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            char character = input.charAt(i);
            char countChar = input.charAt(i + 1);

            int count = parseCount(countChar);

            appendCharacter(output, character, count);
        }

        return output.toString();
    }

    private static int parseCount(char countChar) throws InvalidFormatException {
        if (Character.isDigit(countChar)) {
            return Character.getNumericValue(countChar);
        } else {
            throw new InvalidFormatException("Text from the input doesn't correspond to a Run-Length Encoding compression");
        }
    }

    private static void appendCharacter(StringBuilder output, char character, int count) {
        for (int j = 0; j < count; j++) {
            output.append(character);
        }
    }
	
	
}
