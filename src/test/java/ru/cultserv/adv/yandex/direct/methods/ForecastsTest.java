package ru.cultserv.adv.yandex.direct.methods;

import org.junit.Ignore;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.filters.NewForecastInfo;
import ru.cultserv.adv.yandex.direct.impl.YandexDirectImpl;
import ru.cultserv.adv.yandex.direct.models.Currency;
import ru.cultserv.adv.yandex.direct.models.forecast.Forecast;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Alexandr Kolosov
 * @since 7/3/14
 */
@Ignore
public class ForecastsTest {

	private Forecasts forecasts = new YandexDirectImpl(AuthTokens.fake()).forecasts();

	@Test
	public void testForecastCreation() {
		NewForecastInfo forecastInfo = new NewForecastInfo.Builder()
				.phrases("привет мир")
				.region(213)
				.currency(Currency.RUB)
				.build();

		int forecast_id = forecasts.create(forecastInfo);

		int tries = 10;
		while (tries -- > 0) {
			LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(10));
			Forecast forecast = forecasts.get(forecast_id);
            if (forecast.common != null) {
                break;
            }
		}

		forecasts.delete(forecast_id);
	}

}
