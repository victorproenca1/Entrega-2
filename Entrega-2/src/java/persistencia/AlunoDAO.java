/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;

/**
 *
 * @author Victor
 */
public interface AlunoDAO {
    void salva (Aluno aluno);
    Aluno recupera (Long id);
    List<Aluno> buscaAluno (String nomealuno);
    List<Aluno> buscaTudo();
}
