using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace UserInterfaceApp
{
    class EmployeeService
    {
        public ObservableCollection<Employee> Employees { get; set; }

        public EmployeeService()
        {
            Employees = new ObservableCollection<Employee>();

            Employees.Add(new Employee(1, "Rob Finnerty", "CEO", "img1.jpg"));
            Employees.Add(new Employee(2, "Bill Wrestler", "Director", "img2.jpg"));
            Employees.Add(new Employee(3, "Geri-Beth Hooper", "Delivery Manager", "img3.jpg"));
            Employees.Add(new Employee(4, "Keith Joyce-Purdy", "Project Manager", "img4.jpg"));
            Employees.Add(new Employee(5, "Sheri Spruce", "Sr. Software Engineer", "img5.jpg"));
            Employees.Add(new Employee(6, "Burt Indybrick", "Software Engineer", "img6.jpg"));
        }

        public async Task<ObservableCollection<Employee>> GetEmployees()        
        {
            Thread.Sleep(4000);
            
            return await Task.FromResult(Employees);
        }
    }
}
