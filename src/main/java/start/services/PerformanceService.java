package start.services;

import org.springframework.stereotype.Service;
import start.entities.Employee;
import start.entities.Performance;
import start.repositories.PerformanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {
    PerformanceRepository performanceRepository;
    public List<Performance> getAllPerformances() throws Exception{
        List<Performance> allPerformancesFromDB = performanceRepository.findAll();
        if (allPerformancesFromDB.isEmpty()){
            throw new Exception("No Performances found!");
        }
        return allPerformancesFromDB;
    }

    public Performance newPerformance(Performance performance)throws Exception{
        try {
            if (performance==null) return null;
            return performanceRepository.saveAndFlush(performance);
        }catch (Exception e){
            throw new Exception("Employee not found");
        }
    }
    public Optional<Performance> getPerformanceById(long id) throws Exception{
        try {
            return performanceRepository.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    public void deletePerformance(long id)throws Exception{
        try {
            performanceRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

}
