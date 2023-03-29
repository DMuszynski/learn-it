package pl.dmuszynski.identity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pl.dmuszynski.identity.domain.Authority;
import pl.dmuszynski.identity.domain.User;
import pl.dmuszynski.identity.domain.UserRepository;
import pl.dmuszynski.identity.service.AuthorityService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class AccountServiceApplicationTest
{
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserTest() {
        final User user = new User.Builder(1, "dasd", "eqweq", "dasda")
                .addAuthority(authorityService.findByAuthorityType(Authority.AuthorityType.USER))
                .build();

        userRepository.save(user);
    }
}
