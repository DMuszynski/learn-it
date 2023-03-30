package pl.dmuszynski.learnit.services.identity.repository;

import pl.dmuszynski.learnit.services.identity.domain.Authority;
import pl.dmuszynski.learnit.services.identity.domain.Authority.AuthorityType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Optional<Authority> findByAuthorityType(AuthorityType authorityType);
}
