using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace UserInterfaceApp
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class AppMasterDetailPageMaster : ContentPage
    {
        public ListView ListView;

        public AppMasterDetailPageMaster()
        {
            InitializeComponent();

            BindingContext = new AppMasterDetailPageMasterViewModel();
            ListView = MenuItemsListView;
        }

        class AppMasterDetailPageMasterViewModel : INotifyPropertyChanged
        {
            public ObservableCollection<AppMasterDetailPageMasterMenuItem> MenuItems { get; set; }

            public AppMasterDetailPageMasterViewModel()
            {
                MenuItems = new ObservableCollection<AppMasterDetailPageMasterMenuItem>(new[]
                {
                    new AppMasterDetailPageMasterMenuItem { Id = 0, Title = "Labels", TargetType = typeof(Labels) },
                    new AppMasterDetailPageMasterMenuItem { Id = 1, Title = "Entries", TargetType = typeof(Entries) },
                    new AppMasterDetailPageMasterMenuItem { Id = 2, Title = "Buttons", TargetType = typeof(Buttons) },
                    new AppMasterDetailPageMasterMenuItem { Id = 3, Title = "Images", TargetType = typeof(Images) },
                    new AppMasterDetailPageMasterMenuItem { Id = 4, Title = "Enrollment", TargetType = typeof(EnrollStudentPage) },
                    new AppMasterDetailPageMasterMenuItem { Id = 5, Title = "Employee List", TargetType = typeof(EmployeeListPage) },
                    new AppMasterDetailPageMasterMenuItem { Id = 5, Title = "Behaviors", TargetType = typeof(BehaviorsPage) },

                });
            }

            #region INotifyPropertyChanged Implementation
            public event PropertyChangedEventHandler PropertyChanged;
            void OnPropertyChanged([CallerMemberName] string propertyName = "")
            {
                if (PropertyChanged == null)
                    return;

                PropertyChanged.Invoke(this, new PropertyChangedEventArgs(propertyName));
            }
            #endregion
        }
    }
}