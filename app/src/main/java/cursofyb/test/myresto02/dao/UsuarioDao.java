package cursofyb.test.myresto02.dao;

import cursofyb.test.myresto02.modelo.Usuario;

/**
 * Created by martdominguez on 17/08/17.
 */

public interface UsuarioDao {
    public void guardar(Usuario usr);
    public Usuario leer();
}
