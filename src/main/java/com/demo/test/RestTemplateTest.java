package com.demo.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

public class RestTemplateTest {

    @Test
    public void testPost() {
        RestTemplate restTemplate = new RestTemplate();
        // 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "SessionId=32143214");
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 请求参数
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("test", "123");
        HttpEntity<Map> httpEntity = new HttpEntity(params, headers);
        // 发送请求
        ResponseEntity response = restTemplate.postForEntity("https://api.vvhan.com/api/wbhot", httpEntity, String.class);
        // 获取结果
        System.out.println(response.getBody());
    }
}
