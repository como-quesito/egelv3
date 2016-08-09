package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by campitos on 2/05/16.
 */
@Controller
@RequestMapping("/")
public class ControladorReactivo {
    @Autowired ServicioReactivo  servicioReactivo;


    @CrossOrigin
    @RequestMapping(value="/reactivo", method=RequestMethod.GET, headers={"Accept=application/json"})
    @ResponseBody String leerTodos()throws Exception{
        ObjectMapper maper=new ObjectMapper();
        System.out.println("ya");
        return maper.writeValueAsString(servicioReactivo.buscarTodos());


    }


    @CrossOrigin
    @RequestMapping(value="/reactivo/{tema}", method=RequestMethod.GET, headers={"Accept=application/json"})
    @ResponseBody String buscarPorTema(@PathVariable String tema)throws Exception{
        ObjectMapper maper=new ObjectMapper();
        System.out.println("ya");
        return maper.writeValueAsString(servicioReactivo.buscarPorTema(tema));


    }

    @CrossOrigin
    @RequestMapping(value="/reactivo",method= RequestMethod.POST, headers = {"Accept=application/json"})
    @ResponseBody String buscarTodos(@RequestBody String json)throws Exception{
     ObjectMapper maper=new ObjectMapper();
        System.out.println("Se activo de forma exitosa el POST de Reactivos");
      Reactivo reactivo=  maper.readValue(json, Reactivo.class);
        System.out.println("Pregunta el numero de opciones es:"+json);
        System.out.println("La opcion 2 es:"+reactivo.getOpciones().get(1).isAcierto());
        servicioReactivo.agregarReactivo(reactivo);
     //Preparamos la respuesta en caso de success
        Map map=new HashMap();
        //Agregamos el siguiente elemento ya que extJS requiere el success para verificar que todo es correcto
        map.put("success",true);

        //Enviamos el json de ls respuesta
        return maper.writeValueAsString(map);
    }
}
