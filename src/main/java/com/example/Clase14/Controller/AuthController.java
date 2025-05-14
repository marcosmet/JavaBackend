package com.example.Clase14.Controller;

import com.example.Clase14.Dao.ClienteDao;
import com.example.Clase14.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private ClienteDao clienteDao;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Cliente cliente){

        if (clienteDao.verificarCredenciales(cliente)){
            return "OK";
        }

        return "FAIL";
    }

}
