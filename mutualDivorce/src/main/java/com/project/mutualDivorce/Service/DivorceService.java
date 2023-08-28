package com.project.mutualDivorce.Service;

import com.project.mutualDivorce.Dto.DivorceFormDto;
import com.project.mutualDivorce.Entity.Divorce;
import com.project.mutualDivorce.Repository.DivorceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivorceService {
    private final DivorceRepository divorceRepository;

   @Autowired
    public DivorceService(DivorceRepository divorceRepository) {
        this.divorceRepository = divorceRepository;
    }

    public List<Divorce> findAll(){
        return divorceRepository.findAll();
    }
    public Optional<Divorce> findById(long id){
       return Optional.ofNullable(divorceRepository.findById(id));
   }
    public Divorce save(Divorce divorce){
        return divorceRepository.save(divorce);
    }
    public void deleteById(long id){
        divorceRepository.deleteById(id);
    }

    public Divorce createDivorceForm(DivorceFormDto divorceFormDto){
       Divorce divorceForm = new Divorce();
       divorceForm.setHusbandAfm(divorceFormDto.getHusbandAfm());
       divorceForm.setHusbandAmka(divorceFormDto.getHusbandAmka());
       divorceForm.setHusbandSurname(divorceFormDto.getHusbandSurname());
       divorceForm.setWifeAfm(divorceFormDto.getWifeAfm());
       divorceForm.setWifeAmka(divorceFormDto.getWifeAmka());
       divorceForm.setWifeSurname(divorceFormDto.getWifeSurname());
       divorceForm = divorceRepository.save(divorceForm);
        return divorceForm;
    }

}
