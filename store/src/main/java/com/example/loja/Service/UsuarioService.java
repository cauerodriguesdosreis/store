package com.example.loja.Service;

import com.example.loja.DTO.Request.UsuarioRequestDTO;
import com.example.loja.DTO.Response.UsuarioResponseDTO;
import com.example.loja.Entity.UsuarioEntity;
import com.example.loja.Exception.UsuarioException.UsuarioNaoEncontradoException;
import com.example.loja.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponseDTO> listarUsuarios(){
        return usuarioRepository.findAll().stream().
                map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail())).collect(Collectors.toList());
    }

    public List <UsuarioResponseDTO> buscarUsuarioPorNome(String nome) {
               return usuarioRepository.findByNomeContaining(nome).stream()
                       .map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail()))
                       .collect(Collectors.toList());
    }

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO dto){
        UsuarioEntity usuario = new UsuarioEntity(dto.getNome(), dto.getEmail(), dto.getSenha());
        usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        UsuarioEntity usuario = buscarUsuarioOuFalhar(id);
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return new UsuarioResponseDTO(usuario);
    }

    public UsuarioResponseDTO deletarUsuario(Long id) {
        UsuarioEntity usuario = buscarUsuarioOuFalhar(id);
        usuarioRepository.deleteById(id);
        return new UsuarioResponseDTO();
    }

    public UsuarioEntity buscarUsuarioOuFalhar(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException());
    }
}
