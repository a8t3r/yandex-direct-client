package ru.cultserv.adv.yandex.direct.models.campain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.LocalDate;
import ru.cultserv.adv.yandex.direct.models.Currency;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import java.util.List;

public class CampaignInfo {

	@JsonProperty("Login")
	public String login;

	@JsonProperty("CampaignID")
	public int campaign_id;

	@JsonProperty("Name")
	public String name;

	@JsonProperty("FIO")
	public String fio;

	@JsonProperty("StartDate")
	public LocalDate start_date;

	@JsonProperty("Sum")
	public float sum;

	@JsonProperty("Rest")
	public float rest;

	@JsonProperty("BonusDiscount")
	public float bonus_discount;

	@JsonProperty("Shows")
	public int shows;

	@JsonProperty("Clicks")
	public int clicks;

	@JsonProperty("Currency")
	public Currency currency;

	@JsonProperty("CampaignCurrency")
	public Currency campaign_currency;

	@JsonProperty("SourceCampaignID")
	public int source_campaign_id;

	@JsonProperty("Strategy")
	public CampaignStrategy strategy;

	@JsonProperty("ContextStrategy")
	public CampaignContextStrategy context_strategy;

	@JsonProperty("AdditionalMetrikaCounters")
	public Integer[] additional_metrika_counter;

	@JsonProperty("ClickTrackingEnabled")
	public StatusBoolean click_tracking_enabled;

	@JsonProperty("SmsNotification")
	public SmsNotificationInfo sms_notification;

	@JsonProperty("EmailNotification")
	public EmailNotificationInfo email_notification;

	@JsonProperty("StatusBehavior")
	public String status_behavior;

	@JsonProperty("Status")
	public String status;

	@JsonProperty("TimeTarget")
	public TimeTargetInfo time_target;

	@JsonProperty("StatusContextStop")
	public StatusBoolean status_context_stop;

	@JsonProperty("AutoOptimization")
	public StatusBoolean auto_optimization;

	@JsonProperty("StatusMetricaControl")
	public StatusBoolean status_metrica_control;

	@JsonProperty("DisabledDomains")
	public String disabled_domains;

	@JsonProperty("DisabledIps")
	public String disabled_ips;

	@JsonProperty("StatusOpenStat")
	public StatusBoolean status_open_stat;

	@JsonProperty("ConsiderTimeTarget")
	public StatusBoolean consider_time_target;

	@JsonProperty("ManagerName")
	public String manager_name;

	@JsonProperty("AgencyName")
	public String agency_name;

	@JsonProperty("StatusShow")
	public StatusBoolean status_show;

	@JsonProperty("StatusArchive")
	public StatusBoolean status_archive;

	@JsonProperty("StatusActivating")
	public StatusBoolean status_activating;

	@JsonProperty("StatusModerate")
	public StatusBoolean status_moderate;

	@JsonProperty("IsActive")
	public StatusBoolean is_active;

	@JsonProperty("MinusKeywords")
	public List<String> minus_keywords;

	@JsonProperty("AddRelevantPhrases")
	public StatusBoolean add_relevant_phrases;

	@JsonProperty("RelevantPhrasesBudgetLimit")
	public int relevant_phrases_budget_limit;

	@JsonProperty("SumAvailableForTransfer")
	public float sum_available_for_transfer;

	@JsonProperty("DayBudget")
	public DayBudgetInfo day_budget;

	@JsonProperty("DayBudgetEnabled")
	public StatusBoolean day_budget_enabled;

}
