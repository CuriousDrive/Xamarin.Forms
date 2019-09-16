using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace UserInterfaceApp
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Buttons : ContentPage
    {
        public ICommand LocalCommand => new Command<string>(CommandClicked);

        public Buttons()
        {
            InitializeComponent();
            BindingContext = this;
        }

        private void Button_Clicked(object sender, EventArgs e)
        {
            lblSimple.Text = "Simple button clicked!!";
        }

        private void CommandClicked(string astr)
        {
            lblCommand.Text = astr;
        }
    }
}