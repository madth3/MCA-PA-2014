package mx.lania.mca.cuestionarios.control;

import java.util.Date;
import java.util.List;
import mx.lania.mca.cuestionarios.entidades.Cuestionario;
import mx.lania.mca.cuestionarios.entidades.Pregunta;
import mx.lania.mca.cuestionarios.oad.CuestionarioOAD;
import mx.lania.mca.cuestionarios.oad.PreguntaOAD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author LANIA
 */
@RestController
@RequestMapping("/cuests")
public class CuestionarioControladorRest {
    
    private static final Logger logger = LoggerFactory.getLogger(CuestionarioControladorRest.class);
    
    @Autowired
    CuestionarioOAD cuestionarioOAD;
    
    @Autowired
    PreguntaOAD preguntaOAD;
    
    @RequestMapping("/lista")
    public List<Cuestionario> listaCuestionarios() {
        logger.debug("listaCuestionarios");
        List<Cuestionario> cuestionarios = cuestionarioOAD.findAll();
        return cuestionarios;
    }
    
    @RequestMapping("/{id}")
    public Cuestionario getCuestionario(@PathVariable("id") Integer idCuestionario) {
        logger.debug("getCuestionario");
        Cuestionario cuest = cuestionarioOAD.findOne(idCuestionario);
        return cuest;
    }
    
    @RequestMapping("/preguntas/{id}")
    public List<Pregunta> getPreguntas(@PathVariable("id") Integer idCuestionario) {
        List<Pregunta> pregs = preguntaOAD.getPreguntasDeCuestionario(idCuestionario);
        return pregs;
    }
}












