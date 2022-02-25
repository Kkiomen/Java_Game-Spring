package pl.kkiomen.game.service;

import org.springframework.stereotype.Service;
import pl.kkiomen.game.dto.CityDto;
import pl.kkiomen.game.exception.NotFoundCity;
import pl.kkiomen.game.model.City;
import pl.kkiomen.game.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public boolean save(CityDto cityDto){
        City city = new City();
        city.setLevel(cityDto.getLevel());
        city.setUser(cityDto.getUser());
        city.setMoneyCount(cityDto.getMoneyCount());
        city.setPeopleCount(cityDto.getPeopleCount());
        city.setStoneCount(cityDto.getStoneCount());
        city.setWoodCount(cityDto.getWoodCount());
        city.setX(cityDto.getX());
        city.setY(cityDto.getY());
        cityRepository.save(city);
        return true;
    }

    private City getEntityById(Long Id){
        Optional<City> optional = cityRepository.findById(Id);
        return optional.orElseGet(() -> cityRepository.findById(Id).orElseThrow(NotFoundCity::new));
    }

    public List<City> getAll(){
        List<City> city = new ArrayList<>();
        cityRepository.findAll().forEach(city::add);
        return city;
    }

    public City getByCoordinates(int x, int y){
        Optional<City> city = getAll()
                .stream()
                .filter(currentCity -> Objects.equals(currentCity.getX(),x))
                .filter(currentCity -> Objects.equals(currentCity.getY(),y))
                .findFirst();
        if(city.isPresent()){
            return city.get();
        }
        return null;
    }

    public CityDto getById(Long id){
        City city = getEntityById(id);
        if(city != null){
            return new CityDto(
                    city.getId(),
                    city.getX(),
                    city.getY(),
                    city.getWoodCount(),
                    city.getStoneCount(),
                    city.getPeopleCount(),
                    city.getMoneyCount(),
                    city.getLevel(),
                    city.getUser()
            );
        }
        return null;
    }

    public void update(CityDto cityDto){
        City city = getEntityById(cityDto.getId());
        city.setX(cityDto.getX());
        city.setY(cityDto.getY());
        city.setUser(cityDto.getUser());
        city.setWoodCount(cityDto.getWoodCount());
        city.setPeopleCount(cityDto.getPeopleCount());
        city.setMoneyCount(cityDto.getMoneyCount());
        city.setLevel(cityDto.getLevel());
        cityRepository.save(city);
    }

    public void delete(Long id) {
        City city = getEntityById(id);
        cityRepository.delete(city);
    }

}
