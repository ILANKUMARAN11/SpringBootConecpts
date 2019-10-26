package com.tcs.infy.service;

import com.tcs.infy.entity.User;
import com.tcs.infy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository usersRepository;

    @Transactional
    public User saveUser(User user)
    {
        return usersRepository.save(user);
    }


    @Transactional
    public User updateUser(User user)
    {
        User foundUser=usersRepository.findById(user.getId());
        foundUser.setEmpId(user.getEmpId());
        foundUser.setEmail(user.getEmail());
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setActive(user.getActive());
        foundUser.setRoles(user.getRoles());
        foundUser.setPermissions(user.getPermissions());
        return usersRepository.save(foundUser);
    }

    @Transactional
    public void deleteUser(User user)
    {
         usersRepository.delete(user);
    }
}
