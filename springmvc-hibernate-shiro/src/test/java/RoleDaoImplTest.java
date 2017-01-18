

import ru.ntdev.user.dao.RoleDaoImpl;

import static org.junit.Assert.*;

/**
 * Created by atursunov on 18.01.17.
 */
public class RoleDaoImplTest {
    @org.junit.Test
    public boolean listRoles() throws Exception {
        RoleDaoImpl roleDao = new RoleDaoImpl();
        roleDao.listRoles();
        return true;
    }

    @org.junit.Test
    public void getRoleById() throws Exception {

    }

    @org.junit.Test
    public void addRole() throws Exception {

    }

    @org.junit.Test
    public void removeRole() throws Exception {

    }

    @org.junit.Test
    public void updateRole() throws Exception {

    }

}