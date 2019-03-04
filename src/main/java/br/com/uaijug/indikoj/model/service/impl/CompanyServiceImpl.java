package br.com.uaijug.indikoj.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.uaijug.indikoj.exception.ResourceFoundException;
import br.com.uaijug.indikoj.exception.ResourceNotFoundException;
import br.com.uaijug.indikoj.model.domain.Company;
import br.com.uaijug.indikoj.model.repository.CompanyRepository;
import br.com.uaijug.indikoj.model.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private static final Logger log = LogManager.getLogger(CompanyServiceImpl.class);

	@Autowired
	private CompanyRepository clienteRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.uaijug.indikoj.model.service.ClienteSerivce#salvar(br.com.uaijug.
	 * indikoj.model.domain.Cliente)
	 */
	@Override
	public Company save(Company client) {
		if (client != null) {
			Optional<Company> result = findByName(client.getName());
			if (!result.isPresent()) {
				//if (!CPFUtil.valida(client.getDocumentId())) {
					//throw new CPFValidationException("Erro na validação do cpf!");
				//} else {
					return clienteRepository.save(client);
				//}
			} else {
				throw new ResourceFoundException("Cliente já existe");
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.uaijug.indikoj.model.service.ClienteSerivce#listar()
	 */
	@Override
	@Cacheable("companysInCache")
	public List<Company> listAll() {
		return clienteRepository.findAll();
	}

	@Override
	@Cacheable("companysInCache")
	public Page<Company> findAllPageable(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.uaijug.indikoj.model.service.ClienteSerivce#alterar(java.lang.
	 * Long, br.com.uaijug.indikoj.model.domain.Cliente)
	 */
	@Override
	public Company edit(Long id, Company client) {
		if (id != null && client != null) {
			Optional<Company> result = findById(id);
			if (result.isPresent()) {
				//if (!CPFUtil.valida(client.getDocumentId())) {
				//	throw new CPFValidationException("Erro na validação do cpf!");
				//} else {
					result.get().updade(id, client);
					log.info("Objeto Gravado!");
					return clienteRepository.save(result.get());
				//}

			} else {
				throw new ResourceNotFoundException("Cliente não existe");
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.uaijug.indikoj.model.service.ClienteSerivce#buscarPorId(java.lang.
	 * Long)
	 */
	@Override
	public Optional<Company> findById(Long id) {
		return clienteRepository.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.uaijug.indikoj.model.service.ClienteSerivce#buscarPorId(java.lang.
	 * Long)
	 */
	@Override
	public Optional<Company> findByName(String name) {
		return clienteRepository.findByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.uaijug.indikoj.model.service.ClienteSerivce#delete(java.lang.Long)
	 */
	@Override
	public boolean remove(Long id) {
		Optional<Company> result = findById(id);
		if (result != null) {
			clienteRepository.deleteById(id);
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}	
}
