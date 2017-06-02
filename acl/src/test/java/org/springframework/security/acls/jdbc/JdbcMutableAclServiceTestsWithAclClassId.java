package org.springframework.security.acls.jdbc;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.springframework.security.acls.TargetObjectWithUUID;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests the ACL system using ACL class id type of UUID and using an in-memory database.
 * @author Paul Wheeler
 */
@ContextConfiguration(locations = { "/jdbcMutableAclServiceTestsWithAclClass-context.xml" })
public class JdbcMutableAclServiceTestsWithAclClassId extends JdbcMutableAclServiceTests {

    private static final String TARGET_CLASS_WITH_UUID = TargetObjectWithUUID.class.getName();

    @Override
    protected String getSqlClassPathResource() {
        return "createAclSchemaWithAclClassIdType.sql";
    }

    @Test
    @Transactional
    public void identityWithUuidIdIsSupportedByCreateAcl() throws Exception {
        SecurityContextHolder.getContext().setAuthentication(getAuth());

        UUID id = UUID.randomUUID();
        ObjectIdentity oid = new ObjectIdentityImpl(TARGET_CLASS_WITH_UUID, id);
        getJdbcMutableAclService().createAcl(oid);

        assertNotNull(getJdbcMutableAclService().readAclById(new ObjectIdentityImpl(
            TARGET_CLASS_WITH_UUID, id)));
    }
}
