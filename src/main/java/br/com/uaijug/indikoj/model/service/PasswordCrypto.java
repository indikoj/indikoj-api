package br.com.uaijug.indikoj.model.service;

public interface PasswordCrypto {

	String encrypt(String str);

	boolean matches(String rawPassword, String encodedPassword);

}
