package com.epam.butterfly.controller;

import com.epam.butterfly.domain.NamedEntity;
import com.epam.butterfly.producer.ArchiveProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Archive controller.
 *
 * @author Artsiom_Buyevich
 */

@RestController
@RequestMapping(value = "/archives")
public class ArchiveController {

    @Autowired
    private ArchiveProducer archiveProducer;

    @RequestMapping(method = RequestMethod.POST)
    public void addItem(@RequestBody NamedEntity namedEntity) {
        if (namedEntity != null && namedEntity.getName() != null && !namedEntity.getName().trim().isEmpty()) {
            archiveProducer.send(namedEntity);
        }
    }
}
