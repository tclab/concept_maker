/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innova.ConceptMaker.dao;

import com.innova.ConceptMaker.bo.ConceptoBO;
import com.innova.ConceptMaker.bo.TemaBO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class ConceptDAO {

    private Vector<TemaBO> temas;
    private Vector<ConceptoBO> conceptos;
    private String host;
    private String user;
    private String pss;

    public ConceptDAO(){
        host = "localhost";
        user = "root";
        pss = "jtorocan";
    }

    public Vector<ConceptoBO> getConceptos(String temaAconsultar) {

        conceptos = new Vector();
        ConceptoBO concepto = new ConceptoBO();
        String descripcion = new String();
        String definicion = new String();
        String tema = new String();

        Connection conexion = null;
        PreparedStatement temasGuardados;

        try {
            conexion = getConeccion();

            String sql = new String();

            if (temaAconsultar == null || temaAconsultar.equals("")) {
                sql = "SELECT * FROM CONCEPTOS";
                temasGuardados = conexion.prepareStatement(sql);
            }else{
                sql = "SELECT * FROM CONCEPTOS WHERE TEMA = ?";
                temasGuardados = conexion.prepareStatement(sql);
                temasGuardados.setString(1, temaAconsultar);
            }

            ResultSet resultado = temasGuardados.executeQuery();

            while (resultado.next()) {

                descripcion = resultado.getString("DESCRIPCION");
                definicion = resultado.getString("DEFINICION");
                tema = resultado.getString("TEMA");

                concepto.setConcepto(descripcion);
                concepto.setSignificado(definicion);
                concepto.setTema(tema);
                conceptos.add(concepto);
                concepto = new ConceptoBO();
            }
           
            resultado.close();
            temasGuardados.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if ((conexion != null) && (!conexion.isClosed())) {
                    conexion.close();
                }
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        }

        return conceptos;
    }

    public ConceptoBO getConcepto(String concept) {

        conceptos = new Vector();
        ConceptoBO concepto = new ConceptoBO();
        String descripcion = new String();
        String definicion = new String();
        String tema = new String();

        Connection conexion = null;

        try {
            conexion = getConeccion();

            String sql = "SELECT * FROM CONCEPTOS WHERE DESCRIPCION = ?";

            PreparedStatement temasGuardados = conexion.prepareStatement(sql);

            temasGuardados.setString(1, concept);


            ResultSet resultado = temasGuardados.executeQuery();

            if (resultado.next()) {

                descripcion = resultado.getString("DESCRIPCION");
                definicion = resultado.getString("DEFINICION");
                tema = resultado.getString("TEMA");
            }

            if (descripcion == null || descripcion.equals("")) {
                concepto.setConcepto("ne");
                concepto.setSignificado("ne");
                concepto.setTema("ne");

            } else {
                concepto.setConcepto(descripcion);
                concepto.setSignificado(definicion);
                concepto.setTema(tema);
            }

            resultado.close();
            temasGuardados.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if ((conexion != null) && (!conexion.isClosed())) {
                    conexion.close();
                }
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        }

        return concepto;

    }

    public boolean insertarConcepto(String concepto, String definicion, String tema) {
        boolean insersion = true;
        Connection conexion = null;

        try {
            conexion = getConeccion();

            String sql = "INSERT INTO CONCEPTOS (DESCRIPCION, DEFINICION, TEMA)" +
                    " VALUES (?,?,?)";

            PreparedStatement insertar = conexion.prepareStatement(sql);

            insertar.setString(1, concepto);
            insertar.setString(2, definicion);
            insertar.setString(3, tema);

            int resultado = insertar.executeUpdate();


            if (resultado == 1) {
                System.out.println("Se cre concepto satisfactoriamente\n");
            } else {
                System.out.println("Se produjo un error creando el concepto.\n");
                insersion = false;
            }

        } catch (Exception e) {
            insersion = false; 
            e.printStackTrace();
        } finally {
            try {
                if ((conexion != null) && (!conexion.isClosed())) {
                    conexion.close();
                }
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }

        }

        return insersion; 
    }

    public boolean modificarConcepto(ConceptoBO conNuevo, ConceptoBO conViejo) {
        
        Connection conexion = null;
        boolean resultado = true;

        try {
            conexion = getConeccion();

            String sql1 = "UPDATE CONCEPTOS SET DESCRIPCION = ? WHERE DESCRIPCION = ?";
            String sql2 = "UPDATE CONCEPTOS SET DEFINICION = ? WHERE DESCRIPCION = ?";
            String sql3 = "UPDATE CONCEPTOS SET TEMA = ? WHERE DESCRIPCION = ?";

            PreparedStatement concepto = conexion.prepareStatement(sql1);
            PreparedStatement definicion = conexion.prepareStatement(sql2);
            PreparedStatement tema = conexion.prepareStatement(sql3);

            concepto.setString(1, conNuevo.getConcepto());
            concepto.setString(2, conViejo.getConcepto());

            definicion.setString(1, conNuevo.getSignificado());
            definicion.setString(2, conNuevo.getConcepto());

            tema.setString(1, conNuevo.getTema());
            tema.setString(2, conNuevo.getConcepto());

            int concepRes = concepto.executeUpdate();
            int defRes = definicion.executeUpdate();
            int temaRes = tema.executeUpdate();


            if ((concepRes != 0) && (defRes != 0) && (temaRes != 0)) {
                System.out.println("Se modifico la definicion satisfactoriamente\n");
            } else {
                resultado = false;
                System.out.println("Se produjo un error modificando el concepto\n");
            }

        } catch (Exception e) {
            resultado = false;
            e.printStackTrace();
        } finally {
            try {
                if ((conexion != null) && (!conexion.isClosed())) {
                    conexion.close();
                }
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }

        }

        return resultado;
    }

    public boolean eliminarConcepto(ConceptoBO concepto) {

        Connection conexion = null;
        boolean resultado = true;

        try {
            conexion = getConeccion();

            String sql = "DELETE FROM CONCEPTOS WHERE DESCRIPCION = ?";

            PreparedStatement eliminar = conexion.prepareStatement(sql);

            eliminar.setString(1, concepto.getConcepto());

            int elimRes = eliminar.executeUpdate();


            if (elimRes != 0) {
                System.out.println("Se elimino el concepto satisfactoriamente\n");
            } else {
                resultado = false;
                System.out.println("Se produjo un error eliminando el concepto\n");
            }

        } catch (Exception e) {
            resultado = false;
            e.printStackTrace();
        } finally {
            try {
                if ((conexion != null) && (!conexion.isClosed())) {
                    conexion.close();
                }
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        }
        return resultado;

    }

    /**
     * Metodo que establece la coneccion con la base de datos
     * @return Coneccion con base de datos
     */
    public Connection getConeccion() {

        Connection c = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            c =DriverManager.getConnection("jdbc:mysql://"+host+"/ConceptCreator"
                    , user, pss);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "No se pudo establecer la conexion." +
                    "\nIntente de nuevo.", "Alerta", -1, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return c;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPss() {
        return pss;
    }

    public void setPss(String pss) {
        this.pss = pss;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
