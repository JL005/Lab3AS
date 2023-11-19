package udea.modulo3.lab3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuario")
@ApiModel(description = "Detalles sobre los usuarios del sistema.")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificador del usuario", required = true)
    private long idUsuario;

    @Column(name = "nombre", nullable = false)
    @ApiModelProperty(notes = "Nombre del usuario", required = true)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @ApiModelProperty(notes = "Apellido del usuario", required = true)
    private String apellido;

    @Column(name="celular", nullable = false)
    @ApiModelProperty(notes = "Celular del usuario", required = true)
    private String celular;

    @ApiModelProperty(notes = "Email del usuario", required = true)
    @Column(name="email", nullable = false)
    @Email
    private String email;

    @Column(name="password", nullable = false)
    @ApiModelProperty(notes = "Password del usuario", required = true)
    private String password;

    @Column(name="nro_documento", nullable = false)
    @ApiModelProperty(notes = "Número de documento del usuario", required = true)
    private String nroDocumento;

    @Column(name="rol", nullable = true)
    @ApiModelProperty(notes = "Rol del usuario", required = true)
    private String rol;

    @Column(name="nro_servicios", nullable = true)
    @ApiModelProperty(notes = "Número de servicios del usuario", required = true)
    private String nroServicios;

}
