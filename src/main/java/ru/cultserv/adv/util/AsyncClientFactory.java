package ru.cultserv.adv.util;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;

/**
 * @author Alexandr Kolosov
 * @since 29.07.2014
 */
public class AsyncClientFactory {

    public static AsyncHttpClient createHttpClient(AsyncHttpClientConfig config) {
        return new AsyncHttpClient(config);
    }

    public static AsyncHttpClient getClient() {
        return createHttpClient(new AsyncHttpClientConfig.Builder().build());
    }
}
