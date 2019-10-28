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
    public partial class EmployeeListPage : ContentPage
    {
        public EmployeeListPage()
        {
            InitializeComponent();
        }

        private void ToolbarItem_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new AddOrEditEmployeePage());
        }
        
        private void TapGestureRecognizer_Tapped_Edit(object sender, EventArgs e)
        {
            TappedEventArgs tappedEventArgs = (TappedEventArgs)e;
            Employee employee = ((EmployeeListViewModel)BindingContext).Employees.Where(emp => emp.EmployeeId == (int)tappedEventArgs.Parameter).FirstOrDefault();

            Navigation.PushAsync(new AddOrEditEmployeePage(employee));
        }

        private void TapGestureRecognizer_Tapped_Remove(object sender, EventArgs e)
        {
            TappedEventArgs tappedEventArgs = (TappedEventArgs)e;
            Employee employee = ((EmployeeListViewModel)BindingContext).Employees.Where(emp => emp.EmployeeId == (int)tappedEventArgs.Parameter).FirstOrDefault();

            ((EmployeeListViewModel)BindingContext).Employees.Remove(employee);
        }

        private void ListView_ItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            Navigation.PushAsync(new EmployeeDetailPage((Employee)e.SelectedItem));
        }

    }
}