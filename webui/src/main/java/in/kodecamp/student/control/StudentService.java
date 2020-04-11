package in.kodecamp.student.control;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import in.kodecamp.student.entity.Student;
import in.kodecamp.student.entity.StudentRestClient;

@Stateless
public class StudentService {

  @Inject
  private StudentRestClient studentClient;

  public List<Student> listAll(final String accessToken) {
    final HashMap<String, Object> responseMap = studentClient.students("Bearer " + accessToken, true, 2, 12);
    System.out.println("******************* Response : Start  ********************");
    responseMap.forEach((key, value) -> {
      System.out.println("key : " + key + " value : " + value.getClass());
    });
    List<HashMap<String, String>> listOfMap = (List<HashMap<String, String>>) responseMap.getOrDefault("items",
        Collections.emptyList());

    List<Student> students = listOfMap.stream().map(studentMap -> {
      return mapToObject(studentMap);
    }).collect(Collectors.toList());

    System.out.println("******************* Response : End ***********************");
    return students;
  }

  public Student mapToObject(HashMap<String, String> map) {
    return new Student(map.get("href"), map.get("name"), map.get("address"), map.get("createdOn"),
        map.get("modifiedOn"));
  }

  public HashMap<String, Object> objectToMap(Student student) {
    return null;
  }

}
