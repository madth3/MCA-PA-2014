package mx.lania.mca.cuestionarios.oad;

import java.util.List;
import mx.lania.mca.cuestionarios.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author PCEL
 */
public interface PreguntaOAD extends JpaRepository<Pregunta, Integer>{
    
    @Query("SELECT p FROM Pregunta p WHERE p.cuestionario.id =:idc")
    public List<Pregunta> getPreguntasDeCuestionario(@Param("idc")Integer idCuestionario);
}







