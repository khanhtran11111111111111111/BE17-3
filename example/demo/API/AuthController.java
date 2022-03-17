package com.example.demo.API;

import com.example.demo.Convert.UsersConvert;
import com.example.demo.DTO.ChangProfile;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Entity.RolesEntity;
import com.example.demo.Entity.User;
import com.example.demo.Repository.RolesRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.Service.RolesService;
import com.example.demo.Service.UsersService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.security.JwtTokenProvider;
import com.example.demopayload.JWTAuthResponse;

import springfox.documentation.service.ResponseMessage;

import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersService  usersService;
    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
	UsersConvert usersConvert;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody User loginDto){//hắn ko bắt đượccusername vô đ
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getusername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UsersDTO dto){

        // add check for username exists in a DB
        if(usersRepository.existsByUsername(dto.getusername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        // create user object
        dto.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
		User user = usersConvert.DtoToEntity(dto);
        RolesEntity roles = rolesRepository.findByName("ROLE_READER").get();
        user.setRoles(Collections.singleton(roles));
        user=usersService.saveUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
    @PutMapping("/changeprofile")
    public ResponseEntity<?> changeProfile(HttpServletRequest request,@RequestBody ChangProfile cf){
    	  String token = JwtAuthenticationFilter.getJWTfromRequest(request);
    	  String username=tokenProvider.getUsernameFromJWT(token);
    	  User user;
    	  try {
    		  if(usersRepository.existsByUsername(cf.getusername())) {
    			  
    			  return new ResponseEntity<>("Username", HttpStatus.OK);
    		  }
    		  user= usersRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("User", "Id", "id"));
    		  user.setFullname(cf.getFullname());
    		 usersService.saveUser(user);
    		 return new ResponseEntity<>("Yes", HttpStatus.OK);
    		  }catch (UsernameNotFoundException exception) {
    			  return new ResponseEntity<>("No", HttpStatus.NOT_FOUND);
    		  }
    }


}
