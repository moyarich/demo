package edu.depaul.cdm.se.demo.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;


@Configuration
public class FirebaseConfig {
    

    @Bean
    public DatabaseReference firebaseDatabse() {
        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
        return firebase;
    }

    @Value("${rs.firebase.database.url}")
    private String databaseUrl;

    @Value("${rs.firebase.config.path}")
    private String configPath;

    @PostConstruct
    public void init() {
        InputStream serviceAccount = null;
        try {
            /**
             * https://firebase.google.com/docs/server/setup
             * https://www.baeldung.com/reading-file-in-java
             *
             * Create service account , download json
             */

            //reads a file that is available on a classpath. We will read the file available under src/main/resources:
            //serviceAccount = FirebaseConfig.class.getClassLoader().getResourceAsStream(configPath);
            serviceAccount = getClass().getClassLoader().getResourceAsStream(configPath);
            //serviceAccount = new ClassPathResource(configPath).getInputStream();


/*            BufferedReader r = new BufferedReader(new InputStreamReader(serviceAccount));

            System.out.println("======================================================");
            // reads each line
            String line;
            String val = "";
            while((line = r.readLine()) != null) {
                val = val + line;
            }
            System.out.println(val);
            System.out.println("======================================================");*/

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(databaseUrl)
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (serviceAccount != null) {
                try {
                    serviceAccount.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
