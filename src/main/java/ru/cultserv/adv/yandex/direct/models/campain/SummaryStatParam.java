package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;
import ru.cultserv.adv.yandex.direct.models.Currency;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import java.util.List;

/**
 * @author sergey
 * @since 07.04.16
 */
public class SummaryStatParam {

    /**
     * Массив идентификаторов кампаний
     * Количество кампаний помноженное на количество дней в отчетном периоде не должно превышать 1000.
     */
    @JsonProperty("CampaignIDS")
    public List<Long> campaign_ids;

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
