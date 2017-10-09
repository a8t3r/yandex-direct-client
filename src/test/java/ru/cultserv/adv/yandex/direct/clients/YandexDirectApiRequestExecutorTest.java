package ru.cultserv.adv.yandex.direct.clients;

import org.junit.Ignore;
import org.junit.Test;
import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestExecutor;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.util.AsyncClientFactory;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;
import ru.cultserv.adv.yandex.direct.util.exceptions.ApiException;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectRequest;
import ru.cultserv.adv.yandex.direct.util.requests.YandexRequestExecutor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Ignore
public class YandexDirectApiRequestExecutorTest {
	
	private ApiRequestExecutor executor = new YandexRequestExecutor(AsyncClientFactory.getClient());

	@Test
	public void shouldExecuteYandexRequest() {
		ApiRequest request =
			new YandexDirectRequest.Builder(AuthTokens.fake())
				.forMethod(MethodName.PingAPI.name())
				.build();

		ApiResponse response = executor.execute(request);
		int result = response.as(int.class);
		
		assertEquals(1, result);
	}
	
	@Test
	public void shouldExecuteRequestWithException() {
		ApiRequest request =
			new YandexDirectRequest.Builder(new AuthToken(""))
				.forMethod(MethodName.PingAPI)
				.build();
		
		ApiException exception = null;
		
		try {
			executor.execute(request);
		} catch(ApiException e) {
			exception = e;
		}
		
		assertNotNull(exception);
		assertEquals(53, exception.errorCode());
		
	}

}
