package com.secure.secureDemo.controllers.apiImpl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TestRestApi {

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String, Object> dataTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("message","DataTest");
        return map;
    }

    @PostMapping("/saveData")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Map<String,String> saveData(@RequestBody String data){
        Map<String,String> map = new HashMap<>();
        map.put("dataSaved",data);
        return map;
    }
}
