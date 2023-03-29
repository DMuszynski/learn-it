package pl.dmuszynski.identity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.identity.domain.User;
import pl.dmuszynski.identity.domain.UserRepository;

@Service
public class AccountService {
    private final UserRepository userRepository;

    @Autowired
    public AccountService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
