package ru.cultserv.adv.yandex.direct.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Function;
import ru.cultserv.adv.yandex.direct.models.PhraseInfo;
import ru.cultserv.adv.yandex.direct.models.RegionInfo;
import ru.cultserv.adv.yandex.direct.models.RubricInfo;
import ru.cultserv.adv.yandex.direct.models.banner.BannerInfo;
import ru.cultserv.adv.yandex.direct.models.campain.BannersStat;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.models.campain.SummaryStat;
import ru.cultserv.adv.yandex.direct.models.forecast.Forecast;
import ru.cultserv.adv.yandex.direct.models.forecast.ForecastStatusInfo;
import ru.cultserv.adv.yandex.direct.models.wordstat.WordstatReportInfo;
import ru.cultserv.adv.yandex.direct.models.wordstat.WordstatReportStatusInfo;

import java.util.List;

public enum MethodName {

	// Working with campaigns
	// ~~~~~
	
	ArchiveCampaign(int.class, Constants.getFunction("CampaignID")),
	CreateOrUpdateCampaign(Long.class),
	DeleteCampaign(int.class, Constants.getFunction("CampaignID")),
	GetCampaignParams(new TypeReference<CampaignInfo>() {}, Constants.getFunction("CampaignID")),

	GetCampaignsParams(new TypeReference<List<CampaignInfo>>() {}),
	GetCampaignsList(new TypeReference<List<CampaignShortInfo>>() {}, Constants.SINGLE_PARAM_CONVERTER),

	GetCampaignsListFilter(new TypeReference<List<CampaignShortInfo>>() {}, Constants.SINGLE_PARAM_CONVERTER),
	ResumeCampaign(int.class, Constants.getFunction("CampaignID")),
	StopCampaign(int.class, Constants.getFunction("CampaignID")),
	UnArchiveCampaign(int.class, Constants.getFunction("CampaignID")),
	GetBannersStat(new TypeReference<BannersStat>() {}, Constants.SINGLE_PARAM_CONVERTER),
	GetSummaryStat(new TypeReference<List<SummaryStat>>() {}, Constants.SINGLE_PARAM_CONVERTER),

	// Working with banners
	// ~~~~~

	ArchiveBanners(int.class, Constants.getFunction("BannerIDS")),
	CreateOrUpdateBanners(new TypeReference<List<Long>>() {}, Constants.SINGLE_PARAM_CONVERTER),
	DeleteBanners(int.class, Constants.getFunction("BannerIDS")),
	GetBanners(new TypeReference<List<BannerInfo>>() {}, Constants.SINGLE_PARAM_CONVERTER),
	GetBannerPhrases(new TypeReference<List<PhraseInfo>>() {}),
	GetBannerPhrasesFilter(new TypeReference<List<PhraseInfo>>() {}),
	ModerateBanners(int.class, Constants.SINGLE_PARAM_CONVERTER),
	ResumeBanners(int.class, Constants.getFunction("BannerIDS")),
	StopBanners(int.class, Constants.getFunction("BannerIDS")),
	UnArchiveBanners(int.class, Constants.getFunction("BannerIDS")),

	// Forecast
	CreateNewForecast(int.class, Constants.SINGLE_PARAM_CONVERTER),
	DeleteForecastReport(boolean.class, Constants.SINGLE_PARAM_CONVERTER),
	GetForecast(Forecast.class, Constants.SINGLE_PARAM_CONVERTER),
	GetForecastList(new TypeReference<List<ForecastStatusInfo>>() {}, Constants.EMPTY_PARAM_CONVERTER),

	// Vocabularies
	GetRegions(new TypeReference<List<RegionInfo>>() {}),
	GetRubrics(new TypeReference<List<RubricInfo>>() {}),

	// Util methods
	PingAPI(int.class),

	// WordStats
	CreateNewWordstatReport(int.class, Constants.SINGLE_PARAM_CONVERTER),
	DeleteWordstatReport(int.class, Constants.SINGLE_PARAM_CONVERTER),
	GetWordstatReport(new TypeReference<List<WordstatReportInfo>>() {}, Constants.SINGLE_PARAM_CONVERTER),
	GetWordstatReportList(new TypeReference<List<WordstatReportStatusInfo>>() {}),
	GetKeywordsSuggestion(new TypeReference<List<String>>() {}, Constants.SINGLE_PARAM_CONVERTER);

	private TypeReference<?> return_type;
	private Class<?> return_class;
	private Function<Object[], Object> converter;

	private MethodName(TypeReference<?> type) {
		this(type, null);
	}

	private MethodName(TypeReference<?> type, Function<Object[], Object> converter) {
		this.return_type = type;
		this.converter = converter;
	}
	
	private MethodName(Class<?> clazz) {
		this(clazz, null);
	}

	private MethodName(Class<?> clazz, Function<Object[], Object> converter) {
		this.return_class = clazz;
		this.converter = converter;
	}
	
	public TypeReference<?> returnType() {
		return return_type;
	}
	
	public Class<?> returnClass() {
		return return_class;
	}

	public Function<Object[], Object> getConverter() {
		return converter;
	}
}
