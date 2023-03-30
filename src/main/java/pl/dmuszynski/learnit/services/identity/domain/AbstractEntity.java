package pl.dmuszynski.learnit.services.identity.domain;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.AccessLevel;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected abstract static class Builder {
        protected final long id;

        protected Builder(long id) { this.id = id; }

        protected abstract AbstractEntity build();
    }

    protected AbstractEntity() { this.id = 0L; }
}
