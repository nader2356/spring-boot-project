package com.school.pfe.Dto;


import com.school.pfe.Model.AppUser;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {

  @NotEmpty(message = "the firstname should not be empty")
  @NotBlank(message = "the firstname should not be empty")
  @Size(min = 3, max = 20, message = "the firstname must be between 3 and 20")
  private String firstname;

  @NotEmpty(message = "the lastname should not be empty")
  @NotBlank(message = "the lastname should not be empty")
  private String lastname;

  @NotEmpty
  @NotBlank
  @Email
  private String email;

  @NotEmpty
  @NotBlank
  private String password;

  public static AppUser toEntity(RegistrationRequest request) {
    return AppUser.builder()
            .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(request.getPassword())
        .build();
  }

}
