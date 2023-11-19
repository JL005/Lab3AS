package udea.modulo3.lab3.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import udea.modulo3.lab3.DAO.UsuarioDAO;
import udea.modulo3.lab3.DTO.UsuarioDTO;
import udea.modulo3.lab3.utils.mapper.UsuarioMapper;
import udea.modulo3.lab3.model.Usuario;
import udea.modulo3.lab3.utils.exception.DataDuplicatedException;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioDAO usuarioRepository;

    // public UsuarioService(UsuarioDAO usuarioRepository, TipoUsuarioDAO tipoUsuarioDAO) {
    //     this.usuarioRepository = usuarioRepository;
    //     this.tipoUsuarioRepository = tipoUsuarioDAO;
    // }

    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.crearUsuarioEntidad(usuarioDTO);
        System.out.println("DTO");
        System.out.println(usuarioDTO);
        System.out.println("Entidad");
        System.out.println(usuario);
        System.out.println(this.existeUsuario(usuario));
        if (this.existeUsuario(usuario)) {
            System.out.println("Ya existe un usuario con este email o número de cédula.");
            throw new DataDuplicatedException("Ya existe un usuario con este email o número de cédula.");
        }
        System.out.println("Usuario creado");
        return this.usuarioRepository.save(usuario);
    }



    private boolean existeUsuario(Usuario usuario) {
        return this.usuarioRepository.existsByEmailOrNroDocumento(usuario.getEmail(), usuario.getNroDocumento());
    }
}