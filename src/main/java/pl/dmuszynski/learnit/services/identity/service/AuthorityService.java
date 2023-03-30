package pl.dmuszynski.learnit.services.identity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.learnit.services.identity.domain.Authority;
import pl.dmuszynski.learnit.services.identity.repository.AuthorityRepository;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority findByAuthorityType(Authority.AuthorityType authorityType) {
        return authorityRepository.findByAuthorityType(authorityType)
                .orElse(new Authority(authorityType));
    }
}