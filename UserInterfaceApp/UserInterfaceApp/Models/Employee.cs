using System;
using System.Collections.Generic;
using System.Text;

namespace UserInterfaceApp
{
    public class Employee
    {
        public int EmployeeId { get; set; }
        public string EmployeeName { get; set; }
        public string Designation { get; set; }
        public string PictureUrl { get; set; }

        public Employee(int employeeId, string employeeName, string designation, string pictureUrl)
        {
            EmployeeId = employeeId;
            EmployeeName = employeeName;
            Designation = designation;
            PictureUrl = pictureUrl;
        }

        public Employee()
        {
        }
    }
}
