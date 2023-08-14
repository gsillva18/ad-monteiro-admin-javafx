package com.ad.admonteirojavafx.repository;

import com.ad.admonteirojavafx.model.ChurchEvent;
import com.ad.admonteirojavafx.model.Cult;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

import java.io.InputStream;
import java.util.Map;

public class ADRepository {

    public static void initFirebaseAPP(){

        try {

            InputStream serviceAccount = ADRepository.class.getResourceAsStream("/ad-monteiro-service-firebase-adminsdk-25wf2-c94bb09e27.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://ad-monteiro-service-default-rtdb.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            System.out.println("ERRO AO INICIAR A COMUNICAÇÃO COM FIREBASE");
            e.printStackTrace();
        }
    }

    public void login(String UIDUser) throws Exception{

        try {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuth.getUser(UIDUser);

        } catch (Exception e) {
            throw new Exception("Erro ao fazer login");
        }

    }

    public void createCult(String idReference, Cult cult){
        try{

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

            databaseReference.child("cults").child(idReference).setValue(cult, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        System.out.println("Cult adicionado com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar cult: " + databaseError.getMessage());
                    }
                }
            });
        }catch (Exception e){
            System.out.println("ERRO AO CRIAR CULT");
            e.printStackTrace();
        }
    }

    public void createEvent(String idReference, ChurchEvent event){
        try{

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

            databaseReference.child("events").child(idReference).setValue(event, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        System.out.println("event adicionado com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar event: " + databaseError.getMessage());
                    }
                }
            });
        }catch (Exception e){
            System.out.println("ERRO AO CRIAR EVENT");
            e.printStackTrace();
        }
    }

    public void deleteCult(String idReference){
        try{

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

            databaseReference.child("cults").child(idReference.replaceAll("\\s",""))
                    .removeValue((databaseError, databaseReference1) -> {
                        if (databaseError != null) {
                            System.out.println("Erro ao deletar cult: " + databaseError.getMessage());
                        } else {
                            System.out.println("Cult deletado com sucesso!");
                        }
            });
        }catch (Exception e){
            System.out.println("ERRO AO DELETAR CULT");
            e.printStackTrace();
        }
    }

    public void deleteChurchEvent(String idReference){
        try{

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

            databaseReference.child("events").child(idReference.replaceAll("\\s",""))
                    .removeValue((databaseError, databaseReference1) -> {
                        if (databaseError != null) {
                            System.out.println("Erro ao deletar event: " + databaseError.getMessage());
                        } else {
                            System.out.println("Event deletado com sucesso!");
                        }
                    });
        }catch (Exception e){
            System.out.println("ERRO AO DELETAR EVENT");
            e.printStackTrace();
        }
    }

}
