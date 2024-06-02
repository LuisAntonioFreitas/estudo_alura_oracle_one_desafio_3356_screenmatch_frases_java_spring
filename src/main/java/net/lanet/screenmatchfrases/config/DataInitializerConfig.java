package net.lanet.screenmatchfrases.config;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Configuration
@Service
@Transactional
public class DataInitializerConfig implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        //Test
        List<?> testContent = entityManager.createNativeQuery(
                "SELECT id FROM tab_frases LIMIT 1"
        ).getResultList();
        if (testContent.isEmpty()) {
            String sqlScript = readSqlScript("classpath:db/data.sql");
            String[] sqlStatements = sqlScript.split("\n");
            for (String sql : sqlStatements) {
                jdbcTemplate.execute(sql);
            }
        }
    }

    private String readSqlScript(String resourcePath) {
        Resource resource = resourceLoader.getResource(resourcePath);
        try (InputStream inputStream = resource.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder scriptBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                scriptBuilder.append(line).append("\n");
            }
            return scriptBuilder.toString();
        } catch (IOException e) {
            //throw new RuntimeException("Erro ao ler script SQL: " + resourcePath, e);
        }
        return null;
    }

}
