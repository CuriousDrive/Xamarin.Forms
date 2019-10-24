using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Xamarin.Forms;

namespace UserInterfaceApp
{
    class EmployeeListViewModel : INotifyPropertyChanged
    {
        private ObservableCollection<Employee> _employees;
        public ObservableCollection<Employee> Employees 
        {
            get { return _employees; }
            set { _employees = value; OnPropertyChanged(); }
        }
        public string EmployeeName { get; set; }
        public string SelectedEmployee { get; set; }

        private bool _isBusy;
        public bool IsBusy 
        { 
            get { return _isBusy; }
            set { _isBusy = value; OnPropertyChanged(); }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }



        public EmployeeListViewModel()
        {
            LoadEmployees();

            //Employees = new ObservableCollection<Employee>();

            //Employees.Add(new Employee(1, "Rob Finnerty", "CEO", "img1.jpg"));
            //Employees.Add(new Employee(2, "Bill Wrestler", "Director", "img2.jpg"));
            //Employees.Add(new Employee(3, "Geri-Beth Hooper", "Delivery Manager", "img3.jpg"));
            //Employees.Add(new Employee(4, "Keith Joyce-Purdy", "Project Manager", "img4.jpg"));
            //Employees.Add(new Employee(5, "Sheri Spruce", "Sr. Software Engineer", "img5.jpg"));
            //Employees.Add(new Employee(6, "Burt Indybrick", "Software Engineer", "img6.jpg"));

            MessagingCenter.Subscribe<AddOrEditEmployeePage, Employee>(this, "AddOrEditEmployee",
                (page, employee) =>
                {
                    if (employee.EmployeeId == 0)
                    {
                        employee.EmployeeId = Employees.Count + 1;
                        Employees.Add(employee);
                    }
                    else
                    {
                        Employee employeeToEdit = Employees.Where(emp => emp.EmployeeId == employee.EmployeeId).FirstOrDefault();

                        int newIndex = Employees.IndexOf(employeeToEdit);
                        Employees.Remove(employeeToEdit);

                        Employees.Add(employee);
                        int oldIndex = Employees.IndexOf(employee);

                        Employees.Move(oldIndex, newIndex);
                    }
                }
                );
        }

        public void LoadEmployees() 
        {
            IsBusy = true;
            Task.Run(async () =>
            {
                Employees = await new EmployeeService().GetEmployees();
                IsBusy = false;
            });
        }

    }
}
