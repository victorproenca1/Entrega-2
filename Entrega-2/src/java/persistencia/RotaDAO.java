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
public interface RotaDAO {
    void salva (Rota rota);
    Rota recupera (Long id);
    List<Rota> buscaRota (String nomerota);
    List<Rota> buscaTudo();
}
