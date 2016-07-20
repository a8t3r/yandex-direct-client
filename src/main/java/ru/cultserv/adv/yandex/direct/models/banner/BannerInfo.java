package ru.cultserv.adv.yandex.direct.models.banner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import ru.cultserv.adv.yandex.direct.models.ContactInfo;
import ru.cultserv.adv.yandex.direct.models.PhraseInfo;
import ru.cultserv.adv.yandex.direct.models.SiteLink;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import java.util.List;

public class BannerInfo {

	/**
	 * Идентификатор объявления.
	 * Для создания объявления задают 0, для изменения параметров объявления указывают его идентификатор.
	 */
	@JsonProperty("BannerID")
	public Long banner_id;

	/**
	 * Идентификатор кампании, к которой принадлежит баннер
	 */
	@JsonProperty("CampaignID")
	public Long campaign_id;

	/**
	 * Идентификатор группы объявлений.
	 *
	 * Для создания группы объявлений параметр не указывают или задают значение 0.
	 * Для добавления объявления в существующую группу необходимо указать идентификатор этой группы.
	 * Для изменения параметров объявления или группы параметр указывать необязательно
	 */
	@JsonProperty("AdGroupID")
	public Long ad_group_id;

	/**
	 * Название группы объявлений (до 255 символов).
	 * Если не указано, то при создании группы название остается незаданным (NULL),
	 * а при добавлении второго объявления — присваивается автоматически.
	 *
	 * Если длина строки превышает 255 символов, лишние символы будут отброшены.
	 */
	@JsonProperty("AdGroupName")
	public String ad_group_name;

	/**
	 * Заголовок объявления (до 33 символов, включая пробелы и знаки препинания).
	 */
	@JsonProperty("Title")
	public String title;

	/**
	 * Текст объявления (до 75 символов, включая пробелы и знаки препинания).
	 */
	@JsonProperty("Text")
	public String text;

	/**
	 * Ссылка на сайт рекламодателя. Может содержать подстановочные переменные
	 */
	@JsonProperty("Href")
	public String href;

	/**
	 * Идентификаторы регионов, для которых показы включены или выключены.
	 * Идентификатор 0 или пустая строка — показывать во всех регионах.
	 *
	 * Чтобы выключить показ в регионе, перед идентификатором региона ставят минус,
	 * например «1,-219» — показывать для Москвы и Московской области, кроме Черноголовки.
	 * Регионы с минусом нельзя использовать, если указан нулевой регион.
	 * Также параметр не должен состоять только из минус-регионов.
	 *
	 * Полный список регионов можно получить с помощью метода GetRegions.
	 *
	 * Указывать параметр необязательно, если значение AdGroupID отлично от 0
	 * и не задан ни один из параметров Phrases, MinusKeywords, AutоMinusWords.
	 */
	@JsonProperty("Geo")
	public String geo;

	/**
	 * Объект ContactInfo с контактными данными рекламодателя (визитка).
	 * Требуется один из параметров — Href или ContactInfo.
	 */
	@JsonProperty("ContactInfo")
	public ContactInfo contact_info;

	/**
	 * Массив объектов BannerPhraseInfo, содержащих информацию о фразах.
	 * Для группы объявлений должна быть задана хотя бы одна фраза или условие ретаргетинга.
	 *
	 * Указывать фразы необязательно в случае, если значение AdGroupID отлично от 0
	 * и при этом не задан ни один из параметров Geo, MinusKeywords, AutоMinusWords,
	 * а также в случае, если для группы задано хотя бы одно условие ретаргетинга.
	 */
	@JsonProperty("Phrases")
	public List<PhraseInfo> phrases;

	/**
	 * Массив объектов Sitelink с быстрыми ссылками.
	 * Массив должен содержать от 1 до 4 объектов Sitelink или отсутствовать.
	 */
	@JsonProperty("Sitelinks")
	public List<SiteLink> site_links;

	/**
	 * Массив минус-слов, общих для всех фраз группы объявлений.
	 * Если минус-слово совпадает с ключевым словом во фразе, к данной фразе минус-слово не применяется.
	 *
	 * Общие для всех групп кампании минус-слова предпочтительно задавать в одноименном параметре кампании.
	 */
	@JsonProperty("MinusKeywords")
	public List<String> minus_keywords;

	/**
	 * Автоматически сделать фразы в группе объявлений непересекающимися — Yes/No (см. Устранение пересечений).
	 * Предустановленное значение — No.
	 */
	@JsonProperty("AutoMinusWords")
	public StatusBoolean auto_minus_words;

	@JsonProperty("StatusBannerModerate")
	public BannerStatus moderation_status;

	@JsonProperty("StatusPhrasesModerate")
	public BannerStatus phrases_status;

	@JsonProperty("StatusShow")
	public StatusBoolean show_status;

	@JsonProperty("StatusArchive")
	public StatusBoolean archive_status;

	/**
	 * Возрастная категория.
	 *
	 * Для объявлений, относящихся к группе baby_food (соответствующее значение возвращается в массиве AdWarnings),
	 * — возраст ребенка в месяцах: ‘0months‘, ‘1months‘, ‘2months‘, ..., ‘12months‘.
	 *
	 * Для прочих объявлений — возраст, на которую ориентирована информационная продукция.
	 * Возможные значения: ‘0+‘, ‘6+‘, ‘12+‘, ‘16+‘, ‘18+‘.
	 *
	 * Если у объявления отсутствует возрастная категория, параметр не возвращается в ответах
	 * и игнорируется при попытке задать его.
	 *
	 * Ограничение. 
	 * Через API можно изменить только значение возрастной категории, если она есть у объявления.
	 * Чтобы изменить наличие/отсутствие возрастной категории, пожалуйста, обратитесь в службу поддержки Директа.
	 */
	@JsonProperty("AgeLabel")
	public String age_label;

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("banner_id", banner_id)
				.add("title", title)
				.toString();
	}
}
