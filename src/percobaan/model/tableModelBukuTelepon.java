package percobaan.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fahmi
 */
public class tableModelBukuTelepon extends AbstractTableModel{
    List<Bukutelepon> lb;
    
    public tableModelBukuTelepon(List<Bukutelepon> lb){
        this.lb = lb;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    public int getRowCount(){
        return lb.size();
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Id";
            case 1:
                return "Nomor";
            case 2:
                return "Nama";
            case 3:
                return "Alamat";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column){
        switch (column){
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getNomor();
            case 2:
                return lb.get(row).getNama();
            case 3:
                return lb.get(row).getAlamat();
            default:
                return null;
        }
    }
}
