import com.company.modules.Role;
import com.company.modules.User;
import com.company.services.DataBaseService;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        DataBaseService service = new DataBaseService();
        java.util.Date now = new java.util.Date();
        java.sql.Date date = new java.sql.Date(now.getTime());
        User user = new User();
        user.setId(6);
        user.setRole(Role.DEALER);
        user.setCreatedAt(date);
        user.setEmail("sfrr@gmail.com");
        user.setFirstName("Tim");
        user.setLastName("Sho");
        user.setPassword("12345");
        service.addUser(user);
        List<User> users=service.getUsers(DataBaseService.SELECT_USER_WITH_ID+7);
        System.out.println(users);
    }
}
