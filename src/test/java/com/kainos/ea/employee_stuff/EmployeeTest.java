package com.kainos.ea.employee_stuff;

import com.kainos.ea.employee_stuff.BadNumber;
import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.SalaryTooLowException;
import com.kainos.ea.employee_stuff.SalesEmployee;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;

/** 
* Employee Tester. 
* 
* @author <Authors name> 
* @since <pre>Sept 5, 2022</pre> 
* @version 1.0 
*/ 
public class EmployeeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: setNumber(short number) 
* 
*/ 
@Test
public void testSetNumber() throws Exception {
    Employee tester1 = new Employee();
    assertThrows(BadNumber.class, () -> tester1.setNumber("Hello"));
} 

/** 
* 
* Method: setSalary(int salary) 
* 
*/ 
@Test
public void testSetSalary() throws Exception {
    Employee tester1 = new Employee();
    assertThrows(SalaryTooLowException.class, () -> tester1.setSalary(1000_00));
} 

/** 
* 
* Method: setName(String name) 
* 
*/ 
@Test
public void testSetName() throws Exception {
    Employee tester1 = new Employee();
    tester1.setName("Jack");
    assertEquals("Jack",tester1.getName());
} 

/** 
* 
* Method: getNumber() 
* 
*/ 
@Test
public void testGetNumber() throws Exception {
    Employee tester1 = new Employee();
    tester1.setNumber((short) 10);
    assertEquals(10,tester1.getNumber());
} 

/** 
* 
* Method: getSalary() 
* 
*/ 
@Test
public void testGetSalary() throws Exception { 
//TODO: Test goes here... 
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
* Method: calcPay() 
* 
*/ 
@Test
public void testCalcPay() throws Exception {
    Employee tester1 = new Employee((short) 10,12000_00,"Jack");
    assertEquals(100000,tester1.calcPay());
} 

/** 
* 
* Method: equals(Object obj) 
* 
*/ 
@Test
public void testEquals() throws Exception { 
    Employee tester1 = new Employee((short) 10,10000_00,"Jack");
    Employee tester2 = new Employee((short) 10,20000_00,"Jack");
    Employee tester3 = new Employee((short) 10,10000_00,"Henry");
    Employee tester4 = new Employee((short) 11,10000_00,"Jack");
    Employee tester5 = new Employee((short) 10,10000_00,"Jack");
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
    Employee tester = new Employee((short) 10,20000_00,"Jack");
    assertEquals("Employee 10: Jack, £20,000.00. Monthly gross pay: £1,666.66.",tester.toString());
} 


} 
