package udea.modulo3.lab3.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import udea.modulo3.lab3.model.Usuario;


@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Usuario u WHERE u.email = :email OR u.nroDocumento = :nroDocumento")
    boolean existsByEmailOrNroDocumento(@Param("email") String email, @Param("nroDocumento") String nroDocumento);

}
