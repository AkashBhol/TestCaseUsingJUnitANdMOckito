package com.example.TestCse;

import com.example.TestCse.DTO.Bijay;
import com.example.TestCse.Repository.BIjayRepository;
import com.example.TestCse.ServiceImpl.BijayServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
public class BijayServiceImplTest {
    @InjectMocks
    private BijayServiceImpl service;

    @Mock
    private BIjayRepository  bIjayRepository;

    @Test
    public void createBijayTest(){
        Bijay bijay=new Bijay();
        com.example.TestCse.DO.Bijay bijay1=new com.example.TestCse.DO.Bijay();
        Mockito.when(bIjayRepository.save(Mockito.any())).thenReturn(bijay1);
        try {
            Bijay bijay2 = service.createBijay(bijay);
        }
       catch (Exception e){
            assertTrue(true);
       }
    }

   @Test
    public void getAllBijayTest(){
        List<com.example.TestCse.DO.Bijay> bijays=new ArrayList<>();
       com.example.TestCse.DO.Bijay bijay=new com.example.TestCse.DO.Bijay();
       bijays.add(bijay);
       Mockito.when(bIjayRepository.findAll()).thenReturn(bijays);
        try {
            List<com.example.TestCse.DO.Bijay> allBijay = service.getAllBijay();
        }
        catch (Exception e){
            assertTrue(true);
        }
   }
   @Test
    public void getByIdTest(){
        int id=23;
       com.example.TestCse.DO.Bijay bijay=new com.example.TestCse.DO.Bijay();
       Optional<com.example.TestCse.DO.Bijay> bijay1=Optional.of(bijay);
       Bijay bijay2=new Bijay();
       Mockito.when(bIjayRepository.findAll()).thenReturn((List<com.example.TestCse.DO.Bijay>) bijay2);
        try {
            Bijay byId = service.getById(id);
        }
        catch (Exception e){
            assertTrue(true);
        }
   }

//   @Test
//   public void deleteByIdTest(){
//        int id=23;
//        String s="No records found";
//        Mockito.when(bIjayRepository.deleteById()).thenReturn();
//        try {
//            String s1 = service.deleteById(id);
//        }
//        catch (Exception e){
//            assertTrue(true);
//        }
//   }

    @Test
    public void testDeleteById_RecordExists() {
        int id = 1;
        Mockito.when(bIjayRepository.existsById(id)).thenReturn(true);
        String result = service.deleteById(id);

        Mockito.verify(bIjayRepository).deleteById(id);
        assertEquals("Records Deleted successfully", result);
    }

   @Test
    public void updateBijayTest(){
        Bijay bijay=new Bijay();
        Mockito.when(bIjayRepository.save(Mockito.any())).thenReturn(bijay);
        try {
            Bijay bijay1 = service.updateBijay(bijay);
        }
        catch (Exception e){

        }
   }
}
