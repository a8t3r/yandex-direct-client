package ru.cultserv.adv.util;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class AbstractApiRequestExecutor implements ApiRequestExecutor {

    private AsyncHttpClient client;

    protected AbstractApiRequestExecutor(AsyncHttpClient client) {
        this.client = client;
    }

    @Override
	public ApiResponse execute(ApiRequest request) {
		Preconditions.checkState(!client.isClosed(), "request executor is closed");

		Future<ApiResponse> future = asFuture(request);
		try {
			return future.get();
		} catch (ExecutionException | InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public Future<ApiResponse> asFuture(ApiRequest request) {
		Request http_request = convertToHttpRequest(request);
			com.ning.http.client.ListenableFuture<Response> future = client.executeRequest(http_request);
		return Futures.lazyTransform(future, this::process);
	}
	
	private Request convertToHttpRequest(ApiRequest request) {
		RequestBuilder builder = new RequestBuilder()
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .setBodyEncoding("UTF-8")
                .setMethod(request.httpMethod())
                .setUrl(request.url());
		
		withParams(request.params(), builder);
		
		return builder.build();
	}
	
	protected void withParams(final ApiRequestParams params, final RequestBuilder builder) {
		builder.setBody(Json.toJson(params).toString());
	}

	@Override
	public void close() {
		client.close();
	}

	protected abstract ApiResponse process(Response response);

}
