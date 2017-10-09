package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class RegionInfo {

	@JsonProperty("RegionID")
	public int region_id;

	@JsonProperty("ParentID")
	public int parent_id;

	@JsonProperty("RegionName")
	public String region_name;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("region_id", region_id)
				.add("parent_id", parent_id)
				.add("region_name", region_name)
				.toString();
	}
}
