package com.divnych.contentmanagement.service;

import com.divnych.contentmanagement.converter.EntityConverter;
import com.divnych.contentmanagement.entity.User;
import com.divnych.contentmanagement.model.UserRequest;
import com.divnych.contentmanagement.model.UserResponse;
import com.divnych.contentmanagement.repository.UserRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        userRepository.save(user);
    }

    public List<UserResponse> getUsersByAgeOver(int age) {
        return userRepository.findAll().stream()
            .filter(user -> user.getAge() > age)
            .map(EntityConverter::convertUser)
            .collect(Collectors.toList());
    }


    public Set<String> getUserNamesByArticlesNumOver3() {
        return userRepository.getUserNamesByArticlesNumOver3();
    }
}
