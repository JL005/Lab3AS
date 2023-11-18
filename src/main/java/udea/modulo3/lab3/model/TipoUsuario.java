package udea.modulo3.lab3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "tipo_usuarios")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuario {

    @Id
    @Column(name = "id_tipo_usuario")
    private long idTipoUsuario;

    @Column(name = "nombre", nullable=false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

}
