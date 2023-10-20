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
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/public")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final EmailService emailService;
    private final TokenService tokenService;

    @PostMapping("/signup")
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

    @PostMapping("/forget-password")
    public ResponseEntity<String> forgotPassword(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        // check whether user email exist
        User user = userService.findByEmail(email);
        if (user == null) {
            logger.debug("Received email for password reset: {}", email);
            return new ResponseEntity<>("Invalid email", HttpStatus.BAD_REQUEST);
        }

        // generate 6-digit code
        String code = tokenService.generateCode();

        // Convert this code to JWT.
        tokenService.generateToken(code);

        try {
            // send token to user email
            emailService.sendEmailWithCode(email, code);
        } catch (MessagingException e) {
            logger.error("email_wrong", e);
            return new ResponseEntity<>("Failed to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Verification code sent successfully", HttpStatus.OK);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String code = body.get("code");
        String newPassword = body.get("newPassword");

        boolean resetSuccessful = userService.resetPassword(email, code, newPassword);
        if (resetSuccessful) {
            logger.debug("Password reset successful for email: {}", email);
            return new ResponseEntity<>("Password reset successful.", HttpStatus.OK);
        } else {
            logger.debug("Password reset failed for email: {}", email);
            return new ResponseEntity<>("Password reset failed.", HttpStatus.BAD_REQUEST);
        }
    }
}
