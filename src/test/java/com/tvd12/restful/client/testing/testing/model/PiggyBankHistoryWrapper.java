package com.tvd12.restful.client.testing.testing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PiggyBankHistoryWrapper {

    @JsonProperty("total")
    private int total;
    
    @JsonProperty("datas")
    private List<PiggyBankHistory> histories;
    
}
