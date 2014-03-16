package org.springframework.security.acls;

import java.util.UUID;

/**
 * Dummy domain object class with a {@link UUID} for the Id.
 *
 * @author Luke Taylor
 */
public final class TargetObjectWithUUID {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
