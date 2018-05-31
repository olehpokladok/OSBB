package com.oleh.domain;

import javax.validation.constraints.NotEmpty;

import com.oleh.validator.CheckIfEmailExists;
import com.oleh.validator.CheckPasswordMatch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@CheckPasswordMatch //(message = "")
public class AddUserRequest {
	
	@NotEmpty private String login;
	@NotEmpty @CheckIfEmailExists private String email;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirmation;

}
