package pl.dmuszynski.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pl.dmuszynski.account.domain.Authority;
import pl.dmuszynski.account.domain.AuthorityRepository;
import pl.dmuszynski.account.domain.User;
import pl.dmuszynski.account.domain.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class AccountServiceApplicationTest
{
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserTest() {
        final User user = new User.Builder(1, "dasd", "eqweq", "dasda")
                .addAuthority(authorityRepository
                    .findByAuthorityType(Authority.AuthorityType.USER)
                        .orElse(authorityRepository.save(new Authority())))
                .build();

        userRepository.save(user);
    }
}
