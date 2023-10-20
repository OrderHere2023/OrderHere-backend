package com.backend.OrderHere.controller.v1;

import com.backend.OrderHere.dto.UserGetDto;
import com.backend.OrderHere.dto.UserPostDto;
import com.backend.OrderHere.model.User;
import com.backend.OrderHere.service.EmailService;
import com.backend.OrderHere.service.TokenService;
import com.backend.OrderHere.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/public")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final EmailService emailService;
    private final TokenService tokenService;

    @RequestMapping("/signup")
    public ResponseEntity<UserGetDto> registerUser(@RequestBody UserPostDto userPostDto){

        logger.debug("Received registration request from user: {}", userPostDto);

        //create user and store in db
        UserGetDto newUser = userService.registerUser(userPostDto);

        //generate log and response HTTP request
        logger.debug("User registered successfully: {}", newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @GetMapping("hello")
    public String responseHello(){
        return "Hello";
    }

    @RequestMapping("/test")
    public String replytoConsole(){
        return ("Post Method is fine, no problem at all");
    }

    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestParam String username,
                                                 @RequestParam String email) {
        // check whether user email exist
        User user = userService.findUserByEmail(email);
        if (user == null) {
            return new ResponseEntity<>("Invalid email", HttpStatus.BAD_REQUEST);
        }

        // generate new token
        String token = tokenService.generateToken();

        try {
            // send token to user email
            emailService.sendEmailWithToken(email, token);
        } catch (MessagingException e) {
            return new ResponseEntity<>("Failed to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Token sent successfully", HttpStatus.OK);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestParam String username,
                                                @RequestParam String email,
                                                @RequestParam String token,
                                                @RequestParam String newPassword) {
        boolean resetSuccessful = userService.resetPassword(username, email, token, newPassword);
        if (resetSuccessful) {
            logger.debug("Password reset successful for user: {}", username);
            return new ResponseEntity<>("Password reset successful.", HttpStatus.OK);
        } else {
            logger.debug("Password reset failed for user: {}", username);
            return new ResponseEntity<>("Password reset failed.", HttpStatus.BAD_REQUEST);
        }
    }
}
