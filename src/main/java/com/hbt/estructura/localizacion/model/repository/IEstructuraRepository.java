package com.hbt.estructura.localizacion.model.repository;

import com.hbt.estructura.localizacion.model.entity.Estructura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEstructuraRepository extends CrudRepository<Estructura, Long> {

    List<Estructura> findByNombreStartingWithIgnoreCaseAndTipoAndPadreIdIsNotNull(String nombre,String tipo);
    List<Estructura> findByTipo(String tipo);

}
