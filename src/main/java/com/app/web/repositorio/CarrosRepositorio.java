package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.web.entidad.Carros;
import java.util.List;

@Repository
public interface CarrosRepositorio extends JpaRepository<Carros, Long> {
        @Query("SELECT p FROM Carros p WHERE p.Marca LIKE %?1%" + "OR p.Modelo LIKE %?1%"
               + "OR p.Descripcion LIKE %?1%"
                + "OR p.Tipo_Combustible LIKE %?1%"
                + "OR p.Tipo_de_vehiculo LIKE %?1%")
        public List<Carros> findAll(String palabraClave);
}
