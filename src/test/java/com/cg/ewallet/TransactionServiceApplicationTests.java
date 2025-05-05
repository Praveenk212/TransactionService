package com.cg.ewallet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ewallet.dao.TransactionRepository;
import com.cg.ewallet.dto.Transaction;
import com.cg.ewallet.service.TransactionService;

@SpringBootTest
class TransactionServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TransactionService transService;
	
	
	@MockBean
	private TransactionRepository transDao;
	

	@Test
	public void getAllTransactionTest() {
		List<Transaction> list=new ArrayList<Transaction>();
		Transaction one=new Transaction(1L,8288053865L,1000,50000,LocalDate.of(2020, 2, 02),0,100000000011L,100000000013L,8288053865L,8955194111L);
		Transaction two=new Transaction(2L,8955194111L,0,50000,LocalDate.of(2020, 2, 02),1000,100000000011L,100000000013L,8288053865L,8955194111L);
		Transaction three=new Transaction(3L,9782410575L,0,50000,LocalDate.of(2019, 4, 02),1000,100000000014L,100000000012L,9982828585L,9782410575L);
		Transaction four=new Transaction(4L,9782410575L,1000,50000,LocalDate.of(2020, 8, 01),0,100000000014L,100000000012L,9782410575L,9982828585L);

		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		 
		 when(transDao.findAll()).thenReturn(list);
		 
		 assertEquals(4, transService.getAllTransaction().size());
	
		}
	

	
	
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Test public void getTransactionByPhnNumberTest() {
	 * when(transService.getTransactionByPhnNumber(8288053865L)).thenReturn((List<
	 * Transaction>) new Transaction(1L,8288053865L,1000,50000,LocalDate.of(2020, 2,
	 * 02),0,100000000011L,100000000013L,8288053865L,8955194111L));
	 * 
	 * Transaction one= (Transaction)
	 * transService.getTransactionByPhnNumber(8288053865L);
	 * 
	 * assertEquals(1L,one.getTransactionId());
	 * 
	 * 
	 * 
	 * }
	 */
	
	

}
