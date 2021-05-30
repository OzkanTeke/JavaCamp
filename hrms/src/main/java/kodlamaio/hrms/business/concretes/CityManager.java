package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityRepository;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityRepository cityRepository;

	@Autowired
	public CityManager(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityRepository.findAll(), "Şehirler listelendi.");
	}

}
