package br.com.jornadadeveficiente.mercadolivre.usuario.dominio;

import org.jasypt.util.text.BasicTextEncryptor;

import javax.persistence.AttributeConverter;

public class CriptografarSenha implements AttributeConverter<String, String> {

  private static final String password = "dasuiuyrew543";

  @Override
  public String convertToDatabaseColumn(String senha) {
    BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
    basicTextEncryptor.setPassword(password);
    return basicTextEncryptor.encrypt(senha);
  }

  @Override
  public String convertToEntityAttribute(String senha) {
    BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
    basicTextEncryptor.setPassword(password);
    return basicTextEncryptor.decrypt(senha);
  }
}
