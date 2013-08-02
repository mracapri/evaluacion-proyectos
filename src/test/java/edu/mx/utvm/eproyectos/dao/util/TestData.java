package edu.mx.utvm.eproyectos.dao.util;

import java.util.UUID;

public class TestData {
	public static String generateId32(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String generateId10(){
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0,10);
	}
	
	public static byte[] generateBytes(){
		return TestData.generateId32().getBytes();
	}
	
	public static void main(String[] args) {
		System.out.println(TestData.generateId10());
	}
}
