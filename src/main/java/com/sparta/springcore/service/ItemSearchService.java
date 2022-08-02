package com.sparta.springcore.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springcore.dto.ItemDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class ItemSearchService {
    public List<ItemDto> getItems(String query) throws IOException {
        // 네이버 쇼핑 API 호출에 필요한 Header, Body 정리
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "zdqMoIkFaK8uKvC2oNY2");
        headers.add("X-Naver-Client-Secret", "LiZfsgtuD5");
        String body = "";
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

        // 네이버 쇼핑 API 호출 결과 -> naverApiResponseJson (JSON 형태)
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        String naverApiResponseJson = responseEntity.getBody();

        // naverApiResponseJson (JSON 형태) -> itemDtoList (자바 객체 형태)
        // - naverApiResponseJson 에서 우리가 사용할 데이터만 추출 -> List<ItemDto> 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode itemsNode = objectMapper.readTree(naverApiResponseJson).get("items");
        List<ItemDto> itemDtoList = objectMapper
                .readerFor(new TypeReference<List<ItemDto>>() {})
                .readValue(itemsNode);

        return itemDtoList;
    }
}
