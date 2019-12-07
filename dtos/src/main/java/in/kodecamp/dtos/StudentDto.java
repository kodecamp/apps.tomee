package in.kodecamp.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * StudentDto
 */
@Data
// no field of this class is marked for equals and hascode so the super class
// version will be called
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentDto extends BaseDto {

  private String name;

  private String address;

  public StudentDto() {
  }

  // this will be used by the api to create new students
  public StudentDto(final String name, final String address) {
    this.name = name;
    this.address = address;
  }

}
