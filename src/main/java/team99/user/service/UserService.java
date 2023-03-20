package team99.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team99.user.domain.User;
import team99.user.dto.MultipleUserResponse;
import team99.user.dto.SingleUserResponse;
import team99.user.repository.UserServiceRepository;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserServiceRepository userServiceRepository;

    @Autowired
    private MultipleUserResponse multipleUserResponse;

    @Autowired
    private SingleUserResponse singleUserResponse;


    public MultipleUserResponse getAllUsers()
    {
        List<User> userList = userServiceRepository.findAll();
        return multipleUserResponse.setMultipleUserResponse(userList);

    }

    public SingleUserResponse getUsersById(Integer id)
    {
        Optional<User> user = userServiceRepository.findById(id);
        return singleUserResponse.setSingleUserResponse(user.get());
    }

    public SingleUserResponse saveUser(String name)
    {
        User persistedUser = userServiceRepository.save(new User(name));
        return singleUserResponse.setSingleUserResponse(persistedUser);
    }
}
