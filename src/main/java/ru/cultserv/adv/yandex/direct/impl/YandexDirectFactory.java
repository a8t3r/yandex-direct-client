package ru.cultserv.adv.yandex.direct.impl;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.ProxyServer;
import ru.cultserv.adv.util.AsyncClientFactory;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;

import javax.net.ssl.SSLContext;

/**
 * @author Sergey Zudin
 * @since 26.10.15.
 */
public class YandexDirectFactory {

    public interface InitialBuilder {
        ProxyBuilder sslContext(SSLContext context);
        ProxyBuilder token(AuthToken token);
    }

    public interface ProxyBuilder extends FinalBuilder {
        FinalBuilder proxy(ProxyServer server);
    }

    public interface FinalBuilder {
        FinalBuilder timeout(int millis);
        YandexDirect build();
    }

    public static class YandexDirectBuilder implements InitialBuilder, ProxyBuilder, FinalBuilder {

        private AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
        private AuthToken token;

        @Override
        public ProxyBuilder sslContext(SSLContext context) {
            builder.setSSLContext(context);
            token = new AuthToken(null);
            return this;
        }

        @Override
        public ProxyBuilder token(AuthToken token) {
            this.token = token;
            return this;
        }

        @Override
        public FinalBuilder proxy(ProxyServer server) {
            builder.setProxyServer(server);
            return this;
        }

        @Override
        public FinalBuilder timeout(int millis) {
            builder.setRequestTimeout(millis);
            builder.setConnectTimeout(millis);
            builder.setPooledConnectionIdleTimeout(millis);
            return this;
        }

        @Override
        public YandexDirect build() {
            AsyncHttpClientConfig config = builder.build();
            AsyncHttpClient httpClient = AsyncClientFactory.createHttpClient(config);
            YandexDirectMethodCaller methodCaller = YandexDirectMethodCaller.prepared(token, httpClient);
            return new YandexDirectImpl(methodCaller);
        }
    }

    public static InitialBuilder builder() {
        return new YandexDirectBuilder();
    }

}
