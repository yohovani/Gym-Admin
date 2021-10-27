package com.yoho.gimnasios.services;

import com.yoho.gimnasios.models.Assist;
import com.yoho.gimnasios.models.Payment;
import com.yoho.gimnasios.models.User;
import com.yoho.gimnasios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

     @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser(){
         return userRepository.findAll();
    }

    public void addNewUser(User user){
         user.setAge();
        this.userRepository.save(user);
    }

    public User getUserById(Long id){
         Optional<User> user = this.userRepository.findById(id);
         if(user.isEmpty()){
             return new User();
         }
         return user.get();
    }

    public User getUserByName(String name){
         Optional<User> user = this.userRepository.findUserByName(name);
         if(user.isEmpty()){
            throw new IllegalStateException("Usuario No encontrado");
         }
         return user.get();
    }

    public User addUserAssist(Long id){
         User user = this.getUserById(id);
         user.getAsistencias().add(new Assist());
         this.userRepository.flush();
         return user;
    }

    public Collection<Assist> getAssistsByUser(Long id){
         return this.getUserById(id).getAsistencias();
    }

    public User addUserPayment(Payment payment, Long id){
         User user = this.getUserById(id);
         user.getPagos().add(payment);
         this.userRepository.flush();
         return user;
    }
}
