package udea.modulo3.lab3.utils.mapper;



import udea.modulo3.lab3.DTO.UsuarioDTO;
import udea.modulo3.lab3.model.Usuario;
import udea.modulo3.lab3.utils.hasher.PasswordHash;

public class UsuarioMapper {

    private UsuarioMapper() {
    }


    public static Usuario crearUsuarioEntidad(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .celular(usuarioDTO.getCelular())
                .email(usuarioDTO.getEmail())
                .password(encodePassword(usuarioDTO.getPassword()))
                .nroDocumento(usuarioDTO.getNroDocumento())
                .rol("USUARIO")
                .nroServicios("0")
                .build();
    }



    public static String encodePassword(String password) {
        PasswordHash passwordHash = new PasswordHash();
        return passwordHash.encriptarPassword(password);
    }
}
