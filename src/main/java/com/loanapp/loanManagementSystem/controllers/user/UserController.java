package com.loanapp.loanManagementSystem.controllers.user;

import com.loanapp.loanManagementSystem.dto.loan.LoginRequestDto;
import com.loanapp.loanManagementSystem.dto.loan.LoginResponseDto;
import com.loanapp.loanManagementSystem.dto.user.RegistrationResponseDto;
import com.loanapp.loanManagementSystem.dto.user.UserDto;
import com.loanapp.loanManagementSystem.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public  ResponseEntity<RegistrationResponseDto> register(@RequestBody UserDto dto) {
        RegistrationResponseDto response=userService.register(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {
        LoginResponseDto response = userService.login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/profile/{userId}")
    public UserDto addUserdetails(@PathVariable UUID userId, @RequestBody UserDto dto) {
        return userService.addUserDetails(userId, dto);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{userId}")
    public UserDto getUserDetailById(@PathVariable UUID userId){
        return userService.getUserById(userId);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @GetMapping("/{email}")
//    public  UserDto getUserByEmail(@RequestParam String email){
//        return userService.getByUserEmail(email);
//    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/{userId}")
    public UserDto updateUserdetail(@RequestBody @Valid UserDto dto, @PathVariable UUID userId){
        return userService.updateUser(dto,userId);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> softDeleting(@PathVariable UUID userId){
        userService.softDeleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public UserDto getUserByEmail(){

        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        return userService.getByUserEmail(email);
    }


}
