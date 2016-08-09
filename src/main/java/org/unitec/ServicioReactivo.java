package org.unitec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.reactor.ReactorAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by campitos on 2/05/16.
 */
@Configuration
public class ServicioReactivo {
    @Autowired
    MongoTemplate mongoTemplate;

    /*
     POST INSERTAR
     */
    public void agregarReactivo(Reactivo reactivo){
    if(!mongoTemplate.collectionExists(Reactivo.class)){
        mongoTemplate.createCollection(Reactivo.class);
       }
        mongoTemplate.insert(reactivo);
    }

    /*
      GET  BUSCAR TODOS
     */
    public List<Reactivo> buscarTodos(){
       return  mongoTemplate.findAll(Reactivo.class);
    }

    /*
     GET BUSCAR POR ID
     */
    public Reactivo buscarPorId(String id){
    Reactivo reactivo= mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),Reactivo.class);
        return reactivo;
    }

    /*
    GET POR TEMA
     */
    public ArrayList<Reactivo> buscarPorTema(String tema){
        ArrayList<Reactivo>reactivos=new ArrayList<>();

        for(Reactivo  reactivo:buscarTodos()){

                if(reactivo.getTema().equals(tema)){
                    reactivos.add(reactivo);

            }
        }

        System.out.println("Reactivos encontrados:"+reactivos.size());
        return reactivos;
    }




    public void borrarColeccion(){
        mongoTemplate.dropCollection(Reactivo.class);
    }

}
