/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ude.casosdeuso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.ude.casosdeuso.model.CasoDeUso;
import edu.ude.casosdeuso.util.DbUtil;

/**
 *
 * @author George
 */
public class CasoDeUsoDao {
 
    private Connection connection;

    public CasoDeUsoDao() {
        connection = DbUtil.getConnection();
    }

    public void addCasoDeUso(CasoDeUso cdu) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into caso_de_uso(Text,PositionX,PositionY) values (?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, cdu.getText());
            preparedStatement.setInt(2, cdu.getPositionX());
            preparedStatement.setInt(3, cdu.getPositionY());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int casoDeUsoId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from caso_de_uso where ID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, casoDeUsoId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCasoDeUso(CasoDeUso cdu) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update caso_de_uso set Text=?, PositionX=?, PositionY=?" +
                            "where ID=?");
            // Parameters start with 1
            preparedStatement.setString(1, cdu.getText());
            preparedStatement.setInt(2, cdu.getPositionX());
            preparedStatement.setInt(3, cdu.getPositionY());
            preparedStatement.setInt(4, cdu.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CasoDeUso> getAllCasosDeUso() {
        List<CasoDeUso> cdus = new ArrayList<CasoDeUso>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from caso_de_uso");
            while (rs.next()) {
                CasoDeUso cdu = new CasoDeUso();
                cdu.setId(rs.getInt("ID"));
                cdu.setText(rs.getString("Text"));
                cdu.setPositionX(rs.getInt("PositionX"));
                cdu.setPositionY(rs.getInt("PositionY"));
                cdus.add(cdu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cdus;
    }

    public CasoDeUso getCasoDeUsoById(int cduId) {
        CasoDeUso cdu = new CasoDeUso();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from caso_de_uso where ID=?");
            preparedStatement.setInt(1, cduId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                cdu.setId(rs.getInt("ID"));
                cdu.setText(rs.getString("Text"));
                cdu.setPositionX(rs.getInt("PositionX"));
                cdu.setPositionY(rs.getInt("PositionY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cdu;
    }
}
