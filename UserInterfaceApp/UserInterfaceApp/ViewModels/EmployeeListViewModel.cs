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
        EmployeeService employeeService;
        public ICommand searchCommand => new Command<string>(LoadEmployees);

        public event PropertyChangedEventHandler PropertyChanged;
        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public ObservableCollection<Employee> _employees;
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

        public EmployeeListViewModel()
        {
            employeeService = new EmployeeService();
            LoadEmployees(string.Empty);

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

                        int newIdex = Employees.IndexOf(employeeToEdit);
                        Employees.Remove(employeeToEdit);

                        Employees.Add(employee);
                        int oldIndex = Employees.IndexOf(employee);

                        Employees.Move(oldIndex, newIdex);
                    }
                }
                );
        }
        public void LoadEmployees(string query)
        {
            IsBusy = true;
            Task.Run(async () =>
            {
                Employees = await employeeService.GetEmployeesAsync(query);
                IsBusy = false;
            });
        }
    }
}
