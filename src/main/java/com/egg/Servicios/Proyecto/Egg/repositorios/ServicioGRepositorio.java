
package com.egg.Servicios.Proyecto.Egg.repositorios;

import com.egg.Servicios.Proyecto.Egg.entidades.ServicioG;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioGRepositorio extends JpaRepository<ServicioG, String> {
    
        
    public List<ServicioG>listar();
    
    @Query("SELECT s FROM ServicioG s WHERE s.nombre= :nombre")
    public ServicioG buscarPorNombre(@Param("nombre")String nombre);
}
