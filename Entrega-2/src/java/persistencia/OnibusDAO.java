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
public interface OnibusDAO {
    void salva (Onibus onibus);
    Onibus recupera (Long id);
    List<Onibus> buscaOnibus (String placa);
    List<Onibus> buscaTudo();
}
