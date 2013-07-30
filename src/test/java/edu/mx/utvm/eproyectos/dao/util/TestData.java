package edu.mx.utvm.eproyectos.dao.util;

import java.util.UUID;

public class TestData {
	public static String generateId32(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static byte[] generateBytes(){
		return TestData.generateId32().getBytes();
	}
}
