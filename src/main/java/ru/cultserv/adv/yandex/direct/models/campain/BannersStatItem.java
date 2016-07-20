package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;

/**
 * @author Sergey Zudin
 * @since 18.11.15.
 */
public class BannersStatItem {

    /**\
     * Дата, за которую приведена статистика.
     * Выводится в отчет, если во входном параметре GroupByColumns указано значение «clDate».
     */
    @JsonProperty("StartDate")
    public LocalDate stat_date;

    /**
     * Идентификатор объявления.
     */
    @JsonProperty("BannerID")
    public Long banner_id;

    /**
     * Идентификатор фразы.
     * Выводится в отчет, если во входном параметре GroupByColumns указано значение «clPhrase» и запись содержит
     * информацию о фразе или рубрике Яндекс.Каталога (но не о ретаргетинге).
     *
     * Примечание. Рекомендуется выполнять группировку по PhraseID на стороне приложения, так как в некоторых случаях
     * ответ метода может содержать в массиве Stat несколько объектов с одинаковым значением PhraseID.
     */
    @JsonProperty("PhraseID")
    public Long phrase_id;

    /**
     * Идентификатор рубрики Яндекс.Каталога.
     * Выводится в отчет, если во входном параметре GroupByColumns указано значение «clPhrase» и запись содержит
     * информацию о рубрике Яндекс.Каталога.
     */
    @JsonProperty("RubricID")
    public Long rubric_id;

    /**
     * Идентификатор ретаргетинга.
     * Выводится в отчет, если во входном параметре GroupByColumns указано значение «clPhrase» и запись содержит
     * информацию о ретаргетинге.
     */
    @JsonProperty("RetargetingID")
    public Long retargering_id;

    /**
     * Ключевые слова, или название рубрики Яндекс.Каталога, или наименование условия ретаргетинга, или значение
     * «Автоматически добавленные фразы»
     */
    @JsonProperty("Phrase")
    public String phrase;

    /**
     * Стоимость кликов суммарно на поиске и в Рекламной сети Яндекса (в валюте, указанной во входном параметре Currency).
     */
    @JsonProperty("Sum")
    public Float sum;

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
     * Клики суммарно на поиске и в Рекламной сети Яндекса.
     */
    @JsonProperty("Clicks")
    public Integer clicks;

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

    /**
     * Показы суммарно на поиске и в Рекламной сети Яндекса.
     */
    @JsonProperty("Shows")
    public Integer shows;

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
     * Тип показа объявления: с изображением или без. Возможные значения: Image/Text.
     * Выводится в отчет, если во входном параметре GroupByColumns указано значение «clImage».
     */
    @JsonProperty("StatType")
    public String stat_type;

    /**
     * Тип устройства, на котором показано объявление. Возможные значения: desktop/mobile/tablet.
     */
    @JsonProperty("DeviceType")
    public String device_type;

    /**
     * Средняя позиция показа объявления. При расчете учитываются только показы на первой странице результатов поиска Яндекса. Наивысшая позиция имеет номер 1.
     * Выводится в отчет, если во входном параметре GroupByColumns указано значение «clAveragePosition».
     */
    @JsonProperty("ShowsAveragePosition")
    public Float shows_average_position;

    /**
     * Средняя позиция, на которой произошел клик по объявлению. При расчете учитываются только клики на первой странице результатов поиска Яндекса.
     Выводится в отчет, если во входном параметре GroupByColumns указано значение «clAveragePosition».
     */
    @JsonProperty("ClicksAveragePosition")
    public Float clicks_average_position;

    /**
     * Доход (до двух знаков после запятой) — сумма показателей стоимости заказа, переданных счетчиком Яндекс.Метрики.
     */
    @JsonProperty("Revenue")
    public Float revenue;

    /**
     * Рентабельность инвестиций в рекламу (до двух знаков после запятой).
     */
    @JsonProperty("ROI")
    public Float ROI;

}
