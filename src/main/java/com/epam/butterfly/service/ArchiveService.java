package com.epam.butterfly.service;

import com.epam.butterfly.domain.NamedEntity;

/**
 * Archive service.
 *
 * @author Artsiom_Buyevich
 */
public interface ArchiveService {

    void ping();

    void send(NamedEntity namedEntity);


}
