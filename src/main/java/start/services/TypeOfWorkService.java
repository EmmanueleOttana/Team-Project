package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Performance;
import start.entities.TypeOfWork;
import start.repositories.TypeOfWorkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeOfWorkService {
    @Autowired
    TypeOfWorkRepository typeOfWorkRepository;

    public List<TypeOfWork> getAllTypeOfWorks() throws Exception{
        List<TypeOfWork> allTypeOfWorksFromDB = typeOfWorkRepository.findAll();
        if (allTypeOfWorksFromDB.isEmpty()){
            throw new Exception("No Performances found!");
        }
        return allTypeOfWorksFromDB;
    }

    public TypeOfWork newTypeOfWork(TypeOfWork typeOfWork)throws Exception{
        try {
            if (typeOfWork==null) return null;
            return typeOfWorkRepository.saveAndFlush(typeOfWork);
        }catch (Exception e){
            throw new Exception("TypeOfWork not found");
        }
    }
    public Optional<TypeOfWork> getTypeOfWorkById(long id) throws Exception{
        try {
            return typeOfWorkRepository.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    public void deleteTypeOfWork(long id)throws Exception{
        try {
            typeOfWorkRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }


}
