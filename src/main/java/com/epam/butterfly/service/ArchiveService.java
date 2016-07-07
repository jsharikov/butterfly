package com.epam.butterfly.service;

import com.epam.butterfly.domain.NamedEntity;

import java.io.IOException;

/**
 * Archive service.
 *
 * @author Artsiom_Buyevich
 */
public interface ArchiveService {

    /**
     * Send name of archive into queue.
     *
     * @param namedEntity name of archive
     */
    void send(NamedEntity namedEntity);

    /**
     * Extract archive and save.
     *
     * @param archiveName name of archive
     * @throws IOException {@link IOException}
     */
    void save(String archiveName) throws IOException;

    /**
     * Exist archive in the directory.
     *
     * @param archiveName name of archive
     * @return if exist, then true, else false
     */
    boolean existArchive(String archiveName);

}
