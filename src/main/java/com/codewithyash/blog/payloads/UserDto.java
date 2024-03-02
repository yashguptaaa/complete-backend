package com.codewithyash.blog.payloads;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
    private int id;
    
    @NotEmpty
    @Size(min=4,message="UserName must be greater then or equla to 4")
	private String name;
    
    @Email(message="Please enter valid Email address")
	private String email;
    
    @NotEmpty
    @Size(min=8, max=10, message="Password must be greater than or equal to 8")
	private String password;
    
    @NotEmpty
	private String about;
}
