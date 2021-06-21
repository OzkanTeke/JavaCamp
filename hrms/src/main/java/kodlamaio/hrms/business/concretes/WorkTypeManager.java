package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeRepository;
import kodlamaio.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{

	private WorkTypeRepository workTypeRepository;
	
	@Autowired
	public WorkTypeManager(WorkTypeRepository workTypeRepository) {
		super();
		this.workTypeRepository = workTypeRepository;
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(this.workTypeRepository.findAll(), "Çalışma Türleri listelendi.");
	}

}
