package udea.modulo3.lab3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
@ApiModel(description = "Todos los detalles de un Usuario")
public class Usuario {
    @ApiModelProperty("La base de datos genera el ID del usuario")
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name="celular", nullable = false, length = 10)
    private String celular;

    @Column(name="email", nullable = false, length = 50)
    @Email
    private String email;

    @Column(name="password", nullable = false, length = 256)
    private String password;

    @Column(name="nro_documento", nullable = false, length = 20)
    private String nroDocumento;

    @Column(name="rol", nullable = true, length = 20)
    private String rol;

    @Column(name="nro_servicios", nullable = true, length = 10)
    private String nroServicios;

}
