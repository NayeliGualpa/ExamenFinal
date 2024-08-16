package GNDataAccess.GNDTO;

public class GNHormigaDTO {
    private Integer idHormiga;
    private Integer idSexo;
    private Integer idProvincia;
    private Integer idAlimento;
    private String tipoHormiga;   
    private String estadoHormiga;   
    private String estado;   
    private String fechaCrea;   
    private String fechaModificacion;
    private Integer  id;
    private String   ubicacion;
    private String   sexo;
    private Integer  genoAlimentoId;
    private Integer  ingestaNativaId;


   
    public GNHormigaDTO(int idHormiga2, int idSexo2, int idProvincia2, int idGenoAlimento, int idIngestaNativa, String tipoHormiga2, String estado2, String fechaCrea2){ }

    public GNHormigaDTO (String tipoHormiga){
        this.tipoHormiga = tipoHormiga;
    }
   
    public GNHormigaDTO(Integer idHormiga, Integer idSexo, Integer idProvincia, Integer idAlimento, String tipoHormiga,
            String estadoHormiga, String estado, String fechaCrea, String fechaModificacion) {
        this.idHormiga = idHormiga;
        this.idSexo = idSexo;
        this.idProvincia = idProvincia;
        this.idAlimento = idAlimento;
        this.tipoHormiga = tipoHormiga;
        this.estadoHormiga = estadoHormiga;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModificacion = fechaModificacion;
    }

    public GNHormigaDTO(int id, String tipoHormiga, String ubicacion, String sexo, int genoAlimentoId, int ingestaNativaId, String estado) {
        this.id = id;
        this.tipoHormiga = tipoHormiga;
        this.ubicacion = ubicacion;
        this.sexo = sexo;
        this.genoAlimentoId = genoAlimentoId;
        this.ingestaNativaId = ingestaNativaId;
        this.estado = estado;
    }
    
     
    public Integer getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public String getEstadoHormiga() {
        return estadoHormiga;
    }

    public void setEstadoHormiga(String estadoHormiga) {
        this.estadoHormiga = estadoHormiga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getGenoAlimentoId() {
        return genoAlimentoId;
    }

    public void setGenoAlimentoId(Integer genoAlimentoId) {
        this.genoAlimentoId = genoAlimentoId;
    }

    public Integer getIngestaNativaId() {
        return ingestaNativaId;
    }

    public void setIngestaNativaId(Integer ingestaNativaId) {
        this.ingestaNativaId = ingestaNativaId;
    }
    @Override
    public String toString(){
        return getClass().getName()
        + "\n  IdHormiga: "         + getIdHormiga()
        + "\n  IdSexo: "            + getIdSexo()
        + "\n  IdProvincia: "       + getIdProvincia()
        + "\n  IdAlimento: "        + getIdAlimento()
        + "\n  TipoHormiga: "       + getTipoHormiga()
        + "\n  EstadoHormiga: "     + getEstadoHormiga()
        + "\n  Estado: "            + getEstado()
        + "\n  FechaCrea: "         + getFechaCrea()
        + "\n  FechaModificacion: " + getFechaModificacion();
    }

   
}



   
  
