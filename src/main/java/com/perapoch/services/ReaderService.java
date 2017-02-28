package com.perapoch.services;

import com.perapoch.model.Reader;

/**
 * Created by marcal.perapoch on 28/02/2017.
 */
public interface ReaderService {

    void save(Reader reader);

    Reader findByUsername(String username);
}
