package br.com.jornadadeveficiente.mercadolivre.comum.dominio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class UniqueValidator implements ConstraintValidator<Unique, Object> {

  private String entity;
  private String field;
  private final EntityManager entityManager;

  @Override
  public void initialize(Unique constraintAnnotation) {
    entity = constraintAnnotation.entity();
    field = constraintAnnotation.fieldName();
  }

  @Override
  public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
    Query query = entityManager.createQuery(String.format("select 1 from %s where %s = ?1", entity, field));
    query.setParameter(1, o);
    return query.getResultList().isEmpty();
  }
}
