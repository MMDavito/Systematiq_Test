package org.websparrow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.model.MyUser;

@RestController
public class UserController {

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping(value = "/register-user")
	@ResponseBody
	public ResponseEntity regiter(@RequestBody MyUser myUser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		String encodededPassword = passwordEncoder.encode(myUser.getPassword());
		User user = new User(myUser.getUserName(), encodededPassword, authorities);
		jdbcUserDetailsManager.createUser(user);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@GetMapping(value = "/is_authenticated")
	@ResponseBody
	public ResponseEntity authenticated() {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/")
	public HttpStatus welcome() {
		return HttpStatus.NO_CONTENT;
	}

	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity loginPost() {
		return new ResponseEntity(HttpStatus.OK);
	}

}
