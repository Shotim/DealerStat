import com.company.entity.Role;
import com.company.entity.User;
import com.company.database.DataBaseServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        DataBaseServiceImpl service = new DataBaseServiceImpl();
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
        List<User> users =service.getUsers(DataBaseServiceImpl.SELECT_USER_WITH_ID+7);
        System.out.println(users);
    }
}
