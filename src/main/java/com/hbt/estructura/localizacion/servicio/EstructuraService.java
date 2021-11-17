package com.hbt.estructura.localizacion.servicio;

import com.hbt.estructura.localizacion.model.entity.Estructura;
import com.hbt.estructura.localizacion.model.entity.EstructuraDTO;
import com.hbt.estructura.localizacion.model.repository.IEstructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstructuraService {

    @Autowired
    IEstructuraRepository estructuraRepository;

    @Transactional(readOnly = false)
    public List<Estructura> findEstructuraData(String nombre){
        return estructuraRepository.findByNombreStartingWithIgnoreCaseAndTipoAndPadreIdIsNotNull(nombre,"MUNICIPIO");
    }

    @Transactional(readOnly = false)
    public List<EstructuraDTO> findEstructuraAllData(){
        List<Estructura> estructuras = estructuraRepository.findByTipo("MUNICIPIO");

     List<EstructuraDTO> dtos =   estructuras.stream()
                .map(e -> {
                    EstructuraDTO estructuraDTO = new EstructuraDTO();
                    estructuraDTO.setId(e.getId());
                    estructuraDTO.setNombre(e.getNombre());

                    String prov = e.getPadreId().getNombre();
                    String dpto = e.getPadreId().getPadreId().getNombre();
                    String pais = e.getPadreId().getPadreId().getPadreId().getNombre();

                    estructuraDTO.setUbicacion(pais + "->" + dpto + "->" + prov);
                    return estructuraDTO;

                }).collect(Collectors.toList());


        return  dtos;
    }

}
