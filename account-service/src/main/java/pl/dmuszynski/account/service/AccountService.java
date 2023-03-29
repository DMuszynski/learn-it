package pl.dmuszynski.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.account.domain.User;
import pl.dmuszynski.account.domain.UserRepository;

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
