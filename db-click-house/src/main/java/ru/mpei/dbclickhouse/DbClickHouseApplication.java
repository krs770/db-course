package ru.mpei.dbclickhouse;

import java.time.Instant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mpei.dbclickhouse.domain.Measurement;
import ru.mpei.dbclickhouse.repository.MeasurementRepository;

@SpringBootApplication
public class DbClickHouseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
            SpringApplication.run(DbClickHouseApplication.class, args);

        /*
        * Перед выполнением запустите файл init.sql в консоли ClickHouse чтобы создать таблицу
        * */
        var bean = run.getBean(MeasurementRepository.class);
        bean.save(new Measurement(Instant.now(), "IED_3", 1.0));

        System.out.println(bean.findAll());
       /* List<Measurement> all = bean.findAll();
        System.out.println(all);*/
    }

}
