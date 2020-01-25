package percobaan.model;

/**
 *
 * @author Fahmi
 */
public class Bukutelepon {
    private Integer id;
    private String nomor;
    private String nama;
    private String alamat;
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNomor(){
        return nomor;
    }
    
    public void setNomor(String nomor){
        this.nomor = nomor;
    }
}
