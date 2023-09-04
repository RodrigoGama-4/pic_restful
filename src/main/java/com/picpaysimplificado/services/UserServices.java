package com.picpaysimplificado.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repositories.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository repository;

    public void validadeTransaction(User sender, BigDecimal amount) throws Exception{
        if (sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo lojista não está autorizado a fazer transações");

        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo Insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
