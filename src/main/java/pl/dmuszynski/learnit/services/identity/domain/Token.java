package pl.dmuszynski.learnit.services.identity.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Entity
public final class Token extends AbstractEntity {
    @Column(unique = true, length = 40)
    private String value;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Token(String value, User user) {
        this.user = user;
        this.value = value;
    }
}
