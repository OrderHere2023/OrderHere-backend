package com.backend.OrderHere.service;

import com.backend.OrderHere.dto.UserGetDto;
import com.backend.OrderHere.dto.UserPostDto;
import com.backend.OrderHere.model.User;
import com.backend.OrderHere.model.enums.UserRole;
import com.backend.OrderHere.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TokenService tokenService;

    //register User information and store them in db
    public UserGetDto registerUser(UserPostDto userPostDto){

        User user = new User();
        user.setUsername(userPostDto.getUsername());
        user.setPassword(userPostDto.getPassword());
        user.setFirstname(userPostDto.getFirstname());
        user.setLastname(userPostDto.getLastname());
        user.setEmail(userPostDto.getEmail());
        user.setUserRoleEnum(UserRole.CUSTOMER);

        userRepository.save(user);

        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setUsername(user.getUsername());
        userGetDto.setFirstname(user.getFirstname());
        userGetDto.setLastname(user.getLastname());
        userGetDto.setEmail(user.getEmail());

        return userGetDto;
    }
    public User findUserByUsernameAndEmail(String username, String email) {
        return userRepository.findByUsernameAndEmail(username, email);
    }

    public boolean resetPassword(String username, String email, String token, String newPassword) {
        // check whether token is valid
        if (tokenService.isTokenValid(token)) {
            // check whether user exist
            User user = userRepository.findByUsernameAndEmail(username, email);
            if (user != null) {
                // if all match
                user.setPassword(newPassword);
                userRepository.save(user);
                return true; // reset success
            }
        }
        return false; // reset fail
    }

}