package org.jsp.hbmtempletdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.jsp.hbmtempletdemo.dto.Merchants;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class MerchantDao {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public Merchants savMerchants(Merchants merchants) {
		template.save(merchants);
		return merchants;
	}

	@Transactional
	public Merchants updateMerchants(Merchants merchants) {
		template.update(merchants);
		return merchants;
	}

	@Transactional
	public boolean deleteMerchants(int id) {
		Merchants merchants = findById(id);

		if (merchants != null) {
			template.delete(merchants);
			return true;
		}
		return false;
	}

	public Merchants findById(int id) {
		return template.get(Merchants.class, id);

	}

	public List<Merchants> findAll() {
		return template.loadAll(Merchants.class);
	}

}
