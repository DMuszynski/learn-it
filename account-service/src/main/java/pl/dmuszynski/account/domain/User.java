package pl.dmuszynski.account.domain;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public final class User extends AbstractEntity implements UserDetails {
    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false)
    private boolean isLocked;

    @Column(nullable = false)
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "USER_AUTHORITY",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities;

    public static class Builder extends AbstractEntity.Builder {
        private final String username;
        private final String password;
        private final String email;

        private boolean isLocked = true;
        private boolean isEnabled = false;
        private Set<Authority> authorities = new HashSet<>();

        public Builder(long id, String username, String password, String email) {
            super(id);
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public Builder addAuthority(Authority authority) {
            this.authorities.add(Objects.requireNonNull(authority));
            return this;
        }

        public Builder isLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }

        public Builder isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }

        @Override public User build() {
            if (email.isEmpty())
                throw new IllegalStateException("Email cannot be empty");
            if (username.isEmpty())
                throw new IllegalStateException("Username cannot be empty");
            if (password.isEmpty())
                throw new IllegalStateException("Password cannot be empty");

            final User user = new User();
            user.id = id;
            user.email = email;
            user.username = username;
            user.password = password;
            user.authorities = Set.copyOf(authorities);
            user.isEnabled = isEnabled;
            user.isLocked = isLocked;

            return user;
        }
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override public boolean isAccountNonExpired() {
        return false;
    }

    @Override public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override public boolean isCredentialsNonExpired() {
        return false;
    }
}
