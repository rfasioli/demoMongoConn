package br.com.rfasioli.demomongoconn.domain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SimpleDomainValidator.class)
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidSimpleDomain {
    String message() default "{IsValidSimpleDomain}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
