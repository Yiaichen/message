package com.example.message.contrallor;

import com.example.message.domain.Message;
import com.example.message.service.MessageService;
import com.example.message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class BaseController {

    @Autowired
    MessageService msSvc;

    @Autowired
    UserService usSvc;

    /**
     * 存留言
     *
     * @param request
     * @param params
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    String save(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> params) {
        Message ms = new Message(params.get("name"),params.get("phone"),params.get("content"));
        int result = msSvc.add(ms);
        if (result > 0) {
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "message/query", method = RequestMethod.POST)
    List<Map<String, Object>> query(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> params) {
        List<Map<String, Object>> result = msSvc.query(params);
        return result;
    }

    @RequestMapping(value = "login/get", method = RequestMethod.POST)
    Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> params) {
        Map<String, Object> result = usSvc.find(params.get("name"), params.get("password"));
        return result;
    }

}
