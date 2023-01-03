package it.prova.pizzastore_backend.repository.ordine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pizzastore_backend.model.Ordine;

public class CustomOrdineRepositoryImpl implements CustomOrdineRepository{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Ordine> findByExample(Ordine example) {
		
		Map<String, Object> parameterMap = new HashMap<>();
		List<String> whereClauses = new ArrayList<>();
		
		StringBuilder queryBuilder = new StringBuilder("select o from Ordine o join fetch o.cliente c join fetch o.pizze p where o.id = o.id");
		
		if(example.getData() != null) {
			whereClauses.add(" o.data > :data");
			parameterMap.put("data", example.getData());
		}
		if(example.getCliente() !=  null) {
			whereClauses.add(" c.indirizzo = :indirizzo");
			parameterMap.put("indirizzo", example.getCliente().getIndirizzo());
		}
		if(example.getPizze() != null && !example.getPizze().isEmpty()) {
			whereClauses.add("p in :pizze");
			parameterMap.put("pizze", example.getPizze());
		}
		queryBuilder.append(!whereClauses.isEmpty()?"and" : "");
		queryBuilder.append(StringUtils.join(whereClauses, "and"));		
		
		TypedQuery<Ordine> typedQuery = entityManager.createQuery(queryBuilder.toString(), Ordine.class);
		
		for(String key : parameterMap.keySet()) {
			typedQuery.setParameter(key, parameterMap.get(key));
		}
		
		return typedQuery.getResultList();
	}

}
