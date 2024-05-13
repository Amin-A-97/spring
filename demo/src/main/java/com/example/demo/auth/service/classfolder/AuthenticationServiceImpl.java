package com.example.demo.auth.service.classfolder;

import com.example.demo.auth.dto.LoginBody;
import com.example.demo.auth.dto.RegisterBody;
import com.example.demo.auth.dto.Res;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.user.Users;
import com.example.demo.user.Rolle;
import com.example.demo.auth.repo.AuthRepository;
import com.example.demo.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTImp jwtService;
    private final UserServiceImpl userService;

    private void validation(LoginBody loginBody){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginBody.getUName(),loginBody.getPWord())
            );
        }catch (Exception e){
            if(e.getMessage().equals("Bad credentials")){
                throw new ResourceNotFoundException(e.getMessage());
            }
        }
    }
    public Res signup(RegisterBody registerBody){
        Res res = new Res();
        Users users = new Users();
        users.setEmail(registerBody.getEmail());
        users.setUsername(registerBody.getUName());
        users.setPWord(passwordEncoder.encode(registerBody.getPWord()));
        users.setRolle(Rolle.USER);
        try {
           authRepository.save(users);
           String token = jwtService.generateToken(registerBody.getUName());
           res.setToken(token);
           res.setMessage("Welcome");
           return res;
        }
        catch (Exception e){
            res.setMessage(e.getMessage());
            return res;
        }
    }
    @Override
    public Res signin(LoginBody loginBody) {
        String token;
        Res res = new Res();
        UserDetails userDetails = authRepository.findByUsername(loginBody.getUName());
        if(userDetails != null){
            validation(loginBody);
            token = jwtService.generateToken(userDetails.getUsername());
            res.setMessage(String.format("Welcome %s",userDetails.getUsername()));
            res.setToken(token);
            return res;
        }
        res.setMessage(String.format("Sorry! Try Again %s",userDetails.getUsername()));
        res.setToken("Oops");
        return res;
    }
    @Override
    public String chnagePassword() {
        return null;
    }
    @Override
    public String recoveryPassword() {
        return null;
    }
}
