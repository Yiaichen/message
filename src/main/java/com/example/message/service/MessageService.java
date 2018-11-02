package com.example.message.service;

import com.example.message.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add(Message message) {
        return jdbcTemplate.update("insert into message(name, phone, content) values(?, ?, ?)",
                message.getName(),
                message.getPhone(),
                message.getContent());
    }

    public List<Map<String, Object>> query(Map<String, String> params) {
       return jdbcTemplate.queryForList("select * from message where DATE_FORMAT(TIME,'%Y-%m-%d') >= ? and DATE_FORMAT(TIME,'%Y-%m-%d') <= ? order by time desc",params.get("beginTime"), params.get("endTime"));
    }

}
