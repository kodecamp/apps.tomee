package in.kodecamp.cms.api.commons;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import in.kodecamp.models.BaseEntity;

/**
 * BaseResource
 */
public abstract class BaseResourceController<T extends Link> {

  protected Response created(Link resource) {
    String href = (String) resource.get("href");
    URI uri = URI.create(href);
    return Response.created(uri).entity(resource).build();
  }

  protected CollectionResource createCollectionResource(UriInfo uriInfo, final String link,
      final List<? extends BaseEntity> collection, boolean isExpanded) {

    if (collection == null || collection.size() == 0) {
      return new CollectionResource(uriInfo, link, Collections.emptyList());
    }

    Collection<Link> items = new ArrayList<>(collection.size());
    for (BaseEntity entity : collection) {
      if (isExpanded) {
        items.add(createResource(uriInfo, entity));
      } else {
        items.add(new Link(uriInfo, entity));
      }
    }
    return new CollectionResource(uriInfo, link, items);
  }

  protected abstract T createResource(UriInfo uriInfo, BaseEntity entity);

}
