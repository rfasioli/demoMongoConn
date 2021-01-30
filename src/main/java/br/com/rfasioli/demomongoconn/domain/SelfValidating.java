package br.com.rfasioli.demomongoconn.domain;

import javax.validation.*;
import java.util.Set;

/**
 * Efetua a auto-validação da classe que a estende pela chamada do método validateSelf.
 * @param <T> Passar a própria classe de implementação como template como template
 */
public abstract class SelfValidating<T> {
    private Validator validator;

    public SelfValidating() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Evaluates all Bean Validations on the attributes of this
     * instance.
     */
    protected void validateSelf() {
        @SuppressWarnings("unchecked")
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException(
                    "Erro na validação dos dados",
                    new ConstraintViolationException(violations));
        }
    }
}
