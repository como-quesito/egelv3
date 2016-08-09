/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author campitos
 */
@Controller
@RequestMapping("/")
public class ControladorMensajesMongo {

    @Inject ServicioMensajesMongo servicio;

      @CrossOrigin
    @RequestMapping(value="/mensaje-mongo", method=RequestMethod.GET, headers={"Accept=application/json"})
    @ResponseBody String leerTodos()throws Exception{
        ObjectMapper maper=new ObjectMapper();
        System.out.println("ya");
         return maper.writeValueAsString(servicio.getTodos());


    }

    /*
    @CrossOrigin
    @RequestMapping(value="/mensaje-mongo/{titulo}/{cuerpo}",
            method=RequestMethod.GET, headers={"Accept=text/html"})
    @ResponseBody String guardar(@PathVariable String titulo,
            @PathVariable String cuerpo)throws Exception{
        MensajeMongutio mm=new  MensajeMongutio();
        mm.setTitulo(titulo);
        mm.setCuerpo(cuerpo);
        //servicio.agregarMensaje(mm);
         return "Mensaje guardado";


    }
    */

    @CrossOrigin
    @RequestMapping(value="/mensaje-mongo",
            method=RequestMethod.POST, headers={"Accept=application/json"})
    @ResponseBody String guardarRest(@RequestBody String json)throws Exception{
        MensajeMongutio mm=new  MensajeMongutio();

        System.out.println("SE ACTIVO GUARDAR CON MONGO con el sig JSON:"+json);
        ObjectMapper maper=new ObjectMapper();
     MensajeMongutio mensa=   maper.readValue(json, MensajeMongutio.class);
    String titulo= mensa.getTitulo();
    String cuerpo=mensa.getCuerpo();
    System.out.println("TITULO:"+mensa.getTitulo()+" CUERPO:"+mensa.getCuerpo());

    //Preparamos la respuesta
    Map map = new HashMap();
 map.put("success", true);
 //Si hubiera un error, aqui enviamos en el map en evz de tru false y agergamos el put de error con el
 //error que desees
 //map.put("errors", "File not found in the specified path.");
       // mm.setTitulo(titulo);
      //  mm.setCuerpo(cuerpo);
       /// servicio.agregarMensaje(mm);
         return maper.writeValueAsString(map);


    }


    @CrossOrigin
    @RequestMapping(value="/mensaje-mongo/{id}",
            method=RequestMethod.PUT, headers={"Accept=application/json"})
    @ResponseBody String actualizarRest(@PathVariable String id, @RequestBody String json)throws Exception{
        MensajeMongutio mm=new  MensajeMongutio();

        System.out.println("SE ACTIVO actualizarrrrrr");
        System.out.println("l json de actulizar:"+json);
       // mm.setTitulo(titulo);
      //  mm.setCuerpo(cuerpo);
       /// servicio.agregarMensaje(mm);
         return json;


    }

    @CrossOrigin
    @RequestMapping(value="/mensaje-mongo/{id}",
            method=RequestMethod.GET, headers={"Accept=application/json"})
    @ResponseBody String obtenerPorIdRest(@PathVariable String id)throws Exception{
        MensajeMongutio mm=new  MensajeMongutio();

        System.out.println("SE ACTIVO Bucar    "+id);

     MensajeMongutio mensa=   servicio.getTodos().get(0);
       // mm.setTitulo(titulo);
      //  mm.setCuerpo(cuerpo);
       /// servicio.agregarMensaje(mm);
     ObjectMapper maper=new ObjectMapper();
     System.out.println(maper.writeValueAsString(mensa));
         return maper.writeValueAsString(mensa);


    }


     @CrossOrigin
    @RequestMapping(value="/mensaje-mongo/{id}",
            method=RequestMethod.DELETE, headers={"Accept=text/html","Accept=application/json"})
    @ResponseBody String borrarIdRest(@PathVariable String id)throws Exception{
        MensajeMongutio mm=new  MensajeMongutio();
        ObjectMapper maper=new ObjectMapper();
        MensajeMongutio mensa=new MensajeMongutio();
        System.out.println("SE ACTIVO EL FAMOSISIMO DELETE   "+id);

         return maper.writeValueAsString(mensa);


    }
}
