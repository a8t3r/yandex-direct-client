package ru.cultserv.adv.yandex.direct.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.Currency;
import ru.cultserv.adv.yandex.direct.models.banner.GetPhrases;

import java.util.List;

public class BannersFilterParam {

	/**
	 * Массив идентификаторов кампаний (не более 10 идентификаторов).
	 * Метод возвращает параметры объявлений, принадлежащих указанным кампаниям.
	 */
	@JsonProperty("CampaignIDS")
	public List<Long> campaign_ids;

	/**
	 * Массив, содержащий идентификаторы объявлений.
	 * Допускается указывать не более 2000 идентификаторов.
	 *
	 * Данный параметр имеет приоритет над CampaignIDS: если указаны оба параметра,
	 * объявления отбираются по идентификаторам из массива BannerIDS.
	 */
	@JsonProperty("BannerIDS")
	public List<Long> banners_ids;

	@JsonProperty("Currency")
	public Currency currency;

	@JsonProperty("GetPhrases")
	public GetPhrases phrases_param;

}
