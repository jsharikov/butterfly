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
    @Qualifier("archiveServiceImpl")
    private ArchiveService archiveService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addItem(@RequestBody NamedEntity namedEntity) {
        if (namedEntity != null && !namedEntity.getName().trim().isEmpty()) {
            archiveService.send(namedEntity);
        }
    }
}
