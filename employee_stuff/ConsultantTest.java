package test.com.kainos.ea.employee_stuff; 

import com.kainos.ea.employee_stuff.Consultant;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* Consultant Tester. 
* 
* @author <Authors name> 
* @since <pre>Sept 5, 2022</pre> 
* @version 1.0 
*/ 
public class ConsultantTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getName() 
* 
*/ 
@Test
public void testGetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDailyRate() 
* 
*/ 
@Test
public void testGetDailyRate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setDailyRate(int dailyRate) 
* 
*/ 
@Test
public void testSetDailyRate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDaysWorked() 
* 
*/ 
@Test
public void testGetDaysWorked() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setDaysWorked(int daysWorked) 
* 
*/ 
@Test
public void testSetDaysWorked() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: calcPay() 
* 
*/ 
@Test
public void testCalcPay() throws Exception {
    Consultant tester = new Consultant("Jack",100,50);
    assertEquals(5000, tester.calcPay());
} 

/** 
* 
* Method: getCheque() 
* 
*/ 
@Test
public void testGetCheque() throws Exception {
    Consultant tester = new Consultant("Jack",100,50);
    assertEquals("Jack, 5000", tester.getCheque());
} 


} 
