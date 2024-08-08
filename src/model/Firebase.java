package model;

/**
 *
 * @author Juan Pablo Tejeiro Londoño
 */

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;



public class Firebase {

    private FirebaseDatabase firebaseDatabase;

    public Firebase() throws FileNotFoundException {
        initFirebase();
    }

    public void initFirebase() throws FileNotFoundException {
        try {
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://supermercado-6da04-default-rtdb.firebaseio.com/")
                    .setServiceAccount(new FileInputStream(new File("supermercado.json")))
                    .build();

            FirebaseApp.initializeApp(firebaseOptions);
            firebaseDatabase = FirebaseDatabase.getInstance();
            System.out.println("Conexión exitosa....");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void saveItem(Item item) {
        if (item != null) {
            DatabaseReference databaseReference = firebaseDatabase.getReference("/items");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            databaseReference.push().setValue(item, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    if (de != null) {
                        System.out.println("Error al guardar el registro: " + de.getMessage());
                    } else {
                        System.out.println("Registro guardado!");
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }   
    
}
