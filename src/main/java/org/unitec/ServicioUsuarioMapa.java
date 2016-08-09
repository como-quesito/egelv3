package org.unitec;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rapid on 21/07/2016.
 */
@Repository
public class ServicioUsuarioMapa {
    @Inject
    MongoTemplate mongoTemplate;

    public void agregarMensaje(UsuarioMapa usu){
        if(!mongoTemplate.collectionExists(UsuarioMapa.class)){
            mongoTemplate.createCollection(UsuarioMapa.class);
        }
        mongoTemplate.insert(usu);
    }

    public void borrarMensaje(String id){
        mongoTemplate.remove(new UsuarioMapa(id));
    }

    public void actualizarUsuariomapa(String id, String  miId, String cuerpo){
        // mongoTemplate.up
    }


    public List<UsuarioMapa> getTodos(){
        List<UsuarioMapa> mensajes=new ArrayList<UsuarioMapa>();
        mensajes=mongoTemplate.findAll(UsuarioMapa.class);
        return mensajes;
    }





}