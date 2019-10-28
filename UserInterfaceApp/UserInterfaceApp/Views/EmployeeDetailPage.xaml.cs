using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace UserInterfaceApp
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class EmployeeDetailPage : ContentPage
    {
        public EmployeeDetailPage(Employee employee = null)
        {
            InitializeComponent();

            if (employee != null)
                ((EmployeeDetailViewModel)BindingContext).Employee = employee;
        }
    }
}