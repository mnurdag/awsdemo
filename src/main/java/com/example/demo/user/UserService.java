package com.example.demo.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class UserService {

    UserRepository userRepository;

    public void createUser(CreateUserRequest request) {
        userRepository.save(User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .build());
    }

    public List<UserRespose> getAllUsers() {
        return userRepository.findAll().stream().map(user ->
                UserRespose.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .build()).toList();
    }

}
