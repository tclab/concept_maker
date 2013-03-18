/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.innova.ConceptMaker.dao;

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
public class TemaDAO {

    private Vector<TemaBO> temas;
    private String host;
    private String user;
    private String pss;

    public TemaDAO(){
        host = "localhost";
        user = "root";
        pss = "jtorocan";
    }

    public Vector getTemas() {
        temas = new Vector();
        TemaBO tema = new TemaBO();

        Connection conexion = null;

        try {
            conexion = getConeccion();

            String sql = "SELECT * FROM TEMAS";

            PreparedStatement temasGuardados = conexion.prepareStatement(sql);

            ResultSet resultado = temasGuardados.executeQuery();

            while (resultado.next()) {

                tema.setDescripcion(resultado.getString("DESCRIPCION"));
                temas.addElement(tema);
                tema = new TemaBO();
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

        return temas;

    }

    public void insertarTema(String tema) {

        Connection conexion = null;

        try {
            conexion = getConeccion();

            String sql = "INSERT INTO TEMAS (DESCRIPCION)" +
                    " VALUES (?)";

            PreparedStatement insertar = conexion.prepareStatement(sql);

            insertar.setString(1, tema);

            int resultado = insertar.executeUpdate();


            if (resultado == 1) {
                System.out.println("\nSe inserto TEMA satisfactoriamente");
            } else {
                System.out.println("\nSe produjo un error insertando el TEMA");
            }

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

    }

    public void modificarTema(String temaAMod, String temaMod) {
        Connection conexion = null;

        try {
            conexion = getConeccion();

            String sql = "UPDATE TEMAS SET DESCRIPCION = ? WHERE DESCRIPCION = ?";

            PreparedStatement modificar = conexion.prepareStatement(sql);

            modificar.setString(1, temaMod);
            modificar.setString(2, temaAMod);

            int resultado = modificar.executeUpdate();


            if (resultado == 1) {
                System.out.println("\nSe inserto TEMA satisfactoriamente");
            } else {
                System.out.println("\nSe produjo un error insertando el TEMA");
            }

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
    }

    public void eliminarTema(String tema) {

        Connection conexion = null;

        try {
            conexion = getConeccion();

            String sql1 = "DELETE FROM TEMAS WHERE DESCRIPCION = ?";
            String sql2 = "DELETE FROM CONCEPTOS WHERE TEMA = ?";

            PreparedStatement eliminarTema = conexion.prepareStatement(sql1);
            PreparedStatement eliminarConceptos = conexion.prepareStatement(sql2);

            eliminarTema.setString(1, tema);
            eliminarConceptos.setString(1, tema);

            int temaRes = eliminarTema.executeUpdate();
            int conceptosRes = eliminarConceptos.executeUpdate();


            if ((temaRes != 0) && (conceptosRes != 0)) {
                System.out.println("\nSe inserto TEMA satisfactoriamente");
            } else {
                System.out.println("\nSe produjo un error insertando el TEMA");
            }

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

    }

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

}
