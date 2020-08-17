package com.project.boot.controller;

import com.project.boot.utils.RandomDataGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
@RequiredArgsConstructor
public class TestDataController {

    private final RandomDataGenerator generator;

    @PostMapping("init")
    public void initTestData(@RequestParam Integer instancesCount) {
        generator.init(instancesCount);
    }
}
