package com.auth0.json.mgmt;

import com.auth0.json.JsonTest;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TenantTest extends JsonTest<Tenant> {

    private static final String json = "{\"change_password\":{},\"guardian_mfa_page\":{},\"default_audience\":\"https://domain.auth0.com/myapi\",\"default_directory\":\"Username-Password-Authentication\",\"error_page\":{},\"flags\":{},\"friendly_name\":\"My-Tenant\",\"picture_url\":\"https://pic.to/123\",\"support_email\":\"support@auth0.com\",\"support_url\":\"https://support.auth0.com\",\"allowed_logout_urls\":[\"https://domain.auth0.com/logout\"]}";

    @Test
    public void shouldSerialize() throws Exception {
        Tenant tenant = new Tenant();
        tenant.setChangePasswordPage(new PageCustomization());
        tenant.setGuardianMfaPage(new PageCustomization());
        tenant.setDefaultAudience("https://domain.auth0.com/myapi");
        tenant.setDefaultDirectory("Username-Password-Authentication");
        tenant.setErrorPage(new PageCustomization());
        tenant.setFlags(Collections.<String, Boolean>emptyMap());
        tenant.setFriendlyName("My-Tenant");
        tenant.setPictureUrl("https://pic.to/123");
        tenant.setSupportEmail("support@auth0.com");
        tenant.setSupportUrl("https://support.auth0.com");
        tenant.setAllowedLogoutUrls(Collections.singletonList("https://domain.auth0.com/logout"));

        String serialized = toJSON(tenant);
        assertThat(serialized, is(notNullValue()));
        assertThat(serialized, is(equalTo(json)));
    }

    @Test
    public void shouldDeserialize() throws Exception {
        Tenant tenant = fromJSON(json, Tenant.class);

        assertThat(tenant, is(notNullValue()));
        assertThat(tenant.getChangePasswordPage(), is(notNullValue()));
        assertThat(tenant.getGuardianMfaPage(), is(notNullValue()));
        assertThat(tenant.getDefaultAudience(), is("https://domain.auth0.com/myapi"));
        assertThat(tenant.getDefaultDirectory(), is("Username-Password-Authentication"));
        assertThat(tenant.getErrorPage(), is(notNullValue()));
        assertThat(tenant.getFlags(), is(notNullValue()));
        assertThat(tenant.getFriendlyName(), is("My-Tenant"));
        assertThat(tenant.getPictureUrl(), is("https://pic.to/123"));
        assertThat(tenant.getSupportEmail(), is("support@auth0.com"));
        assertThat(tenant.getSupportUrl(), is("https://support.auth0.com"));
        assertThat(tenant.getAllowedLogoutUrls(), contains("https://domain.auth0.com/logout"));
    }

}