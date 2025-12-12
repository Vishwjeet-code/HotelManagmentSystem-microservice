package com.vishwjeet.ApiGateWay.Models;

import jdk.jfr.DataAmount;
import lombok.*;

import java.util.Collection;
import java.util.Collections;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class authResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expireAt;
    private Collection<String> authorities;
}
