package edu.mx.utvm.eproyectos.util;

public class KeyGenerator {
	public static final String uuid() {
		String result = java.util.UUID.randomUUID().toString();
		result = result.replaceAll("-", "");
		result = result.substring(0, 10);
		return result;
	}
}
