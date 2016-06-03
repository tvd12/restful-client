package com.tvd12.restful.client.testing;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonRootName("Access_Token")
public class AccessToken implements Serializable {
    private static final long serialVersionUID = -8083545232451636370L;

    @JsonProperty("Instance_Url")
    private String instanceUrl;
    
    @JsonProperty("Token")
    private String token;
    
    @JsonProperty("Expiration_date")
    private String expirationDate;
    
    @JsonProperty("Refresh_Token")
    private String refreshToken;
}
