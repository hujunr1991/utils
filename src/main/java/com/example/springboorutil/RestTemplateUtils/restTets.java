package com.example.springboorutil.RestTemplateUtils;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class restTets {
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        String url = "http://192.168.2.40:8081/channel/channelHourData/getHourNewUserData";
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("dt", "20180416");

        // 1、使用postForObject请求接口
        String result = template.postForObject(url, paramMap, String.class);
        System.out.println("result1==================" + result);

        // 2、使用postForEntity请求接口
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap,headers);
        ResponseEntity<String> response2 = template.postForEntity(url, httpEntity, String.class);
        System.out.println("result2====================" + response2.getBody());

        // 3、使用exchange请求接口
        ResponseEntity<String> response3 = template.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println("result3====================" + response3.getBody());

    }

}
