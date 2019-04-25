package com.bootPr.springBootRestfulServices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootPr.springBootRestfulServices.beans.User;
import com.bootPr.springBootRestfulServices.beans.UserNotFoundException;
import com.bootPr.springBootRestfulServices.service.UserService;
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(path="/users/findAll")
	public List<User> findAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource findAllUsers(@PathVariable Long id) {
		User user = userService.findOne(id);
		if(null == user)
			throw new UserNotFoundException("Not available with id " + id) ;
		
		Resource<User> resource = new Resource<>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@PostMapping("/users/")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){

        User savedUser = userService.save(user); /// this is service method

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                      .path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
