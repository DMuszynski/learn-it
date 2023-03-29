package pl.dmuszynski.learnit.services.identity.domain;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
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
