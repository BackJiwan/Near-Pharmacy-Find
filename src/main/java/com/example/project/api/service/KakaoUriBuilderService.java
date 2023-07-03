package com.example.project.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class KakaoUriBuilderService {

    private static final String KAKAO_LOCAL_SEARCH_ASSRESS_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    public URI builderUriByAddressSearch(String address){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ASSRESS_URL);
        uriBuilder.queryParam("query",address);

        URI uri = uriBuilder.build().encode().toUri();
        log.info("[KakaoUriBuilderService buildUriByAddressSearch]");

        return uri;
    }
}
