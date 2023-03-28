package pl.dmuszynski.accountservice.domain;

import jakarta.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public final class User extends AbstractEntity implements UserDetails {
    private String username;
    private String password;
    private String email;

    public static class Builder extends AbstractEntity.Builder {
        private final String username;
        private final String password;
        private final String email;

        public Builder(long id, String username, String password, String email) {
            super(id);
            this.username = username;
            this.password = password;
            this.email = email;
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
            user.username = username;
            user.password = password;
            user.email = email;

            return user;
        }
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override public boolean isAccountNonExpired() {
        return false;
    }

    @Override public boolean isAccountNonLocked() {
        return false;
    }

    @Override public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override public boolean isEnabled() {
        return false;
    }
}
