package mx.lania.mca.cuestionarios.control;

import java.util.Date;
import java.util.List;
import mx.lania.mca.cuestionarios.entidades.Cuestionario;
import mx.lania.mca.cuestionarios.oad.CuestionarioOAD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author LANIA
 */
@Controller
@RequestMapping("/cuestionarios")
public class CuestionarioControlador {
    
    private static Logger logger = LoggerFactory.getLogger(CuestionarioControlador.class);
    
    @Autowired
    CuestionarioOAD cuestionarioOAD;
    
    @RequestMapping("/lista")
    public ModelAndView listaCuestionarios() {
        ModelAndView mav = new ModelAndView("/listaCuestionarios");
        List<Cuestionario> cuestionarios = cuestionarioOAD.findAll();
        mav.addObject("cuestionarios", cuestionarios);
        return mav;
    }
    
    @RequestMapping(value="/nuevo", method = RequestMethod.POST)
    public String nuevoCuestionario(Cuestionario cuestionario) {
        logger.debug("nuevoCuestionario");
        cuestionario.setFechaCreacion(new Date());
        cuestionarioOAD.save(cuestionario);
        return "redirect:/cuestionarios/lista";
    }
}












