package in.kodecamp.student.entity;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Value;

/**
 * Student
 */
@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student implements Comparable<Student> {

  @Include
  private String link;
  private String name;
  private String address;
  private String createdOn;
  private String modifiedOn;

  @Override
  public int compareTo(Student student) {
    return this.link.compareTo(student.getLink());
  }


}
