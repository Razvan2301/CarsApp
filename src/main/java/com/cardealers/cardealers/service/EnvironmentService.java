package com.cardealers.cardealers.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class EnvironmentService {

    private final String websiteName;

    @Autowired
    EnvironmentService(@Value("${server.name}") String websiteName) {
        this.websiteName = websiteName;
    }

}
