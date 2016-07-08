package com.epam.butterfly.producer;


import com.epam.butterfly.domain.NamedEntity;

/**
 * Producer of archive.
 *
 * @author Artsiom_Buyevich
 */
public interface ArchiveProducer {

    /**
     * Send archiveName to queue.
     *
     * @param namedEntity name of archive
     */
    void send(NamedEntity namedEntity);
}
