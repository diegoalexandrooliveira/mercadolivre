package br.com.jornadadeveficiente.mercadolivre.usuario.api;


import br.com.jornadadeveficiente.mercadolivre.usuario.dominio.Usuario;
import br.com.jornadadeveficiente.mercadolivre.usuario.dominio.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(path = "/api/usuarios")
@AllArgsConstructor
public class UsuarioController {


  private UsuarioRepository usuarioRepository;

  @PostMapping
  public ResponseEntity<Void> cria(@RequestBody @Valid NovoUsuarioRequest novoUsuarioRequest) {
    Usuario usuario = novoUsuarioRequest.novoUsuario();
    usuarioRepository.save(usuario);
    return ResponseEntity.ok().build();
  }

}
