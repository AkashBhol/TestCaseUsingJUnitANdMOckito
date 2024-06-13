package com.example.TestCse.Controller;

import com.example.TestCse.DTO.Bijay;
import com.example.TestCse.Service.IBijayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v2")
public class BijayController {
    @Autowired
    private IBijayService iBijayService;

    @PostMapping("/create")
    public ResponseEntity<Bijay> createBijay(@RequestBody Bijay bijay){
        Bijay bijay1 = this.iBijayService.createBijay(bijay);
        return new ResponseEntity<>(bijay1, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<com.example.TestCse.DO.Bijay>> getAllBijay(){
        List<com.example.TestCse.DO.Bijay> allBijay = this.iBijayService.getAllBijay();
        return new ResponseEntity<>(allBijay,HttpStatus.OK);
    }

    @GetMapping("/get/single/{id}")
    public ResponseEntity<Bijay> getById(@PathVariable int id){
        Bijay byId = this.iBijayService.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        String s = this.iBijayService.deleteById(id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }


}
