/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ude.casosdeuso.model;

/**
 *
 * @author George
 */
public class CasoDeUso {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private int id;
    private String text;
    private int positionX;
    private int positionY;
    
    
}
