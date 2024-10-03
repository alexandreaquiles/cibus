package br.com.cibus.tipodecozinha;

import jakarta.persistence.*;

@Entity
public class TipoDeCozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Deprecated
    protected TipoDeCozinha() {
    }

    public TipoDeCozinha(String nome) {
        this.nome = nome;
    }

    public TipoDeCozinha(Long id, String nome) {
        this(nome);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TipoDeCozinha{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
