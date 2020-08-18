package br.com.jornadadeveficiente.mercadolivre.usuario.dominio;

import lombok.SneakyThrows;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.AttributeConverter;

public class CriptografarSenha implements AttributeConverter<String, String> {
  @SneakyThrows
  @Override
  public String convertToDatabaseColumn(String senha) {
    return new BCryptPasswordEncoder().encode(senha);
  }

  @Override
  public String convertToEntityAttribute(String senha) {
    return senha;
  }
}
