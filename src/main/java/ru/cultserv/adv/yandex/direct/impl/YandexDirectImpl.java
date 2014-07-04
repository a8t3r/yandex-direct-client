package ru.cultserv.adv.yandex.direct.impl;

import ru.cultserv.adv.yandex.direct.AuthToken;
import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.methods.*;
import ru.cultserv.adv.yandex.direct.methods.impl.ProxyBuilder;
import ru.cultserv.adv.yandex.direct.util.requests.YandexDirectMethodCaller;

public class YandexDirectImpl implements YandexDirect {

	private YandexDirectMethodCaller caller;
	
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

	private <T> T create(Class<T> targetInterface) {
		return ProxyBuilder.create(targetInterface, caller);
	}
}
