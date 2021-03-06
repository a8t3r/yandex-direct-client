package ru.cultserv.adv.yandex.direct.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
public class ForecastStatusInfo {

	@JsonProperty("ForecastID")
	public int forecast_id;

	@JsonProperty("StatusForecast")
	public String status_forecast;

}
