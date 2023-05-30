package service;

import com.project.eIASbackend.service.IAdService;
import com.project.eIASbackend.service.IMaterialService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IAdServiceTest {

    @Autowired
    IMaterialService materialService;
    @Autowired
    IAdService schemeService;


    @Test
    void generateSummary() {
        String summary = schemeService.generateSummary( 10, 50);
        System.out.println(summary);
    }

}