
package com.egg.Servicios.Proyecto.Egg.servicios;


import com.egg.Servicios.Proyecto.Egg.entidades.ServicioG;
import com.egg.Servicios.Proyecto.Egg.excepciones.MiException;
import com.egg.Servicios.Proyecto.Egg.repositorios.ServicioGRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioGServicio {

    
    @Autowired
    private ServicioGRepositorio servicioRepositorio;
    
    @Transactional
    public void crearServicioG (String nombre, String descripcion, Double valorHora) throws MiException{
        
        validarDatos(nombre, descripcion, valorHora);
        ServicioG servicio=new ServicioG();
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setValorHora(valorHora);
        
     servicioRepositorio.save(servicio);
          
    }
   
    
    public List<ServicioG> listarServiciosG(){
        List <ServicioG> servicios = new ArrayList();
        
        servicios = servicioRepositorio.findAll();
        
        return servicios;
    }
    
    
    
    @Transactional
    public void modificarServicioG(String id, String nombre, String descripcion,Double valorHora) throws MiException{
        
        validarDatos(nombre, descripcion, valorHora);
        Optional<ServicioG> respuestaServicio= servicioRepositorio.findById(id);
        
        
        if(respuestaServicio.isPresent()){
            ServicioG servicio= respuestaServicio.get();
            
            servicio.setNombre(nombre);
            servicio.setDescripcion(descripcion);
            servicio.setValorHora(valorHora);
            
            servicioRepositorio.save(servicio);
                    
        }
        
    }
    
    
    private void validarDatos(String nombre, String descripcion, Double valorHora) throws MiException{
        
        if(nombre.isEmpty()|| nombre==null){
            
            throw new MiException ("El nombre no puede estar vacío ni ser nulo");
        }
        
        if(descripcion.isEmpty()|| descripcion==null){
            
            throw new MiException ("La descripcion no puede estar vacía ni ser nula");
            
        }
        
        if(valorHora==null){
            
            throw new MiException ("El valorHora no puede ser nulo");
        }
        
    }
    
}
