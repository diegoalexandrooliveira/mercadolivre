package br.com.jornadadeveficiente.mercadolivre.usuario.api;

import br.com.jornadadeveficiente.mercadolivre.usuario.dominio.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NovoUsuarioRequest {

  @NotBlank
  @Email
  private String usuario;
  @NotBlank
  @Size(min = 6)
  private String senha;

  public Usuario novoUsuario() {
    return new Usuario(usuario, senha);
  }


}
