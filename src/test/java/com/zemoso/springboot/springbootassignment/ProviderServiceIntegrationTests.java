package com.zemoso.springboot.springbootassignment;


import com.zemoso.springboot.springbootassignment.dao.ProviderRepository;
import com.zemoso.springboot.springbootassignment.entity.Provider;

import com.zemoso.springboot.springbootassignment.service.ProviderService;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//mocktio :
//juint mockito tutorial

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProviderServiceIntegrationTests {

	@Autowired
	ProviderService providerService;

	@Autowired
	ProviderRepository providerRepository;


	@Test
	@Rollback(false)
	//@Order(1)
	//@Rollback(true)
	public void testFindAllProviders() {

		Provider obj =   new Provider("provider9","pr@gmail.com","xyz");
		providerService.save(obj);
		List<Provider> providers = providerService.findAll();
		System.out.println();

		//assertEquals(2, providers.size());
		//asert(providers.size())>1;
		Assertions.assertTrue(providers.size()>1);
	}

	@Test
	@Rollback(false)
	//@Rollback(value = false)
	public void testFindProviderByName() {

		Provider obj =   new Provider("provider10","pr@gmail.com","xyz");
		providerService.save(obj);
		Provider provider = providerRepository.findByProviderName("provider10");

		assertEquals("provider10",provider.getProviderName());
	}

	@Test
	//@Order(3)
	@Rollback(false)
	public void testUpdateProvider(){
		Provider obj =   new Provider("provider11","pr@gmail.com","xyz");
		providerService.save(obj);
		Provider provider = providerRepository.findByProviderName("provider11");
		provider.setProviderName("new_provider");

		assertEquals("new_provider",provider.getProviderName());
	}


	@Test
	@Rollback(false)
	public void testDeleteProvider(){
		Provider obj =   new Provider("provider12","pr@gmail.com","xyz");
		providerService.save(obj);
		//Provider obj1 = providerService.findById(obj)
		providerService.deleteById(obj.getId());
		Provider provider = providerRepository.findByProviderName("provider12");
		//System.out.println(provider.getId());

		//assertEquals(0,provider.getId());
		assertNull(provider);
	}

}
