package com.wvillalobos.recruitment.compression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCompressionRle {
	
	public static final Pattern pattern = Pattern.compile("(.)\\1*");
	
	public static final int MAX_GROUP_LENGHT = 9;
	public static final char MAX_CHAR = '9';

	
	public static String process(String input) {
		
		Matcher groupMatcher = pattern.matcher(input);
		
		StringBuilder output = new StringBuilder();
		
		compress(groupMatcher, output);
		
        return output.toString();
	}

	private static void compress(Matcher groupMatcher, StringBuilder output) {
		
		while(groupMatcher.find()) {
			
			int charGroupLenght = groupMatcher.group().length();
			char character = groupMatcher.group().charAt(0);
			
			if (charGroupLenght > MAX_GROUP_LENGHT) {
				
				appendCharGroupsMoreThanMaxLenght(output, charGroupLenght, character);
				
			} else {
			
				output.append(character).append(charGroupLenght);
			}
		}
	}

	private static void appendCharGroupsMoreThanMaxLenght(StringBuilder compressed, int charGroupLenght, char character) {
		
		String repeatText = new String(new char[]{character, MAX_CHAR});
		
		int duplicationQuantity = charGroupLenght / MAX_GROUP_LENGHT; 
		appender(compressed,repeatText, duplicationQuantity);
		compressed.append(character).append(charGroupLenght - (duplicationQuantity * MAX_GROUP_LENGHT));
	}
	
    private static void appender(StringBuilder output, String text, int count) {
    	
        for (int j = 0; j < count; j++) {
            output.append(text);
        }
    }

}
