package org.websparrow.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.repository.UserRepository;
import org.websparrow.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * Possibly it actually should not do hashing in controller-scope since hashing is buisness-logic.
	 * Should probably have used "dto".
	 * @param myUser
	 * @return Http-status 201 if created, probably 500-something if duplicate, null or disconnected from database.
	 */
	@PostMapping(value = "/register-user")
	@ResponseBody
	public ResponseEntity regiter(@RequestBody UserService myUser) {
		myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));

		userRepository.save(myUser);
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
