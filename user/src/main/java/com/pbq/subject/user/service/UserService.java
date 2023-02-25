package com.pbq.subject.user.service;

import com.pbq.common.po.UserPo;
import com.pbq.common.remote.RemoteCall;
import com.pbq.subject.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Value("${portalUrl}")
    public String portalUrl;

    @Value("${loginTokenTime_seconds}")
    public long time;

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public UserMapper userMapper;

    public String testCall(){
        return (String)RemoteCall.getForObject(portalUrl + "/test/getName").getData();
    }

    public String login(String userName, String password){
        UserPo userPo = userMapper.getUserByUserNameAndPassword(userName, password);
        if (userPo == null) {
            return null;
        }
        userPo.setPassword(null);
        String token = UUID.randomUUID().toString();
        String oldToken = (String)redisTemplate.opsForValue().get(userPo.getUserId());
        //移除旧的token
        if (!StringUtils.isEmpty(oldToken)) {
            redisTemplate.delete(oldToken);
        }
        redisTemplate.opsForValue().set(token, userPo, time, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(userPo.getUserId(), token, time, TimeUnit.SECONDS);
        return token;
    }



}
