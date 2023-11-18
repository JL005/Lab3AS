package udea.modulo3.lab3.service;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import udea.modulo3.lab3.model.Usuario;
import udea.modulo3.lab3.DTO.UsuarioDTO;

@Service
@Transactional
public class UsuarioFacade {
    private UsuarioService usuarioService;

    public UsuarioFacade(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public void crearUsuario(UsuarioDTO usuarioDTO){
        this.usuarioService.crearUsuario(usuarioDTO);
    }

}
