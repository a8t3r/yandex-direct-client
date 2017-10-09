package ru.cultserv.adv.yandex.direct.methods;

import org.junit.Ignore;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.filters.CampaignsFilterParam;
import ru.cultserv.adv.yandex.direct.impl.YandexDirectImpl;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;

import java.util.List;

import static org.junit.Assert.*;

@Ignore
public class CampaignsTest {

	private Campaigns campaigns = new YandexDirectImpl(AuthTokens.fake()).campaigns();
	
	@Test
	public void shouldGetCampaignsList() {
		List<CampaignShortInfo> campaignsInfos = campaigns.list();
		
		assertNotNull(campaignsInfos);
		assertTrue(!campaignsInfos.isEmpty());
		
		CampaignShortInfo campaign = campaignsInfos.get(0);
		assertNotNull(campaign);
		assertNotNull(campaign.campaign_id);

		CampaignInfo info = campaigns.params(campaign.campaign_id);
		assertNotNull(info);
	}
	
	@Test
	public void shouldGetCampaignsListForLogins() {
		List<CampaignShortInfo> campaignsInfos = campaigns.list("xolvo");
		
		assertNotNull(campaignsInfos);
	}
	
	@Test
	public void shouldGetCampaignsWithoutArchiveFilter() {
		int limit = 5;
		
		CampaignsFilterParam filtering_param =
			new CampaignsFilterParam.Builder()
				.withoutArchived()
				.withRange(limit, 0)
				.build();
		
		List<CampaignShortInfo> campaignsInfos = campaigns.list(filtering_param);
		
		checkNotArchivedCampaigns(campaignsInfos, limit);
	}
	
	private void checkNotArchivedCampaigns(List<CampaignShortInfo> campaignsInfos, int limit) {
		assertNotNull(campaignsInfos);
		assertTrue(campaignsInfos.size() <= limit);
		
		for(CampaignShortInfo campaignInfo : campaignsInfos) {
			assertFalse(campaignInfo.isArchived());
		}
	}
	
	public CampaignShortInfo getFirstNotArchivedCampaign() {
		CampaignsFilterParam filtering_param =
			new CampaignsFilterParam.Builder()
				.withoutArchived()
				.withLimit(1)
				.build();
		
		List<CampaignShortInfo> campaignsInfos = campaigns.list(filtering_param);
		
		checkNotArchivedCampaigns(campaignsInfos, 1);
		
		return campaignsInfos.get(0);
	}

}
