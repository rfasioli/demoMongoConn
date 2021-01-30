package br.com.rfasioli.demomongoconn.domain.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.rfasioli.demomongoconn.domain.SimpleDomain;

import static java.util.Objects.nonNull;

public class SimpleDomainValidator implements ConstraintValidator<IsValidSimpleDomain, SimpleDomain> {
    @Override
    public void initialize(IsValidSimpleDomain constraintAnnotation) {
    }

    @Override
    public boolean isValid(SimpleDomain value, ConstraintValidatorContext context) {
        return value.getId() < 10 || nonNull(value.getValue());
    }
}
