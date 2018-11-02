package com.example.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Map<String, Object> find(String name, String password) {
        Map<String, Object> map;
        try {
             map = jdbcTemplate.queryForMap("select * from user where name = ? and password = ?", name, password);
            return map;
        } catch (Exception e) {
            map = new HashMap<String, Object>();
            map.put("error", "1");
        }
        return map;
    }

}
