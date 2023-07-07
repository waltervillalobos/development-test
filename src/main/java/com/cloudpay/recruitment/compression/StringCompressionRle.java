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
			compressed.append(character).append(count);
		}
		
        return compressed.toString();
	}

}
