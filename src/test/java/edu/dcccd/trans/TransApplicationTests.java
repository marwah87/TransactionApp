package edu.dcccd.trans;

import edu.dcccd.trans.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import edu.dcccd.trans.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class TransApplicationTests {
    @Autowired
    TransactionRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDBcount(){
        long revs = repository.count();
        assertEquals(4L,revs);
    }

    @Test
    public void testDBall(){
        Iterable<Transaction> it = repository.findAll();
        it.forEach(t -> log.info("\n" + t.toString()));
    }

}
