package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 04.09.17.
 */
public class AccountManagementResponse {

    @JsonProperty("Accounts")
    public List<AccountManagementInfo> accounts;

}
