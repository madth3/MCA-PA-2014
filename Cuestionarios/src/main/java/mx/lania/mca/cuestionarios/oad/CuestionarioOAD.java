package mx.lania.mca.cuestionarios.oad;

import mx.lania.mca.cuestionarios.entidades.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LANIA
 */
public interface CuestionarioOAD extends JpaRepository<Cuestionario, Integer>{
    
}
