package com.example.TestCse.Service;

import com.example.TestCse.DTO.Bijay;

import java.util.List;

public interface IBijayService {
    Bijay createBijay(Bijay bijay);//create

    List<com.example.TestCse.DO.Bijay> getAllBijay();//getALl

    Bijay getById(int id);//get single record

    String deleteById(int id);//delete single record

    Bijay updateBijay(Bijay bijay);//update records

}
