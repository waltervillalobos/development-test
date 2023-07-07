package com.wvillalobos.recruitment.compression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wvillalobos.recruitment.compression.StringCompressionRle;

public class StringCompressionRleTest {
	
	@Test
	public void whenStringIsCompressedOK() {
		
		String originalText = "AAAAANNNMMMMYYYYuuuuUUUUaaaarWWLLLLJ888DDDDDDDDD";
		
		String compressedText = "A5N3M4Y4u4U4a4r1W2L4J183D9";
		
		Assertions.assertEquals(compressedText, StringCompressionRle.process(originalText), "Compressed text successfull");
	}

	@Test
	public void whenStringContainsMoreThanNineCharInARow() {
		
		String originalText = "DDDDDDDDDDDGG";
		
		String compressedText = "D9D2G2";
		
		Assertions.assertEquals(compressedText, StringCompressionRle.process(originalText), "Compressed text successfull");
	}
}
