package in.kodecamp.cms.api.security;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The name binding annotation to be used by the JAX-RS resources as well as the container request filter.
 * Only annotated methods and types will be processed by the filter.
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface JwtAuthz {
}
