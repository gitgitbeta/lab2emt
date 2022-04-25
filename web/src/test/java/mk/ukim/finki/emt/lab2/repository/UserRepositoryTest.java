//package mk.ukim.finki.emt.lab2.repository;
//
//import mk.ukim.finki.emt.lab2.model.exceptions.UserNotFoundException;
//import mk.ukim.finki.emt.lab2.model.projections.AuthorProjection;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testFindAll()
//    {
//        List<User> userList = this.userRepository.findAll();
//        Assert.assertEquals(2L,userList.size());
//    }
//    @Test
//    public void testFetchAll()
//    {
//        List<User> userList = this.userRepository.fetchAll();
//        Assert.assertEquals(2L,userList.size());
//    }
//    @Test
//    public void testLoadAll()
//    {
//        List<User> userList = this.userRepository.loadAll();
//        Assert.assertEquals(2L,userList.size());
//    }
//
//    @Test
//    public void testProjectUsernameAndNameAndSurname()
//    {
//        AuthorProjection userProjection= this.userRepository.findByRole(Role.ROLE_ADMIN);
//        Assert.assertEquals("admin",userProjection.getUsername());
//        Assert.assertEquals("admin",userProjection.getName());
//        Assert.assertEquals("admin",userProjection.getSurname());
//    }
//
//    @Test
//    public void testOptimistiocLock()
//    {
//        User user1 = this.userRepository.findByUsername("admin").
//                orElseThrow(()-> new UserNotFoundException("admin"));
//        User user2 = this.userRepository.findByUsername("admin").
//                orElseThrow(()-> new UserNotFoundException("admin"));
//
//        user1.setName("user1");
//        user2.setName("user2");
//
//        this.userRepository.save(user1);
//        this.userRepository.save(user2);
//    }
//}
