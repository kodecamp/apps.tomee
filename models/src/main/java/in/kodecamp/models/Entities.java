package in.kodecamp.models;

import java.util.Collection;
import java.util.Collections;

public final class Entities<T> {

  private Collection<T> items;

  public Entities(Collection<T> entities) {
    items = entities;
  }

  // default constructor
  public Entities() {

  }

  public Collection<T> getItems() {
    return Collections.unmodifiableCollection(this.items);

  }

  public void setItems(final Collection<T> newItems) {
    this.items = newItems;
  }

}
