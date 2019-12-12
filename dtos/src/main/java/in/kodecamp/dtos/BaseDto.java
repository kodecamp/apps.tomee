package in.kodecamp.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * BaseDto
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public abstract class BaseDto implements Serializable {

  // protected default constructor

  @EqualsAndHashCode.Include
  protected long id;

  protected long version;

  protected boolean active;

  protected LocalDateTime createdOn;

  protected LocalDateTime modifiedOn;

  protected BaseDto(final long id) {
    this.id = id;
  }

}
