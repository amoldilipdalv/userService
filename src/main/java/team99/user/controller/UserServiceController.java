package team99.user.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import team99.user.dto.MultipleUserResponse;
import team99.user.dto.SingleUserResponse;
import team99.user.dto.UserServiceConstants;
import team99.user.service.UserService;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public MultipleUserResponse getAllUsers(@RequestParam(name = "page_num", defaultValue = UserServiceConstants.defaultPageNum) Integer pageNum,
                                            @RequestParam(name = "page_size", defaultValue = UserServiceConstants.defaultPageSize) Integer pageSize)
    {
        return userService.getAllUsers(pageNum, pageSize);
    }

    @GetMapping("/users/{id}")
    public SingleUserResponse getUsersById(@PathVariable Integer id)
    {
        return userService.getUsersById(id);
    }

    @PostMapping(path = "/users", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public SingleUserResponse saveUsers(@RequestBody MultiValueMap<String, String> requestParamMap ) {
        return userService.saveUser(requestParamMap.getFirst("name"));
    }
}
