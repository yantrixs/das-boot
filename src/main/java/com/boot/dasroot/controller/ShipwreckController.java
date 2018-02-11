package com.boot.dasroot.controller;

import com.boot.dasroot.model.Shipwreck;
import com.boot.dasroot.repository.ShipwreckRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {
    private static final Log logger = LogFactory.getLog(ShipwreckController.class);
    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list(){
        return shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck){
        return shipwreckRepository.saveAndFlush(shipwreck);
    }
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id){
        return shipwreckRepository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){
        // return shipwreckRepository.(id, shipwreck);
        logger.debug(" Getting ID is :::: "+id);
        Shipwreck getShipwreck = shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, getShipwreck);
        return shipwreckRepository.saveAndFlush(getShipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id){
        Shipwreck getShipwreck = shipwreckRepository.findOne(id);
        shipwreckRepository.delete(getShipwreck);
        return getShipwreck;
    }
}
