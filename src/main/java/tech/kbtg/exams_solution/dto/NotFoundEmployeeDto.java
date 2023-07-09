package tech.kbtg.exams_solution.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NotFoundEmployeeDto
{
	@JsonProperty ( "not_found_ids" )
	private List < Integer > notFoundIds;

	public NotFoundEmployeeDto( List < Integer > notFoundIds )
	{
		this.notFoundIds = notFoundIds;
	}

	public List < Integer > getNotFoundIds()
	{
		return notFoundIds;
	}

	public void setNotFoundIds( List < Integer > notFoundIds )
	{
		this.notFoundIds = notFoundIds;
	}
}
