package pl.dmuszynski.identity.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;

@ToString(callSuper = true)
@Entity
public final class Authority extends AbstractEntity implements GrantedAuthority {
    public enum AuthorityType { USER, MODERATOR, ADMIN }

    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 15)
    private final AuthorityType authorityType;

    public Authority(AuthorityType authorityType) {
        this.authorityType = authorityType;
    }

    public Authority() {
        this.authorityType = AuthorityType.USER;
    }

    @Override
    public String getAuthority() {
        return authorityType.name();
    }
}
