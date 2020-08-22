package br.com.jornadadeveficiente.mercadolivre.comum.dominio;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

  String message() default "{UniqueValue}";

  String fieldName();

  String entity();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
