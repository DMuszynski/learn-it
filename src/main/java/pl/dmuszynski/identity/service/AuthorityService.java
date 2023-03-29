package pl.dmuszynski.identity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.identity.domain.Authority;
import pl.dmuszynski.identity.domain.AuthorityRepository;

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