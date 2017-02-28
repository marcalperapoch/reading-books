package com.perapoch.validators;

import com.perapoch.model.Reader;
import com.perapoch.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by marcal.perapoch on 28/02/2017.
 */
@Component
public class ReaderValidator implements Validator {

    @Autowired
    private final ReaderService readerService;

    public ReaderValidator(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Reader.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final Reader reader = (Reader) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (reader.getUsername().length() < 6 || reader.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.readerForm.username");
        }
        if (readerService.findByUsername(reader.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.readerForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (reader.getPassword().length() < 8 || reader.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.readerForm.password");
        }
    }
}
