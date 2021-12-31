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
    public partial class Checkboxes : ContentPage
    {
        public Checkboxes()
        {
            InitializeComponent();
        }

        private void CbXamarinFan_CheckedChanged(object sender, CheckedChangedEventArgs e)
        {
            if (e.Value == true)
                lblCheckBox.Text = "Awesome, me too!!";
            else
                lblCheckBox.Text = "What the hell, what are you even doing here?";
        }
    }
}