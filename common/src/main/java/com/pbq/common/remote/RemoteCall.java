package com.pbq.common.remote;

import com.pbq.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;


public class RemoteCall {

    public static RestTemplate restTemplate = new RestTemplate();

    public static ApiResponse getForObject(String url){
        if (StringUtils.isEmpty(url)) {
            return ApiResponse.error(500, "reauestUrl is null");
        }
        ApiResponse resp = restTemplate.getForObject(url, ApiResponse.class);
        return resp;
    }

    public static ApiResponse postForObject(String url, Object jsonRequest){
        if (StringUtils.isEmpty(url)) {
            return ApiResponse.error(500, "reauestUrl is null");
        }
        ApiResponse resp = restTemplate.postForObject(url, jsonRequest, ApiResponse.class);
        return resp;
    }


}
