package pl.dmuszynski.learnit.services.identity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dmuszynski.learnit.services.identity.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
