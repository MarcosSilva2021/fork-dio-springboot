package dio.aula;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        // inserindo um usuário ao sistema
        List<User> users = repository.findByNameContaining("NovoUsuario");
        for(User u: users){
            System.out.println(u);
        }
    }
    private void insertUser(){
        User user = new User();
        user.setName("User user2");
        user.setUsername("NovoUsuario");
        user.setPassword("123456");
        repository.save(user);

        for(User u: repository.findAll()){
            System.out.println(u);
        }
    }
}
