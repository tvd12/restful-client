package com.tvd12.restful.client.testing.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestUser {

    @ JsonProperty("username")
    private String username;

    @JsonProperty("interest")
    private long wonMoney;
    
}
