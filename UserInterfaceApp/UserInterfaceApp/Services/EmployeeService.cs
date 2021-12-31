using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
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
            InitializeEmployeeService();
        }

        public void InitializeEmployeeService()
        {

            Employees.Add(new Employee(1, "Rob Finnerty", "CEO", "img1.jpg"));
            Employees.Add(new Employee(2, "Bill Wrestler", "Director", "img2.jpg"));
            Employees.Add(new Employee(3, "Geri-Beth Hooper", "Delivery Manager", "img3.jpg"));
            Employees.Add(new Employee(4, "Keith Joyce-Purdy", "Project Manager", "img4.jpg"));
            Employees.Add(new Employee(5, "Sheri Spruce", "Sr. Software Engineer", "img5.jpg"));
            Employees.Add(new Employee(6, "Burt Indybrick", "Software Engineer", "img6.jpg"));

            Employees.Add(new Employee(7, "Steve Jobs", "CEO", "img7.jpg"));
            Employees.Add(new Employee(8, "Reginald Blotchet-Halls", "Director", "img8.jpg"));
            Employees.Add(new Employee(9, "Cheryl Carson", "Delivery Manager", "img9.jpg"));
            Employees.Add(new Employee(10, "Michel DeFrance", "Project Manager", "img10.jpg"));
            Employees.Add(new Employee(11, "Innes del Castillo", "Sr. Software Engineer", "img11.jpg"));
            Employees.Add(new Employee(12, "Ann Dull", "Software Engineer", "img12.jpg"));

            Employees.Add(new Employee(13, "Marjorie Green", "CEO", "img13.jpg"));
            Employees.Add(new Employee(14, "Morningstar Greene", "Director", "img14.jpg"));
            Employees.Add(new Employee(15, "Burt Gringlesby", "Delivery Manager", "img15.jpg"));
            Employees.Add(new Employee(16, "Sheryl Hunter", "Project Manager", "img16.jpg"));
            Employees.Add(new Employee(17, "Livia Karsen", "Sr. Software Engineer", "img17.jpg"));
            Employees.Add(new Employee(18, "Charlene Locksley", "Software Engineer", "img18.jpg"));

            Employees.Add(new Employee(19, "Stearns MacFeather", "CEO", "img19.jpg"));
            Employees.Add(new Employee(20, "Heather McBadden", "Director", "img20.jpg"));
            Employees.Add(new Employee(21, "Michael O'Leary", "Delivery Manager", "img21.jpg"));
            Employees.Add(new Employee(22, "Sylvia Panteley", "Project Manager", "img22.jpg"));
            Employees.Add(new Employee(23, "Albert Ringer", "Sr. Software Engineer", "img23.jpg"));
            Employees.Add(new Employee(24, "Anne Ringer", "Software Engineer", "img24.jpg"));

            Employees.Add(new Employee(25, "Stearns MacFeather", "CEO", "img25.jpg"));
            Employees.Add(new Employee(26, "Heather McBadden", "Director", "img26.jpg"));
            Employees.Add(new Employee(27, "Michael O'Leary", "Delivery Manager", "img27.jpg"));
            Employees.Add(new Employee(28, "Sylvia Panteley", "Project Manager", "img28.jpg"));
            Employees.Add(new Employee(29, "Albert Ringer", "Sr. Software Engineer", "img29.jpg"));
            Employees.Add(new Employee(30, "Anne Ringer", "Software Engineer", "img30.jpg"));
        }

        public async Task<ObservableCollection<Employee>> GetEmployeesAsync(string query)
        {
            //Thread.Sleep(2000);

            if (query != string.Empty)
            {
                Employees.Clear();
                InitializeEmployeeService();
                List<Employee> llstEmployees = Employees.Where(emp => (emp.Designation.ToLower().Contains(query.ToLower())
                                                                    || emp.EmployeeName.ToLower().Contains(query.ToLower()))).ToList();

                Employees.Clear();
                foreach (Employee employee in llstEmployees)
                {
                    Employees.Add(employee);
                }

            }
            else
            {
                InitializeEmployeeService();
            }
            return await Task.FromResult(Employees);
        }

        public async Task<bool> AddEmployeeAsync(Employee employee)
        {
            Employees.Add(employee);
            return await Task.FromResult(true);
        }

        public async Task<bool> UpdateEmployeeAsync(Employee employee)
        {
            Employee employeeToEdit = Employees.Where(emp => emp.EmployeeId == employee.EmployeeId).FirstOrDefault();

            int newIdex = Employees.IndexOf(employeeToEdit);
            Employees.Remove(employeeToEdit);

            Employees.Add(employee);
            int oldIndex = Employees.IndexOf(employee);

            Employees.Move(oldIndex, newIdex);

            return await Task.FromResult(true);
        }
    }
}
