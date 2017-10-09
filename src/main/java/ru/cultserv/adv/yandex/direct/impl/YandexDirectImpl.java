package ru.cultserv.adv.yandex.direct.impl;

import com.ning.http.client.AsyncHttpClientConfig;
import ru.cultserv.adv.util.AsyncClientFactory;
import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.keystore.KeyStoreBuilder;
import ru.cultserv.adv.yandex.direct.methods.*;
import ru.cultserv.adv.yandex.direct.methods.impl.ProxyBuilder;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;

import javax.net.ssl.SSLContext;

public class YandexDirectImpl implements YandexDirect {

	private YandexDirectMethodCaller caller;

	protected YandexDirectImpl(YandexDirectMethodCaller caller) {
		this.caller = caller;
	}

	@Deprecated
    public YandexDirectImpl(KeyStoreBuilder.Builder builder) {
        this(builder.build());
    }

	@Deprecated
    public YandexDirectImpl(SSLContext context) {
        AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
        builder.setSSLContext(context);
        AsyncHttpClientConfig config = builder.build();
        this.caller = YandexDirectMethodCaller.prepared(new AuthToken(null), AsyncClientFactory.createHttpClient(config));
    }

	@Deprecated
	public YandexDirectImpl(AuthToken token) {
		this.caller = YandexDirectMethodCaller.defaultCaller(token);
	}

	@Override
	public Campaigns campaigns() {
		return create(Campaigns.class);
	}

	@Override
	public Banners banners() {
		return create(Banners.class);
	}

	@Override
	public Forecasts forecasts() {
		return create(Forecasts.class);
	}

	@Override
	public Vocabularies vocabularies() {
		return create(Vocabularies.class);
	}

	@Override
	public Utils utils() {
		return create(Utils.class);
	}

    @Override
    public WordStats wordstats() {
        return create(WordStats.class);
    }

	@Override
	public AccountManagement accountManagement() {
		return create(AccountManagement.class);
	}

	private <T> T create(Class<T> targetInterface) {
		return ProxyBuilder.create(targetInterface, caller);
	}

	@Override
	public void close() {
		caller.close();
	}
}
