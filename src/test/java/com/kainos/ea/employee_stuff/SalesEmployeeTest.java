package com.kainos.ea.employee_stuff;

import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.SalesEmployee;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/** 
* SalesEmployee Tester. 
* 
* @author <Authors name> 
* @since <pre>Sept 5, 2022</pre> 
* @version 1.0 
*/ 
public class SalesEmployeeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getCommissionRate() 
* 
*/ 
@Test
public void testGetCommissionRate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCommissionRate(float commissionRate) 
* 
*/ 
@Test
public void testSetCommissionRate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSalesTotal() 
* 
*/ 
@Test
public void testGetSalesTotal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSalesTotal(int salesTotal) 
* 
*/ 
@Test
public void testSetSalesTotal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: calcPay() 
* 
*/ 
@Test
public void testCalcPay() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: equals(Object obj) 
* 
*/ 
@Test
public void testEquals() throws Exception {
    Employee tester1 = new SalesEmployee((short) 10,10000_00,"Jack");
    Employee tester2 = new SalesEmployee((short) 10,20000_00,"Jack");
    Employee tester3 = new SalesEmployee((short) 10,10000_00,"Henry");
    Employee tester4 = new SalesEmployee((short) 11,10000_00,"Jack");
    Employee tester5 = new SalesEmployee((short) 10,10000_00,"Jack");
    assertNotEquals(tester1, tester2);
    assertNotEquals(tester1, tester3);
    assertNotEquals(tester1, tester4);
    assertEquals(tester1, tester5);
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
//TODO: Test goes here... 
} 


} 
