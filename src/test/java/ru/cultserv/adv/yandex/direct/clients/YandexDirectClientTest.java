package ru.cultserv.adv.yandex.direct.clients;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.YandexDirect;
import ru.cultserv.adv.yandex.direct.impl.YandexDirectImpl;
import ru.cultserv.adv.yandex.direct.methods.Campaigns;
import ru.cultserv.adv.yandex.direct.methods.Utils;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;

import static org.junit.Assert.assertNotNull;

public class YandexDirectClientTest {
	
	private YandexDirect direct = new YandexDirectImpl(AuthTokens.fake());

	@Test
	public void shouldCallSimpleMethodToGetCampaigns() {
		Campaigns campaigns = direct.campaigns();
		assertNotNull(campaigns);
	}

	@Test  @Ignore
	public void testPing() {
		Utils utils = direct.utils();
		Assert.assertEquals(1, utils.ping());
	}
}
