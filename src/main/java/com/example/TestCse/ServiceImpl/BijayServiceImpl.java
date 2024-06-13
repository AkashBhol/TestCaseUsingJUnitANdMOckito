package com.example.TestCse.ServiceImpl;

import ch.qos.logback.core.util.OptionHelper;
import com.example.TestCse.DTO.Bijay;
import com.example.TestCse.Repository.BIjayRepository;
import com.example.TestCse.Service.IBijayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BijayServiceImpl implements IBijayService {
    @Autowired
    private BIjayRepository bijayRepository;

    @Override
    public Bijay createBijay(Bijay bijay) {
        com.example.TestCse.DO.Bijay bijay1=new com.example.TestCse.DO.Bijay();
        bijay1.setName(bijay.getName());
        bijay1.setCity(bijay.getCity());
        com.example.TestCse.DO.Bijay save = this.bijayRepository.save(bijay1);
        bijay.setName(save.getName());
        bijay.setCity(save.getCity());
        return bijay;
    }

    @Override
    public List<com.example.TestCse.DO.Bijay> getAllBijay() {
        List<com.example.TestCse.DO.Bijay> all = this.bijayRepository.findAll();
        return all;
    }


    @Override
    public Bijay getById(int id) {
        Optional<com.example.TestCse.DO.Bijay> byId = this.bijayRepository.findById(id);
         Bijay bijay=new Bijay();
         bijay.setName(byId.get().getName());
         bijay.setCity(byId.get().getCity());
         return bijay;
    }

    @Override
    public String deleteById(int id) {
        if(!bijayRepository.existsById(id)){
           return  "No records found";
        }
    this.bijayRepository.deleteById(id);
        return "Records Deleted successfully";
    }

    @Override
    public Bijay updateBijay(Bijay bijay) {
        com.example.TestCse.DO.Bijay bijay1=new com.example.TestCse.DO.Bijay();
        bijay1.setName(bijay.getName());
        bijay1.setCity(bijay.getCity());
        com.example.TestCse.DO.Bijay save = this.bijayRepository.save(bijay1);
        bijay.setName(save.getName());
        bijay.setCity(save.getCity());
        return bijay;
    }
}
