package ru.cultserv.adv.yandex.direct.util.requests;

import com.ning.http.client.AsyncHttpClient;
import ru.cultserv.adv.util.ApiRequest;
import ru.cultserv.adv.util.ApiRequestExecutor;
import ru.cultserv.adv.util.ApiResponse;
import ru.cultserv.adv.util.AsyncClientFactory;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.methods.MethodName;

import java.io.Closeable;

public class YandexDirectMethodCaller implements Closeable {
	
	private final AuthToken token;
	private final ApiRequestExecutor executor;

	public YandexDirectMethodCaller(AuthToken token, ApiRequestExecutor executor) {
		this.token = token;
		this.executor = executor;
	}

	public <T> T call(MethodName method) {
		return call(method, new String[] {});
	}

	@SuppressWarnings("unchecked")
	public <T> T call(MethodName method, Object param) {
		ApiRequest request = buildCommonRequest(method, param);
		ApiResponse response = executor.execute(request);
		T result;

		if(method.returnClass() != null) {
			result = (T) response.as(method.returnClass());
		} else {
			result = (T) response.as(method.returnType());
		}

		return result;
	}
	
	private ApiRequest buildCommonRequest(MethodName method, Object param) {
		return new YandexDirectRequest.Builder(token)
			.forMethod(method)
			.andParam(param)
			.build();
	}

    public static YandexDirectMethodCaller prepared(AuthToken token, AsyncHttpClient client) {
        return new YandexDirectMethodCaller(token, new YandexRequestExecutor(client));
    }

	public static YandexDirectMethodCaller defaultCaller(AuthToken token) {
		return prepared(token, AsyncClientFactory.getClient());
	}

	@Override
	public void close() {
		executor.close();
	}
}
