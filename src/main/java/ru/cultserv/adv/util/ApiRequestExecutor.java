package ru.cultserv.adv.util;

import java.io.Closeable;
import java.util.concurrent.Future;

public interface ApiRequestExecutor extends Closeable {

	ApiResponse execute(ApiRequest request);

	Future<ApiResponse> asFuture(ApiRequest request);

	@Override
	void close();

}
