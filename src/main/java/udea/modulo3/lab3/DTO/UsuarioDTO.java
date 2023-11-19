package udea.modulo3.lab3.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioDTO {

    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String password;
    private String nroDocumento;
}
