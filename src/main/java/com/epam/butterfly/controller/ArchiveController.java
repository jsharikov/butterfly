package com.epam.butterfly.controller;

import com.epam.butterfly.domain.NamedEntity;
import com.epam.butterfly.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Archive controller.
 *
 * @author Artsiom_Buyevich
 */

@RestController
@RequestMapping(value="/archives")
public class ArchiveController {

    @Autowired
    @Qualifier("archiveServiceJmsTemplateImpl")
    private ArchiveService archiveService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public NamedEntity get(@PathVariable String name) {
        NamedEntity namedEntity = new NamedEntity();
        namedEntity.setName("pong");
        return namedEntity;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addItem(@RequestBody NamedEntity namedEntity) {
        System.out.println("!ping");
        archiveService.send(namedEntity);
        if (namedEntity != null && namedEntity.getName() != null && !namedEntity.getName().trim().isEmpty()) {

        }
    }
}
