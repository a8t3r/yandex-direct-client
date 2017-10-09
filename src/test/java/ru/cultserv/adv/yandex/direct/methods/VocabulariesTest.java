package ru.cultserv.adv.yandex.direct.methods;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.cultserv.adv.yandex.direct.impl.YandexDirectImpl;
import ru.cultserv.adv.yandex.direct.models.RegionInfo;
import ru.cultserv.adv.yandex.direct.models.RubricInfo;
import ru.cultserv.adv.yandex.direct.util.AuthTokens;

import java.util.List;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
@Ignore
public class VocabulariesTest {

	private Vocabularies vocabularies = new YandexDirectImpl(AuthTokens.fake()).vocabularies();

	@Test
	public void testGetRegions() {
		List<RegionInfo> regions = vocabularies.getRegions();
		Assert.assertNotNull(regions);
	}

	@Test
	public void testGetRubris() {
		List<RubricInfo> rubrics = vocabularies.getRubrics();
		Assert.assertNotNull(rubrics);
	}
}
