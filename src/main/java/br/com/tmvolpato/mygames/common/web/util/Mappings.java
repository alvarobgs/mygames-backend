package br.com.tmvolpato.mygames.common.web.util;

import br.com.tmvolpato.mygames.common.constant.ConstantWeb;

/**
 * Mappings of resources.
 *
 * @author Thiago Michel Volpato
 * @since 2017
 * @version 1.0.0
 */
public final class Mappings {

    public static final String DOCUMENTATION_API = ConstantWeb.API + ConstantWeb.PUBLIC + "documentation-api";
    public static final String CREATE_ACCOUNT = ConstantWeb.API + ConstantWeb.PUBLIC + "create-account";
    public static final String USERS = ConstantWeb.API + ConstantWeb.RESTRICT + "users";
    public static final String GAMES = ConstantWeb.API + ConstantWeb.RESTRICT + "games";

    private Mappings() {
        throw new AssertionError();
    }
}
