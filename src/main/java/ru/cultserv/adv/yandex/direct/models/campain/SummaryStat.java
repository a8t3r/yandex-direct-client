package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;

/**
 * @author sergey
 * @since 07.04.16
 */
public class SummaryStat {

    /**
     * Идентификатор кампании, для которой формируется отчет.
     */
    @JsonProperty("CampaignID")
    public Integer campaign_id;

    /**
     * Дата, за которую приведена статистика.
     * Выводится в отчет, если во входном параметре GroupByColumns указано значение «clDate».
     */
    @JsonProperty("StartDate")
    public LocalDate date;

    /**
     * Стоимость кликов на поиске (в валюте, указанной во входном параметре Currency).
     */
    @JsonProperty("SumSearch")
    public Float sum_search;

    /**
     * Стоимость кликов в Рекламной сети Яндекса (в валюте, указанной во входном параметре Currency).
     */
    @JsonProperty("SumContext")
    public Float sum_context;

    /**
     * Показы на поиске.
     */
    @JsonProperty("ShowsSearch")
    public Integer shows_search;

    /**
     * Показы в Рекламной сети Яндекса.
     */
    @JsonProperty("ShowsContext")
    public Integer shows_context;

    /**
     * Клики на поиске.
     */
    @JsonProperty("ClicksSearch")
    public Integer clicks_search;

    /**
     * Клики в Рекламной сети Яндекса.
     */
    @JsonProperty("ClicksContext")
    public Integer clicks_context;

}
