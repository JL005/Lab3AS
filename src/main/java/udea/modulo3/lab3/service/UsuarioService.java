package udea.modulo3.lab3.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import udea.modulo3.lab3.DTO.UsuarioDTO;
import udea.modulo3.lab3.UsuarioMapper;
import udea.modulo3.lab3.model.TipoUsuario;
import udea.modulo3.lab3.model.Usuario;
import udea.modulo3.lab3.repository.TipoUsuarioRepository;
import udea.modulo3.lab3.utils.exception.DataDuplicatedException;
import udea.modulo3.lab3.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private TipoUsuarioRepository tipoUsuarioRepository;

    private static final String USUARIO_YA_EXISTE = "Ya existe un usuario con este email o número de cédula usuario  existe";

    public UsuarioService(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.crearUsuarioEntidad(usuarioDTO);
        if (this.existeUsuario(usuario)) {
            throw new DataDuplicatedException(USUARIO_YA_EXISTE);
        }
        this.asignarTipoUsuario(usuario, 1L);
        return this.usuarioRepository.save(usuario);
    }

    private void asignarTipoUsuario(Usuario usuario, long idTipoUsuario) {
        TipoUsuario tipoNuevoUsuario = tipoUsuarioRepository.findById(idTipoUsuario).orElse(null);

        usuario.setTipoUsuario(tipoNuevoUsuario);
    }

    private boolean existeUsuario(Usuario usuario) {
        return this.usuarioRepository.existsByEmailOrNroDocumento(usuario.getEmail(), usuario.getNroDocumento());
    }
}