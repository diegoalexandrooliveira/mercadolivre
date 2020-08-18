package br.com.jornadadeveficiente.mercadolivre.usuario.dominio;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotEmpty
  private String usuario;

  @Size(min = 6)
  @NotEmpty
  @Convert(converter = CriptografarSenha.class)
  private String senha;

  @Past
  private LocalDateTime dataCriacao;

  public Usuario(@NotEmpty String usuario, @Size(min = 6) @NotEmpty String senha) {
    this.usuario = usuario;
    this.senha = senha;
    this.dataCriacao = LocalDateTime.now();
  }
}
