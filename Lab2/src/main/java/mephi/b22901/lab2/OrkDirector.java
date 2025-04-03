/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

/**
 *
 * @author Регина
 */
public class OrkDirector {
    private OrkBuilder orkBuilder;
  
    public void setOrkBuilder(OrkBuilder ob) { orkBuilder = ob; }
    public Ork getOrk() { return orkBuilder.getOrk();   }
    
    public void createBasicOrk(){
        orkBuilder.createNewOrk();
        orkBuilder.setName();
        orkBuilder.setAttributes();
        orkBuilder.setGear();
    }
    
    public void createLeaderOrk(){
        orkBuilder.createNewOrk();
        orkBuilder.setName();
        orkBuilder.setAttributes();
        orkBuilder.setGear();
        orkBuilder.setBanner();
    }
    
    public void createScoutOrk(){
        orkBuilder.createNewOrk();
        orkBuilder.setName();
        orkBuilder.setAttributes();
        orkBuilder.setGear();
        orkBuilder.setBow();
    }
    
}
