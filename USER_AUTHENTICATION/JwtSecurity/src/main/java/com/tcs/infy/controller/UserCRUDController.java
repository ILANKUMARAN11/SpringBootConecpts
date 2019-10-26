package com.tcs.infy.controller;

import com.tcs.infy.entity.User;
import com.tcs.infy.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@CrossOrigin
@RequestMapping
public class UserCRUDController {


	@Autowired
    UserServiceImpl userService;



	@PostMapping(value = "/admin/add/user/radio.brio" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {

		return userService.saveUser(user);

	}

	@PostMapping(value = "/admin/edit/user/radio.brio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User editUser(@RequestBody User user) {

		return userService.updateUser(user);

	}

	@PostMapping(value = "/admin/remove/user/radio.brio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void removeUser(@RequestBody User user) {

		 userService.deleteUser(user);

	}


}
