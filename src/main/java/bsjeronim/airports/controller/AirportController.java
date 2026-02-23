/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bsjeronim.airports.controller;

import bsjeronim.airports.entities.Airport;
import bsjeronim.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping; 
                

/**
 *
 * @author Bárbara
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    //endpoint / airports/ airport
    //retorna TODOS OS aeroportos dabasa de dados.
    //@return
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }

}
