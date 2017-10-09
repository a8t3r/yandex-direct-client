package ru.cultserv.adv.yandex.direct.methods;

import org.junit.Ignore;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.filters.BannersFilterParam;
import ru.cultserv.adv.yandex.direct.impl.YandexDirectImpl;
import ru.cultserv.adv.yandex.direct.models.banner.BannerInfo;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;
import ru.cultserv.adv.yandex.direct.util.FakeBannersDataBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@Ignore
public class BannersTest {

	private Banners banners = new YandexDirectImpl(AuthTokens.fake()).banners();
	
	@Test
	public void shouldGetBannersWithCampaignIdsFilter() {
		// Checks are here
		getBannersForRandomCampaign();
	}
	
	private List<BannerInfo> getBannersForRandomCampaign() {
		CampaignShortInfo campaign_info = new CampaignsTest().getFirstNotArchivedCampaign();
		
		BannersFilterParam param = new BannersFilterParam();
		param.campaign_ids = Arrays.asList(campaign_info.campaign_id);
		
		List<BannerInfo> bannersInfos = banners.get(param);
		
		assertThat(bannersInfos)
			.isNotNull()
			.isNotEmpty();
		
		BannerInfo bannerInfo = bannersInfos.get(0);
		
		assertThat(bannerInfo.campaign_id)
			.isNotNull()
			.isEqualTo(campaign_info.campaign_id);
		
		return bannersInfos;
	}
	
	@Test
	public void shouldStopBanners() {
		List<BannerInfo> bannersInfos = getBannersForRandomCampaign();
		List<Long> banner_ids = new ArrayList<>();
		
		for(BannerInfo b : bannersInfos)
			banner_ids.add(b.banner_id);
		
		assertThat(banner_ids).isNotEmpty();
		
		banners.stop(banner_ids.subList(0, 1));
	}
	
	@Test
	public void shouldCreateBanners() {
		CampaignShortInfo campaign_info = new CampaignsTest().getFirstNotArchivedCampaign();
		List<BannerInfo> items = new FakeBannersDataBuilder(campaign_info).build();
		
		List<Long> created_banner_ids = banners.create(items);
		
		assertThat(created_banner_ids).isNotEmpty();
	}

}
