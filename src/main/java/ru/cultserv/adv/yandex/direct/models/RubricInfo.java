package ru.cultserv.adv.yandex.direct.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * @author Alexandr Kolosov
 * @since 7/2/14
 */
public class RubricInfo {

	@JsonProperty("RubricID")
	public int rubric_id;

	@JsonProperty("ParentID")
	public int parent_id;

	@JsonProperty("Url")
	public String url;

	@JsonProperty("RubricFullName")
	public String rubric_full_name;

	@JsonProperty("RubricName")
	public String rubric_name;

	@JsonProperty("Checkable")
	public String checkable;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("rubric_id", rubric_id)
				.add("parent_id", parent_id)
				.add("url", url)
				.add("rubric_full_name", rubric_full_name)
				.add("rubric_name", rubric_name)
				.add("checkable", checkable)
				.toString();
	}
}
