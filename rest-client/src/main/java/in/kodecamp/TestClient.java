package in.kodecamp;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import in.kodecamp.models.StudentEntity;

public class TestClient {

  private static final String STUDENT_REST_URI = "http://localhost:8080/api/students";

  private static WebTarget resource = null;

  // configuring jakson provided for json serialization and deserialization
  static {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    JacksonJsonProvider provider = new JacksonJsonProvider(mapper);

    Client client = ClientBuilder
        .newClient(new ClientConfig().register(provider));
    resource = client.target(STUDENT_REST_URI);
  }

  public static void main(String[] args) {
    List<StudentEntity> students = getAll();
    students.forEach(System.out::println);
    StudentEntity student = getById(4);
    System.out.println("Student with id : 3 : " + student);

    String msg = deleteById(4);
    System.out.println("Student of id 3 detelion : " + msg);

  }

  @SuppressWarnings("unchecked")
  private static List<StudentEntity> getAll() {
    List<StudentEntity> resultList = resource
        .request(MediaType.APPLICATION_JSON)
        .get(new GenericType<List<StudentEntity>>() {
        });
    return resultList;
  }

  private static StudentEntity getById(final int id) {
    StudentEntity student = resource.path(String.valueOf(id))
        .request(MediaType.APPLICATION_JSON)
        .get(StudentEntity.class);
    return student;
  }

  private static String deleteById(final int id) {
    Response response = resource.path(String.valueOf(id))
        .request(MediaType.APPLICATION_JSON)
        .delete();
    String msg = response.getStatus() == Response.Status.OK.getStatusCode()
        ? "Record Deleted Successfully"
        : "Error occurred";
    return msg;

  }

  private static StudentEntity update(final StudentEntity entity) {
    return null;
  }

}
