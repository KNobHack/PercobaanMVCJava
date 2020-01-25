package percobaan.dao;

/**
 *
 * @author Fahmi
 */

import java.util.List;
import percobaan.model.*;

public interface ImplementBukuTelepon {
    public void insert(Bukutelepon b);
    public void update(Bukutelepon b);
    public void delete(int id);
    public List<Bukutelepon> getALL();
    public List<Bukutelepon> getCari(String cari);
}
