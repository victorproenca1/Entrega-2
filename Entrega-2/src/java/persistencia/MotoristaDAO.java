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
public interface MotoristaDAO {
    void salva (Motorista motorista);
    Motorista recupera (Long id);
    List<Motorista> buscaMotorista (String nomemotorista);
    List<Motorista> buscaTudo();
}
