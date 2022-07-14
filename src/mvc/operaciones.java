package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class operaciones {

    private conexion c = new conexion();
    private Connection con = c.getConexion();
    private PreparedStatement ppt;
    private ResultSet rs;
    private String user = "Administrador", pass = "utcgg_2018";
    private DefaultTableModel modelo;

    public boolean acceso(String usuario, String password) {
        if (usuario.equals(user) && password.equals(pass)) {
            return true;
        }
        return false;
    }

    public int id_carrera(String nom) {
        int id = 0;
        String sql = "select id from carreras where nombre = '" + nom + "' ";
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return id;
    }

    public boolean registrar_l(String datos[]) {
        //INSERT INTO `libros`(`id`, `Folio`, `titulo`, `autor`, `forma_de_adquisicion`, `editorial`, `isbn`, `fecha`, `status`, `carrera`)
        String sql = "insert into libros values(null,?,?,?,?,?,?,?,?,?)";
        int id = id_carrera(datos[8]);
        try {
            ppt = con.prepareCall(sql);
            ppt.setString(1, datos[0]);
            ppt.setString(2, datos[1]);
            ppt.setString(3, datos[2]);
            ppt.setString(4, datos[3]);
            ppt.setString(5, datos[4]);
            ppt.setString(6, datos[5]);
            ppt.setString(7, datos[6]);
            ppt.setString(8, datos[7]);
            ppt.setInt(9, id);

            int exe = ppt.executeUpdate();
            if (exe > 0) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<String> getCarreras() {
        ArrayList<String> lista = new ArrayList<String>();
        String sql = "SELECT nombre FROM `carreras` ORDER BY `carreras`.`nombre` ASC";
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return lista;
    }

    /**
     * Metodo encargado de verificar que el libro a registrar no exista en la
     * base de datos
     *
     * @param folio
     * @return
     */
    public String verificar(String folio) {
        String sql = "SELECT folio FROM libros WHERE folio = '" + folio + "'", verf = "";
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            if (rs.next() == true) {
                rs = ppt.executeQuery();
                while (rs.next()) {
                    verf = rs.getString(1);
                }
                if (verf.equals(folio)) {
                    return "Existente";
                }
            } else {
                return "Nuevo";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * metodo encargado de extraer los registros de los libros
     *
     * @return
     */
    public DefaultTableModel getRegistros() {
        //, "Adquisición", "ISBN", "Fecha",
        String sql = "SELECT li.Folio,li.titulo,li.autor, li.editorial, ca.nombre,li.status\n"
                + "FROM\n"
                + "    carreras AS ca\n"
                + "        INNER JOIN\n"
                + "    libros AS li ON li.id_carrera = ca.id\n"
                + "GROUP BY li.id;";
        String titulos[] = {"Folio", "Título", "Autor", "Editorial", "Carrera", "Status"};
        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[6];
        try {
            modelo.getDataVector().clear();
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }

    public DefaultTableModel librosAlumnos(int matricula) {
        //, "Adquisición", "ISBN", "Fecha",
        String sql = "SELECT li.Folio,li.titulo,li.autor,li.editorial,ca.nombre,li.status "
                + "FROM carreras AS ca INNER JOIN libros AS li ON li.id_carrera = ca.id INNER JOIN "
                + "visit_alumnos AS al ON ca.id = al.id_carrera AND al.id_matricula = " + matricula + " GROUP BY li.folio "
                + "ORDER BY li.titulo ASC,li.folio ASC , li.fecha ASC ;";
        //  String sql = "select l.Folio, l.titulo, l.autor, l.editorial,CA.nombre,l.status from libros AS l,carreras as CA WHERE l.id_carrera = CA.id ";
        String titulos[] = {"Folio", "Título", "Autor", "Editorial", "Carrera", "Status"};
        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[6];
        try {
            modelo.getDataVector().clear();
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }

    public int contador() {
        String sql = "SELECT count(folio) FROM libros";
        int total = 0;
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public String[] getDatos(String folio) {
        String sql = "SELECT li.titulo, li.autor, li.editorial,ca.nombre, li.forma_de_adquisicion,li.isbn FROM\n"
                + "    carreras AS ca\n"
                + "        LEFT JOIN\n"
                + "    libros AS li ON li.folio = '" + folio + "' WHERE\n"
                + "    li.id_carrera = ca.id\n"
                + "GROUP BY li.folio;";
        String datos[] = new String[6];
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public String[] getRegistros(String folio) {
        String sql = "SELECT \n"
                + "    li.Folio,\n"
                + "    ca.nombre,\n"
                + "    li.titulo,\n"
                + "    li.editorial,\n"
                + "    li.autor,\n"
                + "    li.forma_de_adquisicion,\n"
                + "    li.isbn,\n"
                + "    li.fecha,\n"
                + "    li.status\n"
                + "FROM\n"
                + "    carreras AS ca\n"
                + "        LEFT JOIN\n"
                + "    libros AS li ON li.folio = '" + folio + "' WHERE\n"
                + "    li.id_carrera = ca.id\n"
                + "GROUP BY li.folio;";
        String datos[] = new String[9];
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    public DefaultTableModel buscar(String busqueda, String tipo) {
        //, "Adquisición", "ISBN", "Fecha",
        String sql = "";
        if (busqueda.equals("Folio")) {
            sql = "select li.Folio, li.titulo, li.autor, li.editorial,ca.nombre,li.status from  carreras as ca left join libros as li on li.Id_carrera = ca.id where li.folio LIKE '%" + tipo + "%' group by li.folio";
        } else if (busqueda.equals("Titulo")) {
            sql = "select li.Folio, li.titulo, li.autor, li.editorial,ca.nombre,li.status from  carreras as ca left join libros as li on li.Id_carrera = ca.id where li.titulo LIKE '%" + tipo + "%' group by li.folio";
        } else if (busqueda.equals("Carrera")) {
            sql = "select li.Folio, li.titulo, li.autor, li.editorial,ca.nombre,li.status from  carreras as ca left join libros as li on li.Id_carrera = ca.id where ca.nombre LIKE '%" + tipo + "%' group by li.folio";
        }

        System.out.println(sql);
        String titulos[] = {"Folio", "Título", "Autor", "Editorial", "Carrera", "Status"};
        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[6];
        try {
            modelo.getDataVector().clear();
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }

    public DefaultTableModel buscarlumno(String tipo, int matricula) {
        String sql = "SELECT li.Folio,li.titulo,li.autor,li.editorial,ca.nombre,li.status "
                + "FROM carreras AS ca INNER JOIN libros AS li ON li.id_carrera = ca.id INNER JOIN "
                + "visit_alumnos AS al ON ca.id = al.id_carrera AND al.id_matricula = " + matricula + " and li.titulo like'%" + tipo + "%' GROUP BY li.folio "
                + "ORDER BY li.titulo ASC,li.folio ASC , li.fecha ASC ;";
        //  String sql = "select l.Folio, l.titulo, l.autor, l.editorial,CA.nombre,l.status from libros AS l,carreras as CA WHERE l.id_carrera = CA.id ";
        String titulos[] = {"Folio", "Título", "Autor", "Editorial", "Carrera", "Status"};
        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[6];
        try {
            modelo.getDataVector().clear();
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }

    public String registrAlumno(String datos[]) {
        String sql = "insert into visit_alumnos values (?,?,?,?,date(now()))";
        //INSERT INTO `visit_alumnos`(`id_matricula`, `Id_carrera`, `nombre`, `telefono`, `fecha`)
        int id = id_carrera(datos[1]);
        try {
            ppt = con.prepareCall(sql);
            ppt.setInt(1, Integer.parseInt(datos[0]));
            ppt.setInt(2, id);
            ppt.setString(3, datos[2]);
            ppt.setString(4, datos[3]);
            int g = ppt.executeUpdate();
            if (g > 0) {
                return "Correcto";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();

        }
        return "";
    }

    public String accesoAlumno(int matricula, String nombre) {
        String sql = "SELECT id_matricula,nombre from visit_alumnos where id_matricula =" + matricula + " and nombre = '" + nombre + "'";
        String nom = "";
        int matri = 0;
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                matri = rs.getInt(1);
                nom = rs.getString(2);
            }
            System.out.println(nom + "" + matricula);
            if (nom.equalsIgnoreCase(nombre) && matri == matricula) {
                return "Correcto";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Mal";
    }

    public String updateLibro(String datos[]) {
        //INSERT INTO `libros`(`id`, `Folio`, `titulo`, `autor`, `forma_de_adquisicion`, `editorial`, `isbn`, `fecha`, `status`, `carrera`)
        String sql = "update libros set Folio = ?,Id_carrera=?,titulo = ?,editorial = ?,autor = ?, forma_de_adquisicion = ?,isbn = ? where folio = ?";
        int id = id_carrera(datos[1]);
        try {
            ppt = con.prepareCall(sql);
            ppt.setString(1, datos[0]);
            ppt.setInt(2, id);
            ppt.setString(3, datos[2]);
            ppt.setString(4, datos[3]);
            ppt.setString(5, datos[4]);
            ppt.setString(6, datos[5]);
            ppt.setString(7, datos[6]);
            ppt.setString(8, datos[7]);
            System.out.println(ppt);
            int exe = ppt.executeUpdate();
            if (exe > 0) {
                return "Correcto";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return e.getMessage();
        }
        return "Mal";
    }

    public DefaultTableModel getAlumnos(int tipo, String nombre) {
        String sql = "";
        switch (tipo) {
            case 0:
                sql = "SELECT al.id_matricula,al.nombre,ca.nombre AS carrera,al.telefono,al.fecha FROM visit_alumnos AS al \n"
                        + "INNER JOIN  carreras AS ca ON ca.id = al.Id_carrera GROUP BY id_matricula ORDER BY al.nombre ASC;";
                break;
            case 1:
                sql = "SELECT al.id_matricula,al.nombre,ca.nombre AS carrera,al.telefono,al.fecha FROM visit_alumnos AS al \n"
                        + "INNER JOIN  carreras AS ca ON ca.id = al.Id_carrera AND al.nombre LIKE '%" + nombre + "%' GROUP BY id_matricula\n"
                        + "ORDER BY al.nombre ASC;";
                break;
            case 2:
                sql = "SELECT al.id_matricula,al.nombre,ca.nombre AS carrera,al.telefono,al.fecha FROM visit_alumnos AS al \n"
                        + "INNER JOIN  carreras AS ca ON ca.id = al.Id_carrera AND ca.nombre = '" + nombre + "' GROUP BY id_matricula\n"
                        + "ORDER BY al.nombre ASC;";
                break;
            default:
                break;
        }
        //  String sql = "select l.Folio, l.titulo, l.autor, l.editorial,CA.nombre,l.status from libros AS l,carreras as CA WHERE l.id_carrera = CA.id ";
        String titulos[] = {"Matrícula", "Nombre completo", "Nombre de la carrera", "Teléfono", "Fecha de registro"};
        modelo = new DefaultTableModel(null, titulos);
        String fila[] = new String[5];
        try {
            modelo.getDataVector().clear();
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelo;
    }

    public String[] getAlumno(int matricula) {
        String sql = "SELECT  al.id_matricula,  al.nombre, ca.nombre AS carrera,  al.telefono FROM  visit_alumnos AS al  INNER JOIN "
                + "carreras AS ca ON ca.id = al.Id_carrera  where al.id_matricula =  '" + matricula + "'GROUP BY id_matricula\n"
                + "ORDER BY al.nombre ASC";
        String datos[] = new String[4];
        try {
            ppt = con.prepareCall(sql);
            rs = ppt.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public boolean updateAlumno(String datos[]) {
        String sql = "update visit_alumnos set id_matricula = ?,id_carrera = ?,nombre = ?,telefono = ? where id_matricula = ?";
        int id = id_carrera(datos[1]);
        try {
            ppt = con.prepareCall(sql);
            ppt.setInt(1, Integer.parseInt(datos[0]));
            ppt.setInt(2, id);
            ppt.setString(3, datos[2]);
            ppt.setString(4, datos[3]);
            ppt.setInt(5, Integer.parseInt(datos[4]));
            int a = ppt.executeUpdate();
            if (a > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean deleteAlumno(int matricula) {
        String sql = "delete from visit_alumnos where id_matricula = ?";
        try {
            ppt = con.prepareCall(sql);
            ppt.setInt(1, matricula);
            int p = ppt.executeUpdate();
            if (p > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
