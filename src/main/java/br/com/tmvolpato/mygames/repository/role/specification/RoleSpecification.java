package br.com.tmvolpato.mygames.repository.role.specification;

import br.com.tmvolpato.mygames.model.Role;
import br.com.tmvolpato.mygames.model.Role_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;

/**
 * Specific query of role.
 *
 * @author Thiago Michel Volpato
 * @since 2018
 * @version 1.0.0
 */
public final class RoleSpecification {

    /**
     * Procura pelo nome.
     * @param name
     * @return
     */
    public static Specification<Role> findByName(final String name) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            root
                 .fetch(Role_.privileges, JoinType.LEFT);
            final Expression<String> property = root.get(Role_.name);
            return criteriaBuilder.equal(property, name.toUpperCase());
        });
    }

}
