package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;
import ru.cultserv.adv.yandex.direct.models.Currency;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import java.util.Set;

/**
 * @author Sergey Zudin
 * @since 18.11.15.
 */
public class BannersStatParam {

    /**
     * Идентификатор кампании, для которой формируется отчет.
     */
    @JsonProperty("CampaignID")
    public Integer campaign_id;

    /**
     * Начальная дата отчетного периода, YYYY-MM-DD. Период не должен превышать семь дней.
     */
    @JsonProperty("StartDate")
    public LocalDate start_date;

    /**
     * Конечная дата отчетного периода, YYYY-MM-DD. Период не должен превышать семь дней.
     */
    @JsonProperty("EndDate")
    public LocalDate end_date;

    /**
     * Названия полей, выводимых в отчет дополнительно к статистическим данным.
     */
    @JsonProperty("GroupByColumns")
    public Set<BannersStatGroupByName> group_by_columns;

    /**
     * Количество записей, отбираемых из базы данных в отчет. Если не указано, выбираются все записи.
     * Параметры Limit и Offset служат для постраничной выборки записей.
     */
    @JsonProperty("Limit")
    public Integer limit;

    /**
     * Номер записи, с которой начинается выборка. Если не указано, подразумевается 0.
     * Параметры Limit и Offset служат для постраничной выборки записей.
     */
    @JsonProperty("Offset")
    public Integer offset;

    /**
     * Названия полей, по которым сортируются записи в отчете.
     */
    @JsonProperty("OrderBy")
    public Set<BannersStatOrderByNames> order_by;

    /**
     * Валюта, в которой должны быть выражены суммы в ответе
     */
    @JsonProperty("Currency")
    public Currency currency;

    /**
     * Учитывать НДС для стоимости кликов в валюте. По умолчанию Yes
     */
    @JsonProperty("IncludeVAT")
    public StatusBoolean include_vat;

    /**
     * Учитывать скидку для стоимости кликов в валюте. По умолчанию Yes
     */
    @JsonProperty("IncludeDiscount")
    public StatusBoolean include_discount;

}
