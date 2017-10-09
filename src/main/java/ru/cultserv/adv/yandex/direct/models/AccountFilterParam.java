package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sergey Zudin
 * @since 04.09.17.
 */
public class AccountFilterParam {

    @JsonProperty("Action")
    public String action = "Get";
}
