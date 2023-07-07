package com.cloudpay.recruitment.compression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cloudpay.recruitment.compression.exception.InvalidFormatException;

public class StringDecompressionRleTest {
	
	@Test
	public void whenStringIsDecompressedOK() throws InvalidFormatException {
		
		String originalText = "AAAAANNNMMMMYYYYuuuuUUUUaaaarWWLLLLJ888DDDDDDDDD";
		
		String compressedText = "A5N3M4Y4u4U4a4r1W2L4J183D9";
		
		Assertions.assertEquals(originalText, StringDecompressionRle.process(compressedText), "Compressed text successfull");
	}
	
	@Test
	public void whenInvalidCompressionFormatIsProvided() throws InvalidFormatException {
		
		String compressedText = "DDFFGDSDAD";
		
	    Assertions.assertThrows(InvalidFormatException.class, () -> {StringDecompressionRle.process(compressedText);});
	}
	
}
