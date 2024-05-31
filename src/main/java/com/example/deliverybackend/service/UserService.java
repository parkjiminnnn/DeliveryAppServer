package com.example.deliverybackend.service;

import com.example.deliverybackend.entity.UserDao;
import com.example.deliverybackend.entity.UserDto;
import com.example.deliverybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        // DTO에서 엔티티로 매핑하여 저장
        UserDao userdao = new UserDao();
        userdao.setUserId(userDto.getUserId());
        userdao.setPassword(userDto.getPassword());
        userdao.setName(userDto.getName());
        userdao.setPhone(userDto.getPhone());
        userdao.setEmail(userDto.getEmail());
        userRepository.save(userdao);
    }

    public List<String> getAllUserIds() {
        return userRepository.findAll().stream()
                .map(UserDao::getUserId)
                .collect(Collectors.toList());
    }

    public List<UserDao> getAllUsers() {
        return userRepository.findAll();
    }
}
