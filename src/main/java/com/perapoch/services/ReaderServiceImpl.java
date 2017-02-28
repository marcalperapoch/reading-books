package com.perapoch.services;

import com.perapoch.data.ReaderRepository;
import com.perapoch.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marcal.perapoch on 28/02/2017.
 */
@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public void save(Reader reader) {
        readerRepository.save(reader);
    }

    @Override
    public Reader findByUsername(String username) {
        return readerRepository.findOne(username);
    }
}
