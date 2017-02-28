package com.perapoch.data;

import com.perapoch.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by marcal.perapoch on 28/02/2017.
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {
}
