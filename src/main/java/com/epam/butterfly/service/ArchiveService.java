package com.epam.butterfly.service;

import com.epam.butterfly.domain.NamedEntity;

import java.io.IOException;

/**
 * Archive service.
 *
 * @author Artsiom_Buyevich
 */

public interface ArchiveService {

    void ping();

    void send(NamedEntity namedEntity);

    void save(String archiveName) throws IOException;

    boolean existArchive(String archiveName);

}
