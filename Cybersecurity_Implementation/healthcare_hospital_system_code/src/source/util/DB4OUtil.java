/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.util;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import source.Configuration;
import source.EcoSystem;



/**
 *
 * @author GaurangDeshpande
 */
public class DB4OUtil {
     private static DB4OUtil dB4OUtil;
     private int dbVersion ;
     
     public synchronized static DB4OUtil getInstance(){
         if(dB4OUtil == null){
             dB4OUtil = new DB4OUtil();
         }
         return dB4OUtil;
     }
     
     protected synchronized static void closeConnection(ObjectContainer connection){
         if(connection != null){
             connection.close();
         }
     }
     
     private ObjectContainer openConnection(){
         try{
             EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
             configuration.common().add(new TransparentPersistenceSupport());
             configuration.common().activationDepth(Integer.MAX_VALUE);
             configuration.common().updateDepth(Integer.MAX_VALUE);
             configuration.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);
             
             ObjectContainer container = Db4oEmbedded.openFile(configuration, Util.DB4O_FILE_NAME);
             return container;
         }
         catch (Exception e){
             System.out.println("DB4O Class exception--->"+e.getMessage());
         }
         return null;
     }
     
     public synchronized void storeInDatabase(EcoSystem ecoSystem){
         ObjectContainer connection = openConnection();
         connection.store(ecoSystem);
         connection.commit();
         connection.close();
     }
     
     public EcoSystem retrieveFromDatabase(){
         ObjectContainer connection = openConnection();
         ObjectSet<EcoSystem> ecoSystemSet = connection.query(EcoSystem.class);
         EcoSystem ecoSystem;
         if(ecoSystemSet.size() == 0){
             ecoSystem = Configuration.configure();
         }
         else{
             ecoSystem = ecoSystemSet.get(ecoSystemSet.size()-1);
         }
         connection.close();
         return ecoSystem;
     }
     
     
    public EcoSystem checkBackUp() {
        try {
            EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
            configuration.common().add(new TransparentPersistenceSupport());
            configuration.common().activationDepth(Integer.MAX_VALUE);
            configuration.common().updateDepth(Integer.MAX_VALUE);
            configuration.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);

            ObjectContainer container = Db4oEmbedded.openFile(configuration, Util.DB4O_FILE_NAME);
            ObjectSet<EcoSystem> ecoSystemSet = container.query(EcoSystem.class);
            EcoSystem ecoSystem = null;
            if (ecoSystemSet.size() == 0) {
                for (int i = dbVersion; i > 0; i--) {
                    if (Db4oEmbedded.openFile(configuration, "GothamGeneral" + i + ".db4o").query(EcoSystem.class).size() != 0) {
                        ecoSystem = Db4oEmbedded.openFile(configuration, "GothamGeneral" + i + ".db4o").query(EcoSystem.class).get(Db4oEmbedded.openFile(configuration, "GothamGeneral" + i + ".db4o").query(EcoSystem.class).size() - 1);
                        break;
                    }
                }
            }
            else{
                ecoSystem = ecoSystemSet.get(ecoSystemSet.size()-1);
            }
            container.close();
            return ecoSystem;
        } catch (Exception e) {
            System.out.println("DB4O Class exception--->" + e.getMessage());
        }
        return null;
    }
     
     
     public void createBackupFile(int count, EcoSystem ecoSys) {
        ObjectContainer container = null;
        try {
            EmbeddedConfiguration configuration = Db4oEmbedded.newConfiguration();
            configuration.common().add(new TransparentPersistenceSupport());
            configuration.common().activationDepth(Integer.MAX_VALUE);
            configuration.common().updateDepth(Integer.MAX_VALUE);
            configuration.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);

            //String fileName = Util.DB4O_FILE_NAME;
            //String[] name = fileName.split(".");
            dbVersion = count;
            container = Db4oEmbedded.openFile(configuration, "GothamGeneral"+count+".db4o");

        } catch (Exception e) {
            System.out.println("DB4O Class exception--->" + e.getMessage());
        }
        if (container != null) {
            container.store(ecoSys);
            container.commit();
            container.close();
        }

    }
}