package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Sergey Zudin
 * @since 04.09.17.
 */
public class AccountManagementInfo {

    @JsonProperty("AccountId")
    public int account_id;

    @JsonProperty("Amount")
    public BigDecimal amount;

    @JsonProperty("AmountAvailableForTransfer")
    public BigDecimal amount_for_transcfer;

    @JsonProperty("Currency")
    public Currency currency;

    @JsonProperty("Login")
    public String login;

    @JsonProperty("Discount")
    public BigDecimal discount;

    @JsonProperty("AgencyName")
    public String agency_name;

}
