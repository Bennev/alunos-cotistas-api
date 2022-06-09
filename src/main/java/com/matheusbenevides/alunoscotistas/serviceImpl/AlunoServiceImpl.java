/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheusbenevides.alunoscotistas.serviceImpl;

import com.matheusbenevides.alunoscotistas.entity.Aluno;
import com.matheusbenevides.alunoscotistas.entity.Campus;
import com.matheusbenevides.alunoscotistas.entity.Cota;
import com.matheusbenevides.alunoscotistas.entity.Curso;
import com.matheusbenevides.alunoscotistas.entity.SituacaoMatricula;
import com.matheusbenevides.alunoscotistas.entity.SituacaoPeriodo;
import com.matheusbenevides.alunoscotistas.enums.Nivel;
import com.matheusbenevides.alunoscotistas.enums.Sexo;
import com.matheusbenevides.alunoscotistas.repository.AlunoRepository;
import com.matheusbenevides.alunoscotistas.repository.CampusRepository;
import com.matheusbenevides.alunoscotistas.repository.CotaRepository;
import com.matheusbenevides.alunoscotistas.repository.CursoRepository;
import com.matheusbenevides.alunoscotistas.repository.SituacaoMatriculaRepository;
import com.matheusbenevides.alunoscotistas.repository.SituacaoPeriodoRepository;
import com.matheusbenevides.alunoscotistas.service.AlunoService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final CampusRepository campusRepository;
    private final CursoRepository cursoRepository;
    private final CotaRepository cotaRepository;
    private final SituacaoMatriculaRepository situacaoMatriculaRepository;
    private final SituacaoPeriodoRepository situacaoPeriodoRepository;

    @Override
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarAlunos(Aluno alunoFiltro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.EXACT);
        Example example = Example.of(alunoFiltro, matcher);
        return alunoRepository.findAll(example);
    }

    @Override
    public void importarDadosExcel(List<MultipartFile> multipartFiles) {
        if (!multipartFiles.isEmpty()) {
            List<Aluno> alunos = new ArrayList<>();
            multipartFiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    // looping through each row
                    int teste = getNumberOfNonEmptyCells(sheet, 0);
                    for (int rowIndex = 0; rowIndex < teste - 1; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }
                        Campus campus = campusRepository.findBySlug(String.valueOf(getValue(row.getCell(0))).replace(' ', '_'));
                        Nivel nivel = Nivel.valueOf(String.valueOf(getValue(row.getCell(1))).replace(' ', '_').toUpperCase());
                        Curso curso = cursoRepository.findByNome(String.valueOf(getValue(row.getCell(2))));
                        String periodoLetivo = String.valueOf(row.getCell(3));
                        Long matricula = Long.parseLong(row.getCell(4).toString());
                        String nome = String.valueOf(row.getCell(5));
                        Cota cota = cotaRepository.findByNome(String.valueOf(getValue(row.getCell(6))));
                        SituacaoMatricula situacaoMatricula = situacaoMatriculaRepository.findByNome(String.valueOf(getValue(row.getCell(7))));
                        SituacaoPeriodo situacaoPeriodo = situacaoPeriodoRepository.findByNome(String.valueOf(getValue(row.getCell(8))));
                        Date nascimento = row.getCell(9).getDateCellValue();
                        Sexo sexo = Sexo.valueOf(String.valueOf(getValue(row.getCell(10))));
                        String cpfString = row.getCell(11).toString().replace(".", "").replace("-", "").trim();
                        Long cpf = Long.parseLong("00000000000");
                        if (cpfString.length() > 0) {
                            cpf = Long.parseLong(row.getCell(11).toString().replace(".", "").replace("-", "").replace(" ", ""));
                        }
                        String telefones = String.valueOf(row.getCell(12));
                        String email = String.valueOf(row.getCell(13));
                        String emailInstitucional = String.valueOf(row.getCell(14));

                        Aluno aluno = new Aluno();
                        aluno.setCampus(campus);
                        aluno.setNivel(nivel);
                        aluno.setCurso(curso);
                        aluno.setPeriodoLetivo(periodoLetivo);
                        aluno.setMatricula(matricula);
                        aluno.setNome(nome);
                        aluno.setCota(cota);
                        aluno.setSituacaoMatricula(situacaoMatricula);
                        aluno.setSituacaoPeriodo(situacaoPeriodo);
                        aluno.setNascimento(nascimento);
                        aluno.setSexo(sexo);
                        aluno.setCpf(cpf);
                        aluno.setTelefones(telefones);
                        aluno.setEmail(email);
                        aluno.setEmailInstitucional(emailInstitucional);
                        alunos.add(aluno);
                        System.out.println(alunos.size() + "/" + teste);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("Begins saving");
            if (!alunos.isEmpty()) {
                // save to database
                alunoRepository.saveAll(alunos);
            }
            System.out.println("Done!");
        }
    }

    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(columnIndex);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    numOfNonEmptyCells++;
                }
            }
        }
        return numOfNonEmptyCells;
    }

    private Object getValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case ERROR:
                return cell.getErrorCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return null;
            case _NONE:
                return null;
            default:
                break;
        }
        return null;
    }
}
