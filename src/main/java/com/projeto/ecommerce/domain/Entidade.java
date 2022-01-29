package com.projeto.ecommerce.domain;

import com.projeto.ecommerce.infra.exception.DominioInvalido;

import javax.persistence.MappedSuperclass;
import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class Entidade {

    //metodo criado para poder testar com teste unitário. Com o @Valid eu teria que fazer teste de integração (muito mais demorado)
    void isValid() {
        Configuration<?> configuracaoes = Validation.byDefaultProvider().configure();
        ValidatorFactory fabrica = configuracaoes.buildValidatorFactory();
        Validator validador = fabrica.getValidator();
        Set<ConstraintViolation<Entidade>> regrasVioladas = validador.validate(this);

        Set<String> mensagens = new HashSet<>();

        for (ConstraintViolation<Entidade> constraintViolation : regrasVioladas) {
            String campo = constraintViolation.getPropertyPath().toString();
            String msg = constraintViolation.getMessage();
            mensagens.add(campo.concat(" : ").concat(msg));
        }

        if (!mensagens.isEmpty()) {
            throw new DominioInvalido(mensagens);
        }
    }
}