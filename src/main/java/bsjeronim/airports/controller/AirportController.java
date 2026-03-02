/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bsjeronim.airports.controller;

import bsjeronim.airports.DTO.AirportMinDTO;
import bsjeronim.airports.entities.Airport;
import bsjeronim.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    //Endpoint/ airports/ city {CityName}
    //@param cityName
    //@return
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);

        if (result.isEmpty()) {
            //Ops...lista  vazia...
            // notfound devolve 404
            return ResponseEntity.notFound().build();

        } else {
            //eba! tem dados!
            //ok devolve 200
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {

        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        if (result.isEmpty()) {
            //ops, lista vazia
            //notFound devolve 404
            return ResponseEntity.notFound().build();

        } else {
            //eba tem dados
            // ok devolve 200
            return ResponseEntity.ok(result);

        }

    }

    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);

        if (result == null) {
            //ops aeroporto vazio
            //notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            //eba tem dados
            //ok devolve 200
            return ResponseEntity.ok(result);
        }

    }
}
