package in.kodecamp.cms.api.commons;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ResourceHelper
 */
public interface ResourceHelper<E, T> {
  public T fromEntity(E entity);

  public default List<T> fromEntities(Collection<E> entities) {
    return entities.stream().map(this::fromEntity).collect(Collectors.toList());
  }

}
