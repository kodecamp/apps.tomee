
package in.kodecamp.cms.api;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 */
@LoginConfig(authMethod = "MP-JWT")
@ApplicationPath("/api")
@DeclareRoles({"STUDENT", "TEACHER", "PRINCIPAL"})
public class CmsApplication extends Application {

}
