package percobaan.controller;

import java.util.List;
import javax.swing.JOptionPane;
import percobaan.dao.DaoBukuTelepon;
import percobaan.dao.ImplementBukuTelepon;
import percobaan.model.Bukutelepon;
import percobaan.model.tableModelBukuTelepon;
import percobaan.view.FrameTelepon;

/**
 *
 * @author Fahmi
 */
public class ControllerBukuTelepon {
    FrameTelepon frame;
    ImplementBukuTelepon implbukutelepon;
    List<Bukutelepon> lb;
    
    public ControllerBukuTelepon(FrameTelepon frame){
        this.frame = frame;
        implbukutelepon = new DaoBukuTelepon();
        lb = implbukutelepon.getALL();
    }
    
    public void reset(){
        frame.getTextId().setText("");
        frame.getTextNama().setText("");
        frame.getTextNoTelp().setText("");
        frame.getTextAlamat().setText("");
    }
    
    public void isiTabel(){
        lb = implbukutelepon.getALL();
        tableModelBukuTelepon tmb = new tableModelBukuTelepon(lb);
        frame.getTableData().setModel(tmb);
    }
    
    public void isiField(int row){
        frame.getTextId().setText(lb.get(row).getId().toString());
        frame.getTextNoTelp().setText(lb.get(row).getNomor());
        frame.getTextNama().setText(lb.get(row).getNama());
        frame.getTextAlamat().setText(lb.get(row).getAlamat());
    }
    
    public void insert(){
        Bukutelepon b = new Bukutelepon();
        b.setNomor(frame.getTextNoTelp().getText());
        b.setNama(frame.getTextNama().getText());
        b.setAlamat(frame.getTextAlamat().getText());
        implbukutelepon.insert(b);
    }
    
    public void update(){
        Bukutelepon b = new Bukutelepon();
        b.setNomor(frame.getTextNoTelp().getText());
        b.setNama(frame.getTextNama().getText());
        b.setAlamat(frame.getTextAlamat().getText());
        b.setId(Integer.parseInt(frame.getTextId().getText()));
        implbukutelepon.update(b);
    }
    
    public void delete(){
        if(!frame.getTextId().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame.getTextId().getText());
            implbukutelepon.delete(id);
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }
    
    public void isiTabelCari(){
        lb = implbukutelepon.getCari(frame.getTextCari().getText());
        tableModelBukuTelepon tmb = new tableModelBukuTelepon(lb);
        frame.getTableData().setModel(tmb);
    }
    
    public void cari(){
        if(!frame.getTextCari().getText().trim().isEmpty()){
            implbukutelepon.getCari(frame.getTextCari().getText());
            isiTabelCari();
        } else {
            JOptionPane.showMessageDialog(frame, "Isi form cari terlebih dahulu");
        }
    }
}
