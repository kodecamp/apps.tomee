package in.kodecamp.cms.kodecamp;

import java.util.*;

/**
 * Paginator
 */
public class Paginator {

  private List<Object> totalItems;

  private int currentPage = 0;
  private int pageSize = 5;
  private List<Object> currentPageItems = new ArrayList<>();

  public Paginator(List<Object> items, int pageSize) {
    this.totalItems = items;
    this.pageSize = pageSize;
  }

  public List<Object> next() {
    currentPage += 1;
    return totalItems.subList(currentPage * pageSize, currentPage);
  }

  public List<Object> previous() {
    currentPage -= 1;
    return null;
  }

}
