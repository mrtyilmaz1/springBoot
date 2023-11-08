package com.example.firstSpringWeb.service;

import com.example.firstSpringWeb.model.Personel;
import com.example.firstSpringWeb.repository.PersonelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // personelRepository için consructor oluşturuyor.
public class PersonelService {
    private final PersonelRepository personelRepository;

    public Personel savePersonel(Personel personel){
        return personelRepository.save(personel);
    }

public List<Personel> getPersonelList(){
        return personelRepository.findAll();
}

public Personel getPersonelById(Long id){

    return personelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bu kullanıcı yok"));

}

public void  deletePersonelById(Long id){
      personelRepository.deleteById(id);
}

public Personel updatePersonelById(Personel personel){
       return personelRepository.save(personel);
}
    public String getPersonel(Long id) {
        if(id != null) {
            return "personel bulundu";
        }else {
            throw new RuntimeException("personel bulunamadı");
        }
    }

}
