package br.com.tmvolpato.mygames.service;

import br.com.tmvolpato.mygames.common.web.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.StringUtils;

/**
 * Pre condições de exception do serviço.
 *
 * @author Thiago Michel Volpato
 * @version 1.0.0
 * @since 2017
 */
public final class ServicePreconditions {

    private ServicePreconditions() {
        throw new AssertionError();
    }

    /**
     * Entidade existe.
     *
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> T checkEntityExists(final T entity) {
        if (entity == null) {
            throw new MyEntityNotFoundException();
        }
        return entity;
    }

    /**
     * Entidade existe.
     *
     * @param entityExists
     */
    public static void checkEntityExists(final boolean entityExists) {
        if (!entityExists) {
            throw new MyEntityNotFoundException("Entity not found");
        }
    }

    /**
     * E-mail already exist.
     *
     * @param emailExist
     */
    public static void checkEmailExist(final boolean emailExist) {
        if (!emailExist) {
            throw new MyEmailExistException("This e-mail already exist");
        }
    }

    /**
     * Verifica o parametro passado.
     *
     * @param value
     */
    public static void checkParameterLong(final Long value) {
        if (value == null) {
            throw new MyBadRequestException();
        }
    }

    /**
     * Verifica o parametro passado.
     *
     * @param value
     */
    public static void checkParameterString(final String value) {
        if (StringUtils.isEmpty(value)) {
            throw new MyBadRequestException();
        }
    }

    /**
     * Verifica o usuário do applicação.
     *
     * @param object
     */
    public static void checkUserApplication(final Object object) {
        if (object == null) {
            throw new MyAccessDeniedException("User application is null");
        }
    }

    /**
     * Verifica o argumento passado.
     *
     * @param okArgument
     */
    public static void checkOKArgument(final boolean okArgument) {
        if (!okArgument) {
            throw new MyBadRequestException();
        }
    }

    /**
     * Verifica se o valor passado já existe.
     * @param value
     */
    public static void checkIfAlreadyExist(final boolean value) {
       if (value) {
           throw new MyConflictException();
       }
    }

    /**
     * Verifica se o usuário logado é dono do recurso.
     *
     * @param ownerId
     * @param resourceId
     */
    public static void checkResourceOwner(final Long ownerId, final Long resourceId) {

        if (ownerId == null || resourceId == null) {
            throw new MyBadRequestException();
        }

        if (!ownerId.equals(resourceId)) {
            throw new MyResourceNotFoundException();
        }
    }
}
