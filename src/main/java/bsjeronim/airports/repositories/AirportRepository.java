/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bsjeronim.airports.repositories;

import bsjeronim.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Bárbara
 *
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String city);

}



