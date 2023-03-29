package pl.dmuszynski.learnit.services.identity.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Optional<Authority> findByAuthorityType(Authority.AuthorityType authorityType);
}