package SartenMango_4.repositorio;


import SartenMango_4.modelo.Cookware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import SartenMango_4.interfaces.InterfaceCookware;

@Repository
public class CookwareRepositorio {
    @Autowired
    private InterfaceCookware cookWarerepository;

    public List<Cookware> getAll() {
        return cookWarerepository.findAll();
    }

    public Optional<Cookware> getCook(String reference) {
        return cookWarerepository.findById(reference);
    }

    public Cookware create(Cookware cook) {
        return cookWarerepository.save(cook);
    }

    public void update(Cookware cook) {
        cookWarerepository.save(cook);
    }

    public void delete(Cookware cook) {
        cookWarerepository.delete(cook);
    }
}
