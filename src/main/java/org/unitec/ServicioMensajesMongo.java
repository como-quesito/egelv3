/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author campitos
 */
@Repository
public class ServicioMensajesMongo {
    @Inject
    MongoTemplate mongoTemplate;

    public void agregarMensaje(MensajeMongutio mongutio){
        if(!mongoTemplate.collectionExists(MensajeMongutio.class)){
            mongoTemplate.createCollection(MensajeMongutio.class);
        }
        mongoTemplate.insert(mongutio);
    }

    public void borrarMensaje(String id){
        mongoTemplate.remove(new MensajeMongutio(id));
    }

     public void actualizarMensaje(String id, String titulo, String cuerpo){
       // mongoTemplate.up
    }


    public List<MensajeMongutio> getTodos(){
   List<MensajeMongutio> mensajes=new ArrayList<MensajeMongutio>();
        mensajes=mongoTemplate.findAll(MensajeMongutio.class);
        return mensajes;
    }





}
