package com.school.pfe.Service;


import com.school.pfe.Dto.AuthenticationRequest;
import com.school.pfe.Dto.AuthenticationResponse;
import com.school.pfe.Dto.RegistrationRequest;

public interface UserService {


  AuthenticationResponse register(RegistrationRequest request);

  AuthenticationResponse authenticate(AuthenticationRequest request);

}
