package com.cloudpay.recruitment.UI;

import java.util.Scanner;

import com.cloudpay.recruitment.compression.StringDecompressionRle;
import com.cloudpay.recruitment.compression.exception.InvalidFormatException;

public class StringDecompressionHandler {
	
	public static void handle(Scanner scanner) {
		
        System.out.print("Enter the string to decompress: ");
        String inputToDecompress = scanner.nextLine();
   
		try {
			String decompressedString = StringDecompressionRle.process(inputToDecompress);
			System.out.println("Decompressed string: " + decompressedString);
			
		} catch (InvalidFormatException e) {
			System.out.println(e.getMessage());
		}
     
	}


}
