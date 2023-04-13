package com.jpk.jpkai.modules.stableai.service.impl;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.jpk.jpkai.modules.stableai.dto.StableUserDto;
import com.jpk.jpkai.modules.stableai.service.StableUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StableUserServiceImpl implements StableUserService {
    @Value("${stable_ai.STABILITY_API_KEY}")
    private String STABILITY_API_KEY;

    @Value("${stable_ai.URL}")
    private String URL;

    @Override
    public String getUser() {
        String res = HttpRequest.get(URL+"/v1/user/account").header(Header.AUTHORIZATION,"Bearer " + STABILITY_API_KEY).execute().body();
        return res;
    }
}
