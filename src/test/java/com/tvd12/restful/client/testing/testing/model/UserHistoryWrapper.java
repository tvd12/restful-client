package com.tvd12.restful.client.testing.testing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserHistoryWrapper {

    @JsonProperty("logs")
    private List<UserHistory> histories;
    
}
