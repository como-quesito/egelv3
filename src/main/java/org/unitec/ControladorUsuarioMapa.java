package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rapid on 21/07/2016.
 */
@Controller
public class ControladorUsuarioMapa {
@Inject ServicioUsuarioMapa servicio;

@CrossOrigin
@RequestMapping(value="/usuario-mapa", method= RequestMethod.GET, headers={"Accept=application/json"})
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
@RequestMapping(value="/usuario-mapa",
        method=RequestMethod.POST, headers={"Accept=application/json"})
@ResponseBody String guardarRest(@RequestBody String json)throws Exception{
        UsuarioMapa mm=new UsuarioMapa();

        System.out.println("SE ACTIVO GUARDAR CON MONGO con el sig JSON:"+json);
        ObjectMapper maper=new ObjectMapper();
        UsuarioMapa mensa=   maper.readValue(json, UsuarioMapa.class);
        double titulo= mensa.getLati();
        double cuerpo=mensa.getLongi();
        System.out.println("Lati:"+mensa.getLati()+" Longi:"+mensa.getLongi());

        //Preparamos la respuesta
        Map map = new HashMap();
        map.put("success", true);
        //Si hubiera un error, aqui enviamos en el map en evz de tru false y agergamos el put de error con el
        //error que desees
        //map.put("errors", "File not found in the specified path.");
        // mm.setTitulo(titulo);
        //  mm.setCuerpo(cuerpo);
         servicio.agregarMensaje(mensa);
        return maper.writeValueAsString(map);


        }


@CrossOrigin
@RequestMapping(value="/usuario-mapa/{id}",
        method=RequestMethod.PUT, headers={"Accept=application/json"})
@ResponseBody String actualizarRest(@PathVariable String id, @RequestBody String json)throws Exception{
        UsuarioMapa mm=new UsuarioMapa();

        System.out.println("SE ACTIVO actualizarrrrrr");
        System.out.println("l json de actulizar:"+json);
        // mm.setTitulo(titulo);
        //  mm.setCuerpo(cuerpo);
        /// servicio.agregarMensaje(mm);
        return json;


        }

@CrossOrigin
@RequestMapping(value="/usuario-mapa/{id}",
        method=RequestMethod.GET, headers={"Accept=application/json"})
@ResponseBody String obtenerPorIdRest(@PathVariable String id)throws Exception{
        MensajeMongutio mm=new  MensajeMongutio();

        System.out.println("SE ACTIVO Bucar    "+id);

        UsuarioMapa mensa=   servicio.getTodos().get(0);
        // mm.setTitulo(titulo);
        //  mm.setCuerpo(cuerpo);
        /// servicio.agregarMensaje(mm);
        ObjectMapper maper=new ObjectMapper();
        System.out.println(maper.writeValueAsString(mensa));
        return maper.writeValueAsString(mensa);


        }


@CrossOrigin
@RequestMapping(value="/usuario-mapa/{id}",
        method=RequestMethod.DELETE, headers={"Accept=text/html","Accept=application/json"})
@ResponseBody String borrarIdRest(@PathVariable String id)throws Exception{
        MensajeMongutio mm=new  MensajeMongutio();
        ObjectMapper maper=new ObjectMapper();
        MensajeMongutio mensa=new MensajeMongutio();
        System.out.println("SE ACTIVO EL FAMOSISIMO DELETE   "+id);

        return maper.writeValueAsString(mensa);


        }
        }
