package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.api.converter.UsuarioInputDTOToUsuario;
import com.algaworks.algaworksapi.api.converter.UsuarioToDTO;
import com.algaworks.algaworksapi.api.model.UsuarioDTO;
import com.algaworks.algaworksapi.api.model.input.SenhaInputDTO;
import com.algaworks.algaworksapi.api.model.input.UsuarioComSenhaInputDTO;
import com.algaworks.algaworksapi.api.model.input.UsuarioInputDTO;
import com.algaworks.algaworksapi.domain.model.Usuario;
import com.algaworks.algaworksapi.domain.repository.UsuarioRepository;
import com.algaworks.algaworksapi.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuario;

    @Autowired
    private UsuarioToDTO usuarioToDTO;

    @Autowired
    private UsuarioInputDTOToUsuario usuarioInputDTOToUsuario;

    @GetMapping
    public List<UsuarioDTO> listar() {
        List<Usuario> todasUsuarios = usuarioRepository.findAll();

        return usuarioToDTO.toCollectionModel(todasUsuarios);
    }

    @GetMapping("/{usuarioId}")
    public UsuarioDTO buscar(@PathVariable Long usuarioId) {
        Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);

        return usuarioToDTO.toDto(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO adicionar(@RequestBody @Valid UsuarioComSenhaInputDTO usuarioInput) {
        Usuario usuario = usuarioInputDTOToUsuario.toDto(usuarioInput);
        usuario = cadastroUsuario.salvar(usuario);

        return usuarioToDTO.toDto(usuario);
    }

    @PutMapping("/{usuarioId}")
    public UsuarioDTO atualizar(@PathVariable Long usuarioId,
                                @RequestBody @Valid UsuarioInputDTO usuarioInput) {
        Usuario usuarioAtual = cadastroUsuario.buscarOuFalhar(usuarioId);
        usuarioInputDTOToUsuario.copyToDomainObject(usuarioInput, usuarioAtual);
        usuarioAtual = cadastroUsuario.salvar(usuarioAtual);

        return usuarioToDTO.toDto(usuarioAtual);
    }

    @PutMapping("/{usuarioId}/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarSenha(@PathVariable Long usuarioId, @RequestBody @Valid SenhaInputDTO senha) {
        cadastroUsuario.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
    }

}