package mx.lania.mca.cuestionarios.control;

import java.util.List;
import mx.lania.mca.cuestionarios.entidades.Cuestionario;
import mx.lania.mca.cuestionarios.oad.CuestionarioOAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author LANIA
 */
@Controller
@RequestMapping("/cuestionarios")
public class CuestionarioControlador {
    
    @Autowired
    CuestionarioOAD cuestionarioOAD;
    
    @RequestMapping("/lista")
    public ModelAndView listaCuestionarios() {
        ModelAndView mav = new ModelAndView("/listaCuestionarios");
        List<Cuestionario> cuestionarios = cuestionarioOAD.findAll();
        mav.addObject("cuestionarios", cuestionarios);
        return mav;
    }
}












