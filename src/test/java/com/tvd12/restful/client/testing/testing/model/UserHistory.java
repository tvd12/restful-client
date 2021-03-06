package com.tvd12.restful.client.testing.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserHistory {
    
    @JsonProperty("date")
    private String date;
    
    @JsonProperty("ids")
    private int[] cardIds;
    
    @JsonProperty("winning_type")
    private int wonType;
    
    @JsonProperty("exchange")
    private long wonMoney;
}
