package com.tvd12.restful.client.testing.testing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BestUserWrapper {
    
    public BestUserWrapper() {}
    
    public BestUserWrapper(List<BestUser> users) {
        this.users = users;
    }

    private List<BestUser> users;
    
}
