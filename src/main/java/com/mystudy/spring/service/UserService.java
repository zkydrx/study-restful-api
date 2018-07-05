package com.mystudy.spring.service;

import com.mystudy.spring.domain.User;
import com.mystudy.spring.exception.NotFoundException;
import com.mystudy.spring.exception.Result;
import com.mystudy.spring.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mystudy.spring.util.Util.getNullPropertyNames;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public Object addUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getUserList()
    {
        return userRepository.findAll();
    }

    public Object getUser(String id) throws NotFoundException
    {
        User currentInstance = userRepository.findOne(id);
        if (currentInstance == null)
        {
            throw new NotFoundException("user " + id + " is not exist!", Result.ErrorCode.USER_NOT_FOUND.getCode());
        }
        return userRepository.findOne(id);
    }

    public void deleteUser(String id)
    {
        userRepository.delete(id);
    }

    public User update(String id, User user)
    {
        User currentInstance = userRepository.findOne(id);

        //支持部分更新
        String[] nullPropertyNames = getNullPropertyNames(user);
        BeanUtils.copyProperties(user, currentInstance, nullPropertyNames);

        return userRepository.save(currentInstance);
    }
}
