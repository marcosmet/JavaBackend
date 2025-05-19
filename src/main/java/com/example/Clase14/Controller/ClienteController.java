package com.example.Clase14.Controller;
import com.example.Clase14.Dao.ClienteDao;
import com.example.Clase14.Model.Cliente;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;

    @RequestMapping(value="api/clientes")
    public List<Cliente> getCliente(){

        List<Cliente> user=clienteDao.getClientes();

    return user;
    }

    @RequestMapping (value = "api/clientes/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {

        clienteDao.eliminar(id);
    }

    @RequestMapping(value="api/cliente", method = RequestMethod.POST)
    public void registrarCliente(@RequestBody Cliente cliente){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String pass_hasheado=argon2.hash(1,1024,1, cliente.getPassword());

        cliente.setPassword(pass_hasheado);

        clienteDao.registrar(cliente);
    }
}
