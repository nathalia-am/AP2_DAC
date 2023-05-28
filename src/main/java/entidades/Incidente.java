package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Incidente {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "Nome_Vitima")
	private String nome;
	@Column(name = "Sexo")
	private String sexo;
	@Column(name = "Idade")
	private Integer idade;
	@Column(name = "Serie_Turno")
	private String serieTurno;
	@Column(name = "Endereco")
	private String endereco;

	@Column(name = "Nome_Agressor")
	private String nomeAgressor;
	@Column(name = "Sexo_Agressor")
	private String sexoAgressor;
	@Column(name = "Idade_Agressor")
	private Integer idadeAgressor;
	@Column(name = "Grau_Parentesco_Agressor")
	private String grauParentesco;
	@Column(name = "Ocupacao_Agressor")
	private String ocupacao;
	@Column(name = "Raca_Cor_Agressor")
	private String racaCorAgressor;
	@Column(name = "Genero_Agressor")
	private String identGeneroAgressor;
	@Column(name = "Orientacao_Agressor")
	private String orientSexAgressor;
	@Column(name = "Escolaridade_Agressor")
	private Integer escolaridade;

	@Column(name = "Incidente_Relatado")
	private String relatoIncidente;
	@Column(name = "Violacao_Direito")
	private String violacaoDireito;
	@Column(name = "Providencias")
	private String providencias;

	@Column(name = "Data_Registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Integer escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@PrePersist
	protected void onCreate() {
		data = new Date();
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNomeAgressor() {
		return nomeAgressor;
	}

	public void setNomeAgressor(String nomeAgressor) {
		this.nomeAgressor = nomeAgressor;
	}

	public String getSexoAgressor() {
		return sexoAgressor;
	}

	public void setSexoAgressor(String sexoAgressor) {
		this.sexoAgressor = sexoAgressor;
	}

	public Integer getIdadeAgressor() {
		return idadeAgressor;
	}

	public void setIdadeAgressor(Integer idadeAgressor) {
		this.idadeAgressor = idadeAgressor;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getRacaCorAgressor() {
		return racaCorAgressor;
	}

	public void setRacaCorAgressor(String racaCorAgressor) {
		this.racaCorAgressor = racaCorAgressor;
	}

	public String getIdentGeneroAgressor() {
		return identGeneroAgressor;
	}

	public void setIdentGeneroAgressor(String identGeneroAgressor) {
		this.identGeneroAgressor = identGeneroAgressor;
	}

	public String getOrientSexAgressor() {
		return orientSexAgressor;
	}

	public void setOrientSexAgressor(String orientSexAgressor) {
		this.orientSexAgressor = orientSexAgressor;
	}

	public String getRelatoIncidente() {
		return relatoIncidente;
	}

	public void setRelatoIncidente(String relatoIncidente) {
		this.relatoIncidente = relatoIncidente;
	}

	public String getViolacaoDireito() {
		return violacaoDireito;
	}

	public void setViolacaoDireito(String violacaoDireito) {
		this.violacaoDireito = violacaoDireito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOritentacaoSexual() {
		return sexo;
	}

	public void setOritentacaoSexual(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSerieTurno() {
		return serieTurno;
	}

	public void setSerieTurno(String serieTurno) {
		this.serieTurno = serieTurno;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getProvidencias() {
		return providencias;
	}

	public void setProvidencias(String providencias) {
		this.providencias = providencias;
	}
}
