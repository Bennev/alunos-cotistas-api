package com.mateusbenevides.alunoscotistas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mateusbenevides.alunoscotistas.enums.Campus;
import com.mateusbenevides.alunoscotistas.enums.Nivel;
import com.mateusbenevides.alunoscotistas.enums.Sexo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alunos", schema = "alunos_cotistas")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Campus campus;

    @Column
    private Nivel nivel;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    private Curso curso;

    @Column
    private String periodoLetivo;

    @Column
    private Long matricula;

    @Column
    private String nome;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_cota", referencedColumnName = "id")
    private Cota cota;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_situacao_matricula", referencedColumnName = "id")
    private SituacaoMatricula situacaoMatricula;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_situacao_periodo", referencedColumnName = "id")
    private SituacaoPeriodo situacaoPeriodo;

    @Column
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Column
    private Sexo sexo;

    @Column
    private Long cpf;

    @Column
    private String telefones;

    @Column
    private String email;

    @Column
    private String emailInstitucional;
}