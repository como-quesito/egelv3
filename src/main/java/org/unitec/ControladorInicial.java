package org.unitec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by campitos on 14/01/16.
 */
@Controller
@RequestMapping("/")
public class ControladorInicial {
    @RequestMapping(value="/", method = RequestMethod.GET, headers = {"Accept=text/html"})
    @ResponseBody
    String inicio(){
        return "Egel v3";
    }

}
