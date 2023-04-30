package org.spring;

import org.spring.model.Employee;
import org.spring.service.EmployeeService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("spring-bean.xml");
        Employee emp = (Employee) factory.getBean("employee");
        System.out.println(emp.toString());

        EmployeeService employeeService = (EmployeeService) factory.getBean("employeeService");
        System.out.println(employeeService.getEmployeeDetails());

        BeanDefinition employeeService1 = factory.getBeanDefinition("employeeService");
        BeanDefinition employee = factory.getBeanDefinition("employee1");
        employeeService1.setDependsOn("employee");

        System.out.println("bean class name" + employeeService1.getBeanClassName());
        System.out.println("getDependsOn :: " + Arrays.stream(employeeService1.getDependsOn()).findFirst());
        System.out.println("get property values :: " + employee.getPropertyValues());
    }
}
