package udea.modulo3.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udea.modulo3.lab3.model.TipoUsuario;


@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

}
