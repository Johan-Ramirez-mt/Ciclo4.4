package SartenMango_4.servicio;

import SartenMango_4.modelo.Cookware;
import SartenMango_4.repositorio.CookwareRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookwareService {
    @Autowired
    private CookwareRepositorio cookWareRepository;

    public List<Cookware> getAll() {
        return cookWareRepository.getAll();
    }

    public Optional<Cookware> getCook(String reference) {
        return cookWareRepository.getCook(reference);
    }

    public Cookware create(Cookware accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return cookWareRepository.create(accesory);
        }
    }

    public Cookware update(Cookware cook) {

        if (cook.getReference() != null) {
            Optional<Cookware> cookWareDb = cookWareRepository.getCook(cook.getReference());
            if (!cookWareDb.isEmpty()) {

                if (cook.getBrand()!= null) {
                    cookWareDb.get().setBrand(cook.getBrand());
                }
                 if (cook.getMateriales()!= null) {
                    cookWareDb.get().setMateriales(cook.getMateriales());
                }
                  if (cook.getDimensiones()!= null) {
                    cookWareDb.get().setDimensiones(cook.getDimensiones());
                }

                if (cook.getCategory() != null) {
                    cookWareDb.get().setCategory(cook.getCategory());
                }

                if (cook.getDescription() != null) {
                    cookWareDb.get().setDescription(cook.getDescription());
                }
                if (cook.getPrice() != 0.0) {
                    cookWareDb.get().setPrice(cook.getPrice());
                }
                if (cook.getQuantity() != 0) {
                    cookWareDb.get().setQuantity(cook.getQuantity());
                }
                if (cook.getPhotography() != null) {
                    cookWareDb.get().setPhotography(cook.getPhotography());
                }
                cookWareDb.get().setAvailability(cook.isAvailability());
                cookWareRepository.update(cookWareDb.get());
                return cookWareDb.get();
            } else {
                return cook;
            }
        } else {
            return cook;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCook(reference).map(cook -> {
            cookWareRepository.delete(cook);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
