package com.hbt.estructura.localizacion.controller;

import com.hbt.estructura.localizacion.model.entity.Estructura;
import com.hbt.estructura.localizacion.model.entity.EstructuraDTO;
import com.hbt.estructura.localizacion.servicio.EstructuraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstructuraController {

    @Autowired
    EstructuraService estructuraService;

    @GetMapping("/estructura/{nombre}")
    public List<Estructura> findByName(@PathVariable String nombre){
        return estructuraService.findEstructuraData(nombre);
    }

    @GetMapping("/estructura")
    public List<EstructuraDTO> findAll(){
        return estructuraService.findEstructuraAllData();
    }
}
