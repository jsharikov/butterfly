package com.epam.butterfly.service;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Data service.
 *
 * @author Artsiom_Buyevich
 */
public interface DataService {

    /**
     * Persist file.
     *
     * @param file file
     * @throws IOException exception
     */
    void save(Path file) throws IOException;
}
