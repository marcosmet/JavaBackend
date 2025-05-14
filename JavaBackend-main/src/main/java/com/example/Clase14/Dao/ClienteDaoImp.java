package com.example.Clase14.Dao;

import com.example.Clase14.Model.Cliente;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClienteDaoImp implements ClienteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> getClientes() {

        String query = "from Cliente";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        //Todo Auto-generated method stud
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }

    @Override
    public void registrar(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public boolean verificarCredenciales(Cliente cliente) {
        String query = "FROM Cliente WHERE mail= : mail";
        List<Cliente> lista = entityManager.createQuery(query).setParameter("mail", cliente.getMail()).getResultList();

        if (lista.isEmpty()) {
            return false;

        }

        String pass_hasheado = lista.get(0).getPasword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        boolean passIgual = argon2.verify(pass_hasheado, cliente.getPasword());


        return passIgual;


    }
}