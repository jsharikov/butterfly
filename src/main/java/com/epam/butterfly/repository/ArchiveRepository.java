package com.epam.butterfly.repository;

/**
 * Archive repository.
 *
 * @author Artsiom_Buyevich
 */
public interface ArchiveRepository {

    boolean searchAndSaveIfExist(String archiveName);
}
