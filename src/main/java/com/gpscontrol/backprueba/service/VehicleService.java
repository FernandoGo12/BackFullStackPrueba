package com.gpscontrol.backprueba.service;

import com.gpscontrol.backprueba.dto.VehicleDTO;
import com.gpscontrol.backprueba.model.Vehicle;
import com.gpscontrol.backprueba.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private IVehicleRepository iVehicleRepository;

    public List<Vehicle> getAllVehicles(){
        return iVehicleRepository.findAll();
    }
    public <S extends Vehicle>S save(S entity){
        return iVehicleRepository.save(entity);
    }

    public Vehicle createVehicle(VehicleDTO vehicleDTO) throws Exception{
        try {
            Vehicle vehicle = new Vehicle();
            //AQUI DEBERIA HABER UN MAPPER, PERO SOLO ES UNA ENTIDAD Y ES CORTA
            vehicle.setMarca(vehicleDTO.getMarca());
            vehicle.setSucursal(vehicleDTO.getSucursal());
            vehicle.setAspirante(vehicleDTO.getAspirante());
            System.out.println("ESTE ES EL VEHICLE QUE VOY A CREAR " + vehicle);
            return save(vehicle);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Vehicle updateVehicle(Long id, VehicleDTO vehicleDTO) throws Exception{
        try{
            Vehicle vehicleToUpdate = iVehicleRepository.findById(id).get();
            System.out.println("Este es el vehiculo que voy a actualizar "+ vehicleToUpdate);
            vehicleToUpdate.setMarca(vehicleDTO.getMarca());
            vehicleToUpdate.setSucursal(vehicleDTO.getSucursal());
            vehicleToUpdate.setAspirante(vehicleDTO.getAspirante());
            System.out.println("ASI QUEDO DESPUES DE ACTUALIZARLO "+ vehicleToUpdate);
            return save(vehicleToUpdate);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Vehicle deleteVehicle(Long id){
        Vehicle vehicle = iVehicleRepository.findById(id).get();
        iVehicleRepository.deleteById(id);
        return vehicle;
    }
}
