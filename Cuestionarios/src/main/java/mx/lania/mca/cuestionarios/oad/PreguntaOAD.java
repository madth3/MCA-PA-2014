package mx.lania.mca.cuestionarios.oad;

import java.util.List;
import mx.lania.mca.cuestionarios.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author PCEL
 */
public interface PreguntaOAD extends JpaRepository<Pregunta, Integer>{
    
    @Query("SELECT p FROM Pregunta p WHERE p.cuestionario.id = ?1")
    public List<Pregunta> getPreguntasDeCuestionario(Integer idCuestionario);
}
