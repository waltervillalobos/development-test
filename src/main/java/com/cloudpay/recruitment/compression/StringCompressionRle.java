package com.cloudpay.recruitment.compression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCompressionRle {
	
	public static final Pattern pattern = Pattern.compile("(.)\\1*");

	
	public static String process(String input) {
		
		Matcher matcher = pattern.matcher(input);
		
		StringBuilder compressed = new StringBuilder();
		
		while(matcher.find()) {
			
			int count = matcher.group().length();
			char character = matcher.group().charAt(0);
			
			if (count > 9) {
				
				String repeatText = new String(new char[]{character, '9'});
				int duplicate = count / 9; 
				appender(compressed,repeatText, duplicate);
				compressed.append(character).append(count - (duplicate * 9));
				
			} else {
			
				compressed.append(character).append(count);
			}
		}
		
        return compressed.toString();
	}
	
    private static void appender(StringBuilder output, String text, int count) {
        for (int j = 0; j < count; j++) {
            output.append(text);
        }
    }

}
