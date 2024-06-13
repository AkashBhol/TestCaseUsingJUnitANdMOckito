package com.example.TestCse;

import com.example.TestCse.Controller.BijayController;
import com.example.TestCse.DTO.Bijay;
import com.example.TestCse.Service.IBijayService;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class BijayControllerTest {
    @InjectMocks
    private BijayController bijayController;
    
    @Mock
    private IBijayService iBijayService;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
   public  void createBijayTest(){
        Bijay bijay1=new Bijay();
        bijay1.setId(1);
        Mockito.when(iBijayService.createBijay(Mockito.any())).thenReturn(bijay1);
        ResponseEntity<Bijay> bijay = bijayController.createBijay(bijay1);
    }
    @Test
    public void getAllBijay(){
        List<com.example.TestCse.DO.Bijay> bijayList = new ArrayList<>();
        com.example.TestCse.DO.Bijay bijay1 = new com.example.TestCse.DO.Bijay();
        bijay1.setId(1);
        bijayList.add(bijay1);
        Mockito.when(iBijayService.getAllBijay()).thenReturn(bijayList);
        ResponseEntity<List<com.example.TestCse.DO.Bijay>> responseEntity = bijayController.getAllBijay();
    }
    @Test
    public void getById(){
        int id=1;
        Bijay bijay=new Bijay();
        bijay.setId(1);
        Mockito.when(iBijayService.getById(Mockito.anyInt())).thenReturn(bijay);
        ResponseEntity<Bijay> byId = bijayController.getById(id);
    }
    @Test
    public void deleteById(){
        String s="dc";
        int id=1;
        Mockito.when(iBijayService.deleteById(Mockito.anyInt())).thenReturn(s);
        ResponseEntity<String> stringResponseEntity = bijayController.deleteById(id);
    }
}
